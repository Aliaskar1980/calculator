package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        final String inputExp = ReadInput.read();
        LinkedList<String> operations;
        LinkedList<String> numbers;

        String numbersArr[] = inputExp.split("[-+*/]");
        String operArr[] = inputExp.split("[0-9]+");

        numbers = new LinkedList<String>(Arrays.asList(numbersArr));
        operations = new LinkedList<String>(Arrays.asList(operArr));

        Double res = Double.parseDouble(numbers.poll());
        while (!numbers.isEmpty()) {
            String opr = operations.poll();
            Operate operate;
            switch (opr) {
                case "+":
                    operate = new Add();
                    break;
                case "-":
                    operate = new Substract();
                    break;
                case "*":
                    operate = new Multiplay();
                    break;
                case "/":
                    operate = new Divide();
                    break;
                default:
                    continue;
            }
            Double num = Double.parseDouble(numbers.poll());
            res = operate.getResult(res, num);

        }
        System.out.print("=" + res);
    }
}
