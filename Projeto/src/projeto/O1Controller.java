 
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
 
public class O1Controller implements Initializable {
    @FXML
    private Label label;
    @FXML
    private TextField R1_O1;
    @FXML
    private TextField R2_O1;
    @FXML
    private TextField V_O1;
    @FXML
    private TextField R3_O1;
    @FXML
    private Label req;
    @FXML
    private Label v;
    @FXML
    private Label I;
    @FXML
    private ImageView circuitoO1;
    @FXML
    private ImageView seta;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       req.setOpacity(0);
       v.setOpacity(0);
       I.setOpacity(0);
       seta.setOpacity(0);
       circuitoO1.setOpacity(0);
    }    
     
    @FXML
    public void ir_TelaOHM(){ 
         Projeto.loadScene("OHM.fxml", "Lei de Ohm");  
    }
    
    
    @FXML
    private void calcular(){
        try{
            req.setOpacity(1);
            v.setOpacity(1);
            I.setOpacity(1);
            circuitoO1.setOpacity(1);
            seta.setOpacity(1);

            double R1 = Double.parseDouble(R1_O1.getText());
            double R2 = Double.parseDouble(R2_O1.getText());
            double R3 = Double.parseDouble(R3_O1.getText());
            double Vf = Double.parseDouble(V_O1.getText());
            double Req = R1 + R2 + R3;  
            double Corrente = Vf/Req;
            I.setText(Double.toString(Corrente));
            v.setText(Double.toString(Vf));
            req.setText(Double.toString(Req)); 
        }catch(Exception e){
            System.out.println("Erro na Hora de Calcular");
        }
    }
}
    

