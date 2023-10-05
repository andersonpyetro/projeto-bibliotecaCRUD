package br.com.pyetro.dao;

import br.com.pyetro.domain.Livro;
import java.util.Collection;

public interface ILivroDAO {

    public Boolean cadastrar (Livro livro);
    public void excluir(String nome);
    public void alterar(Livro livro);
    public Livro consultar(String nome);
    public Collection<Livro> buscarTodos();
}
