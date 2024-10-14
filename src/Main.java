import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, a + b):");
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println("Результат: " + result);
    }

    static String calc(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("т.к. строка не является математической операцией");
        }
        int a;
        int b;

        try {
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException Hay) {
            throw new IllegalArgumentException("не удается распознать числа.");
        }
        if(a < 1 || a > 10 || b < 1 || b > 10  ){
            throw new IllegalArgumentException("т.к. числа должны быть от 1 до 10 включительно");
        }

        String operation = tokens[1];
        switch (operation) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                if (b == 0) {
                    throw new IllegalArgumentException("т.к деление на ноль.");

                }
                return String.valueOf(a / b);
            default:
            throw new IllegalArgumentException("т.к. неверная операция. Доступные операции: +, -, *, /.");
        }
    }
}
