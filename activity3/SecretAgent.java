import java.time.LocalDateTime;

public class SecretAgent {

    private final String agentId;
    private String codeName;

    private int clearanceLevel;

    private boolean onMission;

    private LocalDateTime lastMissionCompletionTime;
    
    public String getAgentId() {
        return this.agentId;
    }

    public String getCodeName(){
        return this.codeName;
    }

    public int getClearanceLevel(){
        return this.clearanceLevel;
    }

    public boolean isOnMission(){
        return this.onMission;
    }

    public LocalDateTime getLastMissionCompletionTime(){
        return this.lastMissionCompletionTime;
    }

    public SecretAgent(String agentId, String codeName, int clearanceLevel) {
        this.agentId = agentId;
        this.codeName = codeName;
        this.clearanceLevel = clearanceLevel;

        this.onMission = false;
        this.lastMissionCompletionTime = null;
    }

    public String setCodeName(String codeName) {
        this.codeName = codeName;
        return this.codeName;
    }

    public int getClearanceLevel(int clearanceLevel) {
        this.clearanceLevel = clearanceLevel;

        if(clearanceLevel < 1 || clearanceLevel > 5) {
            System.out.println("Invalid clearance level. It must be between 1 and 5.");
        }
        return this.clearanceLevel;
    }

    public boolean startMission() {
            this.onMission = true;
            return true;
    }

    public boolean completeMission() {
            this.onMission = false;
            this.lastMissionCompletionTime = LocalDateTime.now();
            return true;
    }
    
}
