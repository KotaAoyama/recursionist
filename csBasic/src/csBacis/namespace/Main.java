package csBacis.namespace;

// 以下の PhysicsThings の名前空間を作成しましょう
// 重力加速度を 9.8 としてください
// 物体の質量を受け取り、重量を返すメソッドを作成してください
// 物体の質量と高さを受け取り、位置エネルギー（質量 * 高さ * 重力加速度）を返すメソッドを作成してください
// 物体の質力と速さを受け取り、運動エネルギー（質量 * 速さ^2 / 2）を返すメソッドを作成してください
// 質量・高さ・速さは int 型とします
class PhysicsThings {

    public static final double GRAVITY = 9.8;

    public static double getWeight(int quality) {
        return quality * GRAVITY;
    }

    public static double potentialEnergy(int quality, int height) {
        return quality * height * GRAVITY;
    }

    public static double kineticEnergy(int quality, int speed) {
        return quality * speed * speed / 2;
    }

}

// 以下のデータを出力してください
// PhysicsThings.GRAVITY - 9.8
// PhysicsThings.getWeight(80) - 784.0
// PhysicsThings.potentialEnergy(80,4) - 3136.0
// PhysicsThings.kineticEnergy(80,10) - 4000.0
class Main {
    public static void main(String[] args) {

        System.out.println(PhysicsThings.GRAVITY);

        System.out.println(PhysicsThings.getWeight(80));

        System.out.println(PhysicsThings.potentialEnergy(80,4));

        System.out.println(PhysicsThings.kineticEnergy(80,10));
    }
}
