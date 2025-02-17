import java.util.Scanner;

//Obejto da conta Bancária
public class BankAccount {

    //atributos
    private String titular;
    private double saldo;
    private int taxaJuros;

    //Construtor
    public BankAccount(String titular, double saldo, int taxaJuros) {
        this.titular = titular;
        this.saldo = saldo;
        this.taxaJuros = taxaJuros;
    }

    //Getters e Setters
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public int getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(int taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    //Métodos
    public void verDetalhes() {
        System.out.println("Conta: " + titular + " " + saldo + " " + taxaJuros);
    }

    public static double depositar(Scanner scanner) {
        double valor;
        System.out.print("Insira um valor ao depósito: ");
        valor = scanner.nextDouble();

        return valor;
    }

    public static double retirar(Scanner scanner) {
        double valor;
        System.out.print("Insira o valor a ser retirado: ");
        valor = scanner.nextDouble();

        return valor;
    }

    public static double simular(Scanner scanner, double saldo, int taxa, int anos) {
        double valor;
        System.out.println("Insira o número de anos para simulação: ");
        anos = scanner.nextInt();

        valor = saldo * Math.pow(1 + ((double) taxa /100),anos);

        return valor;
    }

    //SetOver
    public static boolean setOver(double saldo, double valor) {
        boolean verificar;
        if ((saldo - valor) >= 0) {
            verificar = true;
        } else {
            verificar = false;
        }
        return verificar;
    }

    //Metodo Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao, taxa, anos = 0;
        double saldo, valor;
        String nome;

        //Iniciando a conta
        System.out.print("Digite o nome do titular: ");
        nome = scanner.nextLine();

        System.out.print("" +
                "Insira o saldo inicial: ");
        saldo = scanner.nextDouble();

        System.out.print("" +
                "Insira a taxa de juros anual (%): ");
        taxa = scanner.nextInt();

        //Criando a conta
        BankAccount conta = new BankAccount(nome,saldo,taxa);

        do {
            //Menu
            System.out.println("""
                    
                    Menu Conta Bancária:
                    
                    1 - Depósito 💰
                    2 - Retirar 🏧
                    3 - Ver Saldo Atual 👀
                    4 - Simule o Saldo Futuro 🔮
                    5 - Sair 🚪
                    
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    valor = depositar(scanner);
                    conta.setSaldo(conta.getSaldo() + valor);
                    System.out.println("Depósito de R$" + valor + " feito com sucesso");
                    break;
                case 2:
                     valor = retirar(scanner);

                     if (setOver(conta.getSaldo(), valor)) {
                         conta.setSaldo(conta.getSaldo() - valor);
                     } else {
                         System.out.println("Ação negada,o valor R$" + valor + ", é maior do que pode ser retirado do seu saldo atual");
                     }
                    break;
                case 3:
                    System.out.println("Saldo atual: R$" + conta.getSaldo());
                    break;
                case 4:
                     valor = simular(scanner, conta.getSaldo(), conta.getTaxaJuros(), anos);
                    System.out.println("O saldo futuro após " + anos + " anos será: R$" + valor + " \uD83D\uDCB0");
                    break;
                case 5:
                    System.out.println("Obrigado por usar o sistema bancário! \uD83D\uDE4F");
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while (opcao != 5);
    }
}
