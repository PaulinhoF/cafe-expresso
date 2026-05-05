import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemPedidoTest {

    @Test
    public void testaCalculoDoSubtotal() {
        Produto produto = new Produto("cafe", 5.5);
        ItemPedido cafe = new ItemPedido(produto, 4);
        cafe.calcularSubtotal();
        assertEquals(22, cafe.calcularSubtotal(), 0.01);
    }

}
