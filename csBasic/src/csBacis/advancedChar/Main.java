package csBacis.advancedChar;

public class Main {
    public static void main(String[] args){

        // 数値から char 型へ変換可能
        System.out.println((char)12398);
        System.out.println((char)0b11000001101110);
        System.out.println((char)0x306E);

        // char型から int 型へ変換可能
        System.out.println((int)'ぬ');

        // 練習問題 1
        // Unicode を使って、A をコンソールに出力してみましょう
        System.out.println('\u0041');

        // 練習問題 2
        // 16 進数 を使って、A をコンソールに出力してみましょう
        System.out.println((char)0x0041);

        // 練習問題 3
        // 10 進数 を使って、A をコンソールに出力してみましょう
        System.out.println((char)65);
    }
}
