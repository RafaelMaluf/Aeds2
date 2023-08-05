//package Exnivelamento;

public class MaiorMenor {
    public static void main(String[] args) {
        int[] array = {7,8,9,9,10,15,27,2,-4};
        
        maiorMenor(array);
    }
    static void maiorMenor(int array[]){
        int maior = array[0];
        int menor = array[0];
        for(int i = 1;i < array.length;i++){
            if(array[i-1] < array[i]){
                maior = array[i];
            }
            else if(array[i-1] > array[i]){
                menor = array[i];
            }
        }
        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
    }
}
