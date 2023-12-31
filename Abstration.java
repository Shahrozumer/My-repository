abstract class Shape {
    abstract void draw(); 
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a square");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Shape myShape;

        myShape = new Circle();
        myShape.draw(); 

        myShape = new Square();
        myShape.draw();
    }
}
