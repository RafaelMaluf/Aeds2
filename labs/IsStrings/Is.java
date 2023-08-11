
    import java.util.Scanner;
        public class Is {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String entrada = sc.nextLine();
                while(!entrada.equals("FIM")){
                if(isVogal(entrada)){
                    System.out.print("SIM ");
                }else{
                    System.out.print("NAO ");
                }
                if(isConsoante(entrada)){
                    System.out.print("SIM ");
                }else{
                    System.out.print("NAO ");
                }
                if(isInteiro(entrada)){
                    System.out.print("SIM ");
                }else{
                    System.out.print("NAO ");
                }
                if(isReal(entrada)){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }
                entrada = sc.nextLine();
            }

            }

            static boolean isVogal(String entrada){
                boolean ehVogal = false;
                entrada = entrada.toLowerCase();
                for(int i = 0;i < entrada.length();i++){
                    if(entrada.charAt(i) == 'a' || entrada.charAt(i) == 'e' || entrada.charAt(i) == 'i' || entrada.charAt(i) == 'o' || entrada.charAt(i) == 'u'){
                        ehVogal = true;
                    }else{
                        return false;
                    }
                }
                return ehVogal;
            }

            static boolean isConsoante(String entrada){
                boolean ehConsoante = false;
                entrada = entrada.toLowerCase();
                for(int i = 0;i < entrada.length();i++){ 
                    if(entrada.charAt(i) >= 'a' && entrada.charAt(i) <= 'z'){
                        if(entrada.charAt(i) != 'a' && entrada.charAt(i) != 'e' && entrada.charAt(i) != 'i' && entrada.charAt(i) != 'o' && entrada.charAt(i) != 'u'){
                        ehConsoante = true;
                    } else {
                        ehConsoante = false;
                    }
                    }
                        else{
                        return false;
                    }
                }
                return ehConsoante;
            }

            static boolean isInteiro(String entrada){
                boolean ehInteiro = false;
                for(int i = 0;i < entrada.length();i++){
                    if(entrada.charAt(i) >= '0' && entrada.charAt(i) <= '9'){
                        ehInteiro = true;
                    }else{
                        return false;
                    }
                }
                return ehInteiro;
            }

            static boolean isReal(String entrada){
                boolean ehReal = false;
                for(int i = 0;i < entrada.length();i++){
                    if((entrada.charAt(i) >= '0' && entrada.charAt(i) <= '9')||(entrada.charAt(i) == '.')){
                        ehReal = true;                
                        }else{
                            return false;
                        }
                    }
                    return ehReal;
                }


            
        }