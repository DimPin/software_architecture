package HomeWork4;

/**
 * Общий класс для геометрических фигур
 */
abstract class Shape {
    /**
     * Считает площадь для фигуры
     * @return площадь фигуры в виде дроби с типом double
     */
    abstract double getArea();

    /**
     * Считает периметр фигуры
     * @return переметр фигуры в виде дроби с типом double
     */
    abstract double getPerimeter();
}

/**
 * Класс для круга
 */
class Circle extends Shape {
    /** Поле радиус */
    private double radius;


    /**
     * Конструктор класса 
     * @param radius для создания круга с определённым радиусом
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

/**
 * Класс для прямоугльника
 */
class Rectangle extends Shape {
    /** Поля длинна (lenght), ширина (width)*/
    private double length;
    private double width;

    /**
     * Конструктор класса
     * @param length для созданния прямоугольника с заданной длинной
     * @param wigth для созданния прямоугольника с заданной шириной
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getArea() {
        return length * width;
    }

    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }
}

/**
 * Класс для треугольника
 */
class Triangle extends Shape {
    /** Первая, вторая, третья сторона */
    private double side1;
    private double side2;
    private double side3;

    /**
     * Конструктор класса
     * @param side1 ->
     * @param side2 ->
     * @param side3 ->
     * -> для создания треугольника с заданными сторонами
     */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double getPerimeter() {
        return side1 + side2 + side3;
    }
}

/**
 * Главный класс приложения
 */
public class GeometryApp {
    public static void main(String[] args) {
        /**
         * Пример использования конкретных классов геометрических фигур
         */
        Circle circle = new Circle(5.0);
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Периметр круга: " + circle.getPerimeter());

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
    }
}
