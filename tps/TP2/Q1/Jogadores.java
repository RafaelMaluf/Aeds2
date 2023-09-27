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

    }

    public Jogadores(int id, String nome, int altura, int peso, int anoNascimento, String universidade,
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
    public static void ler(int id) throws IOException {

        Jogadores jogador = new Jogadores();

        BufferedReader in = null;

        String csv = "players.csv";

        in = new BufferedReader(new FileReader(csv));

        String input = in.readLine();
        int i = 0;
        while (i < 3923) {

            input = in.readLine();
            if(input == null)
                break;
            String[] split = input.split(",");
            
                if (Integer.parseInt(split[0]) == id) {
                    
                    
                    jogador.setId(Integer.parseInt(split[0]));
                    jogador.setNome(split[1]);
                    jogador.setAltura(Integer.parseInt(split[2]));
                    jogador.setPeso(Integer.parseInt(split[3]));
                    if(split[4].length() > 4){
                        jogador.setUniversidade(split[4]);
                        jogador.setAnoNascimento(Integer.parseInt(split[5]));
                    } else {
                        jogador.setUniversidade("nao informado");
                        jogador.setAnoNascimento(Integer.parseInt(split[4]));
                    }
                    if(split.length > 6){
                        jogador.setCidadeNascimento(split[6]);
                        jogador.setEstadoNascimento(split[7]);
                    } else {
                        jogador.setCidadeNascimento("nao informado");
                        jogador.setEstadoNascimento("nao informado");
                    }
                 
                 jogador.imprimir();   
                
            }
            i++;
        } 
        
        
            in.close();
        }
        
    

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        
        while (!input.equals("FIM")) {
            
            int id = Integer.parseInt(input);
            ler(id);
            input = sc.nextLine();

        }
        
       
        

        sc.close();
        }
    }

