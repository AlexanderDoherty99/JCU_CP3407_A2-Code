public class Main {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        try{
            Simulation testSim = new Simulation((float)3.9, 1000);
            Pump pump = new Pump(new Reservoir(500, 500));
            pump.pumpInsulin(new Dose(30, 50, 1));
            User testUser = new User((float)3.9, 10, (float)0.3);
            Sensor sensor = new Sensor(testSim, testUser);
            for(int i = 0; i <= 100; i++){
                testSim.updateSimulation(60);
                String sensorStatus = sensor.measure();
            }
        } catch (Exception exception){
            alarm.raiseAlarm(exception);
        }
    }
}
