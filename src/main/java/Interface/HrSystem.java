package Interface;

public class HrSystem {
    private Notifier notifier;

    public HrSystem(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyEmployee(String message, String employeeContact) {
        notifier.sendNotification(message, employeeContact);
    }
}

