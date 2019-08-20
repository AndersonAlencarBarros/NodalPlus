
package projeto;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
 
public class LC2Controller implements Initializable {
    @FXML
    private Label label;
    @FXML
    private TextField r1;
    @FXML
    private TextField r2;
    @FXML
    private TextField vfem;
    @FXML
    private TextField r3;
    @FXML
    private Label i1;
    @FXML
    private Label i2;
    @FXML
    private ImageView s1;
    @FXML
    private ImageView s2;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       s1.setOpacity(0);
       s2.setOpacity(0); 
       i1.setOpacity(0); 
       i2.setOpacity(0); 
    }    

    @FXML
    private void calcular(ActionEvent event) {
       s1.setOpacity(1);
       s2.setOpacity(1); 
       i1.setOpacity(1); 
       i2.setOpacity(1);
       
       
        CorrenteMalhas c = new CorrenteMalhas();
        int qtdMalhas = 2,ind,ind2;
        int[][] matrizAuxiliar = new int[qtdMalhas][6];
        float vetorTensoes[] = new float[qtdMalhas];
        float matrizMalha[][] = new float[qtdMalhas][4];
        int matrizVerificacao[][] = new int [qtdMalhas][6];
        for (ind = 0; ind < qtdMalhas; ind++){
            vetorTensoes[ind] = 0;
            for (ind2 = 0; ind2 < 4; ind2++){
                matrizMalha[ind][ind2] = 0;
            }
        }        
        for (ind = 0; ind < qtdMalhas; ind++){
            for (ind2 = 0; ind2 < 6; ind2++){
                matrizVerificacao[ind][ind2] = 0;
                matrizAuxiliar[ind][ind2] = 0;
            }
        }        
        matrizMalha[0][0] = Float.parseFloat(r1.getText());
        matrizVerificacao[0][0] = 1;
        matrizAuxiliar[0][0] = 2;
        vetorTensoes[0] = Float.parseFloat(vfem.getText()); 
        
        
        matrizMalha[1][0] = Float.parseFloat(r2.getText());
        matrizVerificacao[1][0] = 2;
        matrizAuxiliar[1][0] = 0;
        matrizMalha[1][1] = Float.parseFloat(r3.getText());
        matrizVerificacao[1][1] = 2;     
        matrizAuxiliar[1][1] = 0;
        matrizMalha[1][2] = Float.parseFloat(r1.getText());
        matrizVerificacao[1][2] = 1;
        matrizAuxiliar[1][2] = 1;
        vetorTensoes[1] = 0;
        
        
        float vetorResultado[] = new float[2];
        vetorResultado = c.principal(qtdMalhas,matrizMalha,matrizVerificacao,vetorTensoes,matrizAuxiliar);
               
        DecimalFormat df = new DecimalFormat("#.00"); 
        
        i1.setText(df.format(vetorResultado[0]));
        i2.setText(df.format(vetorResultado[1]));
    }
    
    @FXML
    public void ir_TelaCorrente(){ 
         Projeto.loadScene("TelaCorrente.fxml", "Lei das Tensões");  
    }
    
}
