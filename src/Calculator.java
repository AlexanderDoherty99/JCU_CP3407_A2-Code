public class Calculator {
    private final User user;

    public Calculator(User user){
        this.user = user;
    }

    public float calculateDose(float glucoseLevel){
        return (float)(glucoseLevel - user.idealRange - (user.idealRange*.05)); //Aim 5% below ideal level
    }
}
