package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        System.out.println("Input:");
        Scanner scr = new Scanner(System.in);
        String str = scr.nextLine();
        String[] strArr = str.split(" ");
        boolean checkRoman = true;
        try {
            RomanNumerals.valueOf(strArr[0]);
            RomanNumerals.valueOf(strArr[2]);
        } catch (IllegalArgumentException e) {
            checkRoman = false;
        }
        int length = strArr.length;
        if (checkRoman && length < 4) {
            RomanNumerals roman1 = RomanNumerals.valueOf(strArr[0]);
            RomanNumerals roman2 = RomanNumerals.valueOf(strArr[2]);
            switch (strArr[1]) {
                case "+":
                    System.out.println("Output:");
                    System.out.println(intRoman(roman1.getRomanInt() + roman2.getRomanInt()));
                    break;
                case "-":
                    if ((roman1.getRomanInt() - roman2.getRomanInt()) > 0) {
                        System.out.println("Output:");
                        System.out.println(intRoman(roman1.getRomanInt() - roman2.getRomanInt()));
                        break;
                    } else {
                        throw new Exception("Error: 0 or negative value");
                    }
                case "*":
                    System.out.println("Output:");
                    System.out.println(intRoman(roman1.getRomanInt() * roman2.getRomanInt()));
                    break;
                case "/":
                    if ((roman1.getRomanInt() / roman2.getRomanInt()) == 0) {
                        throw new Exception("Error: less than 1");
                    } else {
                        System.out.println("Output:");
                        System.out.println(intRoman(roman1.getRomanInt() / roman2.getRomanInt()));
                        break;
                    }
                default:
                    throw new Exception("Error");
            }
        } else {
            int num1 = Integer.parseInt(strArr[0]);
            int num2 = Integer.parseInt(strArr[2]);
            if (num1 > 0 && num1 <= 10 && num2 > 0 && num2 <= 10 && length < 4) {
                switch (strArr[1]) {
                    case "+":
                        System.out.println("Output:");
                        System.out.println(num1 + num2);
                        break;
                    case "-":
                        System.out.println("Output:");
                        System.out.println(num1 - num2);
                        break;
                    case "*":
                        System.out.println("Output:");
                        System.out.println(num1 * num2);
                        break;
                    case "/":
                        if (num1 % num2 == 0) {
                            System.out.println("Output:");
                            System.out.println(num1 / num2);
                            break;
                        } else {
                            System.out.println("Output:");
                            double d1 = new Double(num1);
                            double d2 = new Double(num2);
                            System.out.println(d1 / d2);
                            break;
                        }
                    default:
                        throw new Exception("Error");
                }
            } else {
                throw new Exception("Error");
            }
        }
    }

    public static String intRoman(int num) {
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + units[num % 10];
    }
}
