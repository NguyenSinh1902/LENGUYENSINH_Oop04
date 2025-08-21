package Interface;

public class HrApp {
    public static void main(String[] args) {
        // Có thể chọn EmailNotifier hoặc SMSNotifier
        Notifier notifier = new EmailNotifier();
        // Notifier notifier = new SMSNotifier();

        HrSystem hr = new HrSystem(notifier);
        hr.notifyEmployee("Your leave request is approved.", "employee@company.com");
    }
}

