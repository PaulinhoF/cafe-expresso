public class ItemPedido {

    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularSubtotal(){
        produto = new Produto("Café", 5.5);
        ItemPedido pedido = new ItemPedido(produto, 4);
        double subtotal = produto.getPrecoUnitario() * pedido.getQuantidade();
        return subtotal;
    }

}