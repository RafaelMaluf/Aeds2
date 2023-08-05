//package Exnivelamento;

import java.util.Scanner;
public class TestaPresenca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = Integer.parseInt(sc.nextLine());
        int array[] = new int[n];
        while (n > 0) {
            int i = 0;            
            array[i] = sc.nextInt();
            i++;
            n--;
        }
        int x = sc.nextInt();
        testaPresenca(array, x);
        sc.close();
    } 
   
    
        static boolean testaPresenca(int[] array, int x) {
            for (int i = 0; i < array.length; i++) {
                if(array[i] == x) {
                    return true;
                }
            }
            return false;
        }
    }