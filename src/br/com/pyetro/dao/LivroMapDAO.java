package br.com.pyetro.dao;

import java.util.*;

import br.com.pyetro.domain.Livro;

public class LivroMapDAO implements ILivroDAO {

    private Map<String, Livro> map;

    public LivroMapDAO(){
        map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(Livro livro) {
        if (map.containsKey(livro.getNome())){
            return false;
        }
        map.put(livro.getNome(), livro);
        return true;
    }

    @Override
    public void excluir(String nome) {
        Livro livroCadastrado = map.get(nome);
        map.remove(livroCadastrado.getNome(), livroCadastrado);

    }

    @Override
    public void alterar(Livro livro) {
        Livro livroCadastrado = map.get(livro.getNome());
        livroCadastrado.setNome(livro.getNome());
        livroCadastrado.setAutor(livro.getAutor());
        livroCadastrado.setEditora(livro.getEditora());
        livroCadastrado.setCategoria(livro.getCategoria());
        livroCadastrado.setResumo(livro.getResumo());
        livroCadastrado.setPreco(livro.getPreco());

    }

    @Override
    public Livro consultar(String nome) {
        return this.map.get(nome);
    }

    @Override
    public Collection<Livro> buscarTodos() {
        return this.map.values();
    }
}
