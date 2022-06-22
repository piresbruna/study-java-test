package studyjavatest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoDeComprasTest {
    private CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

    @Test
    void addItem_AddItemToListAndSumValueUpToAHundred_WhenSuccessful() {
        Item item1 = new Item("Batata", 5.50);
        Item item2 = new Item("Arroz", 10.20);

        carrinhoDeCompras.addItem(item1);
        carrinhoDeCompras.addItem(item2);

        assertNotNull(carrinhoDeCompras.getItens());
        assertEquals(item1,carrinhoDeCompras.getItens().get(0));
        assertEquals(item2,carrinhoDeCompras.getItens().get(1));
        assertEquals((item1.getValor() + item2.getValor()), carrinhoDeCompras.getTotalValor());
        assertDoesNotThrow(() -> {
            carrinhoDeCompras.addItem(item1);
            carrinhoDeCompras.addItem(item2);
        });
    }

    @Test
    void addItem_AddItemToListAndSumValueUpOverAHundred_ThenThrowException_WhenSuccessful() {
        Item item1 = new Item("Batata", 5.50);
        Item item2 = new Item("Liquidificador", 99.20);

        assertThrows(IllegalArgumentException.class,() -> {
            carrinhoDeCompras.addItem(item1);
            carrinhoDeCompras.addItem(item2);
        });
    }

    @Test
    void getTotalValor() {
    }

    @Test
    void getPossibilidadeDeCompra_ReturnsHowMuchCanStillBeSpend_WhenSuccessful() {
        Item item1 = new Item("Batata", 5.50);
        Item item2 = new Item("Arroz", 10.20);

        carrinhoDeCompras.addItem(item1);
        carrinhoDeCompras.addItem(item2);

        double epectedValue = 100 - (item1.getValor() + item2.getValor());

        assertEquals(epectedValue, carrinhoDeCompras.getPossibilidadeDeCompra());
    }

    @Test
    void getItens_ReturnsListOfITems_WhenSuccessful() {
        Item item1 = new Item("Batata", 5.50);
        Item item2 = new Item("Arroz", 10.20);

        ArrayList<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);

        carrinhoDeCompras.addItem(item1);
        carrinhoDeCompras.addItem(item2);

        assertNotNull(carrinhoDeCompras.getItens());
        assertEquals(itens,carrinhoDeCompras.getItens());
    }
}