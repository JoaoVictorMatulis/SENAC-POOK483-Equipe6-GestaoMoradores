/*
 * Turma: A
    Autores: João Victor Matulis || Id de aluno: 1142445416
            Bernardo Galvão de Souza || Id de aluno: 1142473154
            Gabriel de Melo Silva || Id de aluno: 1141267353
            Kevin de Sousa dos Santos || Id de aluno: 1142168549

    Professor: Carlos Veríssimo
 */
package Controller.Morador;

import Model.Morador.SenhaDAO;

public class SenhaController {
    public boolean validacao(String s){
        SenhaDAO dao = new SenhaDAO();
        return dao.validacao(s);
    }
}
