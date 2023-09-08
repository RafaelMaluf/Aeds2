import java.util.Scanner;

    public class Espelho{
        public static void main(String [] Args){
            Scanner sc = new Scanner(System.in);
            
            int B = 0;
            int E = 0;
            String input = "";
            String espelho = "";
            while(sc.hasNext()){
                input = sc.nextLine();
                String [] split = input.split(" ");
                B = Integer.parseInt(split[0]);
                E = Integer.parseInt(split[1]);
                espelho = montaEspelho(B,E);
                System.out.println(espelho);
            }



            sc.close();
        }

        public static String montaEspelho (int B, int E){
            String espelho = "";
            for(int i = B; i <= E; i++){
               espelho = espelho + i;
                
            }
            for(int j = espelho.length()-1; j >= 0; j--){
               espelho = espelho + espelho.charAt(j);
                
            }
           
            return espelho;
        }
    }