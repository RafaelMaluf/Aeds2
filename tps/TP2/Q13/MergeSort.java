/**
 * MergeSort em java.
 * @author Rafael Maluf Araujo - 761579
 * @version 1 09/2023
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class jogador {

    private int id;
    private String nome;
    private int altura;
    private int peso;
    private int anoNascimento;
    private String universidade;
    private String cidadeNascimento;
    private String estadoNascimento;

    // construtores
    public jogador() {

        this.id = -1;
        this.nome = "";
        this.altura = -1;
        this.peso = -1;

    }

    public jogador(int id, String nome, int altura, int peso, int anoNascimento, String universidade,
            String cidadeNascimento, String estadoNascimento) {

        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.anoNascimento = anoNascimento;
        this.universidade = universidade;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;

    }

    // getters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public String getUniversidade() {
        return universidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    // metodo clone
    public jogador clone() {
        jogador clone = new jogador(this.id, this.nome, this.altura,
                this.peso, this.anoNascimento, this.universidade,
                this.cidadeNascimento, this.estadoNascimento);
        return clone;
    }

    // metodo imprimir
    public void imprimir() {
        System.out.println("[" + this.id + " ## " + this.nome + " ## " + this.altura
                + " ## " + this.peso + " ## " + this.anoNascimento + " ## "
                + this.universidade + " ## " + this.cidadeNascimento + " ## "
                + this.estadoNascimento + "]");
    }

    // metodo ler
    public void read(String input) throws IOException {

        if (input == null || input.equals("FIM")) {
            return;
        }

        String[] split = input.split(","); // separa os dados em um array de strings

        this.setId(Integer.parseInt(split[0]));
        this.setNome(split[1]);
        this.setAltura(Integer.parseInt(split[2]));
        this.setPeso(Integer.parseInt(split[3]));
        // Id Nome Altura e Peso dos this sempre presentes

        if (split[4].length() > 4) { // se o tamanho da string for maior que 4, significa que a universidade foi
                                     // informada

            this.setUniversidade(split[4]);
            this.setAnoNascimento(Integer.parseInt(split[5]));

            if (split.length >= 8) { // se o tamanho do array for maior ou igual a 8, significa que a cidade e o
                                     // estado foram informados
                this.setCidadeNascimento(split[6]);
                this.setEstadoNascimento(split[7]);

            } else {
                this.setCidadeNascimento("nao informado");
                this.setEstadoNascimento("nao informado");
            }

        } else {
            this.setUniversidade("nao informado");
            if (split[4].equals("")) { // se a universidade nao for informada a posicao 4 da string vai ser
                                       // vazia, entao o ano de nascimento vai estar na posicao 5
                this.setAnoNascimento(Integer.parseInt(split[5]));
            } else
                this.setAnoNascimento(Integer.parseInt(split[4]));

            if (split.length >= 7) { // se a universidade nao for informada mas o split for maior que 7
                                     // significa que a cidade e o estado foram informados
                this.setCidadeNascimento(split[5]);
                this.setEstadoNascimento(split[6]);

            } else {
                this.setCidadeNascimento("nao informado");
                this.setEstadoNascimento("nao informado");
            }
        }

    }
}

public class MergeSort {

    public static int comp = 0;
    public static int mov = 0;

    public static boolean isFim(String s) {
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void mergeSort(ArrayList<jogador> players) {
        mergeSort(players, 0, players.size() - 1);
    }

    public static void mergeSort(ArrayList<jogador> players, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(players, esq, meio);
            mergeSort(players, meio + 1, dir);
            merge(players, esq, meio, dir);
        }
    }

    public static void merge(ArrayList<jogador> players, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        jogador[] a = new jogador[n1];
        jogador[] b = new jogador[n2];

        for (int i = 0; i < n1; i++) {
            a[i] = players.get(esq + i);
        }
        for (int j = 0; j < n2; j++) {
            b[j] = players.get(meio + 1 + j);
        }

        int i = 0;
        int j = 0;
        int k = esq;

        while (i < n1 && j < n2) {
            comp++;
            if (a[i].getUniversidade().compareTo(b[j].getUniversidade()) < 0) {
                mov++;
                players.set(k, a[i]);
                i++;
            }else if(a[i].getUniversidade().compareTo(b[j].getUniversidade()) > 0){
                players.set(k, b[j]);
                mov++;
                j++;
            }
            else {
                if(a[i].getNome().compareTo(b[j].getNome()) < 0){
                    players.set(k, a[i]);
                    mov++;
                    i++;
                }
                else{
                    players.set(k, b[j]);
                    j++;
                }
                    
            }
            k++; 
        }

        while (i < n1) {
            players.set(k, a[i]);
            i++;
            k++;
        }

        while (j < n2) {
            players.set(k, b[j]);
            j++;
            k++;
        }
    }

    public static void main(String[] args) throws Exception {

        String base = "/tmp/players.csv";
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        ArrayList<jogador> players = new ArrayList<jogador>();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(base)));
        String lineCSV = null;
        int lineNumber = 0;

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        while ((lineCSV = br.readLine()) != null) {
            map.put(lineNumber, lineCSV);
            lineNumber++;
        }

        br.close();

        while (!isFim(line)) {
            line = map.get(Integer.parseInt(line) + 1);
            jogador player = new jogador();
            player.read(line);
            players.add(player);
            line = sc.nextLine();
        }

       mergeSort(players);

        for (int i = 0; i < players.size(); i++) {
            players.get(i).imprimir();
        }

        sc.close();

    }
}
