package SOLID;

public class NSP_05 {

    public static class Bird {
        public void eat() {
            System.out.println("The bird is eating...");
        }
        // Common bird properties/methods can go here
    }

    // Interface for things that can fly
    public interface Flyable {
        void fly();
    }

    // Sparrow is a Bird and is Flyable
    public static class Sparrow extends Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("The sparrow is flying...");
        }
    }

    // Penguin is a Bird but not Flyable
    public static class Penguin extends Bird {
        public void swim() {
            System.out.println("The penguin is swimming...");
        }
    }

    // This method now only accepts birds that are Flyable
    public static void letItFly(Flyable flyer) {
        flyer.fly();
    }

    // General method for any bird action
    public static void observeBirdBehavior(Bird bird) {
        bird.eat(); // All birds eat
        if (bird instanceof Flyable) {
            System.out.println("This bird can fly. Attempting to make it fly:");
            ((Flyable) bird).fly(); // Only try to make it fly if it's Flyable
        } else if (bird instanceof Penguin) {
            System.out.println("This bird is a penguin. Let's see it swim:");
            ((Penguin) bird).swim(); // Penguins can swim
        } else {
            System.out.println("This bird has no special observed behavior other than eating.");
        }
    }

    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        Penguin penguin = new Penguin();

        System.out.println("--- Using letItFly (only for Flyable birds) ---");
        letItFly(sparrow);
        // letItFly(penguin); // This would be a compile-time error.

        System.out.println("\n--- Using observeBirdBehavior (for any bird) ---");
        observeBirdBehavior(sparrow);
        System.out.println("---");
        observeBirdBehavior(penguin);
    }
}