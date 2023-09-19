
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class testeArq {
    public static void main(String[] args) throws IOException {
        
        int X = 0;
        int Y = 0;
        String W = "";
        
        String input = leitor();
        while(input != null) {
            if(input.equals("inicio:")){

                while (!input.equals("fim")) {
                    input = leitor();
                    char [] Cinput = input.toCharArray();
                    Cinput[Cinput.length-1] = '\0';
                    input = String.valueOf(Cinput);
                    
                    if ((input.charAt(0)=='X')){   

                        
                        String [] split = input.split("=");                                              
                        X = Integer.parseInt(split[1]);
                        
                    } else

                    if ((input.charAt(0)=='Y')){   

                        String [] split = input.split("=");                        
                        Y = Integer.parseInt(split[1]);

                    } else {
                        
                        String [] split = input.split("=");
                        split[1] = split[1].replaceAll("\0", "");
                       
                        if(split[1].length() == 2){

                            if(split[1].charAt(1) == 'A'){

                            W = "0000";

                            } else 

                            W = "0101";
                            
                        }
                        else if(split[1].length() == 3){

                            if(split[1].charAt(1) == 'x'){

                            W = "0110";

                            } else if(split[1].charAt(1) == 'e'){
                                                      
                            W = "1011";

                            } else if(split[1].charAt(1) == 'o'){
                            W = "1110";
                            } else {
                            W = "1100";
                            }
                            
                        }
                        else if(split[1].length() == 4){
                            
                            if(split[1].charAt(0) == 'A'){
                                if(split[1].charAt(3) == 'n'){
                                    switch (split[1].charAt(1)) {
                                        case 'o':
                                            W = "0001";
                                            
                                            break;
                                        case 'e':
                                            W = "0100";
                                            
                                            break;
                                        case 'x':
                                            W = "1001";
                                            
                                            break;
                                    }

                                } else if(split[1].charAt(1) == 'e'){
                                   W =  "0111";
                                } else if (split[1].charAt(1) == 'o'){
                                   W = "1101";
                                }
                            } else if(split[1].charAt(0) == 'n'){
                                if(split[1].charAt(2) == 'e'){
                                    W = "0010";
                                } else if(split[1].charAt(2) == 'o'){
                                    W = "1000";
                                }
                            }
                            
                        } 
                        else if(split[1].length() == 5)
                        {
                            W = "0011";
                        } 
                        else if(split[1].length() == 6){
                            if(split[1].charAt(0) == 'B'){  
                                W = "1010";                               
                            } else {
                                W = "1111";
                            }

                        }
                      }
                      int decimal = 0;
                      if(W != ""){
                        
                      decimal = binaryToDecimal(Integer.parseInt(W));
                      W = decimalToHex(X) + "" + decimalToHex(Y) + "" + decimalToHex(decimal);
                      escritor(W);
                        }
                
                    }
                }
        
        System.out.println(input);
     }
     }
        
        public static String decimalToBinary(int decimal)
        {
 
        // variable to store the converted
        // binary string
        String binaryString = "";
 
        // loop to generate the binary
        while (decimal != 0) {
 
            // concatenating the remainder
            // on dividing by 2 to the
            // binary string
            binaryString = (decimal % 2) + binaryString;
 
            // updating the decimal integer
            // by dividing by 2 in each iteration
            decimal /= 2;
        }
 
        // loop to ensure that each
        // Hexadecimal character is
        // represented by 4 bits
        while (binaryString.length() % 4 != 0) {
            // adding leading 0's if the
            // character is represented by less
            // than 4 bits
            binaryString = "0" + binaryString;
        }
 
        // returning the converted binary string
        return binaryString;
        }
 

        public static int binaryToDecimal(int binary)
    {
 
        // variable to store the converted
        // binary number
        int decimalNumber = 0, i = 0;
 
        // loop to extract the digits of the binary
        while (binary > 0) {
 
            // extracting the digits by getting
            // remainder on dividing by 10 and
            // multiplying by increasing integral
            // powers of 2
            decimalNumber
                += Math.pow(2, i++) * (binary % 10);
 
            // updating the binary by eliminating
            // the last digit on division by 10
            binary /= 10;
        }
 
        // returning the decimal number
        return decimalNumber;
    }
 
    // method to convert decimal to hexadecimal
    public static String decimalToHex(int decimalNumber)
    { 
        // converting the integer to the desired
        // hex string using toHexString() method
        String hexNumber
            = Integer.toHexString(decimalNumber);
 
        // converting the string to uppercase
        // for uniformity
        hexNumber = hexNumber.toUpperCase();
 
        // returning the final hex string
        return hexNumber;
    }

    public static String leitor() throws IOException {
        

        FileInputStream stream = new FileInputStream("testeula.ula");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
		BufferedReader buffRead = new BufferedReader(new FileReader("testeula.ula"));
		String linha = br.readLine();
        System.out.println(linha);
        br.close();
		buffRead.close();
        return linha;
	}

	public static void escritor(String W) throws IOException {
    
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("testeula.hex"));
        buffWrite.append(W + "\n");
		buffWrite.close();
        
	}
 
}