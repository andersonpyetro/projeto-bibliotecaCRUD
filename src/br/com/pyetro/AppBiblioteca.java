package br.com.pyetro;

import br.com.pyetro.dao.ILivroDAO;
import br.com.pyetro.dao.LivroMapDAO;
import br.com.pyetro.dao.LivroSetDAO;
import br.com.pyetro.domain.Livro;

import javax.swing.*;

public class AppBiblioteca {

    private static ILivroDAO iLivroDAO;

    public static void main(String[] args){
        String opcao = JOptionPane.showInputDialog(null,"Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração e 5 para sair", "Biblioteca",JOptionPane.INFORMATION_MESSAGE);

        while(!isOpcaoValida(opcao)){
            if("".equals(opcao)){
                sair();
            }

            opcao = JOptionPane.showInputDialog(null, "Opção Invalida - Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alterar e 5 para sair","Biblioteca",JOptionPane.INFORMATION_MESSAGE);

        }
        while(isOpcaoValida(opcao)){
            if (isOpcaoSair(opcao)){
                sair();
            } else if (isCadastro(opcao)){
                String dados = JOptionPane.showInputDialog(null,"Digite os dados separados por vírgula", "Cadastro",JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsulta(opcao)){
                String dados = JOptionPane.showInputDialog(null, "Digite o nome do livro que deseja encontrar", "Consulta livro",JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if(isExclusao(opcao)){
                String dados = JOptionPane.showInputDialog(null,"Digite o nome do livro","Excluir livro",JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else {
                String dados = JOptionPane.showInputDialog(null,"Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração e 5 para sair", "Biblioteca",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    private static void atualizar(String dados){
        String[] dadosSeparados = dados.split(",");
        Livro livro = new Livro(dadosSeparados[0], dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5]);
        iLivroDAO.alterar(livro);
    }
    private static void excluir(String dados){
        iLivroDAO.excluir(dados);
        JOptionPane.showMessageDialog(null,"Livro excluído com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);

    }
    private static void consultar(String dados){
        Livro livro = iLivroDAO.consultar(dados);
        if(livro != null) {
            JOptionPane.showMessageDialog(null,"Livro encontrado com sucesso" + livro.toString(),"Sucesso",JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null,"Livro não encontrado", "Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static void cadastrar(String dados){
        String[] dadosSeparados = dados.split(",");
        Livro livro = new Livro(dadosSeparados[0], dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5]);
        Boolean isCadastrado = iLivroDAO.cadastrar(livro);
        if (isCadastrado){
            JOptionPane.showMessageDialog(null, "Livro Cadastrado com sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null,"Livro já se encontra na biblioteca", "Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static boolean isExclusao(String opcao){
        if("3".equals(opcao)){
            return true;
        }
        return false;
    }
    private static boolean isConsulta(String opcao){
        if("2".equals(opcao)){
            return true;
        }
        return false;
    }
    private static boolean isCadastro(String opcao){
        if ("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void sair(){
        String livrosCadastrados = "";
        for( Livro livro : iLivroDAO.buscarTodos()){
            livrosCadastrados += livro.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, "livros cadastrados: ");
        System.exit(0);
    }
    private static boolean isOpcaoSair(String opcao){
        if("5".equals(opcao)){
            return true;
        }
        return false;
    }
    private static boolean isOpcaoValida(String opcao){
        if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) ||"4".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;
    }
}
