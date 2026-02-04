
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class Mission {

    public Random random = new Random();

    private String missionTarget;
    private LocalDate missionDeadline;
    private int difficulty;

    public void missionDetails() {
        String[] missionTargets = {"Retrieve stolen data", "Infiltrate enemy base", "Rescue hostage"};

        this.missionTarget = missionTargets[random.nextInt(3)];

        this.difficulty = random.nextInt((10 - 1) + 1) + 1;

        this.missionDeadline = LocalDate.now().plusDays(random.nextInt((30 - 7) + 1) + 7);
    }

    public String getMissionTarget() {
        return this.missionTarget;
    }

    public LocalDate getMissionDeadline() {
        return this.missionDeadline;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public void displayMissionBriefing() {
        String pattern = "MMMM dd yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
    
    System.out.printf("""

                *** MISSION BRIEFING ***
                Target:     %s
                Difficulty: %s
                Deadline:   %s
                
                """, this.missionTarget, this.difficulty, this.missionDeadline.format(formatter));
    }
    
}
