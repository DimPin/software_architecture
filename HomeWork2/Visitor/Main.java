package HomeWork2.Visitor;

// Интерфейс для вызова стратегии
interface Strategy {
    int execute(int a, int b);
}

// Класс для сложения
class ConcreteStrategyAdd implements Strategy {
    public int execute(int a, int b) {
        return a + b;
    }
}

// Класс для вычитания
class ConcreteStrategySubtract implements Strategy {
    public int execute(int a, int b) {
        return a - b;
    }
}


// Класс для умножения
class ConcreteStrategyMultiply implements Strategy {
    public int execute(int a, int b) {
        return a * b;
    }
}

// Класс контекста использующий интерфейс стратегии
class Context {
    private Strategy strategy;

    public Context() {
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаём контекст
        Context context = new Context();

        // Устанавливаем и запускаем все стратегии
        context.setStrategy(new ConcreteStrategyAdd());
        int result1 = context.executeStrategy(5, 4);

        context.setStrategy(new ConcreteStrategySubtract());
        int result2 = context.executeStrategy(5, 4);

        context.setStrategy(new ConcreteStrategyMultiply());
        int result3 = context.executeStrategy(5, 4);

        // Вывод результатов
        System.out.println("Результат 1: " + result1);
        System.out.println("Результат 2: " + result2);
        System.out.println("Результат 3: " + result3);
    }
}
