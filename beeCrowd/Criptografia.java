import java.io.IOException;
import java.util.Scanner;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Criptografia {
 
    public static void main(String[] args) throws IOException {
 
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = Integer.parseInt(input);
        for(int i = 0; i < n;i++){
            String output ="";
            input = sc.nextLine();
            char [] array = input.toCharArray();
            for(int j = 0; j < input.length(); j++){                  //primeira passada
            
                 if((input.charAt(j) > 96 && input.charAt(j) < 123)
                  ||(input.charAt(j) > 65 && input.charAt(j) < 90)){
                   
                    
                    array[j] = (char)(input.charAt(j) + 3);
                    output += array[j];
                    }
                    else{
                        output += input.charAt(j);
                    }
                    
            }
                    
                    
                    
                    
                
            
            array = output.toCharArray();
            output = "";
            for(int k = array.length-1; k >= 0 ; k--){            //segunda passada
                int l = 0;
                
                array[l] = array[k];
                
                output += array[l];
                l++;
            
            }
            
            array = output.toCharArray();
            output = "";
             for(int j = array.length/2; j < array.length; j++){        // terceira passada
                
                    
                    array[j] = (char)(array[j] - 1);
                    
                    
                
            }
            for(int m = 0; m < array.length; m++){
                output += array[m];
            }
            System.out.println(output);
        }
        sc.close();
    }
 
}