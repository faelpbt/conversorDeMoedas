import java.util.Scanner;

public class Menu {
    private Scanner escreva = new Scanner(System.in);
    private ConexaoApi conecta = new ConexaoApi();
    private double amount;
    private MoedaConvertida moedaConvertida;
    private MoedaApi moedaApi;
    private int opcao = 0;

    public Menu() {
        while (opcao != 7) {
            System.out.println("**************************************************");
            System.out.println("Seja bem vindo ao conversor de moeda!");
            System.out.println("1 - Dólar para Peso Argentino");
            System.out.println("2 - Peso Argentino para Dólar");
            System.out.println("3 - Real Brasileiro para Dólar");
            System.out.println("4 - Dólar para Real Brasileiro");
            System.out.println("5 - Dólar para Peso Colombiano");
            System.out.println("6 - Peso Colombiano para Dólar");
            System.out.println("7 - Para encerrar");
            System.out.println("**************************************************");
            System.out.println();
            System.out.println("Escolha uma opção: ");

            opcao = escreva.nextInt();
            escreva.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor que deseja converter: ");
                    amount = escreva.nextDouble();
                    escreva.nextLine();
                    moedaApi = conecta.conecta("USD");
                    moedaConvertida = new MoedaConvertida(moedaApi, amount, "ARS");
                    System.out.println(moedaConvertida.getConverte());
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja converter: ");
                    amount = escreva.nextDouble();
                    escreva.nextLine();
                    moedaApi = conecta.conecta("ARS");
                    moedaConvertida = new MoedaConvertida(moedaApi, amount, "USD");
                    System.out.println(moedaConvertida.getConverte());
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja converter: ");
                    amount = escreva.nextDouble();
                    escreva.nextLine();
                    moedaApi = conecta.conecta("BRL");
                    moedaConvertida = new MoedaConvertida(moedaApi, amount, "USD");
                    System.out.println(moedaConvertida.getConverte());
                    break;
                case 4:
                    System.out.println("Digite o valor que deseja converter: ");
                    amount = escreva.nextDouble();
                    escreva.nextLine();
                    moedaApi = conecta.conecta("USD");
                    moedaConvertida = new MoedaConvertida(moedaApi, amount, "BRL");
                    System.out.println(moedaConvertida.getConverte());
                    break;
                case 5:
                    System.out.println("Digite o valor que deseja converter: ");
                    amount = escreva.nextDouble();
                    escreva.nextLine();
                    moedaApi = conecta.conecta("USD");
                    moedaConvertida = new MoedaConvertida(moedaApi, amount, "COP");
                    System.out.println(moedaConvertida.getConverte());
                    break;
                case 6:
                    System.out.println("Digite o valor que deseja converter: ");
                    amount = escreva.nextDouble();
                    escreva.nextLine();
                    moedaApi = conecta.conecta("COP");
                    moedaConvertida = new MoedaConvertida(moedaApi, amount, "USD");
                    System.out.println(moedaConvertida.getConverte());
                    break;
                case 7:
                    System.out.println("Aplicativo encerrado");
            }

            if(opcao == 7) {
                break;
            }
        }
    }
}
