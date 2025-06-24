package Lista07;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    /**
     * Construtor padrão. Cria árvore vazia
     */
    public ArvoreBinaria() {
        this.raiz = null;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return this.raiz;
    }

    /**
     * Setter Raiz
     *
     * @param raiz nó raiz da árvore
     */
    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Verifica se a árvore está vazia
     *
     * @return True se a árvore estiver vazia
     */
    public boolean estaVazia() {
        return this.raiz == null;
    }

    /**
     * Metodo publico que verifica se um nó pertence a árvore
     *
     * @param info dado a ser verificado
     * @return True se o nó pertence a árvore
     */
    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    /**
     * Verifica se um nó pertence a árvore
     *
     * @param no   nó a ser verificado
     * @param info dado a ser verificado
     * @return True se o nó pertence a árvore
     */
    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        } else {
            return (no.getInfo().equals(info) ||
                    pertence(no.getEsquerda(), info) ||
                    pertence(no.getDireita(), info));
        }
    }

    /**
     * Retorna a representação textual da árvoer
     *
     * @return Metodo que faz a representação da árvore
     */
    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        } else {
            return "<" + no.getInfo() +
                    arvorePre(no.getEsquerda()) +
                    arvorePre(no.getDireita()) +
                    ">";
        }
    }

    public int contarNos() {
        return contarNos(getRaiz());
    }

    /**
     * Contar o número de nós da árvore
     * @param no nó a ser contado
     * @return número de nós
     */
    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contarNos(no.getEsquerda()) +
                    contarNos(no.getDireita());
        }
    }

    /*
    contar nós internos
     */

    public int contarNosInternos() {
        return contarNosInternos(raiz);
    }

    private int contarNosInternos(NoArvoreBinaria<T> no) {
        if (no == null) return 0;

        boolean temFilho = no.getEsquerda() != null || no.getDireita() != null;

        int contador = temFilho ? 1 : 0;

        contador += contarNosInternos(no.getEsquerda());
        contador += contarNosInternos(no.getDireita());

        return contador;
    }
}
