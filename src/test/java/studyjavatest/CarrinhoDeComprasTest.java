package studyjavatest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoDeComprasTest {
    private CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

    @Test
    void addItem_AddItem() {
        Item item1 = new Item("Batata", 5.50);
        Item item2 = new Item("Arroz", 10.20);

        carrinhoDeCompras.addItem(item1);
        carrinhoDeCompras.addItem(item2);

        assertNotNull(carrinhoDeCompras.getItens());
        assertEquals(item1,carrinhoDeCompras.getItens().get(0));
        assertEquals(item2,carrinhoDeCompras.getItens().get(1));
        assertDoesNotThrow(() -> {
            carrinhoDeCompras.addItem(item1);
            carrinhoDeCompras.addItem(item2);
        });
    }

    @Test
    void addItem_AddItemThrowException() {
        Item item1 = new Item("Batata", 5.50);
        Item item2 = new Item("Liquidificador", 99.20);

        assertThrows(IllegalArgumentException.class,() -> {
            carrinhoDeCompras.addItem(item1);
            carrinhoDeCompras.addItem(item2);
        });
    }

    @Test
    void getTotalValor() {
        Item item1 = new Item("Batata", 5.50);
        Item item2 = new Item("Arroz", 10.20);
        double expectedSum = item1.getValor() + item2.getValor();

        carrinhoDeCompras.addItem(item1);
        carrinhoDeCompras.addItem(item2);

        assertEquals(expectedSum, carrinhoDeCompras.getTotalValor());
    }

    @Test
    void getPossibilidadeDeCompra() {
        Item item1 = new Item("Batata", 5.50);

        carrinhoDeCompras.addItem(item1);

        double epectedValue = 100 - item1.getValor();

        assertEquals(epectedValue, carrinhoDeCompras.getPossibilidadeDeCompra());
    }

    @Test
    void getItens() {
        Item item1 = new Item("Batata", 5.50);

        ArrayList<Item> itens = new ArrayList<Item>();
        itens.add(item1);

        carrinhoDeCompras.addItem(item1);

        assertNotNull(carrinhoDeCompras.getItens());
        assertEquals(itens,carrinhoDeCompras.getItens());
    }
}