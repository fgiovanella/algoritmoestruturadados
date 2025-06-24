package Prova02.questao02;

import Lista06.Questao01.Fila;
import Lista06.Questao01.FilaVaziaException;

public class FilaLista<T> implements Fila<T> {

    private Prova02.questao02.ListaEncadeada<T> lista;

    public FilaLista(){
        lista = new Prova02.questao02.ListaEncadeada<>();
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

    public int duplicarElementos(){
        int cont = 0;
        NoLista<T> no = lista.getPrimeiro();
        while(no != null){
            if(no.getInfo().equals(no.getProximo().getInfo())){
                cont++;
            }
            no = no.getProximo();
        }
        return cont;
    }
}
