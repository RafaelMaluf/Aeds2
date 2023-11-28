
// ---------------------------------------------------------------------------------------------------- //

// Imports
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// ---------------------------------------------------------------------------------------------------- //

class Player {

    // Global variables
    public static final String FILE_PATH = "/tmp/players.csv";
    public static ArrayList<Player> allPlayers = new ArrayList<Player>();

    // -------------------------- //

    // Attributes
    private int id;
    private String name;
    private int height;
    private int weight;
    private String college;
    private int yearOfBirth;
    private String birthCity;
    private String birthState;

    // Empty constructor
    public Player() {

        this.id = 0;
        this.name = "";
        this.height = 0;
        this.weight = 0;
        this.college = "";
        this.yearOfBirth = 0;
        this.birthCity = "";
        this.birthState = "";
    }

    // Constructor
    public Player(int id, String name, int height, int weight, String college, int yearOfBirth, String birthCity, String birthState) {

        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.yearOfBirth = yearOfBirth;
        this.birthCity = birthCity;
        this.birthState = birthState;
    }

    // Gets
    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getHeight() { return this.height; }
    public int getWeight() { return this.weight; }
    public String getCollege() { return this.college; }
    public int getYearOfBirth() { return this.yearOfBirth; }
    public String getBirthCity() { return this.birthCity; }
    public String getBirthState() { return this.birthState; }

