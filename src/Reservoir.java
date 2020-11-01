public class Reservoir {
    private final float totalCapacity;
    private float insulinLevel;

    public Reservoir(float totalCapacity, float insulinLevel) throws ReservoirException {
        if (insulinLevel > totalCapacity || insulinLevel < 0 || totalCapacity <= 0){
            throw new ReservoirException("Invalid constructor parameters!\ninsulinLevel = "
                    + insulinLevel
                    + "\ntotalCapacity = "
                    + totalCapacity);
        }
        this.insulinLevel = insulinLevel;
        this.totalCapacity = totalCapacity;
    }

    public float getInsulinLevel() {
        return insulinLevel;
    }

    public float getTotalCapacity() {
        return totalCapacity;
    }

    public void sendToPump(float amount) throws ReservoirException {
        if (amount <= insulinLevel){
            insulinLevel -= amount;
        }
        else{
            throw new ReservoirException("Not enough insulin in reservoir!");
        }
    }

    private float getLevelPerecentage() throws ReservoirException {
        return insulinLevel/totalCapacity;
    }

    public static class ReservoirException extends Exception{
        public ReservoirException(String message) { super(message); }
    }
}
