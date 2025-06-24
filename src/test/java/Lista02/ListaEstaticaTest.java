package Lista02;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListaEstaticaTest {

   private ListaEstatica<Integer> lista = new ListaEstatica<>();

    @Test // Caso 01
    public void testInclusaoItensLista(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);


        assertEquals("5,10,15,20", lista.toString());
    }

    @Test //Caso 02
    public void testObtencaoTamanhoLista(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.getTamanho());
    }

    @Test //Caso 03
    public void testBuscarElemento(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(2,lista.buscar(15));
    }

    @Test //Caso 04
    public void testBuscarElementoInexistente(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(-1, lista.buscar(30));
    }

    @Test //Caso 05
    public void testRetirarDado(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("5,15,20", lista.toString());

        assertEquals(3, lista.getTamanho());
    }

    @Test //Caso 06
    public void testRedimensionamento(){
        int qtd = 15;
        for (int i = 1; i <= qtd; i++) {
            lista.inserir(i);
        }

        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());

        assertEquals(qtd,lista.getTamanho());
    }

    @Test //Caso 08
    public void testExcecaoAoObterElemento(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        try{
            lista.obterElemento(5);
            fail();
        } catch (IndexOutOfBoundsException e){
            //Se recusou obterElemento(5), está correto.
        }
    }

    @Test //Caso 09
    public void testLiberarElementos(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        assertEquals(true, lista.estaVazia());
    }

    @Test //Caso 10
    public void testMetodoInverter(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.inverter();

        assertEquals("20,15,10,5", lista.toString());
    }

    @Test //Caso 11
    public void testMetodoInverterImpar(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);

        lista.inverter();

        assertEquals("25,20,15,10,5", lista.toString());
    }


    /**
     * Teste alternativo para praticar
     */
    @Test
    public void testRemoverEInverter(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);

        lista.retirar(15);

        lista.inverter();

        assertEquals("25,20,10,5", lista.toString());
    }



}