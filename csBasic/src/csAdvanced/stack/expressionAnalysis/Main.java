package csAdvanced.stack.expressionAnalysis;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Node<E>{
    public E data;
    public Node<E> next;

    public Node(E data){
        this.data = data;
        this.next = null;
    }
}

class Stack<E> {
    public Node<E> head;

    public Stack(){
        this.head = null;
    }

    public void push(E data){
        Node<E> temp = this.head;
        this.head = new Node<E>(data);
        this.head.next = temp;
    }

    public E pop(){
        if (this.head == null) return null;
        Node<E> temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }

    public E peek(){
        if (this.head == null) return null;
        return this.head.data;
    }
}

class Solution {
    public static long expressionParser(String expression) {

        List<Long> operandList = Arrays.stream(expression.split("[+\\-*/]"))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<String> operatorList = Arrays.stream(expression.split("\\d"))
                .filter(str -> !str.equals(""))
                .collect(Collectors.toList());

        Stack<Long> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        operandStack.push(operandList.remove(0));

        while(operatorList.size() > 0 && operandList.size() > 0) {
            operatorStack.push(operatorList.remove(0));
            operandStack.push(operandList.remove(0));

            if (operatorStack.peek().equals("*") || operatorStack.peek().equals("/")) {
                long y = operandStack.pop();
                long x = operandStack.pop();
                String operator = operatorStack.pop();
                operandStack.push(calculate(x, y, operator));
            }
        }

        Stack<Long> operandStack2 = new Stack<>();
        Stack<String> operatorStack2 = new Stack<>();
        while(operandStack.peek() != null) operandStack2.push(operandStack.pop());
        while(operatorStack.peek() != null) operatorStack2.push(operatorStack.pop());

        while(operatorStack2.peek() != null) {
            long x = operandStack2.pop();
            long y = operandStack2.pop();
            String operator = operatorStack2.pop();
            operandStack2.push(calculate(x, y, operator));
        }

        return operandStack2.peek();
    }

    private static long calculate(long x, long y, String operator) {
        System.out.println(x);
        System.out.println(y);
        System.out.println(operator);

        switch (operator) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return (long) x / y;
            default: return 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.expressionParser("3-3+3"));
    }
}
