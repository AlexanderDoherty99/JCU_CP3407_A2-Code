public class Simulation {
    private float glucoseLevel;
    private float rateOfChange;
    private int timeUntilRateUpdate;
    private long previousTime;

    public float getGlucoseLevel() {
        return glucoseLevel;
    }

    public Simulation(float startingGlucoseLevel){ //Simulation Params
        this.glucoseLevel = startingGlucoseLevel;
        this.previousTime = System.currentTimeMillis();
        rateOfChange = (float)(Math.random()+0.2)*4;
        timeUntilRateUpdate = (int)((Math.random()+0.2) * 10);
    }

    public void updateSimulation(int minutes){
        for(int i = 0; i <= minutes; i++){
            glucoseLevel += Math.random()/50 * rateOfChange;

        }
        timeUntilRateUpdate --;
        if(timeUntilRateUpdate == 0 || glucoseLevel <3.5){
            timeUntilRateUpdate = (int)((Math.random()+0.2) * 10);
            rateOfChange = (float)(Math.random()-0.35)*2;
        }
    }

    public void addInsulin(Dose dose){
        this.glucoseLevel -= dose.insulinAmount;
    }

}
