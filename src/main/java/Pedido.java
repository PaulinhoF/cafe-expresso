import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status;

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemPedido(produto, quantidade));
    }

    public double calcularTotal() {
        double total = 0;
        status = StatusPedido.PENDENTE;
        for (ItemPedido itemPedido : itens) {
            total += itemPedido.calcularSubtotal();
        }        
        return total;
    }

    public void pagar() {
        if (status == StatusPedido.PENDENTE)
            status = StatusPedido.PAGO;
    }

    public void enviarParaCozinha() {
        if (status == StatusPedido.PAGO)
            status = StatusPedido.EM_PREPARO;
    }

    public void finalizarPedido() {
        if (status == StatusPedido.EM_PREPARO)
            status = StatusPedido.FINALIZADO;
    }

}