import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Jogo de dados (Use Ctrl+C para fechar)");
        while (true) {
            System.out.print("Número de jogadores: ");
            int playersN = 0;
            try {
                playersN = scan.nextInt();
            } catch (NoSuchElementException e) {
                scan.close();
                System.exit(0);
            }
            if (playersN < 1 || playersN > 10) {
                System.out.println("O número precisa ser entre 1 e 10!");
                continue;
            }
            int players[] = new int[playersN];
            for (int i = 0; i < playersN; i++) {
                System.out.print("Jogador " + (i + 1) + ", informe sua aposta: ");
                int bet = 0;
                try {
                    bet = scan.nextInt();
                } catch (NoSuchElementException e) {
                    scan.close();
                    System.exit(0);
                }
                if (bet < 2 || bet > 12) {
                    System.out.println("O número precisa ser entre 2 e 12!");
                    i--;
                    continue;
                }
                for (int betX : players) {
                    if (betX == bet) {
                        System.out.println("Um jogador já escolheu esse valor!");
                        i--;
                        continue;
                    }
                }
                players[i] = bet;
            }
            int diceA = rand.nextInt(6) + 1, diceB = rand.nextInt(6) + 1;
            System.out.print("Resultado: " + diceA + " + " + diceB + " = " + (diceA + diceB) + ", ");
            for (int i = 0; i <= playersN; i++) {
                if (i == playersN) {
                    System.out.println("o computador ganhou!");
                } else if (diceA + diceB == players[i]) {
                    System.out.println("o jogador " + (i + 1) + " ganhou!");
                    break;
                }
            }
        }
    }
}
