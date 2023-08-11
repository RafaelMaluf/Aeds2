//package labs.AlgebraBoleana;
import java.util.Scanner;

public class Algebra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();
        
        palavra = palavra.replaceAll(" , ",",");
        String []split = palavra.split(" ");
        int n = Integer.parseInt(split[0]);
        boolean []termos = new boolean[n];

            for(int i = 1; i < n ;i++ ){
            termos[i] = Boolean.parseBoolean(split[i]);
            }
        
        String operacao = split[3];
        operador(operacao,termos);
        sc.close();
    }
    public static void operador(String operacao, boolean[] termos){
       if(){
              
       }
    }
    
}
