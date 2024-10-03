package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> numerosOrdenados = new ArrayList<>(numeros);
        Collections.sort(numerosOrdenados);
        return numerosOrdenados;
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> numerosOrdenados = new ArrayList<>(numeros);
        numerosOrdenados.sort(Collections.reverseOrder());
        return numerosOrdenados;
    }

    public void exibirLista(){
        System.out.println(numeros);
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(4);
        ordenacaoNumeros.adicionarNumero(7);
        ordenacaoNumeros.adicionarNumero(8);
        ordenacaoNumeros.adicionarNumero(9);
        ordenacaoNumeros.adicionarNumero(3);
        ordenacaoNumeros.adicionarNumero(0);
        ordenacaoNumeros.adicionarNumero(8);
        ordenacaoNumeros.adicionarNumero(5);
        ordenacaoNumeros.adicionarNumero(3);

        ordenacaoNumeros.exibirLista();
        System.out.println(ordenacaoNumeros.ordenarAscendente());
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }
}