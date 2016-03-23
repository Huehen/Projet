package Scenes;

import Constantes.Ctes;
import ElementsGraphiques.EGRA_Object;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Scene implements Comparable<Scene> {
    public enum STATE {ON, FREEZE, FREEZE_NEXT, INVISIBLE, REFRESH};
    private Scene.STATE state;
    private int prio = 0;
    private Image sence;
    protected List<EGRA_Object> objectList = new ArrayList<>();
    
    public Scene() {
        state = Scene.STATE.ON;
        try {
            sence = new Image(Ctes.LARGEUR_ECRAN, Ctes.HAUTEUR_ECRAN);
        } catch (SlickException e) {
            Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    protected void customRender(GameContainer gc, Graphics g) throws SlickException {
        for (EGRA_Object o : objectList) o.afficher(g);
    }
    
    protected void customUpdate(GameContainer gc, int t) throws SlickException {
        for (EGRA_Object o : objectList) o.update(gc, t);
    }
    
    public void init(GameContainer gc) throws SlickException {}
    
    public void render(GameContainer gc, Graphics g) throws SlickException {
        if (state != Scene.STATE.INVISIBLE) {
            if (state == Scene.STATE.ON || state == Scene.STATE.REFRESH) customRender(gc, g);
            if (state == Scene.STATE.FREEZE_NEXT) {
                sence.getGraphics().clear();
                customRender(gc, sence.getGraphics());
                state = Scene.STATE.FREEZE;
            }
            if (state == Scene.STATE.FREEZE) g.drawImage(sence, 0, 0);
        }
    }
    
    public void update(GameContainer gc, int t) throws SlickException {
        if (state == Scene.STATE.ON) customUpdate(gc, t);
    }
    
    public void setPriority(int p) { prio = p; }
    
    @Override
    public String toString() {
        return "default";
    }
    
    public int getPriority() { return prio; }
    
    @Override
    //TODO : Commenter dans LibrairiePerso pour savoir si -1 traité avant ou après 0
    public int compareTo(Scene compareObject) {
        if (getPriority() < compareObject.getPriority()) return 1;
        else if (getPriority() == compareObject.getPriority()) return 0;
        else return -1;
    }
    
    public void setState(Scene.STATE s) { state = s; }
}