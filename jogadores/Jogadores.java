import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Jogadores {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private int anoNascimento;
    private String universidade;
    private String cidadeNascimento;
    private String estadoNascimento;

    // construtores
    public Jogadores() {

        this.id = -1;
        this.nome = "";
        this.altura = -1;
        this.peso = -1;
        this.universidade = "";
        this.anoNascimento = -1;
        this.cidadeNascimento = "";
        this.estadoNascimento = "";

    }

    public Jogadores(int id, String nome, int altura, int peso, int anoNascimento, String universidade,
            String cidadeNascimento, String estadoNascimento) {

        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.anoNascimento = anoNascimento;

        if (universidade != null)
            this.universidade = universidade;
        else
            this.universidade = "nao informado";

        if (cidadeNascimento != null)
            this.cidadeNascimento = cidadeNascimento;
        else
            this.cidadeNascimento = "nao informado";

        if (estadoNascimento != null)
            this.estadoNascimento = estadoNascimento;
        else
            this.estadoNascimento = "nao informado";

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
    public Jogadores clone() {
        Jogadores clone = new Jogadores(this.id, this.nome, this.altura,
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
    public static void ler(int[] ids) throws IOException {

        Jogadores jogador;
        BufferedReader in = null;
        String csv = "players.csv";
        in = new BufferedReader(new FileReader(csv));
        String input = in.readLine();
        while (input != null) {

            input = in.readLine();

            for (int i = 0; i < ids.length; i++) {
                
                String[] split = input.split(",");

                if (Integer.parseInt(split[0]) == ids[i]) {

                    System.out.println(split.length);

                    for (int j = 0; j < split.length; j++) {
                        System.out.println(split[j]);
                    }

                    jogador = new Jogadores(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]),
                            Integer.parseInt(split[3]), Integer.parseInt(split[5]), split[4],
                            split[6], split[7]);

                    jogador.imprimir();
                }
            }
        }
        in.close();

    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int ids[] = new int[100000];

        while (!input.equals("FIM")) {
            int i = 0;
            System.out.println("input " + i +"= "+Integer.parseInt(input));
            ids[i] = Integer.parseInt(input);
            
            i++;
            input = sc.nextLine();
        }
        
        

        sc.close();
        }
    }

