package br.com.pyetro.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.pyetro.domain.Livro;

public class LivroSetDAO implements ILivroDAO{

    private Set<Livro> set;

    public LivroSetDAO(){
        this.set = new HashSet<>();
    }
    @Override
    public Boolean cadastrar(Livro livro) {
        return this.set.add(livro);
    }

    @Override
    public void excluir(String nome) {
        Livro livroEncontrado = null;
        for (Livro livro: this.set){
            if (livro.getNome().equals(nome)){
                livroEncontrado = livro;
                break;
            }
        }
        if (livroEncontrado != null){
            this.set.remove(livroEncontrado);
        }

    }

    @Override
    public void alterar(Livro livro) {
        if(this.set.contains(livro)){
            for (Livro livroCadastrado : this.set) {
                if (livroCadastrado.equals(livro)){
                    livroCadastrado.setNome(livro.getNome());
                    livroCadastrado.setAutor(livro.getAutor());
                    livroCadastrado.setEditora(livro.getEditora());
                    livroCadastrado.setCategoria(livro.getCategoria());
                    livroCadastrado.setResumo(livro.getResumo());
                    livroCadastrado.setPreco(livro.getPreco());
                    break;

                }

            }
        }

    }

    @Override
    public Livro consultar(String nome) {
        for (Livro livroCadastrado : this.set){
            if (livroCadastrado.getNome().equals(nome)){

            }
        }
        return null;
    }

    @Override
    public Collection<Livro> buscarTodos() {
        return this.set;
    }
}
