package csMiddle.list.generateAlphabet;

public class Main {
    public static char[] generateAlphabet(char firstAlphabet, char secondAlphabet){
        firstAlphabet = Character.toLowerCase(firstAlphabet);
        secondAlphabet = Character.toLowerCase(secondAlphabet);
        char[] stations = new char[(int)secondAlphabet - (int)firstAlphabet + 1];
        for (int i = (int) firstAlphabet; i <= (int) secondAlphabet; i++) {
            stations[i] = (char) i;
        }

        return stations;
    }

    public static void main(String[] args) {
        System.out.println(generateAlphabet('a','z'));// --> [a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z]
        System.out.println(generateAlphabet('b','b'));// --> [b]
        System.out.println(generateAlphabet('C','Z'));// --> [c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z]
        System.out.println(generateAlphabet('M','z'));// --> [m,n,o,p,q,r,s,t,u,v,w,x,y,z]
        System.out.println(generateAlphabet('z','a'));// --> [a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z]
    }
}
