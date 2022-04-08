package csMiddle.recursion.product;

public class Main {
    public static int productHelper(int x, int y, int result) {
        if (y == 0) return result;
        if (y > 0) return productHelper(x, y-1, result+x);
        else return productHelper(x, y+1, result+x);
    }

    public static int product(int x, int y){
        if (y >= 0) return productHelper(x, y, 0);
        else return -productHelper(x, y, 0);
    }

    public static void main(String[] args) {
        System.out.println(product(5,3)); // 15
        System.out.println(product(5,-1)); // -5
        System.out.println(product(-9,8)); // -72
        System.out.println(product(-10,-5)); // 50
        System.out.println(product(0,2)); // 0
        System.out.println(product(-9,0)); // 0
        System.out.println(product(0,0)); // 0
    }
}
