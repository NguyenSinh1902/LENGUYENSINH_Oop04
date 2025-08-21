package Interface;

public class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Email to " + recipient + ": " + message);
    }
}

