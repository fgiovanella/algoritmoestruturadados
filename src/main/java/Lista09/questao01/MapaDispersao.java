package Lista09.questao01;

import Lista03.ListaEncadeada;
import Lista03.NoLista;

public class MapaDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }


    /**
     * Implementa a função de has, que é responsável por identificar em
     * que posição do vetor o objeto deve constar(ou ser armazenado).
     *
     * @param chave Objeto a se calcular o hash
     * @return Hash calculado
     */
    private int calcularHash(int chave) {
        return chave % this.info.length;
    }

    public void inserir(int chave, T valor) {
        int indice = calcularHash(chave);
        if (info[indice] == null) {
            info[indice] = new ListaEncadeada<>();
        }
        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        no.setValor(valor);

        info[indice].inserir(no);
    }

    /**
     * Remove um objeto do mapa. O objeto fornecido como argumento deve ter a chave
     * de buscar informada.
     *
     * @param chave Objeto que contém a chave de busca do objeto a ser removido.
     */
    public void remover(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> no = new NoMapa<>();
            no.setChave(chave);
            info[indice].retirar(no);
        }
    }

    /**
     * Busca um objeto no mapa de dispersão. O objeto fornecido como argumento deve
     * ter a chave de busca informada.
     *
     * @param chave Objeto que contém a chave de busca do objeto a ser buscado.
     * @return O valor associado à chave buscada, ou null se não encontrado.
     */
    public T buscar(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
            if (no != null) {
                return no.getInfo().getValor();
            }
        }
        return null; // Retorna null se não encontrar o valor
    }

    private double calcularFatorCarga() {
        int qtdObjetosAdicionados = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                qtdObjetosAdicionados = qtdObjetosAdicionados
                        + info[i].obterComprimento();
            }
        }
        return (1.0) * qtdObjetosAdicionados / info.length;
    }

//    public void realocarMapa(int novoTamanho) {
//        // Cria novo vetor de listas encadeadas com o novo tamanho
//        ListaEncadeada<NoMapa<T>>[] novoMapa = new ListaEncadeada[novoTamanho];
//
//        // Percorre o mapa atual
//        for (int i = 0; i < info.length; i++) {
//            if (info[i] != null) {
//                NoLista<NoMapa<T>> atual = info[i].getPrimeiro();
//                while (atual != null) {
//                    NoMapa<T> no = atual.getInfo();
//                    int novaPosicao = no.getChave() % novoTamanho;
//
//                    // Cria a lista encadeada se necessário
//                    if (novoMapa[novaPosicao] == null) {
//                        novoMapa[novaPosicao] = new ListaEncadeada<>();
//                    }
//
//                    // Insere o nó na nova posição
//                    novoMapa[novaPosicao].inserir(no);
//
//                    atual = atual.getProximo();
//                }
//            }
//        }
//
//        // Atualiza o atributo info com o novo mapa
//        this.info = novoMapa;
//    }

    public void realocarMapa(int novoTamanho) {
        // Guarda o vetor atual
        ListaEncadeada<NoMapa<T>>[] antigo = info;

        // Cria novo vetor com o novo tamanho
        info = new ListaEncadeada[novoTamanho];

        // Percorre todas as posições do vetor antigo
        for (int i = 0; i < antigo.length; i++) {
            if (antigo[i] != null) {
                NoLista<NoMapa<T>> atual = antigo[i].getPrimeiro(); // ou getInicio(), dependendo do nome real

                while (atual != null) {
                    NoMapa<T> dado = atual.getInfo();
                    int chave = dado.getChave();

                    int novoIndice = chave % novoTamanho;

                    if (info[novoIndice] == null) {
                        info[novoIndice] = new ListaEncadeada<>();
                    }

                    info[novoIndice].inserir(dado);

                    atual = atual.getProximo();
                }
            }
        }
    }

    private int funcaoHash(String chave, int tamanho) {
        return Math.abs(chave.hashCode()) % tamanho;
    }


}
