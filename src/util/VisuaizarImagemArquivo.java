package util;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;


public class VisuaizarImagemArquivo extends FileView {

	    ImageIcon jpgIcon = Utils.createImageIcon("images/jpgIcon.gif");
	    ImageIcon gifIcon = Utils.createImageIcon("images/gifIcon.gif");
	    ImageIcon tiffIcon = Utils.createImageIcon("images/tiffIcon.gif");
	    ImageIcon pngIcon = Utils.createImageIcon("images/pngIcon.png");
	    ImageIcon bmpIcon = Utils.createImageIcon("images/bmpIcon.gif");
	    

	    public String getName(File f) {
	        return null; //let the L&F FileView figure this out
	    }

	    public String getDescription(File f) {
	        return null; //let the L&F FileView figure this out
	    }

	    public Boolean isTraversable(File f) {
	        return null; //let the L&F FileView figure this out
	    }

	    public String getTypeDescription(File f) {
	        String extension = Utils.getExtension(f);
	        String type = null;

	        if (extension != null) {
	            if (extension.equals(Utils.jpeg) ||
	                extension.equals(Utils.jpg)) {
	                type = "JPEG Image";
	            } else if (extension.equals(Utils.gif)){
	                type = "GIF Image";
	            } else if (extension.equals(Utils.tiff) ||
	                       extension.equals(Utils.tif)) {
	                type = "TIFF Image";
	            } else if (extension.equals(Utils.png)){
	                type = "PNG Image";
	        	} else if (extension.equals(Utils.bmp)){
	        		type = "BMP Image";
	        	}
	        }
	        return type;
	    }

	    public Icon getIcon(File f) {
	        String extension = Utils.getExtension(f);
	        Icon icon = null;

	        if (extension != null) {
	            if (extension.equals(Utils.jpeg) ||
	                extension.equals(Utils.jpg)) {
	                icon = jpgIcon;
	            } else if (extension.equals(Utils.gif)) {
	                icon = gifIcon;
	            } else if (extension.equals(Utils.tiff) ||
	                       extension.equals(Utils.tif)) {
	                icon = tiffIcon;
	            } else if (extension.equals(Utils.png)) {
	                icon = pngIcon;
	            } else if (extension.equals(Utils.bmp)) {
	                icon = bmpIcon;
	            }
	        }
	        return icon;
	    }
	}
