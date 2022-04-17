package csMiddle.list.overload;

public class Main{
    public static void printArray(String arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 関数のオーバーロードを使います。
    // 関数のオーバーロードでは、同じ関数があっても異なるデータ型が必要な場合、名前がぶつかり合うことなく関数を使うことができます。
    // コンパイラは、入力データ型に基づいて適切な関数を検索します。
    public static void printArray(double arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(char arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        double doubleArr[] = {34.5,34.4,23,54.3};
        char charArr[] = {'h','e','l','l','o'};
        String stringArr[] = {"The race is starting.", "A dog just escaped", "The company ran out of business"};

        printArray(doubleArr);
        printArray(charArr);
        printArray(stringArr);
    }
}
