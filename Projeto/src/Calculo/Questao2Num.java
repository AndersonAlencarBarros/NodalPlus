/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculo;

import java.util.Scanner;

/**
 *
 * @author ricardo
 */
public class Questao2Num {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int qtdNo = 4, terra = 3, noFonte = 0, tensao = 5;
        int i,j;
        float[][] matrizNodal = new float[(qtdNo-1)][(2*qtdNo+2)];
        for (i = 1;  i < qtdNo-1; i++){
            for (j = 1; j < (2*qtdNo)+2 ; j++){
                System.out.println(j+"ddd");
                matrizNodal[i][j] = 0;
            }
        }
        /**matrizNodal[1][1] = 3;
        matrizNodal[1][2] = 0;
        matrizNodal[1][3] = 1000;
        matrizNodal[1][4] = 2;
        matrizNodal[1][5] = 1000;
        matrizNodal[1][6] = 3;
        matrizNodal[1][7] = 1000;
        
        
        matrizNodal[2][1] = 2;
        matrizNodal[2][2] = 1;
        matrizNodal[2][3] = 1000;
        matrizNodal[2][4] = 3;
        matrizNodal[2][5] = 1000;**/
              
        matrizNodal[1][1] = 3;
        matrizNodal[1][2] = 0;
        matrizNodal[1][3] = 500;
        matrizNodal[1][4] = 2;
        matrizNodal[1][5] = 125;
        matrizNodal[1][6] = 3;
        matrizNodal[1][7] = 1000;
        
        matrizNodal[2][1] = 3;
        matrizNodal[2][2] = 0;
        matrizNodal[2][3] = 20;
        matrizNodal[2][4] = 1;
        matrizNodal[2][5] = 125;
        matrizNodal[2][6] = 3;
        matrizNodal[2][7] = 170;
       
        
        
        
        System.out.println("============== MENU ================\n\n");
        System.out.println("1 - Achar a tensão nos nós;");
        System.out.println("2 - Achar a correntes nas malhas;");
        System.out.println(""); 
        int op;
        System.out.println("=====================================");
        System.out.print("Opção: ");
            op = in.nextInt();
            in.nextLine();
            while (op != 1 && op != 2){            
            System.out.print("ERRO: Opcao invalida! Digite nova opção: ");
            op = in.nextInt();
            //in.nextLine();
            }
        switch (op){
            case (1):
                TensaoNos t = new TensaoNos();
                t.principal(qtdNo,terra,noFonte,tensao,matrizNodal);
                break;
            case(2):
                CorrenteMalhas c = new CorrenteMalhas();
                c.principal();
                break;
        }
        
    }
    
}
