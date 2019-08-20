 
package projeto;
 
import java.net.URL;
import java.security.Principal;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
 
public class TelaPrincipalController implements Initializable {
    @FXML
    private Label label;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void ir_TelaTensao(){ 
         Projeto.loadScene("TelaTensao.fxml", "Lei das Correntes");  
    }
    
    @FXML
    public void ir_Ohm(){ 
         Projeto.loadScene("OHM.fxml", "Lei de Ohm");  
    }
     
    @FXML
    public void ir_TelaCorrente(){ 
         Projeto.loadScene("TelaCorrente.fxml", "Lei das Tensões");  
    }
    
    @FXML
    public void ir_Sobre(){ 
         Projeto.loadScene("Sobre.fxml", "Sobre");  
    }
    
    
    
}
