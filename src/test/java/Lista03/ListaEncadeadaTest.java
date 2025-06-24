package Lista03;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ListaEncadeadaTest {

    private ListaEncadeada<Integer> lista;

    @Before
    public void setUp() {
        lista = new ListaEncadeada<>();
    }

    @Test
    public void testListaVazia() {
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testListaNaoVazia() {
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    public void testInclusaoNumero() {
        lista.inserir(5);
        NoLista<Integer> no = lista.getPrimeiro();
        assertNotNull(no);
        assertEquals((Integer) 5, no.getInfo());
        assertNull(no.getProximo());
    }

    @Test
    public void testInclusaoTresNumeros() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        assertEquals(3, lista.obterComprimento());
        assertEquals((Integer) 15, lista.getPrimeiro().getInfo());
        assertEquals((Integer) 10, lista.getPrimeiro().getProximo().getInfo());
        assertEquals((Integer) 5, lista.getPrimeiro().getProximo().getProximo().getInfo());
    }

    @Test
    public void testBuscaPrimeiraPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista<Integer> no = lista.buscar(20);
        assertNotNull(no);
        assertEquals((Integer) 20, no.getInfo());
    }

    @Test
    public void testBuscaMeioLista() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista<Integer> no = lista.buscar(15);
        assertNotNull(no);
        assertEquals((Integer) 15, no.getInfo());
    }

    @Test
    public void testBuscaDadoInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista<Integer> no = lista.buscar(50);
        assertNull(no);
    }

    @Test
    public void testExclusaoPrimeiroElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        assertEquals(3, lista.obterComprimento());
        assertEquals((Integer) 15, lista.getPrimeiro().getInfo());
    }

    @Test
    public void testExclusaoElementoMeio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(15);
        assertEquals(3, lista.obterComprimento());
        assertEquals((Integer) 20, lista.getPrimeiro().getInfo());
        assertEquals((Integer) 10, lista.getPrimeiro().getProximo().getInfo());
    }

    @Test
    public void testObterNoPosicaoZero() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista<Integer> no = lista.obterNo(0);
        assertEquals((Integer) 20, no.getInfo());
    }

    @Test
    public void testObterNoUltimaPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista<Integer> no = lista.obterNo(3);
        assertEquals((Integer) 5, no.getInfo());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testObterNoPosicaoInvalida() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.obterNo(10);
    }

    @Test
    public void testObterComprimentoListaVazia() {
        assertEquals(0, lista.obterComprimento());
    }

    @Test
    public void testObterComprimentoListaNaoVazia() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(4, lista.obterComprimento());
    }
}