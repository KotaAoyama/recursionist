package csMiddle.object.objectReference;

class Person{
    public String firstName;
    public String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}

public class Main{
    public static String copyAndChangePersonState(Person inputPerson){
        // 新しいメモリアドレスに置き換えるため、渡された Person オブジェクトのコピーを作成します
        inputPerson = new Person(inputPerson.firstName, inputPerson.lastName);
        inputPerson.firstName = "Denice";
        inputPerson.lastName = "Harrison";
        return inputPerson.getFullName();
    }

    // オブジェクト入力として受け取り、状態を変更する外部の関数
    public static void changePersonState(Person person){
        person.firstName = "Denice";
        person.lastName = "Harrison";
    }

    public static void main(String[] args){
        Person carly = new Person("Carly", "Angelo");

        // carly のメモリアドレスを表示します。これがオブジェクト参照です
        // オブジェクト自体はヒープに格納されており、変数の中に格納されているものは参照(メモリアドレス)です
        System.out.println(carly);
        System.out.println(carly.getFullName());

        
        System.out.println("----- 副作用なし -----");
        System.out.println(carly.getFullName());

        // 関数内で新しいオブジェクトを作成します
        System.out.println(copyAndChangePersonState(carly));

        // carly の状態は維持されます
        System.out.println(carly.getFullName());


        System.out.println("----- 副作用あり -----");
        System.out.println(carly.getFullName());

        // オブジェクトの参照が値渡しで渡されます
        // したがって、関数内で状態を変更すると、呼び出し元のオブジェクトに影響を与えます
        changePersonState(carly);

        // 副作用によりオブジェクトの状態に変化が起きました
        // プリミティブ型の値渡しと大きく異なります
        System.out.println(carly.getFullName());
    }
}
