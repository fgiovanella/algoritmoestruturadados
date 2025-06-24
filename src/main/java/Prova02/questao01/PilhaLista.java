package Prova02.questao01;

public class PilhaLista<T> implements Pilha<T> {
    private ListaEncadeada<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia");
        }
        T valor;
        valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia");
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista == null;
    }

    @Override
    public void liberar() {
        lista = null;
    }

    @Override
    public String toString() {
        return lista.toString();
    }


    public boolean validarBalanceamento(String expr) {
        PilhaLista<T> pilha = new PilhaLista<>();
        char[] delimitadores = {'(', ')', '{', '}', '[', ']'};

        for (int i = 0; i < expr.length(); i++) {
            for (char d : delimitadores) {
                if (i == d) {
                    if (i== '(' || i == '{' || i == '[') {
                        pilha.push((T) Character.valueOf(d));
                    } else {
                        if (pilha.estaVazia()) {
                            return false;
                        }
                        char topo = (char) pilha.pop();
                    }
                }
            }
        }
        return pilha.estaVazia();
    }

}