import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    private Produto cafe;
    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        cafe = new Produto("Café", 3.50);
        pedido = new Pedido();
        pedido.adicionarItem(cafe, 3);
    }

    @Test
    public void testaAdicionarItemAoPedido() {
        assertEquals("Café", pedido.getItens().get(0).getProduto().getNome());
    }

    @Test
    public void deveAdicionarMaisItensAoPedido() {
        Produto chocolate = new Produto("Chocolate", 5.50);
        pedido.adicionarItem(chocolate, 2);
        assertEquals(2, pedido.getItens().size());
        assertEquals("Café", pedido.getItens().get(0).getProduto().getNome());
        assertEquals(chocolate, pedido.getItens().get(1).getProduto());
    }

    @Test
    public void deveCalcularTotalDeUmItemNoPedido() {
        assertEquals(10.5, pedido.calcularTotal());
    }

    @Test
    public void deveCalcularTotalDeMaisDeUmItemNoPedido() {
        Produto chocolate = new Produto("Chocolate", 5.50);
        pedido.adicionarItem(chocolate, 2);
        assertEquals(21.5, pedido.calcularTotal());
    }

    @Test
    public void deveAceitarPagamentoDePedidoPendente() {
        pedido.calcularTotal();
        pedido.pagar();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }
       
    @Test
    public void deveEnviarParaCozinhaPedidoPago() {
        pedido.calcularTotal();
        pedido.pagar();
        pedido.enviarParaCozinha();
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }

    @Test
    public void deveFinalizarPedidoDepoisDeTodasEtapas() {
        pedido.calcularTotal();
        pedido.pagar();
        pedido.enviarParaCozinha();
        pedido.finalizarPedido();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }

    @Test
    public void soDeveEnviarParaCozinhaPedidoPago() {
        pedido.calcularTotal();
        pedido.pagar();        
        assertNotEquals(StatusPedido.PENDENTE, pedido.getStatus());
        assertNotEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
        assertNotEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }

}
