import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public void inserir(Professor professor) {
        String sql = "INSERT INTO professores (nome, email,data_nascimento,cpf,cidade,estado_civil, login, senha) VALUES (?, ?, ? , ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setDate(3, professor.getData_nascimento());
            stmt.setString(4, professor.getCpf());
            stmt.setString(5, professor.getCidade());
            stmt.setString(6, professor.getEstado_civil());
            stmt.setString(7, professor.getLogin());
            stmt.setString(8, professor.getSenha());


            stmt.executeUpdate();

            System.out.println("Professor inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }


    public List<Professor> listar() {
        List<Professor> lista = new ArrayList<>();
        String sql = "SELECT * FROM professores";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);

             ResultSet rs = stmt.executeQuery()) {


            while (rs.next()) {

                Professor a = new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento"),
                        rs.getString("cpf"),
                        rs.getString("cidade"),
                        rs.getString("estado_civil"),
                        rs.getString("login"),
                        rs.getString("senha")
                );
                lista.add(a);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }


    public void atualizar(Professor professor) {

        String sql = "UPDATE professores SET nome = ?, email = ?, data_nascimento = ?, cpf = ?, cidade = ?, estado_civil = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setDate(3, professor.getData_nascimento());
            stmt.setString(4, professor.getCpf());
            stmt.setString(5, professor.getCidade());
            stmt.setString(6, professor.getEstado_civil());
            stmt.setInt(7, professor.getId());

            stmt.executeUpdate();

            System.out.println("Professor atualizado!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM professores WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Professor deletado!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }

    public Professor autenticar(String login, String senha){
        String sql = "SELECT * FROM professores WHERE login = ? AND senha = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento"),
                        rs.getString("cpf"),
                        rs.getString("cidade"),
                        rs.getString("estado_civil"),
                        rs.getString("login"),
                        rs.getString("senha")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
        }

        return null;
    }

    public class Sessao {
        private static Professor professorLogado = null;

        public static void login(Professor professor){
            professorLogado = professor;
            System.out.println("Professor logado! " + professor.getNome());
        }

        public static void logout(){
            professorLogado = null;
            System.out.println("Logout realizado!");
        }

        public static boolean isLogado(){
            return professorLogado != null;
        }

        public static Professor getProfessorLogado(){
            return professorLogado;
        }
    }

}

