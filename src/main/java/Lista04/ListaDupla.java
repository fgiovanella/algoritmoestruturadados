package Lista04;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return this.primeiro;
    }

    /**
     * Inclui um novo dado na estrutura de dados
     * @param valor Dado a ser incluído
     */
    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>(valor);
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    /**
     * Busca um nó na estrutura de dados que esteja armazenado o dado fornecido como argumento
     * @param valor Valor a ser localizado
     * @return Nó contendo o dado
     */
    public NoListaDupla<T> buscar(T valor){
        NoListaDupla<T> p = this.primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    /**
     * Retira da estrutura de dados um dado armazenado na lista
     * @param valor Valor a ser retirado
     */
    public void retirar(T valor){
        NoListaDupla<T> p = buscar(valor);

        if (p != null) {
            if (p.getAnterior() != null) {
                p.getAnterior().setProximo(p.getProximo());
            } else {
                primeiro = p.getProximo();
            }

            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    /**
     *
     */
    public void exibirOrdemInversa(){
        NoListaDupla<T> p = this.primeiro;
        while (p.getProximo() != null) {
            p = p.getProximo();
        }
        while (p != null) {
            System.out.println(p.getInfo() + " ");
            p = p.getAnterior();
        }
    }

    /**
     * Outra forma de implementar o método utilizando um método auxiliar chamado obterUltimo()
     */
    /*
    public void exibirOrdemInversa(){
        NoListaDupla<T> p = obterUltimo();

        while(p != null){
            System.out.println(p.getInfo() + " ");
            p = p.getAnterior();
        }
    }
     */

    public void liberar(){
        NoListaDupla<T> p = this.primeiro;

        while (p != null) {
            p.setAnterior(null);

            NoListaDupla<T> backup = p.getProximo();
            p.setProximo(null);

            p = backup;
        }
        this.primeiro = null;
    }

    public String toString() {
        String resultado = "";
        NoListaDupla<T> p = this.primeiro;
        while (p != null) {
            if(p != primeiro){
                resultado += ",";
            }
            resultado += p.getInfo();
            p = p.getProximo();
        }
        return resultado;
    }

    /**
     * Retorna o ultimo elemento da lista encadeada
     * @return ultimo elemento da lista
     */
    /*
    private NoListaDupla<T> obterUltimo(){
        NoListaDupla<T> ultimo = primeiro;

        NoListaDupla<T> p = primeiro;
        while (p != null) {
            ultimo = p;
            p = p.getProximo();
        }
        return ultimo;
     */

}
