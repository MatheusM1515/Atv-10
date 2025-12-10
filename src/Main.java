import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProfessorDAO prof = new ProfessorDAO();

        System.out.println("=== LOGIN DO PROFESSOR ===");

        System.out.println("Login: ");
        String login = sc.nextLine();

        System.out.println("Senha: ");
        String senha = sc.nextLine();

        Professor professor = prof.autenticar(login, senha);

        if (professor == null) {
            System.out.println("\nErro: Login inválido. Encerrando programa...");
            return;
        }

        ProfessorDAO.Sessao.login(professor);
        System.out.println("\nBem-vindo," + professor.getNome() + "!");
        System.out.println();


        int opcao = 0;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Listar Professor");
            System.out.println("3 - Atualizar Professor");
            System.out.println("4 - Deletar Professor");
            System.out.println("0 - Sair");
            System.out.println("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("=== CADASTRO DE PROFESSOR ===");
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

                    System.out.println("Login: ");
                    String loginNovo = sc.nextLine();

                    System.out.println("Senha: ");
                    String senhaNova = sc.nextLine();

                    Professor novo = new Professor(nome, email, dataNascimentoSQL, cpf, cidade, estadoCivil, loginNovo, senhaNova);
                    prof.inserir(novo);
                    break;
                case 2:
                    System.out.println("\n=== LISTA DE PROFESSORES ===");
                    for (Professor p : prof.listar()) {
                        System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getEmail());
                    }
                    break;
                case 3:
                    System.out.println("\n=== ATUALIZAR PROFESSOR ===");
                    System.out.print("Digite o ID do profesor que deseja atualizar: ");
                    int idA = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite o nome do professor: ");
                    String nomeA = sc.nextLine();

                    System.out.print("Digite o email do professor: ");
                    String emailA = sc.nextLine();

                    System.out.print("Nova data de nascimento (dd/mm/aaaa): ");
                    String dataNascA = sc.nextLine();
                    LocalDate dataLocalA = LocalDate.parse(dataNascA, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    java.sql.Date dataSQLA = java.sql.Date.valueOf(dataLocalA);


                    System.out.print("CPF: ");
                    String cpfA = sc.nextLine();

                    System.out.print("Estado civil: ");
                    String estadoCivilA = sc.nextLine();

                    System.out.println("Cidade em que o professor mora: ");
                    String cidadeA = sc.nextLine();

                    Professor atualizado = new Professor(idA, nomeA, emailA, dataSQLA, cpfA, cidadeA, estadoCivilA, null, null);
                    prof.atualizar(atualizado);
                    break;
                case 4:
                    System.out.println("\n=== DELETAR PROFESSOR ===");
                    System.out.print("Digite o ID do professor que deseja deletar: ");
                    int idDelete = sc.nextInt();

                    prof.deletar(idDelete);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opcao != 0);

        sc. close();
    }
}

