/*
 * Turma: A
    Autores: João Victor Matulis || Id de aluno: 1142445416
            Bernardo Galvão de Souza || Id de aluno: 1142473154
            Gabriel de Melo Silva || Id de aluno: 1141267353
            Kevin de Sousa dos Santos || Id de aluno: 1142168549

    Professor: Carlos Veríssimo
 */
package Controller.Dono;

import Model.Dono.RemoverCadastroIdDAO;
import View.Dono.RemoverCadastroId;

public class RemoverCadastroIdController {

    public  void view(){
        new RemoverCadastroId();
    }

    public void removerAcesso(int id) {
        RemoverCadastroIdDAO dao = new RemoverCadastroIdDAO();
        dao.remover(id);
    }
}
