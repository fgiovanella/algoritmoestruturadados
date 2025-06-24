package Lista06.Questao02;

import Lista06.Questao01.Fila;
import Lista06.Questao01.FilaVaziaException;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista;

    public FilaLista(){
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserir(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia");
        }
        return lista.getPrimeiro().getInfo();
    }


    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia");
        }
        T valor;
        valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public void liberar() {
        while (!lista.estaVazia()) {
            lista.retirar(lista.getPrimeiro().getInfo());
        }
    }

    public String toString(){
        return lista.toString();
    }
}
