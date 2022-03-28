package csBacis.functionPractice.isSameLocation;

public class Main {
    public static boolean isSameLocation(int x1, int v1, int x2, int v2) {
        // if文で v1 と v2 が同じだった場合を除きます。
        if (v1 == v2){
            // 同じ速さで、初期地点も同じ時にはTrue
            // それ以外はFalseを返します。
            return x1 == x2;
        }
        // 二人が同じ距離にいるときの時間を計算します
        double time = (x2 - x1) / (double)(v1 - v2);
        // time が正の整数になるときが True です。
        return time >= 0 && time % 1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isSameLocation(0,0,0,0)); // true
        System.out.println(isSameLocation(0,3,5,2)); // true
        System.out.println(isSameLocation(0,2,8,2)); // false
        System.out.println(isSameLocation(0,2,8,3)); // false
        System.out.println(isSameLocation(0,5,1000,3)); // true
        System.out.println(isSameLocation(0,5,1000,2)); // false
        System.out.println(isSameLocation(14,4,98,2)); // true
        System.out.println(isSameLocation(42,3,94,2)); // true
        System.out.println(isSameLocation(43,5,49,3)); // true
        System.out.println(isSameLocation(3,2,0,3)); // true
        System.out.println(isSameLocation(9,2,9,7)); // true
    }
}
