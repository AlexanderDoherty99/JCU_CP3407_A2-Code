public class Dose {
    public final float insulinAmount;
//    public final int duration;
//    public final int startTime;

    public Dose(float amount) throws DoseException {
        this.insulinAmount = amount;
        if(amount <= 0){
            throw new DoseException("12 - Invalid Dose amount");
        }
//        this.duration = duration;
//        this.startTime = startTime;
    }
    public static class DoseException extends Exception{
        public DoseException(String message) { super(message); }
    }

}
