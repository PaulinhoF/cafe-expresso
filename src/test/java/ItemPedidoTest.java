import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ItemPedidoTest {

    @Test
    public void testaCalculoDoSubtotal() {
        Produto produto = new Produto("cafe", 5.5);
        ItemPedido pedido = new ItemPedido(produto,4);
        double subtotal = produto.getPrecoUnitario() * pedido.getQuantidade();
        assertEquals(16.5, subtotal, 0.01);
    }

}
