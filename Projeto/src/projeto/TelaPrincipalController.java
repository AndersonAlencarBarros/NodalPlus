 
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
        // TODO
    }    
    
    @FXML
    public void ir_TelaTensao(){
        System.out.println("akivai");
         Projeto.loadScene("TelaTensao.fxml", "Calcular");  
    }
    
}
