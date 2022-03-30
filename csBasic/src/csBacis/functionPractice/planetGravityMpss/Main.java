package csBacis.functionPractice.planetGravityMpss;

public class Main {
    public static double planetGravityMpss(String planet) {
        if (planet.equals("Earth")) return 9.8;
        if (planet.equals("Jupiter")) return 24.79;
        if (planet.equals("Mercury")) return 3.7;
        else return 0;
    }

    public static double metersToMiles(double meter) {
        return meter * 0.000621371;
    }

    public static int fallingDistance(String planet, int time){
        double meter = planetGravityMpss(planet) * Math.pow(time, 2) / 2;
        return (int) Math.floor(metersToMiles(meter));
    }

    public static void main(String[] args) {
        System.out.println(fallingDistance("Earth", 5000));
    }
}
