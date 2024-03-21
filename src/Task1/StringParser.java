package Task1;

public class StringParser {
    public static void main(String[] args) {

        String string = "1234";

        Boolean negative = true;
        if (Character.isDigit(string.charAt(0))) {
            negative = false;
        }

        int number = 0;
        for (int i = 0; i < string.length(); i++) {
            if (i == 0 & negative) {
                continue;
            }
            else {
                number += Character.getNumericValue(string.charAt(i)) * Math.pow(10, (string.length() - i - 1));
            }
        }
        if (negative) {
            number *= -1;
        }
        System.out.println(number);
    }
}
