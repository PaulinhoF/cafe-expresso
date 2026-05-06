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

    public double calcularSubtotal() {
        
        double subtotal = produto.getPrecoUnitario() * quantidade;
        if(produto.getPrecoUnitario()<0)
            throw new Error("Preço inválido!");
        if(quantidade<1)
            throw new Error("Quantidade inválida!");
        return subtotal;
    }

}