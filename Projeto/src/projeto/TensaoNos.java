/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

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

    static float calculaMaximo(int qtdNo) {
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

    static void Imprime(float[] X, int K, int varStop, int qtdNo) {
        int I;
        if (varStop == 0) {
            if (criterioLinhas(qtdNo) == 1) {
                System.out.print("Critério de Linhas: Aceito!");
            } else {
                System.out.print("Critério de Linhas: Não aceito!");
            }
            System.out.print("\n");
            if (criterioSa(qtdNo) == 1) {
                System.out.print("Critério de Sassenfeld: Aceito!");
            } else {
                System.out.print("Critério de Sassenfeld: Não aceito!");
            }
            System.out.println("\nSolucao do sistema linear\n\n");
            for (I = 1; I < qtdNo - 1; I++) {
                System.out.println("Tensão no nó (" + I + ") = " + X[I] + " V\n");
            }
            if (K > 0) {
                System.out.println("\n\nIteracao " + K + " com diferença máxima " + calculaMaximo(qtdNo) + "\n\n ");
            }
            retornarTela(X);
        }
    }
    
    static float[] retornarTela(float[] X){
        return (X);
    }

    static void iteracao(int k, int qtdNo) {
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
        Imprime(X1, k + 1, 1, qtdNo);
    }

    static int criterioLinhas(int qtdNo) {
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

    static int criterioSa(int qtdNo) {
        int i, j;
        double s;
        double beta[] = new double[qtdNo - 1], maxB = 0.0; //

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

    float[] principal(int qtdNo, int terra, int noFonte, float tensao, float[][] matrizNodal) {
        int auxiliar,auxiliar2;
        for (auxiliar = 1;  auxiliar < qtdNo-1; auxiliar++){
            System.out.print("| "); 
            for (auxiliar2 = 1; auxiliar2 < (2*qtdNo)+2 ; auxiliar2++){
                System.out.print(matrizNodal[auxiliar][auxiliar2]+" ");
            }
            System.out.print (" |");
                    
            System.out.print ("\n");
        }
        int i, j;
        int inf, inf2;
        double inf3;
        //double matrizNo[][],vetorNo[];
        Scanner in = new Scanner(System.in);
        matrizNo = new float[qtdNo - 1][qtdNo - 1];
        vetorNo = new float[qtdNo - 1];
        for (i = 1; i < qtdNo - 1; i++) {
            for (j = 1; j < qtdNo - 1; j++) {
                matrizNo[i][j] = 0;
            }
        }
//        while (terra < 0 || terra > qtdNo - 1) {
//            System.out.print("ERRO: O nó " + terra + " não está dentro do intervalo!");
//            System.out.print("\nEscolha um nó referencial (terra) (0-" + (qtdNo - 1) + "): ");
//            terra = in.nextInt();
//        }
////        Scanner sc = new Scanner(System.in);
////        Scanner sc1 = new Scanner(System.in);
        for (i = 1; i < qtdNo - 1; i++) {
            System.out.print("---------------- Nó " + i + " ----------------\n\n");
            System.out.print("O nó " + (i) + " possui quantas conexões? ");
            inf = (int) (matrizNodal[i][1]);
            System.out.println ("inf "+inf);
            System.out.print("\n\n");
            for (j = 1; j < (2*inf)+1; j++) {
                if (j % 2 == 0) {
                    System.out.print("Informe a conexão " + (j + 1) + " (0-" + (qtdNo - 1) + "): ");
                    inf2 = (int) matrizNodal[i][j];
                    while ((inf2 < 0 || inf2 > qtdNo - 1)) {
                        System.out.print("O nó " + inf2 + " não está dentro do intervalo!");
                        System.out.print("Informe a conexão " + (j + 1) + " (0-" + (qtdNo - 1) + "): ");
                        //inf2 = (sc.nextInt());
                    }
//                    sc.nextLine();
                    inf3 = matrizNodal[i][j+1]; //resistencia
//                    sc1.nextLine();
                    matrizNo[i][i] = (float) (matrizNo[i][i] + (1 / inf3));
                    if (inf2 != terra) {
                        if (inf2 == noFonte) {
                            vetorNo[i] = (float) (vetorNo[i] + (tensao / inf3));
                        } else {
                            matrizNo[i][(inf2)] = (float) ((-1) * (1 / inf3));
                        }
                    }
                }
            }
            System.out.print("--------------------------------------\n");
        }
        int k = 0;
        X0 = new float[qtdNo - 1];
        X1 = new float[qtdNo - 1];
        for (i = 1; i < qtdNo - 1; i++) {
            X0[i] = vetorNo[i] / matrizNo[i][i];
        }
        Imprime(X0, k, 1, qtdNo);
        do {
            iteracao(k,qtdNo);
            DiferencaMax = calculaMaximo(qtdNo);
            for (i = 1; i < qtdNo - 1; i++) {
                X0[i] = X1[i];
            }
            k++;
        } while (DiferencaMax > 1.0e-3);
        Imprime(X1, k, 0,qtdNo);
        return(X1);
//        System.out.println("\n\nMatriz original de dados:\n");
//        for (i = 1; i < qtdNo - 1; i++) {
//            System.out.print("|");
//            for (j = 1; j < qtdNo - 1; j++) {
//                System.out.printf("  %8.2f  ", matrizNo[i][j]);
//            }
//            System.out.printf("  |  %8.2f  |\n", vetorNo[i]);
//
//        }
    }
}
//}
