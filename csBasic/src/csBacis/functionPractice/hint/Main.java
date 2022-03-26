package csBacis.functionPractice.hint;

public class Main {
    public static String lastFourHint(String stringInput){
        if (stringInput.length() < 6) return "There is no Hint";
        return "Hint is:" + stringInput.substring(stringInput.length()-4);
    }

    public static void main(String[] args) {
        System.out.println(lastFourHint("Yes we can!"));
    }
}
