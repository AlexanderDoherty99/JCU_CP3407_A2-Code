public class Dose {
    public final float insulinAmount;
    public final int duration;
    public final int startTime;

    public Dose(float amount, int duration, int startTime){
        this.insulinAmount = amount;
        this.duration = duration;
        this.startTime = startTime;
    }
}
