/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linapreloader;

import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author moises
 */
public class LinaPreLoader extends Preloader {
    
    private Stage preloaderStage;
      
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/linapreloader/SplashScreen.fxml")); 
        Scene scene = new Scene(root, 600, 400, Color.TRANSPARENT); 
        root.setStyle("-fx-background-color: transparent;");
        
        this.preloaderStage = primaryStage;

        preloaderStage.initStyle(StageStyle.TRANSPARENT); 
       
        // Set preloader scene and show stage.
        preloaderStage.setScene(scene);  
        preloaderStage.show();
        
    }

    @Override
    public void handleApplicationNotification(Preloader.PreloaderNotification info) {
      
        if (info instanceof ProgressNotification) {
            
            int progressval = (int) ((ProgressNotification) info).getProgress();
            String message = "Inicializando...";
            
            switch (progressval)
            {
                case 1:
                    message = "Cargando configuración";
                    break;
                    
                case 2:
                    message = "Validando Lina 5";
                    break;
                    
                case 3:
                    message = "Conectando con Lina Server";
                    break;
                    
                case 4:
                    message = "ERROR LELLENDO CONFIGURACION GLOBAL";
                    break;
                    
                case 5:
                    message = "ERROR LELLENDO CONFIGURACION DE USUARIO";
                    break;
                    
                case 6:
                    message = "ERROR DE VALIDACION. ERR_IO";
                    break;
                    
                case 7:
                    message = "ERROR DE VALIDACION. ERR_FNF";
                    break;
                    
                case 8:
                    message = "ERROR DE VALIDACION. EMPTY_KEY";
                    break;
            }
            
            SplashScreenController.lblmsg.setText(message);
            
        } else if (info instanceof StateChangeNotification) {
            //hide after get any state update from application
            preloaderStage.hide();
        }

    }
    
    @Override
    public void handleStateChangeNotification(StateChangeNotification scn) {
        
        StateChangeNotification.Type type = scn.getType();
        
        switch (type) {
            
            case BEFORE_START:
                // Called after NetNumentecLina#init and before NetNumentecLina#start is called.
                preloaderStage.hide();
                break;
                
        }
        
    } 
    
}
