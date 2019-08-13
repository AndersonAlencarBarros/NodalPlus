 
package projeto;
 
import java.net.URL;
import java.security.Principal;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
 
public class TelaPrincipalController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void ir_TelaTensao(){ 
         Projeto.loadScene("TelaTensao.fxml", "Calcular");  
    }
    
    @FXML
    public void ir_Ohm(){ 
         Projeto.loadScene("OHM.fxml", "Lei de Ohm");  
    }
    
}
