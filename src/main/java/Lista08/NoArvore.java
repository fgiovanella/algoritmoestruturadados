package Lista08;

public class NoArvore<T> {
    private T info;
    private NoArvore<T> primeiro;
    private NoArvore<T> proximo;

    public NoArvore(T info) {
        this.info = info;
        this.primeiro = null;
        this.proximo = null;
    }

    public void inserirFilho(NoArvore<T> sa){
        sa.setProximo(this.primeiro);
        this.setPrimeiro(sa);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(){
        this.info = info;
    }

    public NoArvore<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvore<T> primeiro) {
        this.primeiro = primeiro;
    }

    public NoArvore<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore<T> proximo) {
        this.proximo = proximo;
    }
}
