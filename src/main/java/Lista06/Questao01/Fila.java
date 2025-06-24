package Lista06.Questao01;

public interface Fila<T> {

    void inserir(T valor);

    boolean estaVazia();

    T peek();

    T retirar();

    void liberar();

}
