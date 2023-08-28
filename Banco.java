import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 500;
        double limiteChequeEspecial = 100;
        int opcao;
        boolean funcionamento = true;

        while(funcionamento){
            System.out.println("""
                    Qual ação deseja fazer?
                    1- Saque
                    2- Deposito
                    3- Ver saldo e limite cheque especial
                    4- sair
                    """);

            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                case 1:
                    System.out.println("Digite o valor do saque: ");
                    double saqueValor = sc.nextDouble();
                    sc.nextLine();
                    if (saqueValor <= saldo + limiteChequeEspecial){
                        if (saqueValor <= saldo){
                            saldo -= saqueValor;
                            System.out.println("Saque feito com sucesso.");
                        }else{
                            limiteChequeEspecial -= (saqueValor - saldo);
                            saldo = 0;
                            System.out.println("Saque feito utilizando cheque especial, Saldo R$" + saldo + ".");
                        }
                    } else {
                        System.out.println("Saldo insufuciente.");
                    }
                    System.out.println("Precione enter para continuar...");
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println("Digite o valor que deseja depositar:");
                    double depositoValor = sc.nextDouble();
                    sc.nextLine();
                    saldo += depositoValor;
                    System.out.println("Deposito feito com sucesso.");
                    System.out.println("Precione enter para continuar...");
                    sc.nextLine();
                    break;

                case 3:
                    System.out.println("Saldo: R$" + saldo + " Cheque Especial: R$" + limiteChequeEspecial);
                    System.out.println("Precione enter para continuar...");
                    sc.nextLine();
                    break;
                    
                case 4:
                    System.out.println("Até logo!!!");
                    funcionamento = false;
                    break;

                default:
                    System.out.println("opção inválida");
                    System.out.println("Precione enter para continuar...");
                    sc.nextLine();
                    break;
            }
        sc.close();
        }
    }
}

