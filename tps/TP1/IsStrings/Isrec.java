import java.util.Scanner;

public class Isrec {

  // Método recursivo que verifica se a string é composta somente por vogais
  public static boolean ehVogal(String str, int index) {
    if (index >= str.length()) {
      return true;
    }
    char c = str.charAt(index);
    if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
        c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
      return false;
    }
    return ehVogal(str, index + 1);
  }

  // Método recursivo que verifica se a string é composta somente por consoantes
  public static boolean ehConsoante(String str, int index) {
    if (index >= str.length()) {
      return true;
    }
    char c = str.charAt(index);
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
        !Character.isLetter(c)) {
      return false;
    }
    return ehConsoante(str, index + 1);
  }

  // Método recursivo que verifica se a string é um número inteiro
  public static boolean ehInteiro(String str, int index) {
    if (index >= str.length()) {
      return true;
    }
    char c = str.charAt(index);
    if (!Character.isDigit(c)) {
      return false;
    }
    return ehInteiro(str, index + 1);
  }

  // Método recursivo que verifica se a string é um número real
  public static boolean ehReal(String str, int index, boolean pontoDecimal) {
    if (index >= str.length()) {
      return pontoDecimal;
    }
    char c = str.charAt(index);
    if (c == '.' && !pontoDecimal) {
      pontoDecimal = true;
    } else if (!Character.isDigit(c)) {
      return false;
    }
    return ehReal(str, index + 1, pontoDecimal);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String str = sc.nextLine();
      boolean x1 = ehVogal(str, 0);
      boolean x2 = ehConsoante(str, 0);
      boolean x3 = ehInteiro(str, 0);
      boolean x4 = ehReal(str, 0, false);
      System.out.println((x1 ? "SIM" : "NAO") + " " + (x2 ? "SIM" : "NAO") + " " +
          (x3 ? "SIM" : "NAO") + " " + (x4 ? "SIM" : "NAO"));
    }
  }
}
