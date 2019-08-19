 
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
 
public class LT2Controller implements Initializable {
    @FXML
    private Label label;
    @FXML
    private TextField r1;
    @FXML
    private TextField r2;
    @FXML
    private TextField vfem;
    @FXML
    private Label v1;
    @FXML
    private Label v2;
    @FXML
    private Label v3;
    @FXML
    private TextField r3;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 

    @FXML
    private void calcular(ActionEvent event) {
    }
    
    @FXML
    public void ir_TelaTensao(){ 
         Projeto.loadScene("TelaTensao.fxml", "Calcular");  
    }
    
}
