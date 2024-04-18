package Task4.Lambda;

import java.util.function.BinaryOperator;

public class LambdaToMethod {

    public static void main(String[] args) {

        LambdaToMethod obj = new LambdaToMethod();

        BinaryOperator<String> f = (s1, s2) -> concatStrings(s1, s2) + "\n" + obj.compareStrings(s1, s2) + "\n" + String.valueOf(s1.length() + s2.length());
        System.out.println(lambdaMethod(f, "We love Java", ", but Python more"));

    }

    public static String concatStrings(String str1, String str2) {
        return str1 + str2;
    }

    public String compareStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return str1;
        } else {
            return str2;
        }
    }

    public static String lambdaMethod(BinaryOperator f, String str1, String str2) {
        return (String) f.apply(str1, str2);
    }
}
