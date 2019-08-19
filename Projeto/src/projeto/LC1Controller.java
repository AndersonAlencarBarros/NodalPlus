/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ksr
 */
public class LC1Controller implements Initializable {
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
    private TextField r5;
    @FXML
    private Label i1;
    @FXML
    private Label i2;
    @FXML
    private Label i3;
    @FXML
    private ImageView s3;
    @FXML
    private ImageView s2;
    @FXML
    private ImageView s1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void calcular(ActionEvent event) {
    }
      @FXML
    public void ir_TelaCorrente(){ 
         Projeto.loadScene("TelaCorrente.fxml", "Calcular");  
    }
}
