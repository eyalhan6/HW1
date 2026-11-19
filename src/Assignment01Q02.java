public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        for (int k = 0; k < Integer.parseInt(args[0]); k++) {
            approxPi += (Math.pow(-1, k))*(4.0/(2*k+1));
        }

        System.out.println(approxPi + " " + actualPi);
    }
}
