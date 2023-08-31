
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


    public class Ciframento{
        public static void main(String[] args) {
           

        
         Scanner sc = new Scanner(System.in);
          ByteBuffer buffer = StandardCharsets.UTF_8.encode(sc.nextLine()); 
          String palavra = StandardCharsets.UTF_8.decode(buffer).toString();
        
        
         while (palavra.length()==3 && palavra.charAt(0)!='F' && palavra.charAt(1)!='I' && palavra.charAt(2)!='M'){
            String cifrado = "";
            for (int i = 0; i < palavra.length(); i++){
                cifrado += (char)(palavra.charAt(i) + 3);
            }
            System.out.println(cifrado);
            buffer = StandardCharsets.UTF_8.encode(sc.nextLine()); 
            palavra = StandardCharsets.UTF_8.decode(buffer).toString();
         }
        
          sc.close();
         }
}