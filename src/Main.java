public class Main {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        try{
            Pump pump = new Pump(new Reservoir(500, 501));
            pump.pumpInsulin(new Dose(30, 50, 1));
        } catch (Exception exception){
            alarm.raiseAlarm(exception);
        }
    }
}
