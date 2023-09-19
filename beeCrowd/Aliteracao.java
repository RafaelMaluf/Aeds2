import java.io.IOException;
import java.util.Scanner;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Aliteracao {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = "";
        int cont =0;

        while(sc.hasNextLine()){
            input = sc.nextLine().toLowerCase();
            String [] split = input.split(" ");
            for(int i = 0; i < split.length - 1; i++){
                if(split[i].charAt(0) == split[i+1].charAt(0)){
                    cont = cont + 1;
                    i++;
                }
            }
         System.out.println(cont);   
        }

        
        sc.close();
    }
     
        
    }
 
