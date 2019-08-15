/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author UNIVASF
 */
public class TelaTensaoController implements Initializable {
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void ir_TelaPrincipal(){ 
         Projeto.loadScene("TelaPrincipal.fxml", "Calcular");  
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
