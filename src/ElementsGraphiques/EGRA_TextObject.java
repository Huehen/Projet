package ElementsGraphiques;

import Fonctions.FCT_Fonctions;
import Scenes.Scene;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class EGRA_TextObject extends EGRA_Object {
    protected String text;
    protected Color color;
    protected Font font;

    public EGRA_TextObject(Scene sceneOwner, Graphics g) {
        super(sceneOwner);
        init(g);
    }
    
    public EGRA_TextObject(Scene sceneOwner, Graphics g, String text) {
        super(sceneOwner);
        init(g);
        this.text = text;
    }
    
    private void init(Graphics g) {
        this.color = g.getColor();
        this.font = g.getFont();
        this.text = "";
    }
    
    public String getText() { return this.text; }
    public Color getColor() { return this.color; }
    public Font getFont() { return this.font; }
    public int getWidth() { return this.font.getWidth(this.text); }
    public int getHeight() { return this.font.getHeight(this.text); }
    
    public void setText(String text) {
        this.text = text;
        setRenderX();
        setRenderY();
    }
    
    public void setColor(Color color) { this.color = color; }
    
    public void setFont(Font font) { 
        this.font = font;
        setRenderX();
        setRenderY();
    }
    
    @Override
    protected void setRenderX() {
        if (this.hAlign == EGRA_Types.HALIGN.LEFT) this.renderX = this.x;
        else if (this.hAlign == EGRA_Types.HALIGN.CENTER) this.renderX = this.x - (getWidth()/ 2);
        else if (this.hAlign == EGRA_Types.HALIGN.RIGHT) this.renderX = this.x - getWidth();
        else this.renderX = this.x;
    }

    @Override
    protected void setRenderY() {
        if (this.vAlign == EGRA_Types.VALIGN.TOP) this.renderY = this.y;
        else if (this.vAlign == EGRA_Types.VALIGN.MIDDLE) this.renderY = this.y - (getHeight() / 2);
        else if (this.vAlign == EGRA_Types.VALIGN.BOTTOM) this.renderY = this.y - getHeight();
        else this.renderY = this.y;
    }
    
    @Override
    public void update(GameContainer gc, int t) {
        //Nothing to do
    }

    @Override
    public void afficher(Graphics g) {
        if (this.visible) {
            Color oldColor = g.getColor();
            Font oldFont = g.getFont();
            
            g.setColor(this.color);
            g.setFont(this.font);
            g.drawString(this.text, this.renderX, this.renderY);
            
            g.setColor(oldColor);
            g.setFont(oldFont);
        }
    }
    
    public boolean isHover(Input i) {
        if (this.visible) {
            return FCT_Fonctions.testMouse(i, this.renderX, this.renderY, getWidth(), getHeight());
        }
        else return false;
    }
}
