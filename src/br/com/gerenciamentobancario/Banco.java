package br.com.gerenciamentobancario;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    //OS EMOTIS E SÓ PRA MELHORAR A LEITURA NA SAIDA DE DADOS...
    private List<Cliente> clientes;
    private List<Conta> contas;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Conta> getContas() {
        return contas;
    }


    //      CADASTRAR CLIENTE
    public void cadastrarCliente(Cliente novoCliente) {

        for (Cliente c : clientes) {
            if (c.getCpf().equals(novoCliente.getCpf())) {
                System.out.println("\n⚠️ Já existe um cliente com o CPF: " + novoCliente.getCpf());
                return;
            }
        }

        clientes.add(novoCliente);

        System.out.println("\n✅ Cliente cadastrado com sucesso!");
        System.out.println("→ Nome: " + novoCliente.getNome());
        System.out.println("→ CPF: " + novoCliente.getCpf());
    }

    //      CADASTRAR CONTA
    public void cadastrarConta(Conta conta) {

        if (conta == null) {
            System.out.println("❌ Conta inválida! Não foi possível cadastrar.");
            return;
        }

        contas.add(conta);

        System.out.println("\n✅ Conta criada com sucesso!");
        System.out.println("→ Nº da Conta: " + conta.getNumero());
        System.out.println("→ Agência: " + conta.getAgencia());
        System.out.println("→ Titular: " + conta.getCliente().getNome());
        System.out.println("→ Saldo inicial: R$ " + conta.getSaldo());
    }

    //      BUSCAR CLIENTE
    public Cliente buscarCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("\n🔎 Cliente encontrado:");
                System.out.println("→ Nome: " + c.getNome());
                System.out.println("→ CPF: " + c.getCpf());
                return c;
            }
        }
        return null;
    }

    //      BUSCAR CONTA
    public Conta buscarConta(int numero, int agencia) {
        for (Conta c : contas) {
            if (c.getNumero() == numero && c.getAgencia() == agencia) {
                System.out.println("\n🔎 Conta encontrada:");
                System.out.println("→ Nº da Conta: " + c.getNumero());
                System.out.println("→ Agência: " + c.getAgencia());
                System.out.println("→ Titular: " + c.getCliente().getNome());
                System.out.println("→ Saldo: R$ " + c.getSaldo());
                return c;
            }
        }
        return null;
    }

    //          TRANSFERÊNCIA
    public void transferir(int numeroOrigem, int agenciaOrigem,
                           int numeroDestino, int agenciaDestino, double valor) {

        Conta origem = buscarConta(numeroOrigem, agenciaOrigem);
        Conta destino = buscarConta(numeroDestino, agenciaDestino);

        if (origem == null || destino == null) {
            System.out.println("\n❌ ERRO: Conta de origem ou destino não encontrada.");
            return;
        }

        System.out.println("\n========= INICIANDO TRANSFERÊNCIA =========");
        System.out.println("Valor: R$ " + valor);
        System.out.println("De: Conta " + origem.getNumero() + " (Ag " + origem.getAgencia() + ") - " + origem.getCliente().getNome());
        System.out.println("Para: Conta " + destino.getNumero() + " (Ag " + destino.getAgencia() + ") - " + destino.getCliente().getNome());

        if (origem.sacar(valor)) {

            destino.depositar(valor);

            System.out.println("\n💰 Transferência concluída com sucesso!");
            System.out.println("→ Novo saldo da conta origem: R$ " + origem.getSaldo());
            System.out.println("→ Novo saldo da conta destino: R$ " + destino.getSaldo());

        } else {
            System.out.println("\n❌ Saldo insuficiente para realizar a transferência.");
        }
    }
}
