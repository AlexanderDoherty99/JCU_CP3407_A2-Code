public class Simulation {
    private float glucoseLevel;
    private float rateOfChange;
    private int timeUntilRateUpdate;
    private long previousTime;
    private int secondsPerInterval;

    public float getGlucoseLevel() {
        return glucoseLevel;
    }

    public Simulation(float startingGlucoseLevel, int secondsPerInterval){ //Simulation Params
        this.glucoseLevel = startingGlucoseLevel;
        this.previousTime = System.currentTimeMillis();
        this.secondsPerInterval = secondsPerInterval;
        rateOfChange = (float)(Math.random()+0.2)*2;
        timeUntilRateUpdate = (int)((Math.random()+0.2) * 10);
    }

    public void updateSimulation(int intervals){
        for(int i = 0; i <= intervals * secondsPerInterval; i++){
            glucoseLevel += Math.random()/1000 * rateOfChange * secondsPerInterval;

        }
        timeUntilRateUpdate --;
        if(timeUntilRateUpdate == 0){
            timeUntilRateUpdate = (int)((Math.random()+0.2) * 10);
            rateOfChange = (float)(Math.random()+0.2)*2;
        }
    }

    public void addInsulin(Dose dose){
        this.glucoseLevel -= dose.insulinAmount;
    }

}
