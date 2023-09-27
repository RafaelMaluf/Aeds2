package tps.Palindromos;
//package labs.palindromos;

import java.util.Scanner;
    
        class Palindromo {
    	    public static void main(String[]args) {
    		    Scanner sc = new Scanner(System.in);
                String palavra = sc.nextLine();
                
    	    while(!palavra.equals("FIM")){
    		    
              
            	
                String palindromo = ""; // Inicializar a variável palindromo dentro do loop
    		
    		    for(int i = palavra.length() -1; i >= 0; i--){
    			
    		    	palindromo += palavra.charAt(i);//é possível fazer operações com strings no java
                   
    		    }
    		
    		    if(palindromo.equals(palavra)) {//para Strings usar equals ao invés de =
    			System.out.println("SIM");
    		    }
    		    else {
    			System.out.println("NAO");
                
    			}
				palavra = sc.nextLine(); // Ler uma nova palavra dentro do loop
    		    
    	    }
    	    sc.close();
        }

    }