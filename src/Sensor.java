public class Sensor {
    private float glucoseLevel;
    private String statusCode;
    private final String Good = "10", normLow = "11", normHigh = "12", error = "13";
    private Simulation simulation;
    private User user;

    public Sensor(Simulation simulation, User user){
        this.simulation = simulation;
        this.user = user;
        measure();
    }

    public float getGlucoseLevel() {
        return glucoseLevel;
    }

    public String measure(){
        this.glucoseLevel = simulation.getGlucoseLevel();
        if(user.idealRange - user.permittedVariance < glucoseLevel && glucoseLevel < user.idealRange + user.permittedVariance){
            statusCode = Good;
        }
        else if(glucoseLevel < user.idealRange){
            statusCode = normLow;
        }
        else if(glucoseLevel > user.idealRange){
            statusCode = normHigh;
        }
        return this.statusCode;
    }

    public String report(){
        return "Glucose Level: " + glucoseLevel + "\n Status: " + statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
