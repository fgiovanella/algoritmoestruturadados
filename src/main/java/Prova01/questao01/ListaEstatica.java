package Prova01.questao01;

/**
 * Instancia a variável Object
 * @param <T>
 */
public class ListaEstatica<T>{
        private Object[] info;
        private int tamanho;

        /**
         * Cria uma lista vazia
         */
        public ListaEstatica() {
            this.info = new Object[10];
            this.tamanho = 0;
        }


        /**
         * Provoca um pseudo redimensionamento do vetor info
         */
        public void redimensionar() {
            Object[] novoVetor = new Object[this.info.length + 10];
            for (int i = 0; i < this.tamanho; i++) {
                novoVetor[i] = this.info[i];
            }
            info = novoVetor;
        }

        /**
         * Adiciona um valor na lista
         * @param valor Dado a ser adicionado
         */
        public void inserir(int posicao, T valor) {
            if (tamanho == info.length) {
                redimensionar();
            }

            if (posicao >= 0 && posicao <= tamanho) {
                for (int i = tamanho; i > posicao; i--) {
                    info[i] = info[i - 1];
                }
                info[posicao] = valor;
                tamanho++;
            } else {
                throw new IndexOutOfBoundsException("Posição inválida.");
            }
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
        public int buscar(T valor) {
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
        public void retirar(T valor) {
            int posicao = buscar(valor);

            if (posicao > -1) {
                for (int i = posicao + 1; i < this.tamanho; i++) {
                    info[i - 1] = info[i];
                }
                tamanho--;
                info[tamanho] = null; //Necessário retirar o último valor do vetor, para liberar espaço na memória.
            }
        }

        /**
         * Limpa a estrutura de dados, de forma que a lista
         * esteja vazia
         */
        public void liberar() {
            this.info = new Object[10];
            this.tamanho = 0;
        }

        /**
         * Retorna o dado armazenado numa determinada posição
         * @param posicao Posição do dado
         * @return Dado localizado.
         */

        public T obterElemento(int posicao) {
            if (posicao >= 0 && posicao < tamanho) {
                return (T) info[posicao];
            }else {
                throw new IndexOutOfBoundsException("Posição inválida.");
            }
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

    /**
     * Inverte os dados da lista, colocando o último dado inserido por primeiro.
     * Esse for faz a leitura até a metade do vetor e faz a alteração da primeira casa com a última casa,
     * até chegar no meio e parar o loop.
     */

    public void inverter(){
        int esquerda = 0;
        int direita = tamanho -1;

        int qtdTrocas = tamanho / 2;

        Object backup;

        while(qtdTrocas > 0){
            backup = info[esquerda];
            info[esquerda] = info[direita];
            info[direita] = backup;

            esquerda++;
            direita--;

            qtdTrocas--;
        }
    }

}

