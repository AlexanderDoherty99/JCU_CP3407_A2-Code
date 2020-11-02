public class Calculator {
    User user;

    public Calculator(User user){
        this.user = user;
    }

    public float calculateDose(float glucoseLevel){
        return (float)(glucoseLevel - user.idealRange - (user.idealRange*.05));
    }
}
