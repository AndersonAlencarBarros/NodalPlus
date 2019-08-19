 
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
 
public class TelaTensaoController implements Initializable {
    @FXML
    private Label label;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void ir_TelaPrincipal(){ 
         Projeto.loadScene("TelaPrincipal.fxml", "Nodal+");  
    }
    
    @FXML
    public void ir_LT1(){ 
         Projeto.loadScene("LT1.fxml", "Calcular");  
    }
    
    @FXML
    public void ir_LT2(){ 
         Projeto.loadScene("LT2.fxml", "Calcular");  
    }
    
    @FXML
    public void ir_LT3(){ 
         Projeto.loadScene("LT3.fxml", "Calcular");  
    }
}
