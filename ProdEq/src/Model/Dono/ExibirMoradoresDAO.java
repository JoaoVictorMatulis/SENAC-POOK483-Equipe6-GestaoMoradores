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

import Model.ConectarBD;

public class ExibirMoradoresDAO {
    ResultSet result = null;

    public String[][] listar() {
        String[][] resultados = null;
        try {
            resultados = new String[tamanho()][8];
            String minhaQuery = "SELECT * FROM pessoa ORDER BY nome_pessoa";
            result = ConectarBD.getStatement().executeQuery(minhaQuery);
            int linha = 0;
            int coluna = 0;
            while (result.next()) {
                resultados[linha][coluna++] = result.getString("id_pessoa");
                resultados[linha][coluna++] = result.getString("nome_pessoa");
                resultados[linha][coluna++] = result.getString("ap");
                resultados[linha][coluna++] = result.getString("bloco");
                resultados[linha][coluna++] = result.getString("cpf");
                resultados[linha][coluna++] = result.getString("fone");
                resultados[linha][coluna++] = result.getString("email");
                resultados[linha++][coluna] = result.getString("senha");
                coluna = 0;
            }
            return resultados;
        } catch (Exception e) {
            System.out.println("Erro na lista: " + e.getMessage());
        }
        return resultados;
    }

    public int tamanho() {
        int tamanho = 0;
        try {
            String minhaQuery = "SELECT COUNT(*) AS total FROM pessoa";
            result = ConectarBD.getStatement().executeQuery(minhaQuery);
            while (result.next()) {
                tamanho = result.getInt("total");
            }
            return tamanho;
        } catch (Exception e) {
            System.out.println("Erro na lista: " + e.getMessage());
        }
        return tamanho;
    }
}
