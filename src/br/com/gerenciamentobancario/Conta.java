package br.com.gerenciamentobancario;

public class Conta {
    private Cliente cliente;
    private int numero;
    private int agencia;
    private double saldo;

    public Conta(Cliente cliente, int numero, int agencia, double saldo) {
        setCliente(cliente);
        setNumero(numero);
        setAgencia(agencia);
        setSaldo(saldo);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo!");
        }
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número da conta inválido!");
        }
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        if (agencia <= 0) {
            throw new IllegalArgumentException("Agência inválida!");
        }
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo não pode ser negativo!");
        }
        this.saldo = saldo;
    }


    //                 DEPÓSITO
    public boolean depositar(double valor) {
        if (valor <= 0) return false;

        this.saldo += valor;

        System.out.println("\n💰 DEPÓSITO REALIZADO");
        System.out.println("→ Titular: " + cliente.getNome());
        System.out.println("→ Conta: " + numero + " (Ag " + agencia + ")");
        System.out.println("→ Valor depositado: R$ " + valor);
        System.out.println("→ Saldo atual: R$ " + saldo);

        return true;
    }

    //      SAQUE

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) return false;

        this.saldo -= valor;

        System.out.println("\n💸 SAQUE REALIZADO");
        System.out.println("→ Titular: " + cliente.getNome());
        System.out.println("→ Conta: " + numero + " (Ag " + agencia + ")");
        System.out.println("→ Valor sacado: R$ " + valor);
        System.out.println("→ Saldo atual: R$ " + saldo);

        return true;
    }
}
