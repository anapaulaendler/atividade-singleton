public class Main {
    public static void main(String[] args) {
        final String DIVISOR = "-----------------------------------";

        // ... referência aos aniversários kkkkk
        Cliente clienteAna = new Cliente("1904", "Ana");
        Cliente clienteCaue = new Cliente("0509", "Caue");
        Cliente clientePedro = new Cliente("0111", "Pedro");

        System.out.println("Operações Ana:");
        clienteAna.depositar(500);
        clienteAna.sacar(200);
        clienteAna.verSaldo();

        System.out.println(DIVISOR);

        System.out.println("Operações Cauê:");
        clienteCaue.depositar(1000);
        clienteCaue.sacar(2000);
        clienteCaue.verSaldo();

        System.out.println(DIVISOR);

        System.out.println("Operações Pedro:");
        clientePedro.depositar(200);
        clientePedro.sacar(500);
        clientePedro.verSaldo();

        System.out.println(DIVISOR);

        AccountManager gerenciador = AccountManager.getInstancia();
        AccountManager gerenciadorValidacao = AccountManager.getInstancia();

        System.out.println(gerenciador.listarContasAtivas());
        System.out.println(DIVISOR);
        System.out.println("Validação SIngleton: é a mesma instância? " + (gerenciador == gerenciadorValidacao));
    }
}