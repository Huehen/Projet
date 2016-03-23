package ElementsGraphiques;

import Fonctions.FCT_Fonctions;
import Scenes.Scene;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class EGRA_ExtensibleImageEx extends EGRA_AnimatedImage {
    protected int extendedWidth;
    protected int extendedHeight;
    protected Image leftImg;
    protected Image rightImg;
    protected Image centerImg;
    protected Image topImg;
    protected Image bottomImg;
    protected Image middleImg;
    protected boolean extended;
    protected int leftWidth;
    protected int rightWidth;
    protected int topHeight;
    protected int bottomHeight;
    protected Image extendedImage;
    protected Image transpImage;
    
    public EGRA_ExtensibleImageEx(Scene sceneOwner, String path) {
        super(sceneOwner, path);
        init();
        this.extendedWidth = this.width;
        this.extendedHeight = this.height;
    }
    
    public EGRA_ExtensibleImageEx(Scene sceneOwner, String path, int x, int y) {
        super(sceneOwner, path, x, y);
        init();
        this.extendedWidth = this.width;
        this.extendedHeight = this.height;
    }
    
    public EGRA_ExtensibleImageEx(Scene sceneOwner, String path, int x, int y, int width, int height) {
        super(sceneOwner, path, x, y, width, height);
        init();
        this.extendedWidth = this.width;
        this.extendedHeight = this.height;
    }
    
    public EGRA_ExtensibleImageEx(Scene sceneOwner, String path, int x, int y, int width, int height, int extendedWidth, int extendedHeight) {
        super(sceneOwner, path, x, y, width, height);
        init();
        this.extendedWidth = extendedWidth;
        this.extendedHeight = extendedHeight;
    }
    
    private void init() {
        try {
            this.leftImg = null;
            this.rightImg = null;
            this.centerImg = null;
            this.topImg = null;
            this.rightImg = null;
            this.middleImg = null;
            this.extended = false;
            this.leftWidth = 0;
            this.rightWidth = 0;
            this.topHeight = 0;
            this.bottomHeight = 0;
            this.extendedImage = null;
            this.animate = false;
            this.transpImage = new Image("ressources/common/transp1x1.png");
        } catch (SlickException ex) {
            Logger.getLogger(EGRA_ExtensibleImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getExtendedWidth() { return this.extendedWidth; }
    public int getExtendedHeight() { return this.extendedHeight; }
    public int getLeftWidth() { return this.leftWidth; }
    public int getRightWidth() { return this.rightWidth; }
    public int getTopHeight() { return this.topHeight; }
    public int getBottomHeight() { return this.bottomHeight; }
    
    public void setExtendedWidth(int extendedWidth) { 
        this.extendedWidth = extendedWidth; 
        setRenderX();
    }
    
    public void setExtendedHeight(int extendedHeight) { 
        this.extendedHeight = extendedHeight; 
        setRenderY();
    }
    
    public void setLeftWidth(int leftWidth) { this.leftWidth = leftWidth; }
    public void setRightWidth(int rightWidth) { this.rightWidth = rightWidth; }
    public void setTopHeight(int topHeight) { this.topHeight = topHeight; }
    public void setBottomHeight(int bottomHeight) { this.bottomHeight = bottomHeight; }
        
    @Override
    protected void setRenderX() {
        if (this.hAlign == EGRA_Types.HALIGN.LEFT) this.renderX = this.x;
        else if (this.hAlign == EGRA_Types.HALIGN.CENTER) this.renderX = this.x - (this.extendedWidth / 2);
        else if (this.hAlign == EGRA_Types.HALIGN.RIGHT) this.renderX = this.x - this.extendedWidth;
        else this.renderX = this.x;
    }
    
    @Override
    protected void setRenderY() {
        if (this.vAlign == EGRA_Types.VALIGN.TOP) this.renderY = this.y;
        else if (this.vAlign == EGRA_Types.VALIGN.MIDDLE) this.renderY = this.y - (this.extendedHeight / 2);
        else if (this.vAlign == EGRA_Types.VALIGN.BOTTOM) this.renderY = this.y - this.extendedHeight;
        else this.renderY = this.y;
    }
    
    @Override
    public void afficher(Graphics g) {
        if (this.visible) {
            if (changeRenderImage() || this.extendedImage == null) extendsRenderImage();

            g.drawImage(this.extendedImage, this.renderX, this.renderY);
        }
    }
    
    public void extendsRenderImage() {
        try {
            this.extendedImage = this.extendedImage.getScaledCopy(this.extendedWidth, this.extendedHeight);
            this.extendedImage.startUse();
            Graphics g;
            if (this.extendedWidth > this.width) {
                this.leftImg = this.renderImage.getSubImage(0, 0, this.leftWidth, this.height);
                this.centerImg = this.renderImage.getSubImage(this.leftWidth, 0, this.width - this.leftWidth, this.height);
                this.rightImg = this.renderImage.getSubImage(this.width - this.leftWidth, 0, this.leftWidth, this.height);
                
                g = this.extendedImage.getGraphics();
                g.drawImage(this.leftImg, 0, 0);
                g.drawImage(this.centerImg, this.leftWidth, 0);
                g.drawImage(this.rightImg, this.width - this.leftWidth, 0);
                
                this.extended = true;
            }
            else this.extendedImage = this.renderImage;
            if (this.extendedHeight > this.height) {
                this.topImg = this.extendedImage.getSubImage(0, 0, this.width, this.topHeight);
                this.middleImg = this.extendedImage.getSubImage(0, this.topHeight, this.width, this.height - this.bottomHeight);
                this.bottomImg = this.extendedImage.getSubImage(0, this.height - bottomHeight, this.width, this.bottomHeight);
                g = this.extendedImage.getGraphics();
                g.drawImage(this.topImg, 0, 0);
                g.drawImage(this.middleImg, 0, this.topHeight);
                g.drawImage(this.bottomImg, 0, this.height - this.topHeight);
                this.extended = true;
            }
        } catch (SlickException ex) {
            Logger.getLogger(EGRA_ExtensibleImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean isHover(Input i) {
       if (this.visible && this.extendedImage != null) {
           return FCT_Fonctions.testMouse(i, this.extendedImage, this.renderX, this.renderY);
       } 
       else return false;
    }
}
