package com.company;

import java.util.Scanner;

public class Main {

    //Data Members
    private static Scanner scan;
    private static int cardNo;
    private static char[] cardNo_Char = new char[8];
    private static int[] cardNo_Array = new int[8];
    private static int evenValue = 0;
    private static int oddValue = 0;
    private static int sumValue = 0;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        System.out.println("Enter Your Card No. ");
        cardNo = scan.nextInt();
        System.out.println("Validating.....");
        if (("" + cardNo).toCharArray().length == 8) {
            System.out.println("Length Ok..");
            System.out.println("Length " + cardNo_Char.length);
            if (validateCard(cardNo) == true) {
                System.out.println("Validation is Completed");
                System.out.println("Card is Accepted");
            } else {
                System.out.println("Validation is Completed");
                System.err.println("Card is Not Accepted");
            }

        } else {
            System.err.println("Check Your Card No.");
            System.exit(0);
        }
    }

    //Member Function
    private static boolean validateCard(int cardNo) {
        cardNo_Char = ("" + cardNo).toCharArray();
        for (int i = 0; i < cardNo_Char.length; i++) {
            cardNo_Array[i] = Character.getNumericValue(cardNo_Char[i]);
        }

        //oddCardNo. Sumation
        for (int i = 1; i <= 7; i = i + 2) {
            oddValue += cardNo_Array[i];
        }

        //evenCardNo. Sumation
        for (int i = 0; i <= 6; i = i + 2) {
            int temp = cardNo_Array[i] * 2;
            int temp1 = 0;
            while (temp != 0) {
                temp1 += temp % 10;
                temp = temp / 10;
            }
            evenValue += temp1;
        }
        System.out.println("Odd Value: " + oddValue);
        System.out.println("Even Value: " + evenValue);

        sumValue = oddValue + evenValue;

        if (sumValue % 10 == 0)
            return true;
        else
            return false;

        //end
    }
}


