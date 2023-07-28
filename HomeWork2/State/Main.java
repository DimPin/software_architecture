package HomeWork2.State;

public class Main {
    public static void main(String[] args) {
        // Создаём вещество
        StateContext stateContext = new StateContext();

        // Нагреваем вещество
        stateContext.heat();
        stateContext.heat();
        stateContext.heat();

        // Охлождаем вещество
        stateContext.freeze();
        stateContext.freeze();
        stateContext.freeze();
    }
}

// Интерфейс для состояний, для изменения состояния
interface State {
    String getName();
    // Нагрев
    void heat(StateContext stateContext);
    // Охлождение
    void freeze(StateContext stateContext);
}

// Класс твёрдого состояния
class SolidState implements State {
    private static final String NAME = "твёрдое";

    public String getName() {
        return NAME;
    }

    public void heat(StateContext stateContext) {
        stateContext.setState(new LiquidState());
    }

    public void freeze(StateContext stateContext) {
        System.out.println("Ничего не происходит");
    }
}

// Класс жидкого состояния
class LiquidState implements State {
    private static final String NAME = "жидкое";

    public String getName() {
        return NAME;
    }

    public void heat(StateContext stateContext) {
        stateContext.setState(new GaseousState());
    }

    public void freeze(StateContext stateContext) {
        stateContext.setState(new SolidState());
    }
}

// Класс газообразного состояния
class GaseousState implements State {
    private static final String NAME = "газообразное";

    public String getName() {
        return NAME;
    }

    public void freeze(StateContext stateContext) {
        stateContext.setState(new LiquidState());
    }

    public void heat(StateContext stateContext) {
        System.out.println("Ничего не происходит");
    }
}

// Класс для управления состояниями вещества
class StateContext {
    // У вещества по умолчанию твёрдое состояние
    private State state = new SolidState();

    public void heat() {
        System.out.println("Нагреваем " + state.getName() + " вещество...");
        state.heat(this);
        System.out.println();
    }

    public void freeze() {
        System.out.println("Охлождаем " + state.getName() + " вещество...");
        state.freeze(this);
        System.out.println();
    }

    public void setState(State state) {
        System.out.println("Изменение состояния на " + state.getName() + "...");
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
