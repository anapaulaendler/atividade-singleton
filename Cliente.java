public class Cliente {
    private String contaId;
    private String nome;

    public Cliente(String contaId, String nome) {
        this.contaId = contaId;
        this.nome = nome;
        AccountManager.getInstancia().criarConta(contaId);
    }

    public void depositar(double valor) {
        String resultado = AccountManager.getInstancia().depositar(contaId, valor);
        System.out.println(nome + ": " + resultado);
    }

    public void sacar(double valor) {
        String resultado = AccountManager.getInstancia().sacar(contaId, valor);
        System.out.println(nome + ": " + resultado);
    }

    public void verSaldo() {
        String resultado = AccountManager.getInstancia().verSaldo(contaId);
        System.out.println(nome + ": " + resultado);
    }
}