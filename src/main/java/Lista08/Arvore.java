package Lista08;


public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public String toString() {
        if (raiz == null) {
            return "";
        } else {
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s = "<" + no.getInfo();

        NoArvore<T> p;
        p = no.getPrimeiro();
        while (p != null) {
            s += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        s = s + ">";

        return s;
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return true;
        } else {
            NoArvore<T> p = no.getPrimeiro();
            while (p != null) {
                if (pertence(p, info)) {
                    return true;
                }
                p = p.getProximo();
            }
            return false;
        }

    }

    public int contarNos() {
        if(raiz == null) {
            return 0;
        } else {
            return contarNos(raiz);
        }
    }

    private int contarNos(NoArvore<T> no) {
        int qtde = 1;

        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            qtde += contarNos(p);
            p = p.getProximo();
        }

        return qtde;

    }

    /*
       Contar nos internos
     */

    public int contarNosInternos() {
        return contarNosInternos(raiz);
    }

    private int contarNosInternos(NoArvore<T> no) {
        if (no == null) return 0;

        int contador = 0;
        if (no.getPrimeiro() != null) {
            contador = 1;
        }

        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            contador += contarNosInternos(filho);
            filho = filho.getProximo();
        }

        return contador;
    }

}