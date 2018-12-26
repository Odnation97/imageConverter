package com.odnation97.imageconverter.Model;

import java.io.File;
import javafx.scene.control.Alert;

/**
 *
 * @author o_noo
 */

public interface Features 
{
    
    default String directory(String nameOfPdf)
    {
        String destinationLocation = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + nameOfPdf + ".pdf";
        return destinationLocation;
    }
    
    default void alertDialog(String title, String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        
        alert.showAndWait();
    }
    
    default String getExtension(File file)
    {
       String toString = file.toString();
       String extension = "";
       int i = toString.lastIndexOf('.');
       
       if (i > 0) 
       {
           extension = toString.substring(i+1);
       }
       
       return extension;
    }
    
}
