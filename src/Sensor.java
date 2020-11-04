public class Sensor {
    private float glucoseLevel;
    private String statusCode;
    private final String Good = "10", normLow = "11", normHigh = "12", error = "13";
    private Simulation simulation;
    private Patient patient;

    public Sensor(Simulation simulation, Patient patient){
        this.simulation = simulation;
        this.patient = patient;
        measure();
    }

    public float getGlucoseLevel() {
        return glucoseLevel;
    }

    public String measure(){ //Detects glucose level and sets status accordingly
        this.glucoseLevel = simulation.getGlucoseLevel();
        if(patient.idealRange - patient.permittedVariance < glucoseLevel && glucoseLevel < patient.idealRange + patient.permittedVariance){
            statusCode = Good;
        }
        else if(glucoseLevel < patient.idealRange){
            statusCode = normLow;
        }
        else if(glucoseLevel > patient.idealRange){
            statusCode = normHigh;
        }
        return this.statusCode;
    }

    public String report(){
        return "Glucose Level: " + glucoseLevel;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
