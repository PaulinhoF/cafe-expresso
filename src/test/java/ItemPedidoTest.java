import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemPedidoTest {

    @Test
    public void testaCalculoDoSubtotal() {
        Produto produto = new Produto("cafe", 5.5);
        ItemPedido cafe = new ItemPedido(produto, 4);
        cafe.calcularSubtotal();
        assertEquals(22, cafe.calcularSubtotal(), 0.01);
    }

    @Test
    public void testaCalculoDoSubtotalDeveLancarErroQuandoPrecoNegativo() {
        Produto produto = new Produto("pao", -0.01);
        ItemPedido cafe = new ItemPedido(produto, 2);
        Error erroCapturado = assertThrows(Error.class, () -> {
            cafe.calcularSubtotal();
        });
        assertEquals("Preço inválido!", erroCapturado.getMessage());
    }
    
    @Test
    public void testaCalculoDoSubtotalDeveLancarErroQuandoQuantidadeAbaixoDeUm() {
        Produto produto = new Produto("chá", 3.50);
        ItemPedido cha = new ItemPedido(produto, 0);
        Error erroCapturado = assertThrows(Error.class, () -> {
            cha.calcularSubtotal();
        });
        assertEquals("Quantidade inválida!", erroCapturado.getMessage());
    }



}
