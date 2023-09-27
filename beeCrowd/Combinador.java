import java.io.IOException;
import java.util.Scanner;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Combinador {
 
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String input = "";
    for(int i = 0; i < n; i++){
     input = sc.nextLine();
     String [] split = input.split(" ");
     char [] charArray = split[0].toCharArray();
     char [] charArrays = split[1].toCharArray();
     int x = charArray.length > charArrays.length ? charArray.length : charArrays.length;
        String output ="";
     for(int j = 0; j < x; j++){
         if(j < charArray.length){
             output = output + charArray[j];
         }
         if(j < charArrays.length){
             output = output + charArrays[j];
         }
     }
     System.out.println(output);
     sc.close();
    
    }
        
 
    }
 
}