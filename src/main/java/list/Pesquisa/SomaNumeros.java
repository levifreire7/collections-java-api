package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros() {
        numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;

        for(Integer i : numeros){
            soma += i;
        }

        return soma;
    }

    public Integer encontrarMaiorNumero(){
        if(!numeros.isEmpty()){
            int maior = numeros.get(0);
            for(Integer i : numeros){
                if(i > maior){
                    maior = i;
                }
            }
            return maior;
        }else{
            return null;
        }
    }

    public Integer encontrarMenorNumero(){
        if(!numeros.isEmpty()){
            int menor = numeros.get(0);
            for(Integer i : numeros){
                if(i < menor){
                    menor = i;
                }
            }
            return menor;
        }else{
            return null;
        }
    }

    public void exibirNumeros(){
        System.out.println(numeros);
    }

    public static void main(String[] args) {
        SomaNumeros sn = new SomaNumeros();

        sn.adicionarNumero(5);
        sn.adicionarNumero(8);
        sn.adicionarNumero(2);
        sn.adicionarNumero(5);
        sn.adicionarNumero(1);
        sn.adicionarNumero(10);
        sn.adicionarNumero(9);
        sn.adicionarNumero(4);

        sn.exibirNumeros();

        System.out.println(sn.calcularSoma());
        System.out.println(sn.encontrarMaiorNumero());
        System.out.println(sn.encontrarMenorNumero());
    }
}
