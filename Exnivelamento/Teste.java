import java.util.ArrayList;

class Fila {

    public ArrayList<Integer> lista;

    public Fila(){
        lista = new ArrayList<Integer>();
    }

    public void inserir(int elemento){
        lista.add(elemento);
    }

    public void remover(){
        lista.remove(0);
    }

    public void mostrar(){
        for(int i = 0; i < lista.size() ;i ++){
            System.out.println(lista.get(i));
        }
        
    }

}
public class Teste {
    public static void main(String [] Args){
        Fila fila = new Fila();
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        fila.inserir(4);
        fila.inserir(5);
        fila.inserir(6);
        fila.remover();
        fila.remover();
        fila.mostrar();


    }
}