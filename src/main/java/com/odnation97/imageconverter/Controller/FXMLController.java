package com.odnation97.imageconverter.Controller;

import com.odnation97.imageconverter.Model.Features;
import com.odnation97.imageconverter.Model.Converter;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author o_noo
 */

public class FXMLController implements Initializable, Features, Converter {
    
   @FXML Label pathLabel;
   @FXML Button browseBtn;
   @FXML Button covertBtn;
   private String destinationLocation = "";
   private boolean validator = false; // This boolean will indicate the program if an image has been chosen
   
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        destinationLocation = System.getProperty("user.home") + File.separator + "Desktop";
        System.out.println(destinationLocation);
    }  
   
   @FXML
   public void findImage(ActionEvent event) throws NullPointerException
   {
       try
       {
            FileChooser dir = new FileChooser();
            Stage stage = new Stage();
            dir.setTitle("Select Image file");
            File fileChosen = dir.showOpenDialog(stage);
            pathLabel.setText(fileChosen.getAbsolutePath());
            
            validator = true; // Boolean turns true as file has been chosen
            
       }
       catch(NullPointerException e)
       {
           // catching method has been made to stop crash on no file selection - Should not do anything, may add Alert Dialog in the future
       }
   }
   
   @FXML
   public void convertImg(ActionEvent event)
   {
       
       String extension = getExtension(new File(pathLabel.getText()));
       
       if (!validator)
       {
           alertDialog("File not found!", "File not found, please select one!");
       }
       else
       {
            if (extension.equals("jpg"))
            {
                System.out.println("JPG file has been found!");
            }
       }
   }
   
}
