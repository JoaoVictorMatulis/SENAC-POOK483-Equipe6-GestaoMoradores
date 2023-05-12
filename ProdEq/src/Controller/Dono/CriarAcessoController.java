/*
 * Turma: A
    Autores: João Victor Matulis || Id de aluno: 1142445416
            Bernardo Galvão de Souza || Id de aluno: 1142473154
            Gabriel de Melo Silva || Id de aluno: 1141267353
            Kevin de Sousa dos Santos || Id de aluno: 1142168549

    Professor: Carlos Veríssimo
 */
package Controller.Dono;

import Model.Dono.CriarAcessoDAO;
import View.Dono.CriarAcesso;

public class CriarAcessoController {

    public  void view(){
        new CriarAcesso();
    }

    public void criarAcesso(String nome, int ap, int bloco, String cpf, String fone, String email, String senha) {
        CriarAcessoDAO dao = new CriarAcessoDAO();
        dao.inserir(nome,ap,bloco,cpf,fone,email,senha);
    }
    
}
