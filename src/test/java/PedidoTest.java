import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PedidoTest {

    @Test
    public void testaAdicionarItemAoPedido() {
        Produto cafe = new Produto("Café", 3.50);
        Pedido pedido = new Pedido();
        pedido.adicionarItem(cafe, 3);
        Produto produtoNoPedido = pedido.getItens().get(0).getProduto();
        assertEquals("Café", produtoNoPedido.getNome());
    }
}
