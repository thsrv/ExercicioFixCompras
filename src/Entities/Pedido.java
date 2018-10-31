package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momento;
    private StatusPedido status;

    //associações
    private Cliente client;
    private List<ItemPedido> itens = new ArrayList<>();


    public Pedido(Date momento,StatusPedido status,Cliente client){
        this.momento = momento;
        this.status = status;
        this.client = client;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    //Inicio Metodo para add e remover da lista!
    public void addItem(ItemPedido item){
        itens.add(item);
    }
    public void removeItem(ItemPedido item){
        itens.remove(item);
    }
    //Fim metodo para add e remover da lista!

    public double total(){
        double soma = 0;
        //foreach
        for(ItemPedido x :
            itens){
            soma+=x.subTotal();
        }
        return soma;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do Pedido: ");
        sb.append(sdf.format(momento)+"\n");
        sb.append("Status do Pedido: ");
        sb.append(status+"\n");
        sb.append("Cliente: ");
        sb.append(client+"\n");
        sb.append("Itens do pedido:"+"\n");
        //foreach
        for(ItemPedido list:
                itens){
            sb.append(list+"\n");
        }
        sb.append("Preço Total: ");
        sb.append(String.format("%.2f",total()));

        return sb.toString();
    }



}
