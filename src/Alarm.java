public class Alarm {
    public void raiseAlarm(Exception exception){
        System.out.println("ALARM(" + exception.getClass().getSimpleName() + "): " + exception.getMessage());
    }
}
