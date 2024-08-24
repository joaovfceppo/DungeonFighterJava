package dungeonfighterjava;

import java.util.Random;
import javax.swing.*;

public class DungeonFighterJava {

    private static final int linhas = 5;
    private static final int colunas = 10;
    private static final int numeroMonstros = linhas - 1;
    private static final int numeroPerdaFixa = 5;
    private static final int numeroPerdaAleatoria = 5;

    public static void main(String[] args) {
        // Para poder rodar direto o tabuleiro
        
        Heroi heroi = new Barbaro(); // Pode ser alterado conforme necessário
        iniciarJogo(heroi);
    }

    public static void iniciarJogo(Heroi heroi) {
        Random geradorAleatorio = new Random();
        Tabuleiro t1 = new Tabuleiro(linhas, colunas);

        // Adiciona o herói no tabuleiro
        t1.adicionarPersonagem(heroi, 0, geradorAleatorio.nextInt(9));

        Chefao c1 = new Chefao();
        t1.adicionarPersonagem(c1, linhas - 1, geradorAleatorio.nextInt(9));

        // posiciona Monstros Menores
        MonstroMenor[] m = new MonstroMenor[numeroMonstros];
        for (int count = 0; count < numeroMonstros; count++) {
            int i = geradorAleatorio.nextInt(5);
            int j = geradorAleatorio.nextInt(9);

            if (t1.getCelula(i, j).getPersonagem() == null) {
                m[count] = new MonstroMenor();
                t1.adicionarPersonagem(m[count], i, j);
            } else {
                count--;
            }
        }

        // posiciona Armadilhas de Perda Fixa
        ArmadilhaPerdaFixa[] pf = new ArmadilhaPerdaFixa[numeroPerdaFixa];
        for (int count = 0; count < numeroPerdaFixa; count++) {
            int i = geradorAleatorio.nextInt(5);
            int j = geradorAleatorio.nextInt(9);
            if ((t1.getCelula(i, j).getPersonagem() == null) && (t1.getCelula(i, j).getArmadilha() == null)) {
                pf[count] = new ArmadilhaPerdaFixa();
                t1.adicionarArmadilha(pf[count], i, j);
            } else {
                count--;
            }
        }

        // posiciona Armadilhas de Perda Aleatoria
        ArmadilhaPerdaAleatoria[] pa = new ArmadilhaPerdaAleatoria[numeroPerdaAleatoria];
        for (int count = 0; count < numeroPerdaAleatoria; count++) {
            int i = geradorAleatorio.nextInt(5);
            int j = geradorAleatorio.nextInt(9);
            if (t1.getCelula(i, j).getPersonagem() == null && t1.getCelula(i, j).getArmadilha() == null) {
                pa[count] = new ArmadilhaPerdaAleatoria();
                t1.adicionarArmadilha(pa[count], i, j);
            } else {
                count--;
            }
        }

        // Abre tela do tabuleiro (false para modo jogador, true para DEBUG);
        TabuleiroFrame telaTabuleiro = new TabuleiroFrame("Tabuleiro", t1, false);
        // t1.printTabuleiro();
    }
}
