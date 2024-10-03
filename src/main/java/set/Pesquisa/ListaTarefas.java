package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas(){
        tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto está vazio");
        }

        if(tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefas(){
        System.out.println(tarefaSet);
    }

    public int contarTarefas(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for(Tarefa t : tarefaSet){
            if(t.isTarefaConcluida()){
                tarefasConcluidas.add(t);
            }
        }

        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for(Tarefa t : tarefaSet){
            if(!t.isTarefaConcluida()){
                tarefasPendentes.add(t);
            }
        }

        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
        for(Tarefa t : tarefaSet){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setTarefaConcluida(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao){
        Tarefa tarefaParaMarcarComoPendente = null;

        for (Tarefa t : tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaMarcarComoPendente = t;
                break;
            }
        }

        if (tarefaParaMarcarComoPendente != null) {
            if(tarefaParaMarcarComoPendente.isTarefaConcluida()) {
                tarefaParaMarcarComoPendente.setTarefaConcluida(false);
            }
        } else {
            System.out.println("Tarefa não encontrada na lista.");
        }
    }

    public void limparListaTarefas(){
        tarefaSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Ir ao supermercado");
        listaTarefas.adicionarTarefa("Lavar o carro");
        listaTarefas.adicionarTarefa("Comprar passagem");
        listaTarefas.adicionarTarefa("Levar o cachorro para passear");
        listaTarefas.adicionarTarefa("Lavar os sapatos");
        listaTarefas.adicionarTarefa("Lavar o carro");

        listaTarefas.exibirTarefas();

        System.out.println("Total de tarefas: " + listaTarefas.contarTarefas());

        System.out.println("Tarefas concluidas: " + listaTarefas.obterTarefasConcluidas());

        System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaConcluida("Comprar passagem");
        listaTarefas.marcarTarefaConcluida("Levar o cachorro para passear");

        System.out.println("Tarefas concluidas: " + listaTarefas.obterTarefasConcluidas());

        listaTarefas.marcarTarefaPendente("Levar o cachorro para passear");

        System.out.println("Tarefas concluidas: " + listaTarefas.obterTarefasConcluidas());

        System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());

        listaTarefas.removerTarefa("Lavar os sapatos");

        listaTarefas.exibirTarefas();

        listaTarefas.limparListaTarefas();

        listaTarefas.exibirTarefas();
    }
}
