package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    List<Item> listaDeItens;

    public CarrinhoDeCompras(){
        listaDeItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        listaDeItens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensRemover = new ArrayList<>();

        for(Item i : listaDeItens){
            if(i.getNome().equalsIgnoreCase(nome)){
                itensRemover.add(i);
            }
        }

        listaDeItens.removeAll(itensRemover);
    }

    double calcularValorTotal(){
        double valorTotal = 0.0;

        for(Item i : listaDeItens){
            valorTotal += i.getQuantidade() * i.getPreco();
        }

        return valorTotal;
    }

    public void exibirItens(){
        System.out.println(listaDeItens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Chocolate", 2.0, 5);
        carrinho.adicionarItem("Chocolate", 7.0, 4);
        carrinho.adicionarItem("Biscoito", 3.50, 2);
        carrinho.adicionarItem("Rapadura", 1.0, 10);

        carrinho.exibirItens();

        System.out.println("Valor total do pedido: R$" + carrinho.calcularValorTotal());

        carrinho.removerItem("Chocolate");
        System.out.println("Valor total do pedido: R$" + carrinho.calcularValorTotal());
    }
}
