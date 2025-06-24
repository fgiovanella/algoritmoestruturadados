package Lista05.Questao01;

public interface Pilha<T> {

    void push(T info);

    T pop();

    T peek();

    boolean estaVazia();

    void liberar();
}
