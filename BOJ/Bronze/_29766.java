package com.in28minutes.learnspringframework;

import java.util.Scanner;

public class _29766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int res = 0;

        for (int i = 0; i < line.length() - 3; i++) {
            String s = line.substring(i, i + 4);
            if (s.equals("DKSH")) {
                res++;
            }
        }

        System.out.println(res);
    }
}
