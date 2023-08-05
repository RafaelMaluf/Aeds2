//package Exnivelamento;

import java.util.Scanner;
public class Presenca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0; 
        int n = Integer.parseInt(sc.nextLine());
        int array[] = new int[n];
        while (n > 0) {
                       
            array[i] = sc.nextInt();
            i++;
            n--;
        }
        int x = sc.nextInt();
        
        if(testaPresenca(array, x)){
        
        System.out.println("SIM");
        }
        else{
        System.out.println("NAO");
        }
        
        sc.close();
    } 
   
    
    static boolean testaPresenca(int[] array, int x) {
        int esquerda = 0;
        int direita = array.length - 1;
        
        while (esquerda <= direita) { //condição para finalizar o loop
            int meio = esquerda + (direita - esquerda) / 2; //definir meio dentro do loop
            
            if (array[meio] == x) {
                return true; 
            } else if (array[meio] < x) {
                esquerda = meio + 1; 
            } else {
                direita = meio - 1; 
            }
        }
        
        return false; 
    }
    
    }