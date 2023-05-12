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

public class CriarAcessoDAO {

    public void inserir(String nome, int ap, int bloco, String cpf, String fone, String email, String senha) {
        try {
            String query = "insert into pessoa (nome_pessoa, senha, ap, bloco, cpf, fone, email) values ('"+nome+"', '"+senha+"', "+ap+", "+bloco+", '"+cpf+"', '"+fone+"', '"+email+"');";
            ConectarBD.getStatement().executeUpdate(query);
            System.out.println("Morador " +nome + " Incuido com SUCESSO" );
            
        } catch(Exception e) {
            System.out.println("Erro na Inclusao: "+ e.getMessage());
        }
    }
    
}
