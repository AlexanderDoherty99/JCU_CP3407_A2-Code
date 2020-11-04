import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Initializing Insulin Pump.\n Please set Starting Parameters...\n");
        System.out.println("Set Reservoir Capacity (50-300): ");
        int reservoirCapacity = 0;
        while (true){
            try{
                reservoirCapacity = Integer.parseInt(sc.nextLine());
                break;
            } catch (IllegalArgumentException ignored){}
        }
        Alarm alarm = new Alarm();
        //Initialize Simulation, Pump, Sensor and User
        Simulation testSim = new Simulation((float)6);
        Pump pump = new Pump(new Reservoir(reservoirCapacity, reservoirCapacity));
        Patient testPatient = new Patient((float)(3.5 + Math.random()), (float)(8+ Math.random()), (float)0.5);
        Sensor sensor = new Sensor(testSim, testPatient);
        Calculator calc = new Calculator(testPatient);
        //Run for x cycles
        int x = 10000;
        for(int i = 0; i <= x; i++){
            try{
                testSim.updateSimulation(60); //Update simulation
                String sensorStatus = sensor.measure();
                if (sensorStatus == "12"){ //12 being too high glucose level
                    pump.administer(new Dose(calc.calculateDose(sensor.getGlucoseLevel())), testSim);
                }
                System.out.println(sensor.report());
            } catch (Exception exception){
                alarm.raiseAlarm(exception);
                if(exception.getMessage().startsWith("02")){
                    throw exception;
                }
            }
        }

    }
}
