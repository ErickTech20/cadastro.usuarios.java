import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCadastro {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> listarUsuarios();
                case 3 -> editarUsuario();
                case 4 -> excluirUsuario();
                case 5 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE CADASTRO ===");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Listar Usuários");
        System.out.println("3. Editar Usuário");
        System.out.println("4. Excluir Usuário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarUsuario() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nextId++, nome, email);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("\n--- LISTA DE USUÁRIOS ---");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    private static void editarUsuario() {
        listarUsuarios();
        if (usuarios.isEmpty()) return;

        System.out.print("Digite o ID do usuário para editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                System.out.print("Novo nome: ");
                usuario.setNome(scanner.nextLine());
                System.out.print("Novo email: ");
                usuario.setEmail(scanner.nextLine());
                System.out.println("Usuário atualizado!");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    private static void excluirUsuario() {
        listarUsuarios();
        if (usuarios.isEmpty()) return;

        System.out.print("Digite o ID do usuário para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        usuarios.removeIf(usuario -> usuario.getId() == id);
        System.out.println("Usuário removido!");
    }
}