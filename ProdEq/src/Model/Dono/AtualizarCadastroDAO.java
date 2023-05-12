/*
 * Turma: A
    Autores: João Victor Matulis || Id de aluno: 1142445416
            Bernardo Galvão de Souza || Id de aluno: 1142473154
            Gabriel de Melo Silva || Id de aluno: 1141267353
            Kevin de Sousa dos Santos || Id de aluno: 1142168549

    Professor: Carlos Veríssimo
 */
package Model.Dono;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ConectarBD;

public class AtualizarCadastroDAO {
    public String[] verificarId(int id) {
        String[] resultados = null;
        try {
            resultados = new String[7];
            String minhaQuery = "SELECT * FROM pessoa where id_pessoa = '"+id+"'";
            ResultSet result = ConectarBD.getStatement().executeQuery(minhaQuery);
            int coluna = 0;
            if (result.next()) {
                resultados[coluna++] = result.getString("id_pessoa");
                resultados[coluna++] = result.getString("nome_pessoa");
                resultados[coluna++] = result.getString("ap");
                resultados[coluna++] = result.getString("bloco");
                resultados[coluna++] = result.getString("cpf");
                resultados[coluna++] = result.getString("fone");
                resultados[coluna++] = result.getString("email");
                return resultados;
            }
        } catch (Exception e) {
            System.out.println("Erro na Inclusao: " + e.getMessage());
        }
        return resultados;
    }

    public void atualizar(String[] dados){
        try {
            String minhaquery = "update pessoa set nome_pessoa = '"+dados[1]+"', senha = '"+dados[7]+"', ap = '"+dados[2]+"', bloco = '"+dados[3]+"', cpf = '"+dados[4]+"', fone = '"+dados[5]+"', email = '"+dados[6]+"' where id_pessoa = '"+dados[0]+"'; ";
            ConectarBD.getStatement().executeUpdate(minhaquery);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
