
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
 


public class SobreController implements Initializable {
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void ir_TelaPrincipal(){ 
         Projeto.loadScene("TelaPrincipal.fxml", "Nodal+");  
    }
    
}
