package com.company;


import Entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
       /* Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
        sumário do pedido conforme exemplo (próxima página). Nota: o instante do pedido deve ser
        o instante do sistema: new Date()
*/
       Locale.setDefault(Locale.US);
       Scanner sc = new Scanner(System.in);

       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Insira as informações do cliente:");
        System.out.print("Nome: ");
            String clientNome = sc.nextLine();
        System.out.print("Email: ");
            String clientEmail = sc.nextLine();
        System.out.print("Data de nascimento: ");
            Date dataNascimento = sdf.parse(sc.next());

            //Instanciando Cliente.
        Cliente cliente = new Cliente(clientNome,clientEmail,dataNascimento);

            separador();
        System.out.println("Insira os dados do Pedido:");
        System.out.print("Status: ");
            StatusPedido status = StatusPedido.valueOf(sc.next());

            //Instanciando Pedido.
        Pedido pedido = new Pedido(new Date(),status,cliente);

        System.out.print("Quantos itens para esse pedido? ");
            int n = sc.nextInt();
            for(int i=1; i<=n; i++){
                System.out.println("Insira os dados do Pedido #"+i);
                System.out.print("Nome do produto: ");
                sc.nextLine();//pedente.
                    String produtoNome = sc.nextLine();
                System.out.print("Preço do produto: ");
                    double produtoPreco = sc.nextDouble();

                    //Instanciando Produto.
                Produto produto = new Produto(produtoNome,produtoPreco);

                System.out.print("Quantidade: ");
                    int produtoQtd = sc.nextInt();


                //Instanciando ItemPedido.
                ItemPedido itemPedido = new ItemPedido(produtoQtd,produtoPreco,produto);

                //adcionando pedido a lista.
                pedido.addItem(itemPedido);
            }
            separador();
        System.out.println("RESUMO DO PEDIDO:");
        System.out.println(pedido);
    sc.close();
    }

    public static void separador(){
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><>");
    }
}
