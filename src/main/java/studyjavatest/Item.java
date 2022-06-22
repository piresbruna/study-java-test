package studyjavatest;

public class Item {
  private String nome;
  private double valor;

  public Item(String nome, double valor) {
    this.nome = nome;
    this.valor = valor;
  }

  public double getValor() {
    return this.valor;
  }
}