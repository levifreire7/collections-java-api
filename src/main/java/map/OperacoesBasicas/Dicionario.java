package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> verbetes;

    public Dicionario(){
        verbetes = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        verbetes.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if(!verbetes.isEmpty())
            verbetes.remove(palavra);
    }

    public void exibirPalavras(){
        System.out.println(verbetes);
    }

    public String pesquisarPorPalavra(String palavra){
        return verbetes.get(palavra);
    }

    public static void main(String[] args) {
        Dicionario dic = new Dicionario();

        dic.adicionarPalavra("Amor", "Sentimento que induz a aproximar, a proteger ou a conservar a pessoa pela qual se sente afeição ou atração; grande afeição ou afinidade forte por outra pessoa");
        dic.adicionarPalavra("Felicidade", "Estado de espírito de quem se encontra alegre ou satisfeito");
        dic.adicionarPalavra("Paz", "Situação em que não há guerra nem enfrentamento entre dois ou mais países");
        dic.adicionarPalavra("Paz", "Situação em que não há guerra nem enfrentamento entre dois ou mais países");

        dic.exibirPalavras();

        System.out.println(dic.pesquisarPorPalavra("Amor"));

        dic.removerPalavra("Felicidade");

        dic.exibirPalavras();
    }
}
