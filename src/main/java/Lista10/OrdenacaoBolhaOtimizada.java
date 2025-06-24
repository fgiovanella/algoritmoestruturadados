package Lista10;

public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public void ordenar() {
        boolean trocou;
        do {
            trocou = false;
            for (int i = 0; i < getInfo().length - 1; i++) {
                if (getInfo()[i].compareTo(getInfo()[i + 1]) > 0) {
                    trocar(i, i + 1);
                    trocou = true;
                }
            }
        } while (trocou);
    }
}
