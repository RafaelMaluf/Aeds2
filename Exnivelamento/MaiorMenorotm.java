//package Exnivelamento;

public class MaiorMenorotm {
    static class MenorMaior {
        int menor;
        int maior;

        public MenorMaior(int menor, int maior) {
            this.menor = menor;
            this.maior = maior;
        }
    }

    static MenorMaior encontraMenorMaior(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("O array não pode ser nulo ou vazio.");
        }

        int n = array.length;

        int menor, maior;
        int i;

        
        if (n == 1) { //array de tamanho 1 tem o mesmo maior e menor elemento
            menor = array[0];
            maior = array[0];
        } else {
            
            if (array[0] < array[1]) { //inicializa variáveis com os 2 primeiros elementos do array
                menor = array[0];
                maior = array[1];
            } else {
                menor = array[1];
                maior = array[0];
            }

           
            for (i = 2; i < n - 1; i += 2) { //comecamos do terceiro elemento do array
                int a = array[i];
                int b = array[i + 1];

                if (a < b) {
                    if (a < menor) {
                        menor = a;
                    }
                    if (b > maior) {
                        maior = b;
                    }
                } else {
                    if (b < menor) {
                        menor = b;
                    }
                    if (a > maior) {
                        maior = a;
                    }
                }
            }

            
            if (i == n - 1) { //caso array for impar deve ser este metodo
                int ultimoElemento = array[i];
                if (ultimoElemento < menor) {
                    menor = ultimoElemento;
                } else if (ultimoElemento > maior) {
                    maior = ultimoElemento;
                }
            }
        }

        return new MenorMaior(menor, maior);
    }

    public static void main(String[] args) {
        int[] array = { 3, 9, 1, 15, 6, 10, 7 };
        MenorMaior result = encontraMenorMaior(array);
        System.out.println("Mínimo: " + result.menor);
        System.out.println("Máximo: " + result.maior);
    }
}

