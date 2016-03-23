package ElementsGraphiques;

import Fonctions.FCT_Fonctions;
import Scenes.Scene;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class EGRA_AnimatedImage extends EGRA_Image {
    protected int width;
    protected int height;
    protected boolean animate;
    protected Image renderImage;
    protected int renderIndex;
    
    public EGRA_AnimatedImage(Scene sceneOwner, String path) {
        super(sceneOwner, path);
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        init();
    }
    
    public EGRA_AnimatedImage(Scene sceneOwner, String path, int x, int y) {
        super(sceneOwner, path, x, y);
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        init();
    }
    
    public EGRA_AnimatedImage(Scene sceneOwner, String path, int x, int y, int width, int height) {
        super(sceneOwner, path, x, y);
        this.width = width;
        this.height = height;
        init();
    }
    
    private void init() {
        this.animate = true;
        this.renderImage = this.image.getSubImage(0, 0, this.width, this.height);
        this.renderIndex = 0;
    }
    
    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }
    public boolean isAnimate() { return this.animate; }
    
    public void setWidth(int width) { 
        this.width = width; 
        setRenderX();
    }
    
    public void setHeight(int height) { 
        this.height = height; 
        setRenderY();
    }
    
    public void isAnimate(boolean animate) { this.animate = animate; }
        
    @Override
    protected void setRenderX() {
        if (this.hAlign == EGRA_Types.HALIGN.LEFT) this.renderX = this.x;
        else if (this.hAlign == EGRA_Types.HALIGN.CENTER) this.renderX = this.x - (this.width / 2);
        else if (this.hAlign == EGRA_Types.HALIGN.RIGHT) this.renderX = this.x - this.width;
        else this.renderX = this.x;
    }
    
    @Override
    protected void setRenderY() {
        if (this.vAlign == EGRA_Types.VALIGN.TOP) this.renderY = this.y;
        else if (this.vAlign == EGRA_Types.VALIGN.MIDDLE) this.renderY = this.y - (this.height / 2);
        else if (this.vAlign == EGRA_Types.VALIGN.BOTTOM) this.renderY = this.y - this.height;
        else this.renderY = this.y;
    }
    
    @Override
    public void afficher(Graphics g) {
        if (this.visible) {
            changeRenderImage();
            g.drawImage(this.renderImage, this.renderX, this.renderY);
        }
    }
    
    public boolean changeRenderImage() {
        boolean result = false;
        int index = renderIndex;
        
        if (this.animate) {
            if (this.width * (this.renderIndex + 1) + this.width > this.image.getWidth()) this.renderIndex = 0;
            else this.renderIndex++;
        }
        else this.renderIndex = 0;
        
        if (index != renderIndex) {
            this.renderImage = this.image.getSubImage(this.width * this.renderIndex, 0, this.width, this.height);
            result = true;
        }
        
        return result;
    }
    
    @Override
    public boolean isHover(Input i) {
       if (this.visible && this.renderImage != null) {
           return FCT_Fonctions.testMouse(i, this.renderImage, this.renderX, this.renderY);
       } 
       else return false;
    }
}
