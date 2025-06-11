package SOLID;

public class NSP_04 {

    // Common abstract base class for geometric shapes
    public static abstract class Shape {
        public abstract int getArea();
    }

    // Rectangle class
    public static class Rectangle extends Shape {
        protected final int width; // Made final for immutability post-construction
        protected final int height; // Made final for immutability post-construction

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public int getArea() {
            return width * height;
        }
    }

    // Square class - no longer inherits from a mutable Rectangle with problematic
    // setters
    public static class Square extends Shape {
        protected final int side; // Made final

        public Square(int side) {
            this.side = side;
        }

        public int getSide() {
            return side;
        }

        @Override
        public int getArea() {
            return side * side;
        }
    }

    // Client code that uses Shape polymorphically
    public static void printAreaDetails(Shape shape) {
        if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            System.out.println("Rectangle (" + r.getWidth() + "x" + r.getHeight() + ") Area: " +
                    shape.getArea());
        } else if (shape instanceof Square) {
            Square s = (Square) shape;
            System.out.println("Square (side " + s.getSide() + ") Area: " + shape.getArea());
        } else {
            System.out.println("Unknown Shape Area: " + shape.getArea());
        }
    }

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        Shape square = new Square(5);

        printAreaDetails(rectangle);
        printAreaDetails(square);

        // Example showing that substitution works correctly with the Shape contract.
        // If Rectangle had mutable setters that Square overrode problematically,
        // LSP would be violated. Here, the hierarchy is cleaner.
    }
}