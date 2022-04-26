public class Banco {
    public Conta[] contas;
    public Cliente[] clientes;
    public int indice = 0;
    public int idxCurr = 0;

    public Banco(int tamanho) {
        contas = new Conta[tamanho];
        clientes = new Cliente[tamanho];
    }

    public boolean cadastrar(Conta conta) {
        if(indice < contas.length){
            contas[indice] = conta;
            return true;
        } 
        return false;
    }
    public boolean cadastrar(Cliente cliente) {
        if(indice < clientes.length){
            clientes[indice] = cliente;
            indice++;
            return true;
        } 
        return false;
    }

    public boolean cadastrar(Conta conta, Cliente cliente) {
        if(indice < contas.length){
            if(cadastrar(conta)){
                if(cadastrar(cliente)){
                    indice++;
                    return true;
                }
                remover(conta);
            }
        } 
        return false;
    }

    public Cliente getCliente() {
        return clientes[idxCurr];
    }

    public Cliente getCliente(String cpf) {
        for(int i = 0; i < indice; i++){
            if(clientes[i].getCpf().equals(cpf)){
                idxCurr = i;
                return clientes[i];
            }
        }
        return null;
    }

    public Conta getConta() {
        return contas[idxCurr];
    }
    
    public Conta getConta(String numero) {
        for(int i = 0; i < indice; i++){
            if(contas[i].getNumero().equals(numero)){
                idxCurr = i;
                return contas[i];
            }
        }
        return null;
    }

    public boolean remover(Conta conta) {
        for(int i = 0; i < indice; i++){
            if(contas[i].getNumero().equals(conta.getNumero())){
                contas[i] = null;
                clientes[i] = null;
                return true;
            }
        }
        return false;
    }

    public void creditar(String numero, double valor){
        Conta conta = this.getConta(numero);
        if(conta != null){
            conta.creditar(valor);
        }
    }

    public boolean debitar(String numero, double valor){
        Conta conta = this.getConta(numero);
        if(conta != null && conta.getSaldo() >= valor){
            conta.debitar(valor);
            return true;
        }
        return false;
    }

    public void listarDados(String numero){
        Conta conta = this.getConta(numero);
        Cliente cliente = this.getCliente(conta.getNumero());
        if(conta != null){
             conta.listarDados();
             cliente.listarDados();
        }
    }

    public void listarDados(){
        for(int i = 0; i < indice; i++){
            if(contas[i] != null){
                System.out.println( contas[i].getNumero()+"\t"+
                                    contas[i].getSaldo()+"\t"+
                                    clientes[i].getNome()+"\t"+
                                    clientes[i].getCpf()+"\t"+
                                    clientes[i].getTelefone());
            }
        }
    }

}
