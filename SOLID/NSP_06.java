package SOLID;

public class NSP_06 {

    // Specific interface for printing
    public interface Printable {
        void printDocument();
    }

    // Specific interface for scanning
    public interface Scannable {
        void scanDocument();
    }

    // Specific interface for faxing
    public interface Faxable {
        void faxDocument();
    }

    // A simple printer only implements Printable
    public static class SimplePrinter implements Printable {
        @Override
        public void printDocument() {
            System.out.println("SimplePrinter: Sending document to the printer ...");
        }
    }

    // A multi-functional printer can implement multiple interfaces
    public static class MultiFunctionPrinter implements Printable, Scannable, Faxable {
        @Override
        public void printDocument() {
            System.out.println("MultiFunctionPrinter: Printing document...");
        }

        @Override
        public void scanDocument() {
            System.out.println("MultiFunctionPrinter: Scanning document...");
        }

        @Override
        public void faxDocument() {
            System.out.println("MultiFunctionPrinter: Faxing document...");
        }
    }

    public static void main(String[] args) {
        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.printDocument();
        // The following would cause compile errors, which is good:
        // simplePrinter.scanDocument();
        // simplePrinter.faxDocument();

        System.out.println("---");

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.printDocument();
        mfp.scanDocument();
        mfp.faxDocument();
    }
}