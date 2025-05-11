public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[3];
        
        // Instantiate one triangle
        shapeArray[0] = new Triangle(3, 4, 5);
        
        // Instantiate one circle
        shapeArray[1] = new Circle(5);
        
        // Instantiate one rectangle (square is a type of rectangle)
        shapeArray[2] = new Rectangle(4, 4);
        
        // Loop through the array and print each object's data
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}