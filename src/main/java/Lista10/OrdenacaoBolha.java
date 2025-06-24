package Lista10;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar(){
        for (int i = 0; i < getInfo().length - 1; i++) {
            for (int j = 0; j < getInfo().length - 1 - i; j++) {
                if (getInfo()[j].compareTo(getInfo()[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}
