import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Jogadores {
private int id;
private String nome;
private int altura;
private int peso;
private int anoNascimento;
private String universidade;
private String cidadeNascimento;
private String estadoNascimento;

    //construtores
        public Jogadores(){
           
           this.id = -1;
           this.nome = "";
           this.altura = -1;
           this.peso = -1;
           this.universidade = "";
           this.anoNascimento = -1;
           this.cidadeNascimento = "";
           this.estadoNascimento = "";

        }

        public Jogadores(int id, String nome, int altura, int peso, int anoNascimento, String universidade, String cidadeNascimento, String estadoNascimento){
           
           this.id = id;
           this.nome = nome;
           this.altura = altura;
           this.peso = peso;
           this.anoNascimento = anoNascimento;

           if(universidade != null)
           this.universidade = universidade;
           else 
           this.universidade = "nao informado";
           
           if(cidadeNascimento != null)
           this.cidadeNascimento = cidadeNascimento;
           else 
           this.cidadeNascimento = "nao informado";

           if(estadoNascimento != null)
           this.estadoNascimento = estadoNascimento;
           else 
           this.estadoNascimento = "nao informado";

        }
    
    //getters

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

    //setters

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
    public Jogadores clone (Jogadores jogadores){
        Jogadores clone = new Jogadores(jogadores.getId(), jogadores.getNome(), jogadores.getAltura(), 
                                        jogadores.getPeso(), jogadores.getAnoNascimento(), jogadores.getUniversidade(),
                                        jogadores.getCidadeNascimento(), jogadores.getEstadoNascimento());
        return clone;    
    }

    // metodo imprimir  
    public void imprimir(Jogadores jogadores){
        System.out.println("[" + jogadores.getId() + " ## " + jogadores.getNome() + " ## " + jogadores.getAltura() 
                            + " ## " + jogadores.getPeso() + " ## " + jogadores.getAnoNascimento() + " ## " 
                            + jogadores.getUniversidade() + " ## " + jogadores.getCidadeNascimento() + " ## " 
                            + jogadores.getEstadoNascimento() +"]");
    }

    // metodo ler 
    public Jogadores ler(int [] ids){
        Jogadores jogadores = new Jogadores();
        BufferedReader in = null;
        String csv = "players.csv";
        in = new BufferedReader(new FileReader(csv));
        while(in.readLine() != null){
            for(int i = 0; i < ids.length; i++){

            }
        }
        in.close();
        return jogadores;
    }

}
