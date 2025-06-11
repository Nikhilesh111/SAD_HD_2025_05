package SOLID;

public class NSP_07 {

    // Interface for the core work capability
    public interface Workable {
        void work();
    }

    // Interface for entities that can also rest
    public interface Restable {
        void rest();
    }

    // A Developer can work and rest
    public static class Developer implements Workable, Restable {
        @Override
        public void work() {
            System.out.println("Developer is coding ...");
        }

        @Override
        public void rest() {
            System.out.println("Developer is taking a break!");
        }
    }

    // A Robot can only work
    public static class Robot implements Workable {
        @Override
        public void work() {
            System.out.println("Robot is working hard ...");
        }
        // No rest() method forced upon it.
    }

    // This function can take any entity that can work, and if it can rest, it will.
    public static void manageWorker(Workable worker) {
        worker.work();
        if (worker instanceof Restable) { // Check if the worker can rest
            ((Restable) worker).rest();
        } else {
            System.out.println(
                    "This worker (" + worker.getClass().getSimpleName() + ") does not need to rest or cannot rest.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Developer Cycle ---");
        manageWorker(new Developer());

        System.out.println("\n--- Robot Cycle ---");
        manageWorker(new Robot());
    }
}