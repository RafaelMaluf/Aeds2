import java.io.IOException;
import java.util.Scanner;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Led {
 
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String input = "";
    
    for(int i = 0; i < n; i++){
    input = sc.nextLine();
    int leds = 0;
    input = input.trim();
    for(int j = 0; j < input.length(); j++){
        
        if(input.charAt(j) == 49){
            leds = leds + 2;
        }else 
        if(input.charAt(j) == 50 || input.charAt(j) == 51 || input.charAt(j) == 53){
            leds = leds + 5;
        }else 
        if(input.charAt(j) == 52){
            leds = leds + 4;
        }
        else 
        if(input.charAt(j) == 54 || input.charAt(j) == 48 || input.charAt(j) == 57){
            leds = leds + 6;
        }else
        if(input.charAt(j) == 55){
            leds = leds + 3;
        }else 
        if(input.charAt(j) == 56){
            leds = leds + 7;
        }
        
    }
        System.out.println(leds + " leds");
    }
       
    sc.close();
    }
 
} 
