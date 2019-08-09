/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2num;

import java.util.Scanner;

/**
 *
 * @author ricardo
 */
public class TensaoNos {

    static int qtdNo;
    static float vetorNo[], X0[], X1[];
    static float matrizNo[][];
    static float DiferencaMax;

    static float calculaMaximo() {
        int i;
        float d, m = 0;
        for (i = 1; i < qtdNo - 1; i++) {
            d = Math.abs(X1[i] - X0[i]);
            if (d > m) {
                m = d;
            }
        }
        return m;
    }

    static void Imprime(float[] X, int K, int varStop) {
        int I;
        if (varStop == 0) {
            if (criterioLinhas() == 1) {
                System.out.print("Critério de Linhas: Aceito!");
            } else {
                System.out.print("Critério de Linhas: Não aceito!");
            }
            System.out.print("\n");
            if (criterioSa() == 1) {
                System.out.print("Critério de Sassenfeld: Aceito!");
            } else {
                System.out.print("Critério de Sassenfeld: Não aceito!");
            }
            System.out.println("\nSolucao do sistema linear\n\n");
            for (I = 1; I < qtdNo - 1; I++) {
                System.out.println("Tensão no nó (" + I + ") = " + X[I] + " V\n");
            }
            if (K > 0) {
                System.out.println("\n\nIteracao " + K + " com diferença máxima " + calculaMaximo() + "\n\n ");
            }

        }
    }

    static void iteracao(int k) {
        int i, j;

        for (i = 1; i < qtdNo - 1; i++) {
            X1[i] = X0[i];
        }
        for (i = 1; i < qtdNo - 1; i++) {
            X1[i] = vetorNo[i];
            for (j = 1; j < qtdNo - 1; j++) {
                if (i != j) {
                    X1[i] -= matrizNo[i][j] * X1[j];
                }
            }
            X1[i] /= matrizNo[i][i];
        }
        Imprime(X1, k + 1, 1);
    }

    static int criterioLinhas() {
        int i, j;
        double s;

        for (i = 1; i < qtdNo - 1; i++) {
            s = 0.0;
            for (j = 1; j < qtdNo - 1; j++) {
                if (i != j) {
                    s += Math.abs(matrizNo[i][j]);
                }
            }
            if (s >= Math.abs(matrizNo[i][i])) {
                return 0;
            }
        }
        return 1;

    }

    static int criterioSa() {
        int i, j;
        double s;
        double beta[] = new double[qtdNo-1], maxB = 0.0; //

        for (i = 1; i < qtdNo - 1; i++) {
            s = 0.0;

            for (j = 1; j < qtdNo - 1; j++) {
                if (j < i) {
                    s = s + Math.abs(matrizNo[i][j]) * beta[j];
                }
                if (j > i) {
                    s = s + Math.abs(matrizNo[i][j]);
                }
            }
            beta[i] = s / Math.abs(matrizNo[i][i]);

        }

        for (i = 1; i < qtdNo - 1; i++) {
            if (maxB < beta[i]) {
                maxB = beta[i];
            }
        }
        if (maxB < 1.0) {
            return 1;
        } else {
            return 0;
        }
    }

    void principal() {
        int i, j;
        int inf, inf2;
        double inf3;
        //double matrizNo[][],vetorNo[];
        Scanner in = new Scanner(System.in);
        System.out.print("Quantidade de nós no circuito: ");
        qtdNo = in.nextInt();
        matrizNo = new float[qtdNo - 1][qtdNo - 1];
        vetorNo = new float[qtdNo - 1];
        for (i = 1; i < qtdNo - 1; i++) {
            for (j = 1; j < qtdNo - 1; j++) {
                matrizNo[i][j] = 0;
            }
        }
        int terra, noFonte, tensao;
        //in.nextLine();
        System.out.print("Escolha um nó referencial (terra) (0-" + (qtdNo - 1) + "): ");
        terra = in.nextInt();
        in.nextLine();
        while (terra < 0 || terra > qtdNo - 1) {
            System.out.print("ERRO: O nó " + terra + " não está dentro do intervalo!");
            System.out.print("\nEscolha um nó referencial (terra) (0-" + (qtdNo - 1) + "): ");
            terra = in.nextInt();
        }
        System.out.print("\nQual nó recebe tensão? (0-" + (qtdNo - 1) + "): ");
        noFonte = in.nextInt();
        in.nextLine();
        System.out.print("\nQual a tensão no nó (" + noFonte + ")");
        tensao = in.nextInt();
        in.nextLine();
        System.out.println("\n");
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        for (i = 1; i < qtdNo - 1; i++) {
            System.out.print("---------------- Nó " + i + " ----------------\n\n");
            System.out.print("O nó " + (i) + " possui quantas conexões? ");
            inf = in.nextInt();
            in.nextLine();
            System.out.print("\n\n");
            for (j = 0; j < inf; j++) {
                System.out.print("Informe a conexão " + (j + 1) + " (0-" + (qtdNo - 1) + "): ");
                inf2 = (sc.nextInt());
                while ((inf2 < 0 || inf2 > qtdNo - 1)) {
                    System.out.print("O nó " + inf2 + " não está dentro do intervalo!");
                    System.out.print("Informe a conexão " + (j + 1) + " (0-" + (qtdNo - 1) + "): ");
                    inf2 = (sc.nextInt());
                }
                sc.nextLine();
                System.out.print("Informe a resistência entre V" + (i) + " e V" + inf2 + ": ");
                inf3 = (sc1.nextFloat());
                sc1.nextLine();
                //sc = new Scanner(System.in);
                matrizNo[i][i] = (float) (matrizNo[i][i] + (1 / inf3));
                if (inf2 != terra) {
                    if (inf2 == noFonte) {
                        vetorNo[i] = (float) (vetorNo[i] + (tensao / inf3));
                    } else {
                        matrizNo[i][(inf2)] = (float) ((-1) * (1 / inf3));
                    }
                }
            }
            System.out.print("--------------------------------------\n");
        }
        //if (criterioLinhas() == 1 && criterioSa() == 1){ 
        int k = 0;
        X0 = new float[qtdNo - 1];
        X1 = new float[qtdNo - 1];
        for (i = 1; i < qtdNo - 1; i++) {
            X0[i] = vetorNo[i] / matrizNo[i][i];
        }
        Imprime(X0, k, 1);
        do {
            iteracao(k);
            DiferencaMax = calculaMaximo();
            for (i = 1; i < qtdNo - 1; i++) {
                X0[i] = X1[i];
            }
            k++;
        } while (DiferencaMax > 1.0e-3);
        Imprime(X1, k, 0);

        System.out.println("\n\nMatriz original de dados:\n");
        for (i = 1; i < qtdNo - 1; i++) {
            System.out.print("|");
            for (j = 1; j < qtdNo - 1; j++) {
                System.out.printf("  %8.2f  ", matrizNo[i][j]);
            }
            System.out.printf("  |  %8.2f  |\n", vetorNo[i]);

        }
    }
}
//}
