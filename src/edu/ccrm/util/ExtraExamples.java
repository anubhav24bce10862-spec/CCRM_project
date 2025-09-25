package edu.ccrm.util;

import java.util.Arrays;

public class ExtraExamples {
    // Demonstrate arrays, sorting, recursion, labeled break/continue

    public static void demonstrate(){
        int[] arr = {5,2,9,1,3};
        System.out.println("Original array:" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted array:" + Arrays.toString(arr));

        System.out.println("Factorial(5) via recursion = " + factorial(5));

        outer:
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1){
                    System.out.println("Breaking outer loop at i=1,j=1");
                    break outer;
                }
            }
        }

        for(int k=0;k<5;k++){
            if(k==2) continue; // demonstrate continue
            System.out.println("k="+k);
        }
    }

    private static int factorial(int n){
        if(n<=1) return 1;
        return n * factorial(n-1);
    }
}
