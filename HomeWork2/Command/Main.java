package HomeWork2.Command;

// Класс приемника
class Light {
    public Light() {
    }

    public void turnOn() {
        System.out.println("Вкл");
    }

    public void turnOff() {
        System.out.println("Выкл");
    }
}

interface Command {
    void execute();
}

// Команда для включения освещения
class TurnOnLightCommand implements Command {
    private Light theLight;

    public TurnOnLightCommand(Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOn();
    }
}

// Команда для выключения освещения
class TurnOffLightCommand implements Command {
    private Light theLight;

    public TurnOffLightCommand(Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOff();
    }
}

// Класс вызывающего
class Switch {
    private Command flipUpCommand;
    private Command flipDownCommand;

    public Switch(Command flipUpCommand, Command flipDownCommand) {
        this.flipUpCommand = flipUpCommand;
        this.flipDownCommand = flipDownCommand;
    }

    public void flipUp() {
        flipUpCommand.execute();
    }

    public void flipDown() {
        flipDownCommand.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        // создаем объект, который будет использоваться
        Light light = new Light();

        // создаем объекты для всех умений объекта Light:
        Command switchUp = new TurnOnLightCommand(light);
        Command switchDown = new TurnOffLightCommand(light);

        // Создаемтся вызывающий, с которым мы будем непосредственно контактировать:
        Switch switch1 = new Switch(switchUp, switchDown);

        switch1.flipUp();
        switch1.flipDown();
    }
}
