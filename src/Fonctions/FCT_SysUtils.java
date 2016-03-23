package Fonctions;

import ElementsGraphiques.EGRA_Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

public class FCT_SysUtils {
    private static FCT_SysUtils instance = null;
    
    private FCT_SysUtils() {}
    
    public static synchronized FCT_SysUtils getInstance() {
        if (instance == null) instance = new FCT_SysUtils();
        return instance;
    }
    
    public String getApplicationExePath() {
        String path = getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        if (path.startsWith(FCT_Ressources.PATH_DELIMITER)) path = path.substring(1, path.length());
        return path;
    }
    
    public static Image createSlickImage(String path) {
        Image result = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(path));
            Texture texture = BufferedImageUtil.getTexture("", bufferedImage);
            Image img = new Image(texture.getImageWidth(), texture.getImageHeight());
            img.setTexture(texture);
            result = img;
        } catch (IOException | SlickException ex) {
            Logger.getLogger(EGRA_Image.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
