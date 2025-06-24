package Lista06.Questao01;

public class FilaVetor<T> implements Fila<T>{

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

   public FilaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
        this.inicio = 0;
   }

   public void inserir(T valor){
        if (tamanho == limite) {
            throw new FilaCheiaException("Fila cheia");
        }
        int posicao = (inicio + tamanho) % limite;
        info[posicao] = valor;
        tamanho++;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia");
        }
        return (T) info[inicio];
    }

    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia");
        }
        T valor = (T) info[inicio];
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    public void liberar() {
        info = null;
   }

   public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2){
       FilaVetor<T> f3 = new FilaVetor<>(this.limite + f2.limite);

       int posicao = this.inicio;

       for(int i = 0; i < this.tamanho; i++){
           f3.inserir( (T) this.info[posicao]);
           posicao = (posicao + 1) % this.limite;
       }

       posicao = f2.inicio;
       for (int i = 0; i < f2.tamanho; i++){
           f3.inserir( (T) f2.info[posicao]);
           posicao = (posicao + 1) % f2.limite;
       }

       return f3;
   }
}
