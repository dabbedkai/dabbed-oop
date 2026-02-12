import java.lang.reflect.*;
import java.util.*;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Class<?> baClass = Class.forName("BankAccount");

        Object a1 = createAccount(baClass, "Alice", 1200.50);
        Object a2 = createAccount(baClass, "Bob", 250.00);
        Object a3 = createAccount(baClass, "Carol", 0.00);

        Object[] accounts = new Object[] { a1, a2, a3 };

        // Try to find and invoke a TablePrinter-printing method via reflection.
        try {
            Class<?> tpClass = Class.forName("TablePrinter");
            Method printer = findPrintMethod(tpClass);
            if (printer != null) {
                Object target = Modifier.isStatic(printer.getModifiers()) ? null : tpClass.getDeclaredConstructor().newInstance();
                Object param = prepareArgumentFor(printer.getParameterTypes(), accounts);
                if (printer.getParameterCount() == 0) {
                    printer.invoke(target);
                } else {
                    printer.invoke(target, param);
                }
                return;
            }
        } catch (ClassNotFoundException ignored) {}

        // Fallback: simple println of each account
        System.out.println("Accounts:");
        for (Object acct : accounts) {
            System.out.println(acct);
        }
    }

    static Object createAccount(Class<?> cls, String name, double bal) throws Exception {
        // Try constructors with common signatures
        for (Constructor<?> c : cls.getDeclaredConstructors()) {
            Class<?>[] p = c.getParameterTypes();
            if (p.length == 2 && p[0] == String.class && (p[1] == double.class || p[1] == Double.class)) {
                return c.newInstance(name, bal);
            }
            if (p.length == 2 && p[0] == String.class && (p[1] == int.class || p[1] == Integer.class)) {
                return c.newInstance(name, (int) bal);
            }
            if (p.length == 1 && p[0] == String.class) {
                return c.newInstance(name);
            }
            if (p.length == 0) {
                Object inst = c.newInstance();
                // try set fields if present
                trySetField(inst, "owner", name);
                trySetField(inst, "name", name);
                trySetField(inst, "balance", bal);
                trySetField(inst, "amount", bal);
                return inst;
            }
        }
        throw new NoSuchMethodException("No suitable BankAccount constructor found.");
    }

    static void trySetField(Object obj, String fieldName, Object value) {
        try {
            Field f = obj.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            if (f.getType() == double.class || f.getType() == Double.class) {
                f.set(obj, ((Number) value).doubleValue());
            } else {
                f.set(obj, value);
            }
        } catch (Throwable ignored) {}
    }

    static Method findPrintMethod(Class<?> tpClass) {
        List<String> preferredNames = Arrays.asList("print", "printTable", "printAccounts", "display", "show");
        for (String name : preferredNames) {
            for (Method m : tpClass.getMethods()) {
                if (!m.getName().equals(name)) continue;
                if (m.getParameterCount() == 1) return m;
                if (m.getParameterCount() == 0) return m;
            }
        }
        // fallback: any public method that takes one parameter (array or Collection)
        for (Method m : tpClass.getMethods()) {
            if (m.getParameterCount() == 1) return m;
        }
        return null;
    }

    static Object prepareArgumentFor(Class<?>[] paramTypes, Object[] accounts) {
        if (paramTypes.length == 0) return new Object[] {};
        Class<?> p = paramTypes[0];
        if (p.isArray()) {
            Class<?> comp = p.getComponentType();
            Object arr = Array.newInstance(comp, accounts.length);
            for (int i = 0; i < accounts.length; i++) {
                Array.set(arr, i, accounts[i]);
            }
            return arr;
        }
        if (Collection.class.isAssignableFrom(p) || List.class.isAssignableFrom(p)) {
            return Arrays.asList(accounts);
        }
        // single Object param
        if (p == Object.class) return accounts;
        // try to pass as a single-element array if param is an Object and method expects varargs
        return accounts;
    }
}