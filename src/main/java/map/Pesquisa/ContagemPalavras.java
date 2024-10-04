package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras(){
        this.contagemPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        contagemPalavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if(!contagemPalavrasMap.isEmpty()){
            contagemPalavrasMap.remove(palavra);
        }
    }

    public void exibirContagemPalavras(){
        System.out.println(contagemPalavrasMap);
    }

    public String encontraPalavraMaisFrequente(){
        String palavraMaisFrequente = null;
        int contagem = 0;
        if(!contagemPalavrasMap.isEmpty()){
            for(Map.Entry<String, Integer> entry : contagemPalavrasMap.entrySet()){
                if(entry.getValue() > contagem){
                    contagem = entry.getValue();
                    palavraMaisFrequente = entry.getKey();
                }
            }
        }
        return "Palavra mais frequente: " + palavraMaisFrequente + " Contagem: " + contagem;
    }

    public static void main(String[] args) {
        ContagemPalavras cp = new ContagemPalavras();

        cp.adicionarPalavra("Vida", 50);
        cp.adicionarPalavra("História", 25);
        cp.adicionarPalavra("Tesouro", 100);
        cp.adicionarPalavra("Poder", 37);
        cp.adicionarPalavra("Noite", 179);

        cp.exibirContagemPalavras();

        cp.removerPalavra("Poder");

        cp.exibirContagemPalavras();

        System.out.println(cp.encontraPalavraMaisFrequente());
    }
}
