package Lista10;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract{

    @Override
    public void ordenar(){
        quickSort(0, getInfo().length - 1);
    }

    private void quickSort(int inicio, int fim){
        if (inicio < fim) {
            int pivo = particionar(inicio, fim);
            quickSort(inicio, pivo - 1);
            quickSort(pivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim){
        T pivo = (T) getInfo()[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (getInfo()[j].compareTo(pivo) <= 0) {
                i++;
                trocar(i, j);
            }
        }

        trocar(i + 1, fim);
        return i + 1;
    }
}
