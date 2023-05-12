/*
 * Turma: A
    Autores: João Victor Matulis || Id de aluno: 1142445416
            Bernardo Galvão de Souza || Id de aluno: 1142473154
            Gabriel de Melo Silva || Id de aluno: 1141267353
            Kevin de Sousa dos Santos || Id de aluno: 1142168549

    Professor: Carlos Veríssimo
 */
package Controller.Dono;

import Model.Dono.ExibirMoradoresDAO;
import View.Dono.ExibirMoradores;

public class ExibirMoradoresController {
    
    public void viewMoradores(){
        ExibirMoradoresDAO dao = new ExibirMoradoresDAO();
        new ExibirMoradores(dao.listar());
    }

    public void viewEsp(){
        
    }
}
