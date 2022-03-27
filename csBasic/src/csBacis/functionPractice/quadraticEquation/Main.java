package csBacis.functionPractice.quadraticEquation;

public class Main {
    public static int quadraticEquation(int a, int b, int c) {
        // aが0の時は二次方程式ではないので最初に除外します。
        if (a == 0) return 0;
        // 判別式を作ります
        // b^2は、Mathライブラリのpow関数を使います。
        double d = Math.pow(b, 2) - 4 * a * c;

        // 判別式 d が 0 の時は重解を持つので 1 を返します。
        if (d == 0) return 1;
            // d が 0 より大きいときは　実数解を二つ持つので 2 を返します。
        else if (d > 0) return 2;
            // それ以外の時は虚数解を持つので -2 を返します。
        else return -2;
    }

    public static void main(String[] args) {
        System.out.println(quadraticEquation(0,3,2)); // 0
        System.out.println(quadraticEquation(0,4,5)); // 0
        System.out.println(quadraticEquation(5,10,5)); // 1
        System.out.println(quadraticEquation(4,10,8)); // -2
        System.out.println(quadraticEquation(4,13,5)); // 2
        System.out.println(quadraticEquation(1,6,9)); // 1
        System.out.println(quadraticEquation(1,-8,12)); // 2
        System.out.println(quadraticEquation(1,2,5)); // -2
    }
}
