

import java.io.IOException;
import java.util.Scanner;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Atalhos {
 
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       while (sc.hasNextLine()){
            String input = sc.nextLine();
            char [] in = input.toCharArray();
            boolean italico = false;
            boolean negrito = false;
            int n = input.length();
            for(int i = 0; i < n; i++){
                if(in[i] == '_'){
                    if(italico){
                        input = input.replaceFirst("_", "</i>");
                        italico = false;
                    }else{
                        input = input.replaceFirst("_", "<i>");
                        italico = true;
                    }
                }
                if(in[i] == '*'){
                    if(negrito){
                        input = input.replaceFirst("\\*", "</b>");
                        negrito = false;
                    }else{
                        input = input.replaceFirst("\\*", "<b>");
                        negrito = true;
                    }
                }
            }
                
            
        
       
                
            
            
            System.out.println(input);
           
        }
       
       
       sc.close();
    }
 
}
