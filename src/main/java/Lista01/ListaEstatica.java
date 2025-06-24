package Lista01;

/**
 * Quando instanciando o arraylist no construtor padrão, sempre irá criar com 10 elementos.
 *
 */

public class ListaEstatica {

    private int[] info;
    private int tamanho;

    /**
     * Cria uma lista vazia
     */
    public ListaEstatica() {
        this.info = new int[10];
        this.tamanho = 0;
    }


    /**
     * Provoca um pseudo redimensionamento do vetor info
     */
    public void redimensionar() {
        int[] novoVetor = new int[this.info.length + 10];
        for (int i = 0; i < this.tamanho; i++) {
            novoVetor[i] = this.info[i];
        }
        info = novoVetor;
    }

    /**
     * Adiciona um valor na lista
     * @param valor Dado a ser adicionado
     */
    public void inserir(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        this.tamanho++;
    }

    /**
     * Exibe o conteúdo da lista
     */
    public void exibir() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(this.info[i] + " ");
        }
        System.out.println();
    }

    /**
     * Procura na lista um determinado valor
     * @param valor Dado a ser pesquisado
     * @return posição do valor na lista. Caso não seja encontrado
     * retorna -1.
     */
    public int buscar(int valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retira um dado da lista
     * @param valor Dado a ser removido
     */
    public void retirar(int valor) {
        int posicao = buscar(valor);

        if (posicao > -1) {
            for (int i = posicao + 1; i < this.tamanho; i++) {
                info[i - 1] = info[i];
            }
            tamanho--;
        }
    }


    /**
     * Limpa a estrutura de dados, de forma que a lista
     * esteja vazia
     */
    public void liberar() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    /**
     * Retorna o dado armazenado numa determinada posição
     * @param posicao Posição do dado
     * @return Dado localizado.
     */

    public int obterElemento(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        return this.info[posicao];
    }


    /**
     * Avalia se a lista está vazia ou contem dados armazenados.
     * @return true = lista vazia, caso contrário retornará false.
     */
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    /**
     * Retorna o tamanho atual do vetor, ou seja, a quantidade de dados
     * já armazenados na estrutura de dados.
     * @return tamanho da lista.
     */
    public int getTamanho() {
        return this.tamanho;
    }

    /**
     * Exibe os dados armazenados na lista
     * @return String contendo os dados armazenados na lista
     */

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < this.tamanho; i++) {
            if(i > 0){
                resultado += ",";
            }
            resultado += info[i];
        }
        return resultado;
    }
}

