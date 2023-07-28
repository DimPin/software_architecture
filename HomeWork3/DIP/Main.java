package HomeWork3.DIP;

interface Massage {
    String getText();
}

class Text implements Massage {
    String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

class Printer {
    public void print(Massage text) {
        System.out.println(text.getText());
    }
}

public class Main {
    public static void main(String[] args) {
        Massage myText = new Text("Hello, world!");
        Printer myPrinter = new Printer();
        myPrinter.print(myText);
    }
}
