package Prova02.questao03;

public class NoArvoreBinaria<T> {

    private T info;
    private NoArvoreBinaria<T> direita;
    private NoArvoreBinaria<T> esquerda;

    public NoArvoreBinaria(T info){
        this.info = info;
        this.direita = null;
        this.esquerda = null;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> dir, NoArvoreBinaria<T> esq){
        this.info = info;
        this.direita = dir;
        this.esquerda = esq;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public T getInfo(){
        return this.info;
    }

    public NoArvoreBinaria<T> getEsquerda(){
        return this.esquerda;
    }

    public NoArvoreBinaria<T> getDireita(){
        return this.direita;
    }

    public void setEsquerda(NoArvoreBinaria<T> esq){
        this.esquerda = esq;
    }

    public void setDireita(NoArvoreBinaria<T> dir){
        this.direita = dir;
    }
}
