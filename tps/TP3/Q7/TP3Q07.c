/**
 * Struct Jogadores
 * @author Rafael Maluf Araujo - 761579
 * @version 1 10/2023
 */
#ifndef FILA_H
#define FILA_H
#ifndef CELULA_H
#define CELULA_H


#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

typedef struct jogador jogador;
struct jogador{
    int id;
    char nome[50];
    int altura;
    int peso;
    char universidade[50];
    int anoNascimento;
    char cidadeNascimento[50];
    char estadoNascimento[50];
};

jogador _jogador(){
    jogador j;
    j.id = 0;
    strcpy(j.nome, "");
    j.altura = 0;
    j.peso = 0;
    strcpy(j.universidade, "");
    j.anoNascimento = 0;
    strcpy(j.cidadeNascimento, "");
    strcpy(j.estadoNascimento, "");
    return j;
}

jogador new_jogador(int id, char *nome, int altura, int peso, char *universidade, int anoNascimento, char *cidadeNascimento, char *estadoNascimento){
    jogador j;
    j.id = id;
    strcpy(j.nome, nome);
    j.altura = altura;
    j.peso = peso;
    strcpy(j.universidade, universidade);
    j.anoNascimento = anoNascimento;
    strcpy(j.cidadeNascimento, cidadeNascimento);
    strcpy(j.estadoNascimento, estadoNascimento);
    return j;
}

void setid(jogador* this, int id){
    this->id = id;
}

void setnome(jogador* this, char* nome){
    strcpy(this->nome, nome);
}

void setaltura(jogador* this, int altura){
    this->altura = altura;
}

void setpeso(jogador* this, int peso){
    this->peso = peso;
}

void setuniversidade(jogador* this, char* universidade){
    strcpy(this->universidade, universidade);
}

void setanoNascimento(jogador* this, int anoNascimento){
    this->anoNascimento = anoNascimento;
}

void setcidadeNascimento(jogador* this, char* cidadeNascimento){
    strcpy(this->cidadeNascimento, cidadeNascimento);
}

void setestadoNascimento(jogador* this, char* estadoNascimento){
    strcpy(this->estadoNascimento, estadoNascimento);
}

int getid(jogador* this){
    return this->id;
}

char* getnome(jogador* this){
    return this->nome;
}

int getaltura(jogador* this){
    return this->altura;
}

int getpeso(jogador* this){
    return this->peso;
}

char* getuniversidade(jogador* this){
    return this->universidade;
}

int getanoNascimento(jogador* this){
    return this->anoNascimento;
}

char* getcidadeNascimento(jogador* this){
    return this->cidadeNascimento;
}

char* getestadoNascimento(jogador* this){
    return this->estadoNascimento;
}

void imprimir(jogador* this){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", this->id, this->nome, this->altura, this->peso, this->anoNascimento, this->universidade, this->cidadeNascimento, this->estadoNascimento);
}

void imprimirSemId(jogador* this){
    printf("## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", this->nome, this->altura, this->peso, this->anoNascimento, this->universidade, this->cidadeNascimento, this->estadoNascimento);
    
}

void read(char *line, jogador* this){
    int index = 0;
    int atr_index = 0;
    char id_string[10];
    char nome_string[100];
    char altura_string[10];
    char peso_string[10];
    char universidade_string[100];
    char anoNascimento_string[10];
    char cidadeNascimento_string[100];
    char estadoNascimento_string[100];
    
    int i;

    while(1){

        if(line[index] == ','){
            for(i = atr_index; i < index; i++){
                id_string[i - atr_index] = line[i];
            }
            id_string[index - atr_index] = '\0';

            if(strcmp(id_string, "") == 0 || strcmp(id_string, ",") == 0){
                this->id = 0;
                atr_index = ++index;
            }else{
                this->id = atoi(id_string);
                atr_index = ++index;
            }

            break;
        }
        index++;

    }
    
    while(1){
        if(line[index] == ','){
            for(i = atr_index; i < index; i++){
                nome_string[i - atr_index] = line[i];
            }
            nome_string[index - atr_index] = '\0';

            if(strcmp(nome_string, "") == 0 || strcmp(nome_string, ",") == 0){
                strcpy(this->nome, "nao informado");
                atr_index = ++index;
            }else{
                strcpy(this->nome, nome_string);
                atr_index = ++index;
            }
            break;
        }
        index++;
    }

    while(1){

        if(line[index] == ','){
            for(i = atr_index; i < index; i++){
                altura_string[i - atr_index] = line[i];
            }
            altura_string[index - atr_index] = '\0';

            if(strcmp(altura_string, "") == 0 || strcmp(altura_string, ",") == 0){
                this->altura = 0;
                atr_index = ++index;
            }else{
                this->altura = atoi(altura_string);
                atr_index = ++index;
            }
            break;
        }
        index++;
    }

    while(1){
            if(line[index] == ','){
                for(i = atr_index; i < index; i++){
                    peso_string[i - atr_index] = line[i];
                }
                peso_string[index - atr_index] = '\0';
                if(strcmp(peso_string, "") == 0 || strcmp(peso_string, ",") == 0){
                    this->peso = 0;
                    atr_index = ++index;
                }else{
                    this->peso = atoi(peso_string);
                    atr_index = ++index;
                }

                break;
            }
            index++;
        }

        while(1){
            

            if(line[index] == ','){
                for(i = atr_index; i < index; i++){
                    universidade_string[i - atr_index] = line[i];
                }
                universidade_string[index - atr_index] = '\0';
                if(strcmp(universidade_string, "") == 0 || strcmp(universidade_string, ",") == 0){
                    strcpy(this->universidade, "nao informado");
                    atr_index = ++index;
                }else{
                    strcpy(this->universidade, universidade_string);
                    atr_index = ++index;
                }
                break;
            }
            index++;
        }

        while(1){
            

            if(line[index] == ','){
                for(i = atr_index; i < index; i++){
                    anoNascimento_string[i - atr_index] = line[i];
                }
                anoNascimento_string[index - atr_index] = '\0';

                if(strcmp(anoNascimento_string, "") == 0){
                    this->anoNascimento = 0;
                    atr_index = ++index;
                }else{
                    this->anoNascimento = atoi(anoNascimento_string);
                    atr_index = ++index;
                }
                
                break;
            }
            index++;
        }


    while(1){
            if(line[index] == ','){
                for(i = atr_index; i < index; i++){
                    cidadeNascimento_string[i - atr_index] = line[i];
                }
                cidadeNascimento_string[index - atr_index] = '\0';
                
                if(strcmp(cidadeNascimento_string, "") == 0 || strcmp(cidadeNascimento_string, ",") == 0){
                    strcpy(this->cidadeNascimento, "nao informado");
                    atr_index = ++index;
                }else{
                    strcpy(this->cidadeNascimento, cidadeNascimento_string);
                    atr_index = ++index;
                }
                break;
            }
            index++;
        }

        while(1){
            if(index == strlen(line) - 1){
                for(i = atr_index; i < index; i++){
                    estadoNascimento_string[i - atr_index] = line[i];
                }
                estadoNascimento_string[index - atr_index] = '\0';
                
                if(strcmp(estadoNascimento_string, "") == 0  || strcmp(estadoNascimento_string, ",") == 0 ){
                    strcpy(this->estadoNascimento, "nao informado");
                    atr_index = ++index;
                }else{
                    strcpy(this->estadoNascimento, estadoNascimento_string);
                }
                break;
            }
            index++;
        }
}

