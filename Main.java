import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        Scanner scanner = new Scanner(System.in);
        
            System.out.println("Boas vindas a nossa Árvore Binária!!");
            String opcao = "10";
            int num;
        while (!opcao.equals("0")) {
            System.out.println("");
            System.out.println("O que deseja fazer?");
            System.out.println("Digite 1 para ver a Árvore Binária");
            System.out.println("Digite 2 para adicionar um valor a Árvore Binária");
            System.out.println("Digite 3 para remover um valor da Árvore Binária");
            System.out.println("Digite 0 para sair da aplicação");
            System.out.println("");
            opcao = scanner.nextLine();
            System.out.println("");
            switch (opcao) {
                case "1" -> {
                    if (arvoreBinaria.getRaiz() == null){
                        System.out.println("Ops, parece que não há nenhum valor na Árvore Binária ainda");
                        System.out.println("Tente adicionar um valor antes de tentar visualizar");
                    } else{
                        System.out.println("Aqui está sua Árvore Binária (pré-Ordem): ");
                        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                }
                }
                case "2" -> {
                    System.out.println("Qual valor você quer adiciona a árvore?");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    arvoreBinaria.inserir(num);
                    System.out.println("Valor adicionado");
                }
                case "3" -> {
                    System.out.println("Qual valor você quer remover da árvore?");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    arvoreBinaria.remover(num);
                }
                case "0" -> {
                    System.out.println("Até a próxima!!");
                    break;
                }
                default -> {
                System.out.println("Valor inválido. Tente novamente");
            }
            }
        } 
    }
}