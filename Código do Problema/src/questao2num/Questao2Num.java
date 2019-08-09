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
public class Questao2Num {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
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
                t.principal();
                break;
            case(2):
                CorrenteMalhas c = new CorrenteMalhas();
                c.principal();
                break;
        }
        
    }
    
}
