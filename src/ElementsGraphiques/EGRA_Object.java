package ElementsGraphiques;

import Scenes.Scene;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class EGRA_Object {
    protected EGRA_Object owner;
    protected int x;
    protected int y;
    protected boolean visible;
    protected EGRA_Types.HALIGN hAlign;
    protected EGRA_Types.VALIGN vAlign;
    protected int renderX;
    protected int renderY;
    protected Scene sceneOwner;
    
    public EGRA_Object() {
        this.x = 0;
        this.y = 0;
        init();
    }
    
    public EGRA_Object(Scene sceneOwner) {
        this.x = 0;
        this.y = 0;
        init();
        this.sceneOwner = sceneOwner;
    }
    
    public EGRA_Object(Scene sceneOwner, int x, int y) {
        this.x = x;
        this.y = y;
        init();
        this.sceneOwner = sceneOwner;
    }
    
    private void init() {
        this.owner = null;
        this.visible = true;
        this.hAlign = EGRA_Types.HALIGN.LEFT;
        this.vAlign = EGRA_Types.VALIGN.TOP;
        this.renderX = this.x;
        this.renderY = this.y;
        this.sceneOwner = null;
    }
    
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public boolean isVisible() { return this.visible; }
    public EGRA_Types.HALIGN getHAlign() { return this.hAlign; }
    public EGRA_Types.VALIGN getVAlign() { return this.vAlign; }
    public EGRA_Object getOwner() { return this.owner; }
    public Scene getSceneOwner() { return this.sceneOwner; }
     
    public void setX(int x) { 
        this.x = x; 
        setRenderX();
    }
    
    public void setY(int y) { 
        this.y = y; 
        setRenderY();
    }
    
    public void setVisible(boolean visible) { this.visible = visible; }
    
    public void setHAlign(EGRA_Types.HALIGN hAlign) { 
        this.hAlign = hAlign; 
        setRenderX();
    }
    
    public void setVAlign(EGRA_Types.VALIGN vAlign) { 
        this.vAlign = vAlign; 
        setRenderY();
    }
    
    public void setOwner(EGRA_Object owner) { this.owner = owner; }
    public void setSceneOwner(Scene SceneOwner) { this.sceneOwner = SceneOwner; }
    
    public abstract void update(GameContainer gc, int t);
    public abstract void afficher(Graphics g);
    protected abstract void setRenderX();
    protected abstract void setRenderY();
}
