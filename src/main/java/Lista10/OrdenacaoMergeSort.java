package Lista10;

public class OrdenacaoMergeSort <T extends Comparable<T>> extends OrdenacaoAbstract<T>{

    @Override
    public void ordenar() {
        mergeSort(0, getInfo().length - 1);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, meio, fim);
        }
    }

    private void merge(int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        T[] esquerda = (T[]) new Comparable[n1];
        T[] direita = (T[]) new Comparable[n2];

        for (int i = 0; i < n1; i++) {
            esquerda[i] = getInfo()[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            direita[j] = getInfo()[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (esquerda[i].compareTo(direita[j]) <= 0) {
                getInfo()[k] = esquerda[i];
                i++;
            } else {
                getInfo()[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            getInfo()[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            getInfo()[k] = direita[j];
            j++;
            k++;
        }
    }
}
