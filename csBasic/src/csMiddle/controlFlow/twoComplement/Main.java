package csMiddle.controlFlow.twoComplement;

public class Main {
    public static String twosComplement(String bits){

        String twoComplement = oneComplement(bits);
        int len = twoComplement.length();
        boolean carryOut = false;

        for (int i = len - 1; i >= 0; i--) {
            if (twoComplement.charAt(i) == '0') {
                twoComplement = twoComplement.substring(0, i) + '1' + twoComplement.substring(i+1, len);
                carryOut = false;
                break;
            } else {
                twoComplement = twoComplement.substring(0, i) + '0' + twoComplement.substring(i+1, len);
                carryOut = true;
            }
        }
        return carryOut ? '1' + twoComplement : twoComplement;
    }

    public static String oneComplement(String bits){
        String output = "";
        for (int i = 0; i < bits.length(); i++) {
            output += bits.charAt(i) == '0' ? "1" : "0";
        }
        return output;
    }

    public static void main(String[] args){
        System.out.println(twosComplement("00011100")); // 11100100
        System.out.println(twosComplement("10010")); // 01110
        System.out.println(twosComplement("001001")); // 110111
        System.out.println(twosComplement("0111010")); // 1000110
        System.out.println(twosComplement("1")); // 1
        System.out.println(twosComplement("0")); // 10
        System.out.println(twosComplement("000")); // 1000
    }
}
