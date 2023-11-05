import java.util.Scanner;
import java.util.Random;

// Essas duas bibliotecas quase sempre serão importadas juntas
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        try (Scanner scanner = new Scanner(System.in)) {

            // Caso o usuário responda "s", o jogo vai começar, caso o contrário o jogo não inicia
            System.out.println("Gostaria de Jogar um jogo de Pedra, Papel ou Tesoura? [S/N]");
            String resposta = scanner.nextLine().toLowerCase();
            
            if (resposta.equals("s")){

                List<String> escolhas = new ArrayList<>(); // Cria uma lista
                Random random = new Random(); // Cria um objeto de aleatoriedade

                escolhas.addAll(List.of("Pedra", "Papel", "Tesoura")); // Adicionou objetos na lista
                // Outra função seria .add("")

                // Pontuação
                int jogador1_pontos = 0;
                int jogador2_pontos = 0;

                while(true){ // Laço de repetição while

                    int escolha = random.nextInt(escolhas.size()); // Pega um número aleatório pelo tamanho da lista
                    String jogador2 = escolhas.get(escolha); // Pega o objeto dentro da lista com base no número aleatório

                    System.out.println("Digite \"Pedra\", \"Papel\" ou \"Tesoura\":");

                    String jogador1 = lerString(scanner).toLowerCase(); // Caso tenha algo de errado, irá acionar o catch

                    // Imprime o resultado dos jogadores. No caso do jogador1, irá imprimir formatando o texto, deixando a primeira letra em caixa alta
                    System.out.println("\nVocê escolheu " + (jogador1.substring(0, 1).toUpperCase() + jogador1.substring(1)));
                    System.out.println("Jogador 2 escolheu " + jogador2 + "\n");
                    
                    if (jogador1.equals("pedra")){ // Verifica se o jogador1 é igual à pedra
                        switch (jogador2){
                            case "Pedra":
                                System.out.println("Empate! Ninguém Pontuou!");
                                break;
                            case "Papel":
                                System.out.println("Jogador 2 ganhou! Ponto para Jogador 2!");
                                jogador2_pontos += 1;
                                break;
                            case "Tesoura":
                                System.out.println("Jogador 1 ganhou! Ponto para Jogador 1!");
                                jogador1_pontos += 1;
                                break;
                        }
                    } 
                    else if (jogador1.equals("papel")){
                        switch (jogador2){
                            case "Pedra":
                                System.out.println("Jogador 1 ganhou! Ponto para Jogador 1!");
                                jogador1_pontos += 1;
                                break;
                            case "Papel":
                                System.out.println("Empate! Ninguém Pontuou!");
                                break;
                            case "Tesoura":
                                System.out.println("Jogador 2 ganhou! Ponto para Jogador 2!");
                                jogador2_pontos += 1;
                                break;
                        }
                    } 
                    else if (jogador1.equals("tesoura")){
                        switch (jogador2){
                            case "Pedra":
                                System.out.println("Jogador 2 ganhou! Ponto para Jogador 2!");
                                jogador2_pontos += 1;
                                break;
                            case "Papel":
                                System.out.println("Jogador 1 ganhou! Ponto para Jogador 1!");
                                jogador1_pontos += 1;
                                break;
                            case "Tesoura":
                                System.out.println("Empate! Ninguém Pontuou!");
                                break;
                        }
                    } 
                    else{
                        System.out.println("Você precisa escolher entre Pedra, Papel ou Tesoura!");
                    }

                    // Verifica se o usuário gostaria de jogar de novo
                    System.out.println("\nGostaria de jogar de novo? [S/N]");
                    resposta = scanner.nextLine().toLowerCase();

                    if (!resposta.equals("s")){
                        System.out.println("Pontuação:");
                        System.out.println("Jogador 1: " + jogador1_pontos);
                        System.out.println("Jogador 2: " + jogador2_pontos);
                        System.out.println("\nObrigado por jogar!");
                        break;
                    }
                } 
            } 
            else{
                System.out.println("O jogo não será iniciado.");
            }
            scanner.close(); // Fecha o scanner
        }
        catch(EmptyStringException e){ // O catch será acionado caso encontre algo errado no código
            System.out.println(e.getMessage());
        }
    }

    // Função criada para ser usada no código e verificar possível erro que possa ocorrer
    public static String lerString(Scanner scanner) throws EmptyStringException{
        
        String texto = scanner.nextLine(); // Irá definir o valor que o usuário irá colocar no início da execução

        if (texto.isEmpty()) // Caso o usuário coloque um texto vazio, irá jogar uma exceção com uma mensagem
            throw new EmptyStringException("Erro: Não há nenhum digito");
        
        return texto; // Retorna o texto caso não entre na primeira condição
    }
}
