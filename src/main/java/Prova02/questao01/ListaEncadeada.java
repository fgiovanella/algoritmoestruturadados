package Prova02.questao01;

public class ListaEncadeada <T>{

    private NoLista<T> primeiro;
    private NoLista<T> proximo;

    /**
     * Construtor Padrão. Cria lista Vazia
     */

    public ListaEncadeada(){
        this.primeiro = null;
    }

    /**
     * Getter da varável primeiro
     * @return primeiro nó da lista
     */
    public NoLista<T> getPrimeiro(){
        return this.primeiro = primeiro;
    }

    /**
     * Insere um novo valor na lista
     * @param valor a ser inserido na lista
     */
    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>(valor);
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        primeiro = novo;
    }

    /**
     * Avalia se a lista está vazia ou não
     * @return True se a lista estiver vazia
     */
    public boolean estaVazia(){
        return this.primeiro == null;
    }

    public void exibir(){
        NoLista<T> p = this.primeiro;
        while (p != null) {
            System.out.println(p.getInfo() + " ");
            p = p.getProximo();
        }
    }

    /**
     * Busca um nó na lista encadeada
     *
     * @param valor Dado a ser localizado
     * @return Nó contendo o dado localizado
     */
    public NoLista<T> buscar(T valor){
        NoLista<T> p = this.primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    /**
     * Retira um dado da lista encadeada
     *
     * @param valor Dado a ser retirado da lista encadeada
     */
    public void retirar(T valor){
        NoLista<T> anterior = null;
        NoLista<T> p = this.primeiro;

        //Procura o nó que contém o valor a ser retirado
        while (p != null && !p.getInfo().equals(valor)) {
            anterior = p;
            p = p.getProximo();
        }
        //Verifica se o nó foi encontrado
        if (p != null) {
            if (p == primeiro) {
                primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    // Uma forma mais eficiente de realizar este metodo eh instanciar qtdNos no inserir(++) e retirar(--), assim no obterComprimento so retornamos a variavel qtdNos.
    public int obterComprimento(){
        int qtdNos = 0;

        NoLista<T> p = primeiro;
        while (p != null) {
            qtdNos++;
            p = p.getProximo();
        }
        return qtdNos;
    }

    public NoLista<T> obterNo(int idx){
        if(idx < 0){
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        NoLista<T> p = getPrimeiro();
        while ((p != null) && (idx > 0)) {
            idx--;
            p = p.getProximo();
        }

        if(p == null){
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        return p;
    }

    public String toString(){
        String str = "";
        NoLista<T> p = getPrimeiro();

        while (p != null) {
            if(p != primeiro){
                str += ",";
            }
            str += p.getInfo();
            p = p.getProximo();
        }

        return str;
    }

}
