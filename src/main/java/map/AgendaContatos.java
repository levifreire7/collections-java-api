package main.java.map;

import main.java.set.Ordenacao.Aluno;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos(){
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisaPorNome(String nome){
        return agendaContatoMap.get(nome);
    }

    public static void main(String[] args) {
        AgendaContatos ac = new AgendaContatos();

        ac.adicionarContato("Maria", 123456);
        ac.adicionarContato("José", 123457);
        ac.adicionarContato("Mateus", 123458);
        ac.adicionarContato("Paulo", 123459);
        ac.adicionarContato("Maria Clara", 123456);
        ac.adicionarContato("Maria", 123450);

        ac.exibirContatos();

        System.out.println(ac.pesquisaPorNome("Mateus"));
        System.out.println(ac.pesquisaPorNome("Ítalo"));

        ac.removerContato("Paulo");

        ac.exibirContatos();
    }
}
