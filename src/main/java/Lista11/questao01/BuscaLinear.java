package Lista11.questao01;

public class BuscaLinear<T> extends BuscaAbstract<T> {

    public int buscar(T valor) {
        Object[] info = getInfo();
        int n = info.length;
        for (int i = 0; i < n; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
}
