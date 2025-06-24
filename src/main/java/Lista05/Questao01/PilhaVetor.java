package Lista05.Questao01;

public class PilhaVetor<T> implements Pilha<T>{

    private Object[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T info) {
        if(limite == tamanho){
            throw new PilhaCheiaException("Pilha Cheia");
        }
    this.info[tamanho] = info;
    tamanho = tamanho+1;
    }

    /**
     * Remove o último elemento da pilha
     * @return último elemento da pilha
     */
    @Override
    public T pop(){
        if(estaVazia()){
            throw new PilhaVaziaException("Pilha Vazia");
        }

        T valor = peek();
        this.info[tamanho-1] = null;
        tamanho--;
        return valor;
    }

    /**
     * Retorna o último elemento da pilha sem removê-lo
     * @return último elemento da pilha
     */
    @Override
    public T peek(){
        if(estaVazia()){
            throw new PilhaVaziaException("Pilha Vazia");
        }
        return (T) this.info[tamanho-1];
    }

    /**
     * Verifica se a pilha está vazia
     * @return true se a pilha estiver vazia, false caso contrário
     */
    @Override
    public boolean estaVazia() {
        return (tamanho == 0);
    }

    /**
     * Desempilha todos os dados da pilha
     */
    @Override
    public void liberar() {
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    @Override
    public String toString() {
        String resultado = "";

        for(int i = tamanho - 1; i >= 0; i--){
            resultado += this.info[i];
            if(i > 0){
                resultado = resultado + " ";
            }
        }
        return resultado;
    }

    /**
     * Concatena pilha corrente com outra pilha.
     * @param p Pilha a ser concatenada da pilha atual
     */

    public void concatenar(PilhaVetor<T> p) {
        if(this.tamanho + p.tamanho > this.limite){
            throw new PilhaCheiaException("Pilha Cheia");
        }

        for(int i=0; i < p.tamanho; i++){
            this.push((T)p.info[i]);
        }
    }

}
