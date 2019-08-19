 
package projeto;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
 
public class LT1Controller implements Initializable {
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
    private TextField r4;
    @FXML
    private TextField r5;
    @FXML
    private Label v1;
    @FXML
    private Label v2;
    @FXML
    private Label v3;
    @FXML
    private Label v4;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 

    @FXML
    private void calcular(ActionEvent event) {
        int qtdNo = 4, terra = 3, noFonte = 0;
        int i,j;
        float[][] matrizNodal = new float[(qtdNo-1)][(2*qtdNo+2)];
        for (i = 1;  i < qtdNo-1; i++){
            for (j = 1; j < (2*qtdNo)+2 ; j++){
                System.out.println(j+"ddd");
                matrizNodal[i][j] = 0;
            }
        }
        
        matrizNodal[1][1] = 3;
        matrizNodal[1][2] = 0;
        matrizNodal[1][3] = Float.parseFloat(r4.getText());
        matrizNodal[1][4] = 2;
        matrizNodal[1][5] = Float.parseFloat(r2.getText());
        matrizNodal[1][6] = 3;
        matrizNodal[1][7] = Float.parseFloat(r5.getText());;
        
        matrizNodal[2][1] = 3;
        matrizNodal[2][2] = 0;
        matrizNodal[2][3] = Float.parseFloat(r1.getText());;
        matrizNodal[2][4] = 1;
        matrizNodal[2][5] = Float.parseFloat(r2.getText());;
        matrizNodal[2][6] = 3;
        matrizNodal[2][7] = Float.parseFloat(r3.getText());;
        
        TensaoNos t = new TensaoNos();
        float vetorResultado[] = new float[3]; 
        int aux;
        
        vetorResultado = (t.principal(qtdNo, terra, noFonte , Integer.parseInt(vfem.getText()), matrizNodal));
        DecimalFormat df = new DecimalFormat("#.00"); 
        
        v3.setText(df.format(vetorResultado[1])+" V");
        v1.setText(df.format(vetorResultado[2])+" V");
        v4.setText((vfem.getText())+" V");
        v2.setText(Float.toString(vetorResultado[0])+" V");
    }
     @FXML
    public void ir_TelaTensao(){ 
         Projeto.loadScene("TelaTensao.fxml", "Calcular");  
    }
    
}
