using System;
using System.Linq;
class Program {
  public static void Main (string[] args) {
    string palavra = Console.ReadLine();
    
    while(palavra != "FIM"){
    string palavraInversa = new string(palavra.Reverse().ToArray());
      
      if(palavra == palavraInversa){
        Console.WriteLine("SIM");
      }else{
        Console.WriteLine("NAO");
      }
      palavra = Console.ReadLine();
    }

    }
  }