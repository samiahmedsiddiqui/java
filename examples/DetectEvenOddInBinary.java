/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectevenoddinbinary;

/**
 *
 * @author sami
 */
public class DetectEvenOddInBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 43707;          // 1010101010111011
        int testNumber;
        String binaryNumber = Integer.toBinaryString(x);
        System.out.println(binaryNumber);
        for (int i = 0 ; i != binaryNumber.length() ; i++) {
            char c = binaryNumber.charAt(i);
            testNumber = Character.getNumericValue(binaryNumber.charAt(i));
            if (testNumber == 0) {
                System.out.println("Even Number");
            } else {
                System.out.println("Odd Number");
            }
        }
    }
    
}
