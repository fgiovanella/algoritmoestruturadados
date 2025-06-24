package org.example;

import Lista01.ListaEstatica;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica();
        lista.inserir(55);
        lista.inserir(66);
        lista.inserir(77);


        /**
         * Forma de iterar sobre a lista e informar que cada dado foi armazenado.
         */
        for(int i = 0; i < lista.getTamanho(); i++){
            System.out.println(lista.obterElemento(i) + " está armazenado.");
        }



    }
}