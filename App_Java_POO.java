import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Animal {
    private String nome;
    private String raca;
    private int idade;

    public Animal() {
    }

    public Animal(String nome, String raca, int idade) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

class Cliente implements Comparable<Cliente> {
    private String nome;
    private String cpf;
    private String telefone;
    private Animal animal;


    public Cliente() {
    }

    public Cliente(String nome, String cpf, String telefone, Animal animal) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.animal = animal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Animal: " + animal.getNome());
        System.out.println("Raça: " + animal.getRaca());
        System.out.println("Idade: " + animal.getIdade());
    }

    @Override
    public int compareTo(Cliente outroCliente) {
        return this.nome.compareToIgnoreCase(outroCliente.getNome());
    }
}

class Agendamento {
    private String cliente;
    private String servico;
    private double preco;
    private String horario;

    public Agendamento() {
    }

    public Agendamento(String cliente, String servico, double preco, String horario) {
        this.cliente = cliente;
        this.servico = servico;
        this.preco = preco;
        this.horario = horario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Agendamento [cliente=" + cliente + ", servico=" + servico + ", preco=" + preco + ", horario=" + horario + "]";
    }
}

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Agendamento> agendamentos = new ArrayList<>();

        try {
            while (true) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Cadastrar Cliente");
                System.out.println("2. Cadastrar Agendamento");
                System.out.println("3. Exibir Informações de Clientes");
                System.out.println("4. Exibir Agendamentos");
                System.out.println("5. Sair");

                int opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        Cliente cliente = new Cliente();
                        System.out.print("Nome do Cliente: ");
                        cliente.setNome(ler.nextLine());
                        System.out.print("CPF: ");
                        cliente.setCpf(ler.nextLine());
                        System.out.print("Telefone: ");
                        cliente.setTelefone(ler.nextLine());

                        Animal animal = new Animal();
                        System.out.print("Nome do Animal: ");
                        animal.setNome(ler.nextLine());
                        System.out.print("Raça: ");
                        animal.setRaca(ler.nextLine());
                        System.out.print("Idade: ");
                        animal.setIdade(ler.nextInt());
                        cliente.setAnimal(animal);
                        clientes.add(cliente);
                        break;

                    case 2:
                        Agendamento agendamento = new Agendamento();
                        System.out.print("Nome do Cliente: ");
                        agendamento.setCliente(ler.nextLine());
                        System.out.print("Serviço: ");
                        agendamento.setServico(ler.nextLine());
                        System.out.print("Preço: ");
                        agendamento.setPreco(ler.nextDouble());
                        ler.nextLine();
                        System.out.print("Horário: ");
                        agendamento.setHorario(ler.nextLine());
                        agendamentos.add(agendamento);
                        break;

                    case 3:

                        Collections.sort(clientes);

                        for (Cliente c : clientes) {
                            c.exibirInformacoes();
                        }
                        break;

                    case 4:
                        for (Agendamento a : agendamentos) {
                            System.out.println(a);
                        }
                        break;

                    case 5:
                        System.out.println("Saindo do programa.");
                        return;
                }
            }
        } finally {
            ler.close();
        }
    }
}
