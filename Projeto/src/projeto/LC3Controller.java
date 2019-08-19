 
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
 
public class LC3Controller implements Initializable {
    @FXML
    private Label label;
    @FXML
    private TextField r1;
    @FXML
    private TextField r2;
    @FXML
    private TextField vfem;
    @FXML
    private TextField r3;
    @FXML
    private TextField r4;
    @FXML
    private ImageView s1;
    @FXML
    private Label i1;
    @FXML
    private ImageView s2;
    @FXML
    private Label i2;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       s1.setOpacity(0);
       s2.setOpacity(0); 
       i1.setOpacity(0); 
       i2.setOpacity(0); 
    }    
    
    @FXML
    private void calcular(ActionEvent event) {
       s1.setOpacity(0);
       s2.setOpacity(0); 
       i1.setOpacity(0); 
       i2.setOpacity(0); 
    }
    @FXML
    public void ir_TelaCorrente(){ 
         Projeto.loadScene("TelaCorrente.fxml", "Lei das Correntes");  
    }
    
}
