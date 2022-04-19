package csMiddle.list.listContains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static String[] fireEmployees(String[] employees, String[] unemployed){
        List<String> resultList = new ArrayList<>();

        for (String employee : employees) {
            if (!Arrays.asList(unemployed).contains(employee)) {
                resultList.add(employee);
            }
        }

        return resultList.toArray(new String[resultList.size()]);
    }

    public static void printArray(String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){

        printArray(fireEmployees(new String[]{"Steve","David","Mike","Donald","Lake","Julian"},new String[]{"Donald","Lake"}));
        printArray(fireEmployees(new String[]{"Donald","Lake"},new String[]{"Donald","Lake"}));
        printArray(fireEmployees(new String[]{"Steve","David","Mike","Donald","Lake","Julian"},new String[]{}));
        printArray(fireEmployees(new String[]{"Mike","Steve","David","Mike","Donald","Lake","Julian"},new String[]{"Mike"}));
    }
}
