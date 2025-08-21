package Interface;

public class SMSNotifier implements Notifier {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("SMS to " + recipient + ": " + message);
    }
}

