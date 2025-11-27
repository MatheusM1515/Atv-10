import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProfessorDAO prof = new ProfessorDAO();

        System.out.println("=== CADASTRO DE PROFESSOR ===");

        // --- 1. Operação CREATE (Criação) ---
        System.out.print("Digite o nome do professor: ");
        String nome = sc.nextLine();

        System.out.print("Digite o email do professor: ");
        String email = sc.nextLine();

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimentoLocal = LocalDate.parse(dataNascimento, formatter);
        java.sql.Date dataNascimentoSQL = java.sql.Date.valueOf(dataNascimentoLocal);


        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Estado civil: ");
        String estadoCivil = sc.nextLine();

        System.out.println("Cidade em que o professor mora: ");
        String cidade = sc.nextLine();


        Professor novo = new Professor(nome, email,dataNascimentoSQL,cpf, cidade,estadoCivil);
        prof.inserir(novo);

        // --- 2. Operação READ (Leitura/Listagem) ---
        System.out.println("\n--- LISTA DE PROFESSORES ---");
        for (Professor a : prof.listar()) {
            System.out.println(a.getId() + " - " + a.getNome() + " - " + a.getEmail() + " - "+ a.getData_nascimento() + " - "+ a.getCpf() + " - "+ a.getCidade() + " - " + a.getEstado_civil() );
        }

        // --- 3. Operação UPDATE (Atualização) ---
        System.out.println("\n=== ATUALIZAR UM PROFESSOR ===");
        System.out.print("Digite o ID do profesor que deseja atualizar: ");
        int idA = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o nome do professor: ");
        String nomeA = sc.nextLine();

        System.out.print("Digite o email do professor: ");
        String emailA = sc.nextLine();

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        String dataNascimentoA = sc.nextLine();
        DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimentoLocalA = LocalDate.parse(dataNascimento, formatterA);
        java.sql.Date dataNascimentoSQLA = java.sql.Date.valueOf(dataNascimentoLocal);


        System.out.print("CPF: ");
        String cpfA = sc.nextLine();

        System.out.print("Estado civil: ");
        String estadoCivilA = sc.nextLine();

        System.out.println("Cidade em que o professor mora: ");
        String cidadeA = sc.nextLine();


        Professor atualizado = new Professor(idA, nomeA, emailA,dataNascimentoSQLA,cpfA,cidadeA,estadoCivilA);
        prof.atualizar(atualizado);

        // --- 4. Operação DELETE (Exclusão) ---
        System.out.println("\n=== DELETAR UM PROFESSOR ===");
        System.out.print("Digite o ID do professor que deseja deletar: ");
        int idDelete = sc.nextInt();

        prof.deletar(idDelete);

        sc.close();
    }
}