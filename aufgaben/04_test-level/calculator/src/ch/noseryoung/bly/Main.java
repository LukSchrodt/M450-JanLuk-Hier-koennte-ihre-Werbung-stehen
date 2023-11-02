package ch.noseryoung.bly;

class Calculator {
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        double resultAdd = calculator.add(5.0, 3.0);
        System.out.println("Addition Result: " + resultAdd);

        double resultSubtract = calculator.subtract(5.0, 3.0);
        System.out.println("Subtraction Result: " + resultSubtract);

        double resultMultiply = calculator.multiply(5.0, 3.0);
        System.out.println("Multiplication Result: " + resultMultiply);

        double resultDivide = calculator.divide(6.0, 2.0);
        System.out.println("Division Result: " + resultDivide);
    }
}
