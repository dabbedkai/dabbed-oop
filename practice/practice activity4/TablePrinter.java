// new file
public final class TablePrinter {

    private TablePrinter() {}

    public static void printAccountTable(String action, String accountNumber, String accountName, double balance, String info) {
        String[] headers = {"Action", "AccountNumber", "AccountName", "Balance", "Info"};
        String[] values = {
            action,
            accountNumber,
            accountName,
            String.format("%.2f", balance),
            info
        };
        printSqlTable(headers, values);
    }

    public static void printTransactionTable(String action, double amount, double balance) {
        String[] headers = {"Action", "Amount", "Balance"};
        String[] values = {
            action,
            String.format("%.2f", amount),
            String.format("%.2f", balance)
        };
        printSqlTable(headers, values);
    }

    private static void printSqlTable(String[] headers, String[] values) {
        int cols = headers.length;
        int[] widths = new int[cols];
        for (int i = 0; i < cols; i++) {
            widths[i] = Math.max(headers[i].length(), values[i] != null ? values[i].length() : 0);
        }

        String sep = "+";
        for (int w : widths) {
            sep += repeat('-', w + 2) + "+";
        }

        System.out.println(sep);

        StringBuilder headerRow = new StringBuilder("|");
        for (int i = 0; i < cols; i++) {
            headerRow.append(" ").append(padRight(headers[i], widths[i])).append(" |");
        }
        System.out.println(headerRow.toString());
        System.out.println(sep);

        StringBuilder valueRow = new StringBuilder("|");
        for (int i = 0; i < cols; i++) {
            String v = values[i] != null ? values[i] : "";
            valueRow.append(" ").append(padRight(v, widths[i])).append(" |");
        }
        System.out.println(valueRow.toString());
        System.out.println(sep);
    }

    private static String padRight(String s, int width) {
        StringBuilder sb = new StringBuilder(s != null ? s : "");
        while (sb.length() < width) sb.append(' ');
        return sb.toString();
    }

    private static String repeat(char c, int times) {
        StringBuilder sb = new StringBuilder(times);
        for (int i = 0; i < times; i++) sb.append(c);
        return sb.toString();
    }
}