
    import java.util.Scanner;
        class is {
            public static void main(String[] args) {
                
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
                    if(entrada.charAt(i) != 'a' && entrada.charAt(i) != 'e' && entrada.charAt(i) != 'i' && entrada.charAt(i) != 'o' && entrada.charAt(i) != 'u'){
                        ehConsoante = true;
                    }else{
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
            }

            static boolean isReal(String entrada){
                boolean ehReal = false;
                for(int i = 0;i < entrada.length();i++){
                    if(entrada.charAt(i) >= '0' && entrada.charAt(i) <= '9'){
                        if(entrada.charAt(i) == '.'){
                        ehReal = true;                
                        }else{
                            return false;
                        }
                    }
            }

            
        }