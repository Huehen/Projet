package ElementsGraphiques;

import Fonctions.FCT_Fonctions;
import Fonctions.FCT_SysUtils;
import Scenes.Scene;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class EGRA_Image extends EGRA_Object {
    protected Image image;
    
    public EGRA_Image(Scene sceneOwner, String path) {
        super(sceneOwner);
        this.image = FCT_SysUtils.createSlickImage(path);
    }
    
    public EGRA_Image(Scene sceneOwner, String path, int x, int y) {
        super(sceneOwner, x, y);
        this.image = FCT_SysUtils.createSlickImage(path);
    }
    
    public Image getImage() { return this.image; }
    public void setImage(Image image) { this.image = image; }
        
    @Override
    protected void setRenderX() {
        if (this.image != null) {
            if (this.hAlign == EGRA_Types.HALIGN.LEFT) this.renderX = this.x;
            else if (this.hAlign == EGRA_Types.HALIGN.CENTER) this.renderX = this.x - (this.image.getWidth() / 2);
            else if (this.hAlign == EGRA_Types.HALIGN.RIGHT) this.renderX = this.x - this.image.getWidth();
            else this.renderX = this.x;
        }
        else this.renderX = this.x;
    }
    
    @Override
    protected void setRenderY() {
        if (this.image != null) {
            if (this.vAlign == EGRA_Types.VALIGN.TOP) this.renderY = this.y;
            else if (this.vAlign == EGRA_Types.VALIGN.MIDDLE) this.renderY = this.y - (this.image.getHeight() / 2);
            else if (this.vAlign == EGRA_Types.VALIGN.BOTTOM) this.renderY = this.y - this.image.getHeight();
            else this.renderY = this.y;
        }
        else this.renderY = this.y;
    }
    
    public void setImage(String path) {
        this.image = FCT_SysUtils.createSlickImage(path);
    }
    
    public boolean isHover(Input i) {
       if (this.visible && this.image != null) {
           return FCT_Fonctions.testMouse(i, this.image, this.renderX, this.renderY);
       } 
       else return false;
    }

    @Override
    public void update(GameContainer gc, int t) {
        //Nothing to do
    }

    @Override
    public void afficher(Graphics g) {
        if (this.visible) g.drawImage(this.image, this.renderX, this.renderY);
    }
}
