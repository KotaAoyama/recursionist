package csMiddle.object.RGB;

class RGB{
    private final int red;
    private final int green;
    private final int blue;

    public RGB(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String getHexCode() {
        return "#" + String.format("%02x%02x%02x", this.red, this.green, this.blue);
    }

    public String getBits() {
        String hex = getHexCode();
        int decimal = Integer.parseInt(hex.substring(1), 16);
        return Integer.toBinaryString(decimal);
    }

    public String getColorShade() {
        if (this.red == this.green && this.green == this.blue) return "grayscale";

        if (this.red > this.green) {
            if (this.red > this.blue) {
                return "red";
            } else {
                return "blue";
            }
        } else {
            if (this.green > this.blue) {
                return "green";
            } else {
                return "blue";
            }
        }
    }
}

public class Main {
    public static void main(String[] args){
        RGB color1 = new RGB(0, 153, 255);
        System.out.println(color1.getHexCode());
        System.out.println(color1.getBits());
        System.out.println(color1.getColorShade());

        RGB color2 = new RGB(255, 153, 204);
        System.out.println(color2.getHexCode());
        System.out.println(color2.getBits());
        System.out.println(color2.getColorShade());

        RGB color3 = new RGB(0, 87, 0);
        System.out.println(color3.getHexCode());
        System.out.println(color3.getBits());
        System.out.println(color3.getColorShade());

        RGB gray = new RGB(123, 123, 123);
        System.out.println(gray.getHexCode());
        System.out.println(gray.getBits());
        System.out.println(gray.getColorShade());
    }
}
