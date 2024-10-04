package main.java.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    Map<String, Livro> livrariaOnlineMap;

    public LivrariaOnline(){
        livrariaOnlineMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livrariaOnlineMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo){
        String chaveRemover;
        for(Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if(entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                chaveRemover = entry.getKey();
                livrariaOnlineMap.remove(chaveRemover);
                break;
            }
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrariaOnlineMap.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livrariaOnlineMap.entrySet());

        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry: livrariaOnlineMap.entrySet()){
            if(entry.getValue().getAutor().equalsIgnoreCase(autor)){
                livrosPorAutor.put(entry.getKey(), entry.getValue());
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> obterLivroMaisCaro() {
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;

        if (!livrariaOnlineMap.isEmpty()) {
            for (Livro livro : livrariaOnlineMap.values()) {
                if (livro.getPreco() > precoMaisAlto) {
                    precoMaisAlto = livro.getPreco();
                }
            }
        }

        for(Map.Entry<String, Livro> entry: livrariaOnlineMap.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisAlto) {
                Livro livroComPrecoMaisAlto = livrariaOnlineMap.get(entry.getKey());
                livrosMaisCaros.add(livroComPrecoMaisAlto);
            }
        }
        return livrosMaisCaros;
    }

    public List<Livro> obterLivroMaisBarato() {
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBaixo = Double.MAX_VALUE;

        if (!livrariaOnlineMap.isEmpty()) {
            for (Livro livro : livrariaOnlineMap.values()) {
                if (livro.getPreco() < precoMaisBaixo) {
                    precoMaisBaixo = livro.getPreco();
                }
            }
        }

        for(Map.Entry<String, Livro> entry: livrariaOnlineMap.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisBaixo) {
                Livro livroComPrecoMaisBaixo = livrariaOnlineMap.get(entry.getKey());
                livrosMaisBaratos.add(livroComPrecoMaisBaixo);
            }
        }
        return livrosMaisBaratos;
    }

    public static void main(String[] args) {
        LivrariaOnline lo = new LivrariaOnline();

        lo.adicionarLivro("https://www.amazon.com.br/homem-giz-C-J-Tudor/dp/855100977X?ref=dlx_67407_dg_dcl_855100977X_dt_mese18_81", "O homem de giz", "C. J. Tudor", 45.84);
        lo.adicionarLivro("https://www.amazon.com.br/pr%C3%ADncipe-cruel-Vol-Povo-Ar/dp/850111555X?ref=dlx_67407_dg_dcl_850111555X_dt_mese18_81", "O príncipe cruel (Vol. 1 O Povo do Ar)", "Holly Black", 38.00);
        lo.adicionarLivro("https://www.amazon.com.br/Dopamina-mol%C3%A9cula-Daniel-Z-Lieberman/dp/655564575X?ref=dlx_67407_dg_dcl_655564575X_dt_mese18_81", "Dopamina: a molécula do desejo", "Daniel Z. Lieberman", 41.80);
        lo.adicionarLivro("https://www.amazon.com.br/Peter-Pan-Cole%C3%A7%C3%A3o-Cl%C3%A1ssicos-Zahar/dp/853781153X?ref=dlx_67407_dg_dcl_853781153X_dt_mese18_81", "Peter Pan: edição bolso de luxo", "J. M. Barrie", 34.14);

        System.out.println(lo.exibirLivrosOrdenadosPorAutor());
        System.out.println(lo.exibirLivrosOrdenadosPorPreco());

        System.out.println(lo.obterLivroMaisBarato());
        System.out.println(lo.obterLivroMaisCaro());

        System.out.println(lo.pesquisarLivrosPorAutor("Holly Black"));

        lo.removerLivro("O homem de giz");
        System.out.println(lo.exibirLivrosOrdenadosPorPreco());
    }
}
