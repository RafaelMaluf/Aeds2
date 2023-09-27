
import java.util.Scanner;
import java.util.Random;
    class Alteracao{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String palavra = sc.nextLine();
            Random gerador = new Random( );
                   gerador.setSeed (4);
            while (!palavra.equals("FIM")){
                char x = ((char) ('a' + (Math.abs (gerador.nextInt( )) % 26)));
                char y = ((char) ('a' + (Math.abs (gerador.nextInt( )) % 26)));
              
              
              palavra = palavra.replace(x,y);
              
              System.out.println(palavra);
              palavra = sc.nextLine();
                
            }
            sc.close();
        }
        
        
    }