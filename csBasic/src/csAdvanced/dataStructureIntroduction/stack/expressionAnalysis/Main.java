package csAdvanced.dataStructureIntroduction.stack.expressionAnalysis;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public static long expressionParser(String expression) {
        Stack<String> nums = new Stack<>(); // 数字を入れるためのスタック
        Stack<String> ops = new Stack<>(); // 演算子を入れるためのスタック

        for (int i = 0; i < expression.length(); i++) {
            // 演算子が来たときの処理
            if (!Character.isDigit(expression.charAt(i))) {
                String currOP = expression.charAt(i) + "";
                // 現在の演算子とスタックに入っている演算子の優先順位を比較します。
                // スタックに入っている演算子の方が優先順位が高い時は先に計算します。
                while (!ops.isEmpty() && getPriority(currOP) <= getPriority(ops.peek())) {
                    process(nums, ops.pop());
                }
                // 現在の演算子をスタックに入れます。
                ops.push(currOP);
            }
            // 数字が来たときの処理 ここでは文字列として扱います。
            else {
                String number = "";
                // 2桁以上の数字に対応するため、演算子がくるまで文字を結合していきます。
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    number += expression.charAt(i);
                    i++;
                }
                i--; // 最後に増やしたiを1つ戻しておきます。
                nums.push(number);
            }
        }

        // 演算子のスタックが空になるまでprocessを呼び出して計算を続けます。
        while (!ops.isEmpty()) {
            process(nums, ops.pop());

        }
        // 数字のスタックの先頭に答えが入っています。
        // =====Long.parseLongで文字列をlong型の数値に変更=====
        return Long.parseLong(nums.peek());
    }

    // スタックから数字を取り出し、受け取った演算子で計算する関数
    public static void process(Stack<String> stack, String op) {
        // 数字のスタックから文字列を取り出し数字にします。
        long right = Long.parseLong(stack.pop());
        long left = Long.parseLong(stack.pop());

        long value = 0;

        switch (op) {
            case "+":
                value = left + right;
                break;
            case "-":
                value = left - right;
                break;
            case "*":
                value = left * right;
                break;
            case "/":
                value = (int) Math.floor(left / right);
                break;
        }
        // 計算した結果は、次の演算子での計算のため再度スタックに入れます。
        stack.push(value + "");
    }

    // 演算子の優先順位を返す関数
    public static int getPriority(String op) {
        Map<String, Integer> map = new HashMap<>() {
            {
                put("*", 2);
                put("/", 2);
                put("+", 1);
                put("-", 1);
            }
        };
        int result = map.getOrDefault(op, 0);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.expressionParser("2+4*6")); // 26
        System.out.println(Solution.expressionParser("2*3+4")); // 10
        System.out.println(Solution.expressionParser("3-3+3")); // 3
        System.out.println(Solution.expressionParser("2+2+2")); // 6
        System.out.println(Solution.expressionParser("1-1-1")); // -1
        System.out.println(Solution.expressionParser("3*3/3*3*3")); // 27
        System.out.println(Solution.expressionParser("14/3*2")); // 8
        System.out.println(Solution.expressionParser("12/3*4")); // 16
        System.out.println(Solution.expressionParser("1+2+3+4+5+6+7+8+9+10")); // 55
        System.out.println(Solution.expressionParser("1+2*5/3+6/4*2")); // 6
        System.out.println(Solution.expressionParser("42")); // 42
        System.out.println(Solution.expressionParser("7*3622*636*2910*183+343/2926/1026")); // 8587122934320
    }
}
