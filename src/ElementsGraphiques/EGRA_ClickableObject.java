package ElementsGraphiques;

import Scenes.Scene;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public abstract class EGRA_ClickableObject extends EGRA_Object {
    protected EGRA_Image image;
    protected EGRA_Image imageHover;
    protected EGRA_TextObject text;
    protected EGRA_TextObject textHover;
    protected boolean hover;
    protected EGRA_EventSource onClick;

    public EGRA_ClickableObject(Scene sceneOwner, Graphics g) {
        super(sceneOwner);
        init(g);
    }
    
    public EGRA_ClickableObject(Scene sceneOwner, Graphics g, int x, int y) {
        super(sceneOwner, x, y);
        init(g);
    }
    
    public EGRA_ClickableObject(Scene sceneOwner, Graphics g, int x, int y, String text) {
        super(sceneOwner, x, y);
        init(g);
    }
    
    private void init(Graphics g) {
        this.image = null;
        this.imageHover = null;
        this.text = new EGRA_TextObject(this.sceneOwner, g);
        this.textHover = new EGRA_TextObject(this.sceneOwner, g);
        this.hover = false;
        this.onClick = new EGRA_EventSource();
    }
    
    public EGRA_Image getImage() { return this.image; }
    public EGRA_Image getImageHover() { return this.imageHover; }
    public EGRA_TextObject getText() { return this.text; }
    public EGRA_TextObject getTextHover() { return this.textHover; }
    public boolean isHover() { return this.hover; }
    public EGRA_EventSource getOnClick() { return this.onClick; }
    
    @Override
    public void setX(int x) {
        super.setX(x);
        if (this.image != null) this.image.setX(x);
        if (this.imageHover != null) this.imageHover.setX(x);
        if (this.text != null) this.text.setX(x);
        if (this.textHover != null) this.textHover.setX(x);
    }
    
    @Override
    public void setY(int y) {
        super.setY(y);
        if (this.image != null) this.image.setY(y);
        if (this.imageHover != null) this.imageHover.setY(y);
        if (this.text != null) this.text.setY(y);
        if (this.textHover != null) this.textHover.setY(y);
    }
    
    @Override
    public void setHAlign(EGRA_Types.HALIGN hAlign) { 
        super.setHAlign(hAlign);
        if (this.image != null) this.image.setHAlign(hAlign);
        if (this.imageHover != null) this.imageHover.setHAlign(hAlign);
        if (this.text != null) this.text.setHAlign(hAlign);
        if (this.textHover != null) this.textHover.setHAlign(hAlign);
    }
    
    @Override
    public void setVAlign(EGRA_Types.VALIGN vAlign) { 
        super.setVAlign(vAlign);
        if (this.image != null) this.image.setVAlign(vAlign);
        if (this.imageHover != null) this.imageHover.setVAlign(vAlign);
        if (this.text != null) this.text.setVAlign(vAlign);
        if (this.textHover != null) this.textHover.setVAlign(vAlign);
    }
    
    public void setImage(EGRA_Image image) { 
        this.image = image;
        if (this.image != null) {
            this.image.setHAlign(this.getHAlign());
            this.image.setVAlign(this.getVAlign());
            this.image.setX(this.getX());
            this.image.setY(this.getY());
        }
        image.setOwner(this);
    }
    
    public void setImageHover(EGRA_Image imageHover) { 
        this.imageHover = imageHover;
        if (this.imageHover != null) {
            this.imageHover.setHAlign(this.getHAlign());
            this.imageHover.setVAlign(this.getVAlign());
            this.imageHover.setX(this.getX());
            this.imageHover.setY(this.getY());
        }
        imageHover.setOwner(this);
    }
    
    public void setText(EGRA_TextObject text) { 
        this.text = text;
        text.setOwner(this);
    }
    
    public void setTextHover(EGRA_TextObject textHover) { 
        this.textHover = textHover;
        textHover.setOwner(this);
    }
    
    public void setOnClick(EGRA_EventSource onClick) { 
        this.onClick = onClick;
        this.onClick.setSender(this);
    }
    
    @Override
    protected void setRenderX() {
        //Nothing to do
    }

    @Override
    protected void setRenderY() {
        //Nothing to do
    }
    
    @Override
    public void update(GameContainer gc, int t) {
        Input i = gc.getInput();
        boolean testHover = false;
        
        if (this.visible) {
            if (this.hover) {
                if (this.imageHover != null) testHover = testHover || this.imageHover.isHover(i);
                if (this.textHover != null) testHover = testHover || this.textHover.isHover(i);
                if (!testHover) this.hover = false;
            }
            else {
                if (this.imageHover != null) testHover = testHover || this.image.isHover(i);
                if (this.textHover != null) testHover = testHover || this.text.isHover(i);
                if (testHover) this.hover = true;
            }
            
            if (this.hover && i.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                if (this.onClick != null) this.onClick.fireEvent(this, gc, t);
            }
        }
    }

    @Override
    public void afficher(Graphics g) {
        if (this.visible) {
            if (this.hover) {
                if (this.imageHover != null) this.imageHover.afficher(g);
                if (this.textHover != null) this.textHover.afficher(g);
            }
            else {
                if (this.image != null) this.image.afficher(g);
                if (this.text != null) this.text.afficher(g);
            }
        }
    }
}
