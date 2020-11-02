public class Main {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        try{
            //Initialize Simulation, Pump, Sensor and User
            Simulation testSim = new Simulation((float)3.9, 1000);
            Pump pump = new Pump(new Reservoir(150, 150));
            User testUser = new User((float)3.9, 10, (float)0.3);
            Sensor sensor = new Sensor(testSim, testUser);
            Calculator calc = new Calculator(testUser);

            //Run for x cycles
            int x = 1000;
            for(int i = 0; i <= x; i++){
                testSim.updateSimulation(60); //Update simulation
                Thread.sleep(500);
                String sensorStatus = sensor.measure();
                if (sensorStatus == "12"){ //12 being too high glucose level
                    pump.administer(new Dose(calc.calculateDose(sensor.getGlucoseLevel())), testSim);
                }
                System.out.println(sensor.report());
            }
        } catch (Exception exception){
            alarm.raiseAlarm(exception);
        }
    }
}
