package HomeWork2.Mediator;

// Родительский класс для коллег
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public abstract void notify(String message);
}

// Конкретный класс коллеги 1
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println("Коллега 1 получает сообщение: " + message);
    }
}

// Конкретный класс коллеги 2
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println("Коллега 2 получает сообщение: " + message);
    }
}

// Родительский класс посредников
abstract class Mediator {
    public abstract void send(String message, Colleague sender);
}

// Кокретный класс посредника
class ConcreteMediator extends Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague) {
        this.colleague1 = colleague;
    }

    public void setColleague2(ConcreteColleague2 colleague) {
        this.colleague2 = colleague;
    }

    @Override
    public void send(String message, Colleague sender) {
        if (sender.equals(colleague1)) {
            colleague2.notify(message);
        } else {
            colleague1.notify(message);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаём посредника
        ConcreteMediator concreteMediator = new ConcreteMediator();

        // Создаём коллегу 1 и коллегу 2
        ConcreteColleague1 concreteColleague1 = new ConcreteColleague1(concreteMediator);
        ConcreteColleague2 concreteColleague2 = new ConcreteColleague2(concreteMediator);

        // Устанавливаем для посредника двух коллег
        concreteMediator.setColleague1(concreteColleague1);
        concreteMediator.setColleague2(concreteColleague2);

        // Коллеги отправляют друг другу собщения через посредника
        concreteColleague1.send("Как дела?");
        concreteColleague2.send("Всё хорошо, спасибо!");
    }
}
