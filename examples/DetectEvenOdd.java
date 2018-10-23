/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectevenodd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sami
 */
public class DetectEvenOdd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 43707;
        List<Integer> digits = new ArrayList<>();
        while(x > 0) {
            digits.add(x % 10);
            x /= 10;
        }
        int i = digits.size() - 1;
        int total = 0;
        while (i >= total) {
           if(digits.get(i)%2 == 0){
               System.out.println("Even Number" + digits.get(i));
           } else {
                System.out.println("Odd Number" + digits.get(i));
           }
           i--;
        }
    }
}
