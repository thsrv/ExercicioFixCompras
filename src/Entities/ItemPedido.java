package Entities;

public class ItemPedido {

    private int qtd;
    private double preco;

    private Produto produto;

    public ItemPedido(int qtd,double preco,Produto produto){
        this.qtd = qtd;
        this.preco = preco;
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double subTotal(){
        return preco*qtd;
    }

    public String toString(){

        return produto.getNome()
                +", $"
                +String.format("%.2f",preco)
                +", Quantidade: "
                +qtd
                +", Subtotal: "
                +subTotal();
    }
}
