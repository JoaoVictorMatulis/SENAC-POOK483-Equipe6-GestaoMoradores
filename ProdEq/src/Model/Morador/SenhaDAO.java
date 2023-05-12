/*
 * Turma: A
    Autores: João Victor Matulis || Id de aluno: 1142445416
            Bernardo Galvão de Souza || Id de aluno: 1142473154
            Gabriel de Melo Silva || Id de aluno: 1141267353
            Kevin de Sousa dos Santos || Id de aluno: 1142168549

    Professor: Carlos Veríssimo
 */
package Model.Morador;

import java.sql.ResultSet;
import Model.ConectarBD;

public class SenhaDAO {
    public boolean validacao(String senha) {
        try {
            String minhaquery = "select id_pessoa, senha from pessoa where senha = '" + senha + "';";
            ResultSet result = ConectarBD.getStatement().executeQuery(minhaquery);
            if (result.next()) {
                String id = result.getString("id_pessoa");
                minhaquery = "select * from registros where fk_id_pessoa = '" + id + "'and saida is null;";
                result = ConectarBD.getStatement().executeQuery(minhaquery);
                if(result.next() && setVazio(result.getString("saida"))){
                    id = result.getString("id_registro");
                    minhaquery = "update registros set saida = now() where id_registro = '"+id+"';";
                    ConectarBD.getStatement().executeUpdate(minhaquery);
                }else{
                    minhaquery = "insert into registros(fk_id_pessoa, saida) value('"+id+"',null);";
                    ConectarBD.getStatement().executeUpdate(minhaquery);
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro na Inclusao: " + e.getMessage());
        }
        return false;
    }

    private static Boolean setVazio(String result){
        if(result == null){
            return true;
        }
        return false;
    }
}
