
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
 
public class OHMController implements Initializable {
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
    public void ir_O1(){ 
         Projeto.loadScene("O1.fxml", "Calcular");  
    }
    
    @FXML
    public void ir_O2(){ 
         Projeto.loadScene("O2.fxml", "Calcular");  
    }
    
    @FXML
    public void ir_O3(){ 
         Projeto.loadScene("O3.fxml", "Calcular");  
    }
    
} 