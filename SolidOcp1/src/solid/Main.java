package solid;

import solid.ocp.Canvas;
import solid.ocp.RightTriangle;
import solid.ocp.Shape;
import solid.ocp.Square;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();

        canvas.addShape(new RightTriangle(2, 3));
        canvas.addShape(new Square(4));

        System.out.printf("Сумма площадей фигур равна %f \n", canvas.getArea());
    }
}
