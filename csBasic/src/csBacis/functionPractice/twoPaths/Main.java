package csBacis.functionPractice.twoPaths;

public class Main {
    public static String twoPaths(String path1, String path2){
        String replacedPath1 = path1.replace("/", "");
        String replacedPath2 = path2.replace("/", "");

        return replacedPath1 + "/" + replacedPath2;
    }

    public static void main(String[] args) {
        System.out.println(twoPaths("recursioninst/", "/great/"));
    }
}
