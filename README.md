# HomeWork 1

Задание 1. На основе Диаграмы классов ModelElements, разработать классы: Model Store, PoligonalModel (Texture, Poligon), Flash, Camera, Scene (Реализовать диограмму на любом языке программирования)

Задание 2. Ознакомиться с документацией в свободном формате, которая может пригодиться Вам для дальнейшей работы:
ГОСТ Р ИСО/МЭК 12207-2010 Информационная технология (ИТ). Системная и программная инженерия. Процессы жизненного цикла программных средств.
ISO/IEC/IEEE 29148:2018 Systems and software engineering — Life cycle processes — Requirements engineering
Стандарты ЕСКД — единая система конструкторской документации
ГОСТ 2.001-2013 ЕСКД. Общие положения
Стандарты АСУ ГОСТ 34 — автоматизированные системы управления
Стандарты ЕСПД ГОСТ 19 — единая система программной документации

https://www.cybermedian.com/ru/a-comprehensive-guide-to-uml-class-diagram/

В этой призентации, в конце есть диограмма для 'Задания 1'
https://docs.google.com/presentation/d/1d-ReTu3A_944hmccTxqbUrRNMHtIDViiCMKvUUaKu24/edit?pli=1#slide=id.g161fe117232_1_7

# HomeWork 2

Задание.
Прислать простую реализацию 5-ти Патернов ,на любом языке (С комментариями ), из списка -

Строитель (Builder)
Цепочка обязанностей (Chain of Responsibility)
Команда (Command)
Итератор (Iterator)
Посредник (Mediator)
Памятка (Memento)
Состояние (State)
Стратегия (Strategy)
Шаблонный метод (Template Method)
Посетитель (Visitor)

# HomeWork 3

https://github.com/vyntyk/Solid.git

Продолжить работу с семинара.
рассмотрим четвертый принцип SOLID - Принцип сегрегации интерфейса (Interface Segregation Principle, ISP). Он гласит: "Клиенты не должны зависеть от интерфейсов, которые они не используют".
Вам надо написать код который исправяет эту ошибку и реализует этот принцип
Пример кода, который нарушает ISP:


public interface Worker {
    void work();
    void eat();
}

public class HumanWorker implements Worker {
    public void work() {
        System.out.println("Человек работает");
    }

    public void eat() {
        System.out.println("Человек ест");
    }
}

public class RobotWorker implements Worker {
    public void work() {
        System.out.println("Робот работает");
    }

    public void eat() {
        throw new UnsupportedOperationException("Роботы не едят!");
    }
}

public class Main {
    public static void main(String[] args) {
        Worker worker = new RobotWorker();
        worker.work();
        worker.eat(); // Здесь возникнет исключение UnsupportedOperationException
    }
}
В этом примере класс RobotWorker не использует и не должен использовать метод eat(), поэтому он нарушает принцип сегрегации интерфейса.

И аналогично 5-ый принцип

Принцип инверсии зависимостей (Dependency Inversion Principle, DIP) гласит: "Зависимости на абстракциях. Нет зависимостей на что-то конкретное". Это означает, что высокоуровневые модули, которые обеспечивают сложную логику, должны быть независимы от низкоуровневых модулей, которые обеспечивают утилитарные функции. Оба типа модулей должны зависеть от абстракций.

Пример кода, который нарушает DIP:


public class Text {
    String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

public class Printer {
    public void print(Text text) {
        System.out.println(text.getText());
    }
}

public class Main {
    public static void main(String[] args) {
        Text myText = new Text("Hello, world!");
        Printer myPrinter = new Printer();
        myPrinter.print(myText);
    }
}
В этом примере класс Printer зависит от конкретного класса Text.

# HomeWork 4

Вам необходимо доработать код, добавив контракты к методам, документацию и обеспечив высокую связанность и низкую сочетаемость:

// Класс для геометрических фигур
abstract class Shape {
    // Общие поля и методы для всех геометрических фигур
    abstract double getArea();
    abstract double getPerimeter();
}

// Класс для круга
class Circle extends Shape {
    private double radius;

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

// Класс для прямоугольника
class Rectangle extends Shape {
    private double length;
    private double width;

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

// Класс для треугольника
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

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

// Главный класс приложения
public class GeometryApp {
    public static void main(String[] args) {
        // Пример использования конкретных классов геометрических фигур
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