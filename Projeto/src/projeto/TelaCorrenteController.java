 
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
 
public class TelaCorrenteController implements Initializable {
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void ir_TelaPrincipal(){ 
         Projeto.loadScene("TelaPrincipal.fxml", "Calcular");  
    }
     @FXML
    public void ir_LC1(){ 
         Projeto.loadScene("LC1.fxml", "Calcular");  
    }
     @FXML
    public void ir_LC2(){ 
         Projeto.loadScene("LC2.fxml", "Calcular");  
    }
     @FXML
    public void ir_LC3(){ 
         Projeto.loadScene("LC3.fxml", "Calcular");  
    }
}
