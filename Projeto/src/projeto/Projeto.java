 
package projeto;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
 
public class Projeto extends Application {
     
    public static Stage  primaryStage;
    public static Class thisClass;  

    public Projeto() {
        thisClass = getClass();
    }
     
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
    
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
      public static void loadScene(String nameFile, String titlePage) {
        Parent root;
        try {
            root = FXMLLoader.load(thisClass.getResource(nameFile)); 
            Scene scene = new Scene(root);
            root.requestFocus();
            primaryStage.setResizable(false);
            primaryStage.setTitle(titlePage);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) { 
            System.out.println("Erro ao Abrir a Tela");
            e.printStackTrace();
        }
    } 
    
}
