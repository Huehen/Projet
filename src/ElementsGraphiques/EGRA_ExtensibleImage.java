package ElementsGraphiques;

import Fonctions.FCT_Fonctions;
import Scenes.Scene;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class EGRA_ExtensibleImage extends EGRA_AnimatedImage {
    protected int extendedWidth;
    protected int extendedHeight;
    protected Image leftImg;
    protected Image rightImg;
    protected Image centerImg;
    protected Image topLeftImg;
    protected Image bottomLeftImg;
    protected Image middleLeftImg;
    protected Image topCenterImg;
    protected Image bottomCenterImg;
    protected Image middleCenterImg;
    protected Image topRightImg;
    protected Image bottomRightImg;
    protected Image middleRightImg;
    protected boolean isExtended;
    protected boolean isExtendedWidth;
    protected boolean isExtendedHeight;
    protected int leftWidth;
    protected int rightWidth;
    protected int topHeight;
    protected int bottomHeight;
    
    public EGRA_ExtensibleImage(Scene sceneOwner, String path) {
        super(sceneOwner, path);
        init();
        this.extendedWidth = this.width;
        this.extendedHeight = this.height;
    }
    
    public EGRA_ExtensibleImage(Scene sceneOwner, String path, int width, int height) {
        super(sceneOwner, path, width, height);
        init();
        this.extendedWidth = this.width;
        this.extendedHeight = this.height;
    }
    
    public EGRA_ExtensibleImage(Scene sceneOwner, String path, int width, int height, int extendedWidth, int extendedHeight) {
        super(sceneOwner, path, width, height);
        init();
        this.extendedWidth = extendedWidth;
        this.extendedHeight = extendedHeight;
    }
    
    private void init() {
        this.leftImg = null;
        this.rightImg = null;
        this.centerImg = null;
        this.topLeftImg = null;
        this.topCenterImg = null;
        this.topRightImg = null;
        this.middleLeftImg = null;
        this.middleCenterImg = null;
        this.middleRightImg = null;
        this.bottomLeftImg = null;
        this.bottomCenterImg = null;
        this.bottomRightImg = null;
        this.isExtended = false;
        this.isExtendedWidth = false;
        this.isExtendedHeight = false;
        this.leftWidth = 0;
        this.rightWidth = 0;
        this.topHeight = 0;
        this.bottomHeight = 0;
        this.animate = false;
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
        this.isExtended = false;
    }
    
    public void setExtendedHeight(int extendedHeight) { 
        this.extendedHeight = extendedHeight; 
        setRenderY();
        this.isExtended = false;
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
        if (changeRenderImage() || !this.isExtended) extendsRenderImage();
        if (this.isExtendedWidth && !this.isExtendedHeight) {
            int nbDup = (this.extendedWidth - this.leftWidth - this.rightWidth) / this.centerImg.getWidth();
            g.drawImage(this.leftImg, this.renderX, this.renderY);
            for (int i = 0 ; i < nbDup ; i++) 
                g.drawImage(this.centerImg, this.renderX + this.leftWidth + (i * this.centerImg.getWidth()), this.renderY);
            g.drawImage(this.centerImg, this.renderX + this.extendedWidth - this.rightWidth - this.centerImg.getWidth(), this.renderY);
            g.drawImage(this.rightImg, this.renderX + (this.extendedWidth - this.rightWidth), this.renderY);
        }
        else if (this.isExtendedHeight) {
            int nbDupHeight = (this.extendedHeight - this.topHeight - this.bottomHeight) / this.middleLeftImg.getHeight();
            g.drawImage(this.topLeftImg, this.renderX, this.renderY);
            for (int i = 0 ; i < nbDupHeight ; i++)
                g.drawImage(this.middleLeftImg, this.renderX, this.renderY + this.topHeight + (i * this.middleLeftImg.getHeight()));
            g.drawImage(this.middleLeftImg, this.renderX, this.renderY + this.extendedHeight - this.bottomHeight - this.middleLeftImg.getHeight());
            g.drawImage(this.bottomLeftImg, this.renderX, this.renderY + (this.extendedHeight - this.bottomHeight));
            if (this.isExtendedWidth) {
                int nbDupWidth = (this.extendedWidth - this.leftWidth - this.rightWidth) / this.topCenterImg.getWidth();
                for (int j = 0 ; j < nbDupWidth ; j++) {
                    g.drawImage(this.topCenterImg, this.renderX + this.leftWidth + (j * this.topCenterImg.getWidth()), this.renderY);
                    g.drawImage(this.bottomCenterImg, this.renderX + this.leftWidth + (j * this.topCenterImg.getWidth()), this.renderY + this.extendedHeight - this.bottomHeight);
                    for (int i = 0 ; i < nbDupHeight ; i++) 
                        g.drawImage(this.middleCenterImg, this.renderX + this.leftWidth + (j * this.topCenterImg.getWidth()), this.renderY + this.topHeight + (i * this.middleCenterImg.getHeight()));
                    g.drawImage(this.middleCenterImg, this.renderX + this.leftWidth + (j * this.topCenterImg.getWidth()), this.renderY + this.extendedHeight - this.bottomHeight - this.middleCenterImg.getHeight());
                }
                g.drawImage(this.topCenterImg, this.renderX + this.extendedWidth - this.rightWidth - this.topCenterImg.getWidth(), this.renderY);
                g.drawImage(this.bottomCenterImg, this.renderX + this.extendedWidth - this.rightWidth - this.bottomCenterImg.getWidth(), this.renderY + this.extendedHeight - this.bottomHeight);
                for (int i = 0 ; i < nbDupHeight ; i++) 
                    g.drawImage(this.middleCenterImg, this.renderX + this.extendedWidth - this.rightWidth - this.bottomCenterImg.getWidth(), this.renderY + this.topHeight + (i * this.middleCenterImg.getHeight()));
                g.drawImage(this.middleCenterImg, this.renderX + this.extendedWidth - this.rightWidth - this.bottomCenterImg.getWidth(), this.renderY + this.extendedHeight - this.bottomHeight - this.middleCenterImg.getHeight());

                g.drawImage(this.topRightImg, this.renderX + (this.extendedWidth - this.rightWidth), this.renderY);
                for (int i = 0 ; i < nbDupHeight ; i++)
                    g.drawImage(this.middleRightImg, this.renderX + (this.extendedWidth - this.rightWidth), this.renderY + this.topHeight + (i * this.middleRightImg.getHeight()));
                g.drawImage(this.middleRightImg, this.renderX + (this.extendedWidth - this.rightWidth), this.renderY + this.extendedHeight - this.bottomHeight - this.middleRightImg.getHeight());
                g.drawImage(this.bottomRightImg, this.renderX + (this.extendedWidth - this.rightWidth), this.renderY + this.extendedHeight - this.bottomHeight);
            }
        }
        else g.drawImage(this.renderImage, this.renderX, this.renderY);
    }
    
    public void extendsRenderImage() {
        this.isExtendedWidth = false;
        this.isExtendedHeight = false;
        if (this.extendedWidth > this.width) {
            this.leftImg = this.renderImage.getSubImage(0, 0, this.leftWidth, this.height);
            this.centerImg = this.renderImage.getSubImage(this.leftWidth, 0, this.width - this.rightWidth - this.leftWidth, this.height);
            this.rightImg = this.renderImage.getSubImage(this.width - this.leftWidth, 0, this.leftWidth, this.height);
            this.isExtendedWidth = true;
        }

        if (this.extendedHeight > this.height) {
            if (this.isExtendedWidth) {
                this.topLeftImg = this.leftImg.getSubImage(0, 0, this.leftImg.getWidth(), this.topHeight);
                this.topCenterImg = this.centerImg.getSubImage(0, 0, this.centerImg.getWidth(), this.topHeight);
                this.topRightImg = this.rightImg.getSubImage(0, 0, this.rightImg.getWidth(), this.topHeight);
                this.middleLeftImg = this.leftImg.getSubImage(0, this.topHeight, this.leftImg.getWidth(), this.height - this.topHeight - this.bottomHeight);
                this.middleCenterImg = this.centerImg.getSubImage(0, this.topHeight, this.centerImg.getWidth(), this.height - this.topHeight - this.bottomHeight);
                this.middleRightImg = this.rightImg.getSubImage(0, this.topHeight, this.rightImg.getWidth(), this.height - this.topHeight - this.bottomHeight);
                this.bottomLeftImg = this.leftImg.getSubImage(0, this.height - this.bottomHeight, this.leftImg.getWidth(), this.bottomHeight);
                this.bottomCenterImg = this.centerImg.getSubImage(0, this.height - this.bottomHeight, this.centerImg.getWidth(), this.bottomHeight);
                this.bottomRightImg = this.rightImg.getSubImage(0, this.height - this.bottomHeight, this.rightImg.getWidth(), this.bottomHeight);
            }
            else {
                this.topLeftImg = this.renderImage.getSubImage(0, 0, this.width, this.topHeight);
                this.middleLeftImg = this.renderImage.getSubImage(0, this.topHeight, this.width, this.height - this.topHeight);
                this.bottomLeftImg = this.renderImage.getSubImage(0, this.height - this.bottomHeight, this.width, this.bottomHeight);
            }
            this.isExtendedHeight = true;
        }
        this.isExtended = true;
    }
    
    @Override
    public boolean isHover(Input i) {
        return this.visible && FCT_Fonctions.testMouse(i, this.renderX, this.renderY, this.extendedWidth, this.extendedHeight);
    }
}
