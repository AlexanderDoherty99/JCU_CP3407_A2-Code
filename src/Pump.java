public class Pump{
    private String statusCode;
    private final String ready = "00", pumping = "01", error = "02", empty = "03";
    private Reservoir reservoir;

    public Pump(Reservoir reservoir){
        if (reservoir.getInsulinLevel() > 0){
            this.reservoir = reservoir;
            statusCode = ready;
        }
        else if (reservoir.getInsulinLevel() == 0){
            this.reservoir = reservoir;
            statusCode = empty;
        }
        else{
            statusCode = error;
        }
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void pumpInsulin(Dose dose) throws PumpException {
        switch (statusCode){
            case pumping: throw new PumpException("Already pumping");
            case error: throw new PumpException("Pump Error");
            case ready:
                try{
                    int pumpingTimePeriod = dose.duration;
                    statusCode = pumping;
                    reservoir.sendToPump(dose.insulinAmount);
                    break;
                } catch (Exception e){
                    this.statusCode = error;
                    throw new PumpException("Pump error");
                }
        }
        statusCode = ready;
    }
    public static class PumpException extends Exception{
        public PumpException(String message) { super(message); }
    }

}
