package main.java.Leetcode.MonthlyLC;

import java.util.Random;

public class Practice {
    public static void main(String[] args) {
        int seat_conf = 7;  // input seat config
        int number_of_treats = 15;  // number of treats
        int draw = 0;
        if (seat_conf > 0) {
            draw = usingRandomClass(seat_conf);
        }
        System.out.println("draw: " + draw);
        int each_std = number_of_treats / seat_conf;
        int remaing = number_of_treats % seat_conf;
        int each_student1 = draw;
        if (draw > 0) {
            for (int i = 0; i < seat_conf - remaing; i++) {
                each_student1--;
                System.out.println("each student: " + each_student1 + ":" + number_of_treats / seat_conf);
            }
        }
        each_std++;
        for (int i = 0; i < remaing; i++) {
            if (draw > seat_conf) {
                draw = 1;
            }
            System.out.println("seat No :" + draw + ":" + each_std);
            if (i == remaing - 1) {
                System.out.println(" Output a: last seat No :" + draw);
            }
            draw++;
        }
    }
    static int usingRandomClass(int seat_conf) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(seat_conf) + 1;
    }
}
