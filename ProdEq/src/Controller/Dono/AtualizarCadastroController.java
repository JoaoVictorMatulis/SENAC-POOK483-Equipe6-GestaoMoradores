/*
 * Turma: A
    Autores: João Victor Matulis || Id de aluno: 1142445416
            Bernardo Galvão de Souza || Id de aluno: 1142473154
            Gabriel de Melo Silva || Id de aluno: 1141267353
            Kevin de Sousa dos Santos || Id de aluno: 1142168549

    Professor: Carlos Veríssimo
 */
package Controller.Dono;

import Model.Dono.AtualizarCadastroDAO;

public class AtualizarCadastroController {
    
    public String[] verificarId(int id){
        AtualizarCadastroDAO dao = new AtualizarCadastroDAO();
        return dao.verificarId(id);
    }

    public void atualizar(String[] dados){
        AtualizarCadastroDAO dao = new AtualizarCadastroDAO();
        dao.atualizar(dados);
    }
}
