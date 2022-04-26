public class Conta {
    private String numero;
    private double saldo;

    public Conta (String numero) {
        this.numero = numero;
        saldo = 0;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void creditar(double valor) {
        saldo += valor;
    }
    public boolean debitar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    public void listarDados() {
        System.out.println("Numero: " + numero);
        System.out.println("Saldo: " + saldo);
    }

    public boolean cadastrar(){
        return true;
    }
}
