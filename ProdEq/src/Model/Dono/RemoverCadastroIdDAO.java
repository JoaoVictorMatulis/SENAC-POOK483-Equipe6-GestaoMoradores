/*
 * Turma: A
    Autores: João Victor Matulis || Id de aluno: 1142445416
            Bernardo Galvão de Souza || Id de aluno: 1142473154
            Gabriel de Melo Silva || Id de aluno: 1141267353
            Kevin de Sousa dos Santos || Id de aluno: 1142168549

    Professor: Carlos Veríssimo
 */
package Model.Dono;

import Model.ConectarBD;

public class RemoverCadastroIdDAO {

    public void remover(int id) {
        try {
            String query = "DELETE FROM registros WHERE fk_id_pessoa = " + id + ";";
            ConectarBD.getStatement().executeUpdate(query);
            query = "DELETE FROM pessoa WHERE id_pessoa = " + id + ";";
            ConectarBD.getStatement().executeUpdate(query);
            System.out.println("ID: "+ id + "EXCLUIDO COM SUCESSO");
            
        } catch(Exception e) {
            System.out.println("Erro na Exclusao: "+ e.getMessage());
        }
    }
    
}
