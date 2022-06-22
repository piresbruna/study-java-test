package studyjavatest;

import java.util.List;
import java.util.ArrayList;

public class CarrinhoDeCompras {
  private List<Item> itens;

  public CarrinhoDeCompras() {
    this.itens = new ArrayList<>();
  }

  public void addItem(Item item) {
    double somaTotal = getTotalValor() + item.getValor();

    if(somaTotal > 100.00) {
      throw new IllegalArgumentException("Total de itens deve ser menor que 100.00");
    }

    this.itens.add(item);
  }

  public double getTotalValor() {
    double total = 0.0;

    for (Item item : this.itens) {
      total += item.getValor();
    }

    return total;
  }

  public double getPossibilidadeDeCompra() {
    return 100 - getTotalValor();
  }


  public List<Item> getItens() {
    return this.itens;
  }
}