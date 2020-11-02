public class Simulation {
    private float glucoseLevel;
    private float rateOfChange;
    private int timeUntilRateUpdate;
    private long previousTime;
    private final int timeMultiplier;

    public float getGlucoseLevel() {
        return glucoseLevel;
    }

    public Simulation(float startingGlucoseLevel, int timeMultiplier){
        this.glucoseLevel = startingGlucoseLevel;
        this.previousTime = System.currentTimeMillis();
        this.timeMultiplier = timeMultiplier;
        rateOfChange = (float)(Math.random()+0.2)*2;
        timeUntilRateUpdate = (int)((Math.random()+0.2) * 10);
    }

    public void updateSimulation(int secondsElapsed){
        for(int i = 0; i <= secondsElapsed; i++){
            glucoseLevel += Math.random()/100 * rateOfChange;

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
