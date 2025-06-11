package SOLID;

public class NSP_08 {

    // Abstraction for a switchable device
    public interface Switchable {
        void turnOn();

        void turnOff();

        boolean isOn();
    }

    public static class LightBulb implements Switchable {
        private boolean on = false;

        @Override
        public void turnOn() {
            on = true;
            System.out.println("LightBulb: Light is ON!");
        }

        @Override
        public void turnOff() {
            on = false;
            System.out.println("LightBulb: Light is OFF!");
        }

        @Override
        public boolean isOn() {
            return on;
        }
    }

    // Another device that could be switched
    public static class Fan implements Switchable {
        private boolean on = false;

        @Override
        public void turnOn() {
            on = true;
            System.out.println("Fan: Fan is ON!");
        }

        @Override
        public void turnOff() {
            on = false;
            System.out.println("Fan: Fan is OFF!");
        }

        @Override
        public boolean isOn() {
            return on;
        }
    }

    // Switch depends on the abstraction (Switchable)
    public static class Switch {
        private Switchable device; // Depends on abstraction

        public Switch(Switchable device) {
            this.device = device;
        }

        // Operates the device by toggling its state
        public void operate() {
            if (device.isOn()) {
                device.turnOff();
            } else {
                device.turnOn();
            }
        }
    }

    public static void main(String[] args) {
        Switchable lightBulb = new LightBulb(); // Program to an interface
        Switch lightSwitch = new Switch(lightBulb);

        System.out.println("Operating light switch:");
        lightSwitch.operate(); // Turns ON
        lightSwitch.operate(); // Turns OFF

        System.out.println("\nOperating fan switch:");
        Switchable fan = new Fan(); // Program to an interface
        Switch fanSwitch = new Switch(fan);
        fanSwitch.operate(); // Turns ON
        fanSwitch.operate(); // Turns OFF
    }
}