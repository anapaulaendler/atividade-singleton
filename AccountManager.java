public class AccountManager {
    private static final int MAX_CONTAS = 10; // porque não quis usar listas
    private static final double SALDO_INICIAL = 1000.00;

    private static AccountManager instancia;

    private String[] contasIds;
    private double[] saldos;
    private int totalContasAtual;

    private AccountManager() {
        contasIds = new String[MAX_CONTAS];
        saldos = new double[MAX_CONTAS];
        totalContasAtual = 0;
    }

    public static AccountManager getInstancia() {
        if (instancia == null) {
            instancia = new AccountManager();
        }
        return instancia;
    }

    public void criarConta(String contaId) {
        if (buscarIndiceConta(contaId) == -1 && totalContasAtual < MAX_CONTAS) {
            contasIds[totalContasAtual] = contaId;
            saldos[totalContasAtual] = SALDO_INICIAL;
            totalContasAtual++;
        }
    }

    public String depositar(String contaId, double valor) {
        int indiceConta = buscarIndiceConta(contaId);
        if (indiceConta == -1) {
            return "Conta não encontrada.";
        }
        saldos[indiceConta] += valor;
        return "Depósito realizado. Saldo atual da conta " + contaId + ": R$ " + saldos[indiceConta];
    }

    public String sacar(String contaId, double valor) {
        int indiceConta = buscarIndiceConta(contaId);
        if (indiceConta == -1) {
            return "Conta não encontrada.";
        }
        if (saldos[indiceConta] < valor) {
            return "Saldo insuficiente.";
        }
        saldos[indiceConta] -= valor;
        return "Saque realizado. Saldo atual da conta " + contaId + ": R$ " + saldos[indiceConta];
    }

    public String verSaldo(String contaId) {
        int indiceConta = buscarIndiceConta(contaId);
        if (indiceConta == -1) {
            return "Conta não encontrada.";
        }
        return "Saldo da conta " + contaId + ": R$ " + saldos[indiceConta];
    }

    public String listarContasAtivas() {
        if (totalContasAtual == 0) {
            return "Nenhuma conta ativa.";
        }
        String listaDeContas = "";
        for (int i = 0; i < totalContasAtual; i++) {
            listaDeContas += contasIds[i];
            if (i < totalContasAtual - 1) {
                listaDeContas += ", ";
            }
        }
        return "Contas ativas: " + listaDeContas;
    }

    private int buscarIndiceConta(String contaId) {
        for (int i = 0; i < totalContasAtual; i++) {
            if (contasIds[i].equals(contaId)) {
                return i;
            }
        }
        return -1;
    }
}