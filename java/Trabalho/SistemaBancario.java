//import com.google.gson.Gson;

public class SistemaBancario {

    private static final String BEM_VINDO = "\nBem vindo ao sistema bancario (digite opção pretendida)";
    
    public static void main(String args[]){
        boolean inicio = true;
        Banco banco = new Banco(10);
        Conta conta = null;
        Cliente cliente = null;
        
        while(true){
            if(inicio){
                System.out.println(BEM_VINDO);
                System.out.println("1 > para criar/selecionar uma conta");
                System.out.println("2 > para procurar uma conta");
                System.out.println("3 > para creditar uma conta");
                System.out.println("4 > para debitar uma conta");
                System.out.println("5 > para saldo de uma conta");
                System.out.println("6 > para listar as contas");
                System.out.println("7 > para sair");
                System.out.println();
                inicio = false;
            }
            int opcao = Integer.parseInt(System.console().readLine());
            
            // opcoes do menu
            if(opcao == 1){  // criar/selecionar conta
                System.out.print("| Digite o numero da conta: ");
                String numero = System.console().readLine();
                // if(numero.equals("")){
                //     System.out.println("| Numero da conta nao pode ser vazio");
                //     continue;
                // }
                if(banco.getConta(numero) == null){
                    conta = new Conta(numero);
                    if(banco.cadastrar(conta)){
                        // cadastrar cliente
                        System.out.print("| Digite o nome do cliente: ");
                        String nome = System.console().readLine();
                        System.out.print("| Digite o cpf do cliente: ");
                        String cpf = System.console().readLine();
                        System.out.print("| Digite o telefone do cliente: ");
                        String telefone = System.console().readLine();
                        cliente = new Cliente(nome, cpf, telefone);
                        if(banco.cadastrar(cliente)){
                            System.out.println("| Conta criada com sucesso!");
                        } else {
                            System.out.println("| Erro ao cadastrar cliente!");
                        }
                    } else {
                        System.out.println("| Não foi possivel criar a conta!");
                    }
                } else {
                    conta = banco.getConta(numero);
                    cliente = banco.getCliente(conta.getNumero());
                    System.out.println("| Selecionando conta existente! (" + conta.getNumero() + ")");
                }
            }
            else if(opcao == 2){ // procurar conta
                //System.out.print("| Digite o numero da conta (" + conta.getNumero() + "): ");
                //String numero = System.console().readLine();
                //if(numero.equals("")) numero = conta.getNumero();
                //conta = banco.getConta(numero);
                conta = banco.getConta(conta.getNumero());
                System.out.println("| Conta selecionada! (" + conta.getNumero() + ")");
                if(conta != null){
                    conta.listarDados();
                    //System.out.println("| Saldo: " + conta.getSaldo());
                } else {
                    System.out.println("| Conta nao encontrada");
                }
            }
            else if(opcao == 3){ // creditar em conta
                //System.out.print("| Digite o numero da conta: (" + conta.getNumero() + "): ");
                //String numero = System.console().readLine();
                //if(numero.equals("")) numero = conta.getNumero();
                conta = banco.getConta(conta.getNumero());
                System.out.println("| Conta selecionada! (" + conta.getNumero() + ")"); 
                System.out.print("| Digite o valor a ser creditado: ");
                double valor = Double.parseDouble(System.console().readLine());
                banco.creditar(conta.getNumero(), valor);
            }
            else if(opcao == 4){ // debitar em conta
                //System.out.print("| Digite o numero da conta: (" + conta.getNumero() + "): ");
                //String numero = System.console().readLine();
                //if(numero.equals("")) numero = conta.getNumero();
                conta = banco.getConta(conta.getNumero());
                System.out.println("| Conta selecionada! (" + conta.getNumero() + ")");
                System.out.print("| Digite o valor a ser debitado: ");
                double valor = Double.parseDouble(System.console().readLine());
                if(banco.debitar(conta.getNumero(), valor)){ 
                    System.out.println("| Debito realizado com sucesso!");
                } else {
                    System.out.println("| Não foi possivel debitar!"); 
                }  
            }
            else if(opcao == 5){ // saldo de conta
                //System.out.print("| Digite o numero da conta: (" + conta.getNumero() + "): ");
                //String numero = System.console().readLine();
                //if(numero.equals("")) numero = conta.getNumero();
                //conta = banco.getConta(numero);
                conta = banco.getConta(conta.getNumero());
                System.out.println("| Conta selecionada! (" + conta.getNumero() + ")");
                if(conta != null){
                    System.out.println("| Saldo: " + conta.getSaldo());
                }
                else{
                    System.out.println("| Conta nao encontrada");
                }
            }else if(opcao == 6){ // listar contas
                System.out.println("| Listando Contas");
                System.out.println("numero\tsaldo\tnome\tcpf\ttelefone");
                banco.listarDados();
            }
            else if(opcao == 7){
                break;
            }
            else{
                System.out.println("| Opcao invalida");
                inicio = true;
            }
            // System.out.println();
        }
    }  
}
