import java.util.Locale;
import java.util.Scanner;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.nio.charset.*;


public class Arquivoemjava {
	  public static void main(String[] args) throws IOException {
	    Scanner scanner = new Scanner(System.in);
	    scanner.useLocale(Locale.US);

	    int n = scanner.nextInt();

	    RandomAccessFile raf = new RandomAccessFile("numeros.txt", "rw");

	    for (int i = 0; i < n; i++) {

	      double aux = scanner.nextDouble();
	      raf.writeDouble(aux);
	    }

	    raf.close();


	    RandomAccessFile raf2 = new RandomAccessFile("numeros.txt", "rw");
	    for (int i = n * 8 - 8; i >= 0; i -= 8) {
	      raf2.seek(i);
	      double num = raf2.readDouble();
	      if (num == (int) num) {
	        System.out.println((int) num); // imprime o número sem as casas decimais
	      } else {
	        System.out.println(num); // imprime o número com as casas decimais
	      }
	    }
	    raf2.close();
	  }
	}


