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
public class OHMController implements Initializable {
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
    @FXML
    public void ir_O1(){ 
         Projeto.loadScene("O1.fxml", "Calcular");  
    }
    
}