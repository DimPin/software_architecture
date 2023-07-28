package HomeWork3.ISP;

interface Worker {
    void work();
}

interface Eat {
    void eat();
}

class HumanWorker implements Worker, Eat {
    public void work() {
        System.out.println("Человек работает");
    }

    public void eat() {
        System.out.println("Человек ест");
    }
}

class RobotWorker implements Worker {
    public void work() {
        System.out.println("Робот работает");
    }
}

public class Main {
    public static void main(String[] args) {
        Worker worker = new RobotWorker();
        worker.work();
    }
}
