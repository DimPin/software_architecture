package HomeWork2.Builder;

// Класс продукта, который мы построим
class Product {
    private String part1;
    private String part2;
    private String part3;

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public void display() {
        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
        System.out.println("Part3: " + part3);
    }
}

// Интерфейс для Строителя
interface Builder {
    void buildPart1();
    void buildPart2();
    void buildPart3();
    Product getResult();
}

// Конкретный класс Строителя
class ConcreteBuilder implements Builder {
    private Product product;

    public ConcreteBuilder() {
        this.product = new Product();
    }

    public void buildPart1() {
        product.setPart1("3");
    }

    public void buildPart2() {
        product.setPart2("2");
    }

    public void buildPart3() {
        product.setPart3("1");
    }

    public Product getResult() {
        return product;
    }
}

// Директор, который управляет Строителем
class Director {
    private Builder concreteBuilder;

    public Director(Builder concreteBuilder) {
        this.concreteBuilder = concreteBuilder;
    }

    public void construct() {
        concreteBuilder.buildPart1();
        concreteBuilder.buildPart2();
        concreteBuilder.buildPart3();
    }
}

// Рабочий код
public class Main {
    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Director director = new Director(concreteBuilder);
        director.construct();

        Product product = concreteBuilder.getResult();
        product.display();
    }
}
