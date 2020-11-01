public class Simulation {
    private float glucoseLevel;
    private long previousTime;
    private final int timeMultiplier;

    public float getGlucoseLevel() {
        return glucoseLevel;
    }

    public Simulation(float startingGlucoseLevel, int timeMultiplier){
        this.glucoseLevel = startingGlucoseLevel;
        this.previousTime = System.currentTimeMillis();
        this.timeMultiplier = timeMultiplier;
    }

    public void updateSimulation(int secondsElapsed){
        for(int i = 0; i <= secondsElapsed; i++){
            glucoseLevel += Math.random()/100;
        }
    }

}
