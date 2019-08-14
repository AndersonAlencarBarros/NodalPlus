 
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
 
public class O2Controller implements Initializable {
    @FXML
    private Label label;
    @FXML
    private TextField R1;
    @FXML
    private TextField R2;
    @FXML
    private ImageView circuitoO1;
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
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       req.setOpacity(0);
       v.setOpacity(0);
       I.setOpacity(0);
       seta.setOpacity(0);
       circuitoO1.setOpacity(0);
    }    

    @FXML
    private void ir_TelaOHM(ActionEvent event) {
         Projeto.loadScene("OHM.fxml", "Calcular"); 
    }

    @FXML
    private void calcular(ActionEvent event) {
       req.setOpacity(1);
       v.setOpacity(1);
       I.setOpacity(1);
       circuitoO1.setOpacity(1);
       seta.setOpacity(1);
       
        double r1 = Double.parseDouble(R1.getText());
        double r2 = Double.parseDouble(R2.getText()); 
        double v1 = Double.parseDouble(V.getText());
        double Req = (r1*r2)/(r1 + r2);  
        double Corrente = v1/Req;
        I.setText(Double.toString(Corrente));
        v.setText(Double.toString(v1));
        req.setText(Double.toString(Req));
        
    }
    
}