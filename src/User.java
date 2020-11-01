public class User {
    public final float upperLimit;
    public final float lowerLimit;
    public final float idealRange;
    public final float permittedVariance;

    public User(float lowerLimit, float upperLimit, float permittedVariance){
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
        idealRange = (upperLimit + lowerLimit)/2;
        this.permittedVariance = permittedVariance;
    }
}
