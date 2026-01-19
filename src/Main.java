
import br.com.gerenciamentobancario.Banco;
import br.com.gerenciamentobancario.Cliente;
import br.com.gerenciamentobancario.Conta;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();
        // CADASTRO DE CLIENTES

        System.out.println("\n========== CADASTRANDO CLIENTES ==========");
        Cliente cliente1 = new Cliente("Anderson", "98542131237", "98 99968-5478", "andderson@gmail.com");
        Cliente cliente2 = new Cliente("Maria", "74569871456", "98 98288-6755", "maria@gmail.com");

        banco.cadastrarCliente(cliente1);
        banco.cadastrarCliente(cliente2);

        // CADASTRO DE CONTAS

        System.out.println("\n========== CADASTRANDO CONTAS ==========");
        Conta conta1 = new Conta(cliente1, 1001, 1, 700.0);
        Conta conta2 = new Conta(cliente2, 2001, 2, 300.0);

        banco.cadastrarConta(conta1);
        banco.cadastrarConta(conta2);

        //Bucar Cliente & Conta
        banco.buscarCliente("98542131237");
        banco.buscarConta(1001,1);

        // SALDOS INICIAIS

        System.out.println("\n================================");
        System.out.println("          SALDOS INICIAIS       ");
        System.out.println("================================");
        System.out.printf("Conta 1 | Agência 1 | Saldo: R$ %.2f%n", conta1.getSaldo());
        System.out.printf("Conta 2 | Agência 2 | Saldo: R$ %.2f%n", conta2.getSaldo());


        // DEPÓSITO

        System.out.println("\n========== OPERANDO DEPÓSITO ==========");
        System.out.println("Depositando R$ 223,00 na conta1...");
        conta1.depositar(223.00);

        // SAQUE

        System.out.println("\n========== OPERANDO SAQUE ==========");
        System.out.println("Sacando R$ 150,00 da conta2...");
        conta2.sacar(150.00);


        // TRANSFERÊNCIA

        System.out.println("\n========== OPERANDO TRANSFERÊNCIA ==========");
        System.out.println("Transferindo R$ 150,00 da conta1 → conta2...");
        banco.transferir(1001, 1, 2001, 2, 150);

        // SALDOS FINAIS

        System.out.println("\n================================");
        System.out.println("           SALDOS FINAIS        ");
        System.out.println("================================");
        System.out.printf("Conta 1 | Agência 1 | Saldo: R$ %.2f%n", conta1.getSaldo());
        System.out.printf("Conta 2 | Agência 2 | Saldo: R$ %.2f%n", conta2.getSaldo());
    }


}
