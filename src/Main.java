public class Main {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        try{
            //Initialize Simulation, Pump, Sensor and User
            Simulation testSim = new Simulation((float)3.9, 1000);
            Pump pump = new Pump(new Reservoir(150, 150));
            User testUser = new User((float)3.9, 10, (float)0.3);
            Sensor sensor = new Sensor(testSim, testUser);

            //Run for 100 cycles
            for(int i = 0; i <= 100; i++){
                testSim.updateSimulation(60); //Update simulation
                String sensorStatus = sensor.measure(); //
                if (sensorStatus == "12"){
                    pump.administer(new Dose((float)0.5), testSim);
                }
            }
        } catch (Exception exception){
            alarm.raiseAlarm(exception);
        }
    }
}
