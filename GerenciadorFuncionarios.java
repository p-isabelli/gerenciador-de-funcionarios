import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorFuncionarios {
    private ArrayList<Funcionario> listaDeFuncionarios;
    private ArrayList<Funcionario> ListaDeFuncionariosAtualizada;


    public GerenciadorFuncionarios() {
        listaDeFuncionarios = new ArrayList<Funcionario>();
    }

    public void executarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

       while (opcao != 5) {
            System.out.println("Selecione uma opção: ");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários cadastrados");
            System.out.println("3 - Remover funcionário");
            System.out.println("4 - Atualizar informações");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    removerFuncionario();
                    break;
                case 4:
                    atualizarInformacao();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("opção inválida");

            }
        }
    }

    public ArrayList<Funcionario> cadastrarFuncionario(){

        Funcionario novoFuncionario = new Funcionario(listaDeFuncionarios.size() + 1, lerNome(), lerCargo(), lerSalario());

        listaDeFuncionarios.add(novoFuncionario);

        System.out.println("Funcionário adicionado com sucesso!");

        return listaDeFuncionarios;

    }

    public String lerNome(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        return nome;

    }

    public String lerCargo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        return cargo;
    }

    public double lerSalario(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();

        return salario;
    }

    public void listarFuncionarios() {
        if (listaDeFuncionarios.size() == 0) {
            System.out.println("Não há funcionários cadastrados.");
            return;
        }

        for (Funcionario funcionario : listaDeFuncionarios) {
            System.out.println("ID: " + funcionario.getId());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("--------------------------");
        }
    }

    public void removerFuncionario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do funcionário que deseja remover: ");
        int id = scanner.nextInt();

        boolean funcionarioRemovido = false;

        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            Funcionario funcionario = listaDeFuncionarios.get(i);

            if (funcionario.getId() == id) {
                listaDeFuncionarios.remove(i);
                System.out.println("Funcionário removido com sucesso!");
                funcionarioRemovido = true;
                break;
            }
        }

        if (!funcionarioRemovido) {
            System.out.println("Não foi possível encontrar um funcionário com o ID informado.");
        }
    }

    public void atualizarInformacao(){
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while(opcao != 4){
            System.out.println("O que você gostaria de alterar? ");
            System.out.println("1 - Nome");
            System.out.println("2 - Cargo");
            System.out.println("3 - Salário");
            System.out.println("4 - Sair");
            opcao = scanner.nextInt();

           switch (opcao){
               case 1:
                   atualizarNome();
                   break;
               case 2:
                   atualizarCargo();
                   break;
               case 3:
                   atualizarSalario();
                   break;
               default:
                   System.out.println("opcão inválida");
           }
    }
}

    public void atualizarNome(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o índice do funcionário a ser atualizado: ");
        int indiceFuncionario = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo nome: ");
        String nomeAtualizado = scanner.nextLine();

        Funcionario funcionarioAtualizado = listaDeFuncionarios.get(indiceFuncionario);
        funcionarioAtualizado.setNome(nomeAtualizado);

        listaDeFuncionarios.set(indiceFuncionario, funcionarioAtualizado);

    }

    public void atualizarCargo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o índice do funcionário a ser atualizado: ");
        int indiceFuncionario = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo cargo: ");
        String cargoAtualizado = scanner.nextLine();

        Funcionario funcionarioAtualizado = listaDeFuncionarios.get(indiceFuncionario);
        funcionarioAtualizado.setCargo(cargoAtualizado);

        listaDeFuncionarios.set(indiceFuncionario, funcionarioAtualizado);

    }

    public void atualizarSalario(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("Digite o índice do funcionário a ser atualizado: ");
        int indiceFuncionario = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo salário: ");
        double salarioAtualizado = scanner.nextDouble();

        Funcionario funcionarioAtualizado = listaDeFuncionarios.get(indiceFuncionario);
        funcionarioAtualizado.setSalario(salarioAtualizado);

        listaDeFuncionarios.set(indiceFuncionario, funcionarioAtualizado);

    }
}