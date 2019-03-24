/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linapreloader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author moises
 */
public class SplashScreenController implements Initializable {

    @FXML
    private ImageView imageview;
    
    @FXML
    private ProgressBar progressbar;
    public static ProgressBar pbar;
    
    @FXML
    private Label lbl;
    public static Label lblmsg;
    @FXML
    private Label lblmessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Image image = new Image("/linapreloader/Lina_Icon2.png");

        imageview.setImage(image);
        imageview.setCache(true);
        
        pbar = progressbar;
        lblmsg = lblmessage;

    }    
    
}
