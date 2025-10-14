import java.util.Scanner;

abstract class Calc {
    protected int a, b;

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public abstract int calculate();
}

class Add extends Calc {
    public int calculate() {
        return a + b;
    }
}
class Mul  extends Calc {
    public int calculate() {
        return a * b;
    }
}

class Sub extends Calc {
    public int calculate() {
        return a - b;
    }
}

class Div extends Calc {
    public int calculate() {
        return a / b;
    }
}


public class Calculator {
    int a, b;
    char operator;

    private void geyUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("두 정수와 연산자를 입력하시오>>");
        a = sc.nextInt();
        b = sc.nextInt();
        operator = sc.next().charAt(0);
        sc.close();
    }

    private Calc getOperatorObj() {
        switch (operator) {
            case '+':
                return new Add();

            case '-':
                return new Sub();

            case  '*':
                return new Mul();

            case '/':
                return new Div();

            default:
                System.out.println("잘못된 연산자입니다.");
                return null;
        }
    }

    public void execute() {
        geyUserInput();

        Calc exp = getOperatorObj();

        exp.setValue(a, b);

        if((exp instanceof Div) && (b == 0)) {
            System.out.println("계산할 수 없습니다.");
        }
        else {
            System.out.println(exp.calculate());
        }
    }

    public static void main(String[] args) {
        Calculator calObj = new Calculator();
        calObj.execute();
    }
}