bool isFim(char *str){
    bool resp = false;
    if(strlen(str) >= 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
        resp = true;
    }
    return resp;
}




 //=============================================================================
typedef struct Celula{
    jogador elemento;
    struct Celula *prox;
}Celula;
//=============================================================================
Celula* new_celula(jogador elemento){
    Celula *temp = (Celula*)malloc(sizeof(Celula));
    temp->elemento = elemento;
    temp->prox = NULL;
    return temp;
}

#endif

//=============================================================================
typedef struct Fila{
    struct Celula *primeiro, *ultimo;
    int size;
} Fila;
//=============================================================================
Fila new_fila(){
    Fila temp;
    temp.primeiro = temp.ultimo = new_celula(_jogador());
    temp.size = 0;
    return temp;
}
//=============================================================================
int size_fila(Fila *f){
    return f->size;
}
//=============================================================================
jogador dequeue_fila(Fila *f){
    
    if (f->primeiro == f->ultimo){
        printf("\nA fila esta vazia!\n");
        return _jogador();
    }
    
    Celula *temp = f->primeiro;
    f->primeiro = f->primeiro->prox;
    
    f->size--;
    free(temp);
    return f->primeiro->elemento;
}
//=============================================================================
void enqueue_fila(Fila *f, jogador elemento){
    f->size++;
    if(f->size > 5){
    dequeue_fila(f);
    f->ultimo->prox = new_celula(elemento);
    f->ultimo = f->ultimo->prox;
    
    
    } else {
    f->ultimo->prox = new_celula(elemento);
    f->ultimo = f->ultimo->prox;
    }
}
//=============================================================================
int media_fila(Fila *f){
    Celula *i;
    float soma = 0;
    int media = 0;
    int n = 0;
    for (i = f->primeiro->prox; i != NULL; i = i->prox)
    {
        n++;
        soma = soma + i->elemento.altura;
    }
    float aux = soma/n;
    if(aux - (int)aux >= 0.5){
        media = (int)aux + 1;
    } else {
        media = (int)aux;
    }

    return media;
}
//=============================================================================
void print_fila(Fila *f){
    Celula *i;
    int n = 0;
    for (i = f->primeiro->prox; i != NULL; i = i->prox)
    {   
        printf("[%d] ", n);
        imprimirSemId(&i->elemento);
        n++;
    }
}
//=============================================================================
void delete_fila(Fila *f){
    while(f->size > 0)
        dequeue_fila(f);
    free(f->primeiro);
}
//=============================================================================
#endif


int main(){
    char entraString[1000];
    char base[1000] = "/tmp/players.csv";
    char line[1000];
    scanf("%s", entraString);
   Fila fila = new_fila();
    while(!isFim(entraString)){
        FILE *arq = fopen(base, "r");
        int num = atoi(entraString);
        for(int i = 0; i < num + 2; i++){
            fgets(line, 1000, arq);
        }
        jogador player;
        read(line, &player);
        
        enqueue_fila(&fila, player);
        printf("%i\n", media_fila(&fila));
        fclose(arq);
        scanf("%s", entraString);
    }
    
    int num;
    scanf("%d", &num);
    
    

      for(int i = 0; i < num; i++){ 
        FILE *arq = fopen(base, "r");
      scanf("%s", line);

      if(strcmp(line, "R") == 0){
         jogador j = dequeue_fila(&fila);
         printf("(R) %s\n", j.nome);
      } else if (strcmp(line, "I") == 0){
        
         scanf("%s", line);
         int num = atoi(line);
         for(int i = 0; i < num + 2; i++){
            fgets(line, 1000, arq);
        }
         jogador player;
         read(line, &player);
         enqueue_fila(&fila, player);
         printf("%i\n", media_fila(&fila));
      }
      fclose(arq);
   }
    print_fila(&fila);
    
}