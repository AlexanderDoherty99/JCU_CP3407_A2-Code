public class Pump{
    private String statusCode;
    private final String ready = "00", pumping = "01", error = "02", empty = "03";
    private Reservoir reservoir;

    public Pump(Reservoir reservoir){ //Constructor, sets initial statusCode and adds reservoir.
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

    public void administer(Dose dose, Simulation simulation) throws Exception { //Administers dose with error checking
        switch (statusCode){
            case pumping: throw new PumpException("01 - Already pumping");
            case error: throw new PumpException("02 - Pump Error");
            case ready:
                try{
//                    int pumpingTimePeriod = dose.duration;
                    System.out.println("Administering dose of " + dose.insulinAmount);
                    statusCode = pumping;
                    reservoir.sendToPump(dose.insulinAmount);
                    simulation.addInsulin(dose);
                    break;
                } catch (Reservoir.ReservoirException e){
                    this.statusCode = error;
                    throw new Reservoir.ReservoirException(e.getMessage());
                }
        }
        statusCode = ready;
    }
    public static class PumpException extends Exception{
        public PumpException(String message) { super(message); }
    }

}
