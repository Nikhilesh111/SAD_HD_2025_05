package SOLID;

public class NSP_09 {

    public interface NotificationService {

        void sendNotification(String employeeName, String message);

    }

    public static class EmailNotificationService implements NotificationService {

        @Override

        public void sendNotification(String employeeName, String message) {

            System.out.println("Sending email to " + employeeName + ": " + message);

        }

    }

    public static class SMSNotificationService implements NotificationService {

        @Override

        public void sendNotification(String employeeName, String message) {

            System.out.println("Sending SMS to " + employeeName + ": " + message);

        }

    }

    public static class Employee {

        private String name;

        private NotificationService notificationService;

        public Employee(String name, NotificationService notificationService) {

            this.name = name;

            this.notificationService = notificationService;

        }

        public void requestBonus() {

            System.out.println("Bonus requested for " + name);

            notificationService.sendNotification(this.name, "Your bonus request has been submitted.");

        }

        public String getName() {

            return name;

        }

    }

    public static void main(String[] args) {

        NotificationService emailService = new EmailNotificationService();

        Employee employee1 = new Employee("Alice_DIP02", emailService);

        employee1.requestBonus();

        System.out.println("---");

        NotificationService smsService = new SMSNotificationService();

        Employee employee2 = new Employee("Bob_DIP02", smsService);

        employee2.requestBonus();

    }

}
