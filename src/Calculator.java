public class Calculator {
    private final Patient patient;

    public Calculator(Patient patient){
        this.patient = patient;
    }

    public float calculateDose(float glucoseLevel){
        if(glucoseLevel > patient.idealRange + patient.permittedVariance){
            return (float)(glucoseLevel - patient.idealRange - patient.permittedVariance/2); //Aim 10% below ideal level
        }
        return 0;
    }
}
