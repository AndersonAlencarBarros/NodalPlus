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
public class CorrenteMalhas {

    int qtdMalhas;
    float vetorTensao[], X0[], X1[];
    float matrizResistencias[][];
    float diferencaMax;

    void recebeMatriz() {
        int i, j;

        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Entre com a quantidade de malhas: ");
            qtdMalhas = in.nextInt();
            if (qtdMalhas <= 0) {
                System.out.println("\nERRO! Entrada inválida! Tente novamente!\n");
            }
        } while (qtdMalhas <= 0);

        matrizResistencias = new float[qtdMalhas][qtdMalhas];
        vetorTensao = new float[qtdMalhas];
        for (i = 0; i < qtdMalhas; i++) {
            for (j = 0; j < qtdMalhas; j++) {
                matrizResistencias[i][j] = 0;
            }
        }
        for (i = 0; i < qtdMalhas; i++) {
            in.nextLine();
            System.out.print("-------------------------- Malha " + (i + 1) + " -------------------------------\n");
            for (j = 0; j < 4; j++) {
                System.out.print("Digite a resistencia " + (j + 1) + " da malha " + (i + 1) + ": ");
                float aux = Math.abs(in.nextFloat());
                if (aux == 0.0) {
                    continue;
                } else {
                    int op;
                    matrizResistencias[i][i] += aux;
                    do {
                        System.out.print("A resistência " + (j + 1) + " faz conexão com outra malha: 1 - Sim | 2 - Nao ");
                        op = in.nextInt();
                    } while (op != 1 && op != 2);
                    if (op == 1) {
                        do {
                            System.out.print("Com qual malha a resistencia " + (j + 1) + " faz conexão: ");
                            op = in.nextInt();
                        } while ((op == i + 1) || (op <= 0 || op > qtdMalhas));
                        matrizResistencias[i][op - 1] = aux * (-1);
                    }
                }
            }

            System.out.print("Entre com a tensão da malha " + (i + 1) + " : ");
            vetorTensao[i] = (in.nextFloat());

            System.out.println();
        }
    }

    float calculaMaximo() {
        int i;
        float d, m = 0;
        for (i = 0; i < qtdMalhas; i++) {
            d = Math.abs(X1[i] - X0[i]);
            if (d > m) {
                m = d;
            }
        }
        return m;
    }

    void Imprime(float[] X, int K, int parada) {
        int I;
        if (parada == 0) {
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
            for (I = 0; I < qtdMalhas; I++) {
                System.out.println("Corrente na malha(" + (I + 1) + ")= " + X[I] + " A\n");
            }
            if (K > 0) {
                System.out.println("\n\nIteracao " + K + " MaxDif " + calculaMaximo() + "\n\n ");
            }
        }
    }

    int criterioLinhas() {
        int i, j;
        double s;

        for (i = 0; i < qtdMalhas; i++) {
            s = 0.0;
            for (j = 0; j < qtdMalhas; j++) {
                if (i != j) {
                    s += Math.abs(matrizResistencias[i][j]);
                }
            }
            if (s >= Math.abs(matrizResistencias[i][i])) {
                return 0;
            }
        }
        return 1;

    }

    int criterioSa() {
        int i, j;
        double s;
        double beta[] = new double[qtdMalhas], maxB = 0.0; //

        for (i = 0; i < qtdMalhas; i++) {
            s = 0.0;

            for (j = 0; j < qtdMalhas; j++) {
                if (j < i) {
                    s = s + Math.abs(matrizResistencias[i][j]) * beta[j];
                }
                if (j > i) {
                    s = s + Math.abs(matrizResistencias[i][j]);
                }
            }
            beta[i] = s / Math.abs(matrizResistencias[i][i]);

        }

        for (i = 0; i < qtdMalhas; i++) {
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

    void iteracao(int k) {
        int i, j;

        for (i = 0; i < qtdMalhas; i++) {
            X1[i] = X0[i];
        }
        for (i = 0; i < qtdMalhas; i++) {
            X1[i] = vetorTensao[i];
            for (j = 0; j < qtdMalhas; j++) {
                if (i != j) {
                    X1[i] -= matrizResistencias[i][j] * X1[j];
                }
            }
            X1[i] /= matrizResistencias[i][i];
        }
        Imprime(X1, k + 1, 1);
    }

    void principal() {
        // TODO code application logic here
        int i, j, k = 0;
        recebeMatriz();
        X0 = new float[qtdMalhas];
        X1 = new float[qtdMalhas];
        for (i = 0; i < qtdMalhas; i++) {
            X0[i] = 0;
        }
        Imprime(X0, k, 1);
        do {
            iteracao(k);
            diferencaMax = calculaMaximo();
            for (i = 0; i < qtdMalhas; i++) {
                X0[i] = X1[i];
            }
            k++;
        } while (diferencaMax > 1.0e-3);
        Imprime(X1, k, 0);
        //in.nextLine();
        System.out.println("\n\nMatriz original de dados:\n");
        for (i = 0; i < qtdMalhas; i++) {
            System.out.print("|");
            for (j = 0; j < qtdMalhas; j++) {
                System.out.printf("  %8.2f  ", matrizResistencias[i][j]);
            }
            System.out.printf("  |  %8.2f  |\n", vetorTensao[i]);
        }
    }

}
