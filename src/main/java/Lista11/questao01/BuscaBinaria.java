package Lista11.questao01;

public class BuscaBinaria <T extends Comparable<T>> extends BuscaAbstract<T> {

    public int buscar(T valor) {
        int inicio = 0;
        int fim = getInfo().length - 1;
        int meio;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            int comparacao = valor.compareTo((T)getInfo()[meio]);
            if (comparacao < 0) {
                fim = meio -1;
            } else {
                if (comparacao > 0) {
                    inicio = meio + 1;
                } else {
                    return meio; // Valor encontrado
                }
            }
        }
        return -1; // Valor não encontrado
    }
}
