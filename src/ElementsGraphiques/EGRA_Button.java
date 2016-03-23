package ElementsGraphiques;

import Scenes.Scene;
import org.newdawn.slick.Graphics;

public class EGRA_Button extends EGRA_ClickableObject {
    protected boolean autoFit;
    protected int paddingH;
    protected int paddingV;
    
    public EGRA_Button(Scene sceneOwner, Graphics g) {
        super(sceneOwner, g);
        init();
    }
    
    public EGRA_Button(Scene sceneOwner, Graphics g, int x, int y) {
        super(sceneOwner, g, x, y);
        init();
    }

    public EGRA_Button(Scene sceneOwner, Graphics g, int x, int y, String text) {
        super(sceneOwner, g, x, y, text);
        init();
    }
    
    private void init() {
        this.autoFit = true;
        this.paddingH = 5;
        this.paddingV = 5;
    }
    
    @Override
    public EGRA_ButtonText getText() { return (EGRA_ButtonText)super.getText(); }
    
    @Override
    public EGRA_ButtonText getTextHover() { return (EGRA_ButtonText)super.getTextHover(); }
    
    public boolean isAutoFit() { return this.autoFit; }
    public int getPaddingH() { return this.paddingH; }
    public int getPaddingV() { return this.paddingV; }
    
    @Override
    public void setText(EGRA_TextObject text) { 
        if (!(text instanceof EGRA_ButtonText)) {
            EGRA_ButtonText buttonText = (EGRA_ButtonText)text;
            text = buttonText;
        }
        super.setText(text);
        if (this.autoFit) resizeImages();
    }
    
    @Override
    public void setTextHover(EGRA_TextObject textHover) {
        if (!(textHover instanceof EGRA_ButtonText)) {
            EGRA_ButtonText buttonText = (EGRA_ButtonText)textHover;
            textHover = buttonText;
        }
        super.setTextHover(textHover);
        if (this.autoFit) resizeImages();
    }
    
    public void isAutoFit(boolean autoFit) { this.autoFit = autoFit; }
    public void setPaddingH(int paddingH) { 
        this.paddingH = paddingH;
        if (this.autoFit) resizeImages();
    }
    
    public void setPaddingV(int paddingV) { 
        this.paddingV = paddingV;
        if (this.autoFit) resizeImages();
    }
    
    public void setPadding(int padding) {
        this.paddingH = padding;
        this.paddingV = padding;
        if (this.autoFit) resizeImages();
    }
    
    public void resizeImages() {
        if (this.text != null && this.image != null) {
            if (this.image instanceof EGRA_ExtensibleImage) {
                EGRA_ExtensibleImage extImage = (EGRA_ExtensibleImage)this.image;
                extImage.setExtendedWidth(this.text.getWidth() + extImage.getLeftWidth() + extImage.getRightWidth() + 2 * this.paddingH);
                extImage.setExtendedHeight(this.text.getHeight()+ extImage.getTopHeight()+ extImage.getBottomHeight()+ 2 * this.paddingV);
            }
        }
    }
}
