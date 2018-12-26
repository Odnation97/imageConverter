package com.odnation97.imageconverter.Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author o_noo
 */

public interface Converter extends Features
{
    default void convertJpg(String pdfName, File jpgFile) 
    {
        String pathImage = jpgFile.getAbsolutePath();
        
        try
        {
            Document doc = new Document();
            
            PdfWriter.getInstance(doc, new FileOutputStream(directory(pdfName)));
            doc.open();
            
            Image image = Image.getInstance(pathImage);
            image.setAbsolutePosition(0, 0);
            image.setBorderWidth(0);
            image.scaleAbsolute(PageSize.A4);
            doc.add(image);
            doc.close();
        }
        catch (DocumentException e)
        {
            alertDialog("Error!", "Documents has been corrupted! Please try another!");
        }
        catch (FileNotFoundException f)
        {
            alertDialog("Error!", "File is not found!");
        }
        catch (MalformedURLException e)
        {
            
        }
        catch (IOException e)
        {
            
        }
                
    }
}

