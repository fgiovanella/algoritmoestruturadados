package Lista11.questao01;

public class BuscaLinearVetorOrdenado <T extends Comparable<T>> extends BuscaAbstract<T>{

    public int buscar(T valor){
        T[] info = (T[]) getInfo();
        int n = info.length-1;
        for(int i = 0; i < n; i++){
            if(info[i].equals(valor)) {
                return i;
            } else {
                if (valor.compareTo((T)info[i]) < 0) {
                    break;
                }
            }
        }

        return -1;
    }


}
