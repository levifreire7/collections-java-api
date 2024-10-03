package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> conjuntoPalavras;

    public ConjuntoPalavrasUnicas(){
        conjuntoPalavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        conjuntoPalavras.add(palavra);
    }

    public void removerPalavra(String palavra){
        conjuntoPalavras.remove(palavra);
    }

    public boolean verificarPalavra(String palavra){
        return conjuntoPalavras.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        System.out.println(conjuntoPalavras);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Ford");
        conjuntoPalavrasUnicas.adicionarPalavra("Chevrolet");
        conjuntoPalavrasUnicas.adicionarPalavra("Toyota");
        conjuntoPalavrasUnicas.adicionarPalavra("Honda");
        conjuntoPalavrasUnicas.adicionarPalavra("Toyota");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.removerPalavra("Honda");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        System.out.println(conjuntoPalavrasUnicas.verificarPalavra("Chevrolet"));
        System.out.println(conjuntoPalavrasUnicas.verificarPalavra("Honda"));

        conjuntoPalavrasUnicas.removerPalavra("Kia");
    }
}
