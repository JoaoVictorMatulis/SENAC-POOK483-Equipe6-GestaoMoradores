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

public class ExibirRegistrosDAO {
    ResultSet result = null;

    public String[][] listar() {
        String[][] resultados = null;
        try {
            resultados = new String[tamanho()][4];
            String minhaQuery = "SELECT * FROM registros";
            result = ConectarBD.getStatement().executeQuery(minhaQuery);
            int linha = 0;
            int coluna = 0;
            while (result.next()) {
                resultados[linha][coluna++] = result.getString("id_registro");
                resultados[linha][coluna++] = result.getString("fk_id_pessoa");
                resultados[linha][coluna++] = result.getString("entrada");
                resultados[linha++][coluna++] = result.getString("saida");
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
            String minhaQuery = "SELECT COUNT(*) AS total FROM registros";
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
