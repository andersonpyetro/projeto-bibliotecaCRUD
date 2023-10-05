package br.com.pyetro.domain;

import java.util.Objects;

public class Livro {

    private String nome;
    private String autor;
    private String editora;
    private String categoria;
    private String resumo;
    private Integer preco;

    public Livro(String nome, String autor, String editora,String categoria, String resumo, String preco){
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
        this.resumo = resumo;
        this.preco = Integer.valueOf(preco.trim());
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public String getEditora(){
        return editora;
    }
    public void setEditora(String editora){
        this.editora = editora;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getResumo(){
        return resumo;
    }
    public void setResumo(String resumo){
        this.resumo = resumo;
    }
    public Integer getPreco(){
        return preco;
    }
    public void setPreco(Integer preco){
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash +Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.nome, other.nome)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", Autor=" + autor +
                ", Editora=" + editora +
                ", Categoria='" + categoria + '\'' +
                ", Resumo=" + resumo +
                ", Preço='" + preco + '\'' +
                '}';
    }
}
