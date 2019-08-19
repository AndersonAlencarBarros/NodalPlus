 
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
 
public class O3Controller implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField R1;
    @FXML
    private TextField R2;
    @FXML
    private ImageView circuito;
    @FXML
    private Label req;
    @FXML
    private Label v;
    @FXML
    private Label I;
    @FXML
    private TextField V;
    @FXML
    private ImageView seta;
    @FXML
    private TextField R3;
    @FXML
    private TextField R4;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       req.setOpacity(0);
       v.setOpacity(0);
       I.setOpacity(0);
       seta.setOpacity(0);
       circuito.setOpacity(0);
    }    

     @FXML
    private void ir_TelaOHM(ActionEvent event) {
         Projeto.loadScene("OHM.fxml", "Calcular"); 
    }

     @FXML
    private void calcular(ActionEvent event) {
       try{
        req.setOpacity(1);
        v.setOpacity(1);
        I.setOpacity(1);
        circuito.setOpacity(1);
        seta.setOpacity(1);

         double r1 = Double.parseDouble(R1.getText());
         double r2 = Double.parseDouble(R2.getText()); 
         double r3 = Double.parseDouble(R3.getText()); 
         double r4 = Double.parseDouble(R4.getText()); 
         double v1 = Double.parseDouble(V.getText());
         double Req1 = r2 + r3;
         double Req2 = r1 + (r4*Req1)/(r4 + Req1);  
         double Corrente = v1/Req2;
         I.setText(Double.toString(Corrente));
         v.setText(Double.toString(v1));
         req.setText(Double.toString(Req2));   
        }catch(Exception e){
            System.out.println("Erro na Hora de Calcular");
        }
    }
    
}
