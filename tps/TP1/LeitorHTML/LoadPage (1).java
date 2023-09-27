
import java.util.Scanner;   
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.*;

class MyIO {

   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
   private static String charset = "ISO-8859-1";

   public static void setCharset(String charset_){
      charset = charset_;
      in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
   }

   public static void print(){
   }

   public static void print(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
   
   public static void print(float x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
   
   public static void print(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(){
   }

   public static void println(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(float x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
   
   public static void println(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void printf(String formato, double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.printf(formato, x);// "%.2f"
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim().replace(",","."));
      }catch(Exception e){}
      return d;
   }

   public static double readDouble(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readDouble();
   }

   public static float readFloat(){
      return (float) readDouble();
   }

   public static float readFloat(String str){
      return (float) readDouble(str);
   }

   public static int readInt(){
      int i = -1;
      try{
         i = Integer.parseInt(readString().trim());
      }catch(Exception e){}
      return i;
   }

   public static int readInt(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readInt();
   }

   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readString(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readString();
   }

   public static String readLine(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readLine(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readLine();
   }

   public static char readChar(){
      char resp = ' ';
      try{
         resp  = (char)in.read();
      }catch(Exception e){}
      return resp;
   }

   public static char readChar(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readChar();
   }

   public static boolean readBoolean(){
      boolean resp = false;
      String str = "";

      try{
         str = readString();
      }catch(Exception e){}

      if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
            str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
         resp = true;
            }

      return resp;
   }

   public static boolean readBoolean(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readBoolean();
   }

   public static void pause(){
      try{
         in.read();
      }catch(Exception e){}
   }

   public static void pause(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      pause();
   }
}
public class LoadPage {

    public void getPage(URL url) throws IOException {
        BufferedReader in = 
        new BufferedReader(new InputStreamReader(url.openStream()));
        String input = "";
        String inputLine = in.readLine();

       while ((inputLine = in.readLine()) != null) {
		
            input += inputLine;
        }
		countVogais(input);
        countConsoantes(input);
        countPadroes(input);

        in.close();
        
    }

    public static void main(String[] args) {
         MyIO.setCharset("UTF-8");
        URL url = null;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String nome = "";
        
        
        while(!(input.equals("FIM"))){
            nome = input;
            input = sc.nextLine();
        try {
            url = new URL(input);
            new LoadPage().getPage(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            break;
        }
        System.out.println(nome);
        input = sc.nextLine();
    }
    sc.close();
    }
    public void countVogais(String input){
        int tamanho = 0;
        int a,e,i,o,u;      // vogais simples
        a = e = i = o = u = 0;
        int _a,_e,_i,_o,_u; // à
        _a=_e=_i=_o=_u=0;
        int a_,e_,i_,o_,u_; // á
        a_=e_=i_=o_=u_=0;
        int a$,e$,i$,o$,u$; // â
        a$=e$=i$=o$=u$=0;
        int $a,$o;          // ã
        $a=$o=0;
        
        while (tamanho < input.length()){
            input = input.toLowerCase();
            char temp = input.charAt(tamanho);
           
            
        if(temp == 'a'){  a++;  } else
        if(temp == 'e'){  e++;  } else 
        if(temp == 'i'){  i++;  } else
        if(temp == 'o'){  o++;  } else
        if(temp == 'u'){  u++;  } else //vogais simples
        if(temp == 'à'){  _a++;  } else
        if(temp == 'è'){  _e++;  } else
        if(temp == 'ì'){  _i++;  } else
        if(temp == 'ò'){  _o++;  } else
        if(temp == 'ù'){  _u++;  } else //vogais com acento grave
        if(temp == 'á'){  a_++;  } else
        if(temp == 'é'){  e_++;  } else
        if(temp == 'í'){  i_++;  } else
        if(temp == 'ó'){  o_++;  } else
        if(temp == 'ú'){  u_++;  } else //vogais com acento agudo
        if(temp == 'â'){  a$++;  } else
        if(temp == 'ê'){  e$++;  } else
        if(temp == 'î'){  i$++;  } else
        if(temp == 'ô'){  o$++;  } else
        if(temp == 'û'){  u$++;  } else //vogais com acento circunflexo
        if(temp == 'ã'){  $a++;  } else
        if(temp == 'õ'){  $o++;  } // vogais com til
        tamanho++;
    }
        System.out.print("a("+a+") " + "e("+e+") " + "i("+i+") " + "o("+o+") " + "u("+u+") ");
        System.out.print("á("+a_+") " + "é("+e_+") " + "í("+i_+") " + "ó("+o_+") " + "ú("+u_+") ");
        System.out.print("à("+_a+") " + "è("+_e+") " + "ì("+_i+") " + "ò("+_o+") " + "ù("+_u+") ");
        System.out.print("ã("+$a+") " + "õ("+$o+") ");
        System.out.print("â("+a$+") " + "ê("+e$+") " + "î("+i$+") " + "ô("+o$+") " + "û("+u$+") ");
    }

    public void countConsoantes(String input){
        int tamanho = 0;
        int consoantes = 0;
        while (tamanho < input.length()){
            char temp = input.charAt(tamanho);
            if(temp == 113 || temp == 119 || temp == 114 || temp == 116 || temp == 121 || temp == 112 
            || temp == 115 || temp == 100 || temp == 102 || temp == 103 || temp == 104 || temp == 106 
            || temp == 107 || temp == 108 || temp == 122 || temp == 120 || temp == 99 || temp == 118 
            || temp == 98 || temp == 110 || temp == 109){
                consoantes++;
            }
            tamanho++;
        }
        System.out.print("consoante(" + consoantes + ") ");
    }

    public void countPadroes(String input){
        if(input.contains("<br>")){     System.out.print("<br>(1) ");     } 
        else { System.out.print("<br>(0) "); }
        if(input.contains("<table>")){      System.out.print("<table>(1) ");      } 
        else { System.out.print("<table>(0) "); }
    }
    
}