    // Sets
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setHeight(int height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setCollege(String college) { this.college = college; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public void setBirthCity(String birthCity) { this.birthCity = birthCity; }
    public void setBirthState(String birthState) { this.birthState = birthState; }

    // Clone
    public Player clone() { return new Player(this.id, this.name, this.height, this.weight, this.college, this.yearOfBirth, this.birthCity, this.birthState); }

    // Print
    public void print() {

        System.out.printf("## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n",
            this.name, this.height, this.weight, this.yearOfBirth, this.college, this.birthCity, this.birthState);
    }

    // Read
    public void read(String line) {

        // Split line by ","
        String[] splitted = line.split(",", -1);

        // Fill empty attributes
        for(int i = 0; i < splitted.length; i++) {

            if(splitted[i].equals("")) splitted[i] = "nao informado";
        }

        // Set attributes
        this.id = Integer.parseInt(splitted[0]);
        this.name = splitted[1];
        this.height = Integer.parseInt(splitted[2]);
        this.weight = Integer.parseInt(splitted[3]);
        this.college = splitted[4];
        this.yearOfBirth = Integer.parseInt(splitted[5]);
        this.birthCity = splitted[6];
        this.birthState = splitted[7];
    }

    // ---------------------------------------------------------------------------------------------------- //

    // Read all players function
    public static void startPlayers() {

        // Initialize variables
        try {

            FileInputStream fstream = new FileInputStream(FILE_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            // ---------------------- //

            // Explode CSV file
            String line = br.readLine();
  
            while((line = br.readLine()) != null) {

                // Initialize player
                Player player = new Player();

                // Read line
                player.read(line);

                // Add player to array
                allPlayers.add(player);
            }

            // Close CSV file
            fstream.close();
        }
        catch(IOException e) { e.printStackTrace(); }
    }

    // ---------------------------------------------------------------------------------------------------- //

    // Search by id function
    public static Player searchById(int id, ArrayList<Player> players) {

        // Search for player
        for(int i = 0; i < players.size(); i++) {

            if(players.get(i).getId() == id) return players.get(i);
        }
        return null;
    }
}

class Celula {
        public Player elemento; // Elemento inserido na celula.
        public Celula prox; // Aponta a celula prox.


        /**
         * Construtor da classe.
         */
        public Celula() {
            this(new Player());
        }

        /**
         * Construtor da classe.
         * @param elemento int inserido na celula.
         */
        public Celula(Player elemento) {
        this.elemento = elemento;
        this.prox = null;
        }
    }

    class Lista {
        private Celula primeiro;
        private Celula ultimo;


        /**
         * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
         */
        public Lista() {
            primeiro = new Celula();
            ultimo = primeiro;
        }


        /**
         * Insere um elemento na primeira posicao da lista.
        * @param x int elemento a ser inserido.
        */
        public void inserirInicio(Player x) {
            Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
            primeiro.prox = tmp;
            if (primeiro == ultimo) {                 
                ultimo = tmp;
            }
        tmp = null;
        }


        /**
         * Insere um elemento na ultima posicao da lista.
        * @param x int elemento a ser inserido.
        */
        public void inserirFim(Player x) {
            ultimo.prox = new Celula(x);
            ultimo = ultimo.prox;
        }


        /**
         * Remove um elemento da primeira posicao da lista.
        * @return resp int elemento a ser removido.
        * @throws Exception Se a lista nao contiver elementos.
        */
        public Player removerInicio() throws Exception {
            if (primeiro == ultimo) {
                throw new Exception("Erro ao remover (vazia)!");
            }

        Celula tmp = primeiro;
            primeiro = primeiro.prox;
            Player resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
            return resp;
        }


        /**
         * Remove um elemento da ultima posicao da lista.
        * @return resp int elemento a ser removido.
        * @throws Exception Se a lista nao contiver elementos.
        */
        public Player removerFim() throws Exception {
            if (primeiro == ultimo) {
                throw new Exception("Erro ao remover (vazia)!");
            } 

            // Caminhar ate a penultima celula:
        Celula i;
        for(i = primeiro; i.prox != ultimo; i = i.prox);

        Player resp = ultimo.elemento; 
        ultimo = i; 
        i = ultimo.prox = null;
        
            return resp;
        }


        /**
        * Insere um elemento em uma posicao especifica considerando que o 
        * primeiro elemento valido esta na posicao 0.
        * @param x int elemento a ser inserido.
        * @param pos int posicao da insercao.
        * @throws Exception Se <code>posicao</code> invalida.
        */
    public void inserir(Player x, int pos) throws Exception {

        int tamanho = tamanho();

        if(pos < 0 || pos > tamanho){
                throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0){
            inserirInicio(x);
        } else if (pos == tamanho){
            inserirFim(x);
        } else {
            // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
            
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }


        /**
        * Remove um elemento de uma posicao especifica da lista
        * considerando que o primeiro elemento valido esta na posicao 0.
        * @param posicao Meio da remocao.
        * @return resp int elemento a ser removido.
        * @throws Exception Se <code>posicao</code> invalida.
        */
        public Player remover(int pos) throws Exception {
        Player resp;
        int tamanho = tamanho();

            if (primeiro == ultimo){
                throw new Exception("Erro ao remover (vazia)!");

        } else if(pos < 0 || pos >= tamanho){
                throw new Exception("Erro ao remover posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0){
            resp = removerInicio();
        } else if (pos == tamanho - 1){
            resp = removerFim();
        } else {
            // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
            
            Celula tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }

            return resp;
    }

        /**
         * Mostra os elementos da lista separados por espacos.
         */
        public void mostrar() {
            int j = 0;
            for (Celula i = primeiro.prox ; i != null; i = i.prox) {
                System.out.print("[" + j + "] ");
                i.elemento.print();
                j++;
            }
            
        }

        /**
         * Procura um elemento e retorna se ele existe.
         * @param x Elemento a pesquisar.
         * @return <code>true</code> se o elemento existir,
         * <code>false</code> em caso contrario.
         */
        public boolean pesquisar(Player x) {
            boolean resp = false;
            for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if(i.elemento == x){
                resp = true;
                i = ultimo;
            }
            }
            return resp;
        }

        /**
         * Calcula e retorna o tamanho, em numero de elementos, da lista.
         * @return resp int tamanho
         */
    public int tamanho() {
        int tamanho = 0; 
        for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
        return tamanho;
    }
    }
    public class ListaFlex extends Player{

    
       
    public static void main(String[] args) throws Exception {
        

        // #1 - Start - Read all players in CSV file

        startPlayers();

        // #2 - Read input and print players from pub.in id entries

        // Initialize scanner
        Scanner inScanner = new Scanner(System.in);

        // Initialize player
        Player player = new Player();

        // Read first line
        String line = inScanner.nextLine();

        Lista lista = new Lista(); 

        // While line is not "FIM"
        while(!line.equals("FIM")) {

            // Get id
            int id = Integer.parseInt(line);

            // Search for player
            player = searchById(id, allPlayers);

            
            lista.inserirFim(player);

            // Read line
            line = inScanner.nextLine();
        }
        int n = Integer.parseInt(inScanner.nextLine());
        for(int i = 0; i < n ; i ++){

            line = inScanner.nextLine();

            String[] split = line.split(" ");

            if(split.length == 1){
                Player removed = new Player();
                if(split[0].charAt(1) == 'I'){
                    removed = lista.removerInicio();
                    System.out.println("(R) " + removed.getName());
                } else {
                    removed = lista.removerFim();
                    System.out.println("(R) " + removed.getName());
                }
            } else if (split.length == 2)
            {
                if(split[0].charAt(0) == 'I'){
                    if(split[0].charAt(1) == 'I'){
                        lista.inserirInicio(searchById(Integer.parseInt(split[1]), allPlayers));
                    } else {
                        lista.inserirFim(searchById(Integer.parseInt(split[1]), allPlayers));
                    }
                } else {
                    Player removed = new Player();
                    removed = lista.remover(Integer.parseInt(split[1]));
                    System.out.println("(R) " + removed.getName());
                }
            } else {
                lista.inserir(searchById(Integer.parseInt(split[2]), allPlayers), Integer.parseInt(split[1]));
            }

        }
        lista.mostrar();
        // Close scanner
        inScanner.close();
    }
}

    