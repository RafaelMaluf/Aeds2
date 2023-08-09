
import java.util.Scanner;

    public class Ciframento{
        public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String palavra = sc.nextLine();
        
         while (!palavra.equals("FIM")){
            String cifrado = "";
            for (int i = 0; i < palavra.length(); i++){
                cifrado += (char)(palavra.charAt(i) + 3);
            }
            System.out.println(cifrado);
            palavra = sc.nextLine();
         }
        
          sc.close();
         }
}