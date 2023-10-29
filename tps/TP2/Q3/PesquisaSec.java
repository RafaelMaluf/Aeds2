/**
 * Pesquisa sequencial em java
 * @author Rafael Maluf Araujo - 761579
 * @version 2 09/2023
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

class Jogadores {
    
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
    public static Jogadores ler(int id) throws IOException {

        Jogadores jogador = new Jogadores();

        BufferedReader in = null;

        String csv = "/tmp/players.csv";

        in = new BufferedReader(new FileReader(csv)); // leitos do arquivo

        String input = in.readLine();
        int i = 0;
        while (i < 3923) {

            input = in.readLine();
            if (input == null)
                break;
            String[] split = input.split(","); // separa os dados em um array de strings

            if (Integer.parseInt(split[0]) == id) {
                jogador.setId(Integer.parseInt(split[0]));
                jogador.setNome(split[1]);
                jogador.setAltura(Integer.parseInt(split[2]));
                jogador.setPeso(Integer.parseInt(split[3]));
                // Id Nome Altura e Peso dos jogadores sempre presentes

                if (split[4].length() > 4) { // se o tamanho da string for maior que 4, significa que a universidade foi
                                             // informada

                    jogador.setUniversidade(split[4]);
                    jogador.setAnoNascimento(Integer.parseInt(split[5]));

                    if (split.length >= 8) { // se o tamanho do array for maior ou igual a 8, significa que a cidade e o
                                             // estado foram informados
                        jogador.setCidadeNascimento(split[6]);
                        jogador.setEstadoNascimento(split[7]);

                    } else {
                        jogador.setCidadeNascimento("nao informado");
                        jogador.setEstadoNascimento("nao informado");
                    }

                } else {
                    jogador.setUniversidade("nao informado");
                    if (split[4].equals("")) { // se a universidade nao for informada a posicao 4 da string vai ser
                                               // vazia, entao o ano de nascimento vai estar na posicao 5
                        jogador.setAnoNascimento(Integer.parseInt(split[5]));
                    } else
                        jogador.setAnoNascimento(Integer.parseInt(split[4]));

                    if (split.length >= 7) { // se a universidade nao for informada mas o split for maior que 7
                                             // significa que a cidade e o estado foram informados
                        jogador.setCidadeNascimento(split[5]);
                        jogador.setEstadoNascimento(split[6]);

                    } else {
                        jogador.setCidadeNascimento("nao informado");
                        jogador.setEstadoNascimento("nao informado");
                    }
                }

            }
            i++;
        }
        in.close();
        return jogador;
    }


}

class PesquisaSec extends Jogadores{
    public static void main(String[] args) throws IOException {

       Jogadores [] array = new Jogadores[3923];
              

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // primeira leitura de dados 
        int i = 0;
        while (!input.equals("FIM")) {  
            
            Jogadores jogador = new Jogadores(); // criação de um objeto jogador
            int id = Integer.parseInt(input);   // id do jogador a ser lido
            jogador = ler(id);
            input = sc.nextLine();    // leitura do proximo id        
            array[i] = jogador;      // inserção do jogador no array
            i++;
            
        }
        
            input = sc.nextLine(); // leitura do primeiro nome a ser pesquisado
        while (!input.equals("FIM")) { // segunda leitura de dados

            if (PesquisaSequencial(input, array, i -1)){
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            input = sc.nextLine();
        }


        sc.close();
    }

    static boolean PesquisaSequencial(String nome, Jogadores []array, int tam){
        Boolean contem = false;
            
            for(int i = 0; i < tam && !contem ; i++){ // for para percorrer o array que para quando o nome for encontrado
                
                if(array[i].getNome().equals(nome)){  // se o nome for encontrado, contem recebe true
                    contem = true;
                } 
            }
            
            return contem;
    }
}
