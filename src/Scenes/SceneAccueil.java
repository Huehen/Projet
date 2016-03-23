package Scenes;

import Accueil.*;
import BDD.Requete;
import Constantes.Ctes;
import ElementsGraphiques.EGRA_Button;
import ElementsGraphiques.EGRA_EventSource;
import ElementsGraphiques.EGRA_Image;
import ElementsGraphiques.EGRA_Types;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class SceneAccueil extends Scene {
    
    public SceneAccueil() {
        super();
        setPriority(1);
    }
    
    @Override
    public String toString() { return "Accueil"; }
    
    @Override
    protected void customRender(GameContainer gc, Graphics g) throws SlickException {
        super.customRender(gc, g);
    }
    
    @Override
    protected void customUpdate(GameContainer gc, int t) throws SlickException {
        super.customUpdate(gc, t);
    }
    
    @Override
    public void init(GameContainer gc) throws SlickException {
        gc.getInput().clearKeyPressedRecord();
        InitializeInterface(gc.getGraphics());
    }
    
    private void InitializeInterface(Graphics g) {
        EGRA_Image Fond = new EGRA_Image(this, "Images\\Accueil\\Fond.png", 0, 0);
        this.objectList.add(Fond);
        
        EGRA_Button BtnNewGame = new EGRA_Button(this, g, Ctes.XMID_ECRAN, Ctes.ACC_Y_NEWGAME);
        BtnNewGame.setHAlign(EGRA_Types.HALIGN.CENTER);
        BtnNewGame.setImage(new EGRA_Image(this, "Images\\Accueil\\NewGame.png"));
        BtnNewGame.setImageHover(new EGRA_Image(this, "Images\\Accueil\\NewGame_Hover.png"));
        BtnNewGame.setOnClick(new EGRA_EventSource(new ACC_ListenerNewGame()));
        this.objectList.add(BtnNewGame);
        
        if (saveExist()) {
            EGRA_Button BtnContinue = new EGRA_Button(this, g, Ctes.XMID_ECRAN, Ctes.ACC_Y_CONTINUE);
            BtnContinue.setHAlign(EGRA_Types.HALIGN.CENTER);
            BtnContinue.setImage(new EGRA_Image(this, "Images\\Accueil\\Continue.png"));
            BtnContinue.setImageHover(new EGRA_Image(this, "Images\\Accueil\\Continue_Hover.png"));
            BtnContinue.setOnClick(new EGRA_EventSource(new ACC_ListenerContinue()));
            this.objectList.add(BtnContinue);
        } 
        else {
            EGRA_Image BtnContinueDisabled = new EGRA_Image(this, "Images\\Accueil\\Continue_Disabled.png", Ctes.XMID_ECRAN, Ctes.ACC_Y_CONTINUE);
            BtnContinueDisabled.setHAlign(EGRA_Types.HALIGN.CENTER);
            this.objectList.add(BtnContinueDisabled);
        }
        
        EGRA_Button BtnQuit = new EGRA_Button(this, g, Ctes.XMID_ECRAN, Ctes.ACC_Y_QUIT);
        BtnQuit.setHAlign(EGRA_Types.HALIGN.CENTER);
        BtnQuit.setImage(new EGRA_Image(this, "Images\\Accueil\\Quit.png"));
        BtnQuit.setImageHover(new EGRA_Image(this, "Images\\Accueil\\Quit_Hover.png"));
        BtnQuit.setOnClick(new EGRA_EventSource(new ACC_ListenerQuit()));
        this.objectList.add(BtnQuit);
    }
    
    public void newGame() {
        
    }
    
    public void continueGame() {
        
    }
    
    public void quit(GameContainer gc) {
        Main.Game.manager.removeAll();
        gc.exit();
    }
    
    private boolean saveExist() {
        boolean result = false;
        
        try {
            Requete rq = new Requete();
            ResultSet rs = rq.select("SELECT ID FROM SAVE;");
            int Count = 0;
            
            while (rs.next()) Count++;
            
            rq.closeDB();
            
            result = (Count > 0);
        } catch (SQLException ex) {
            Logger.getLogger(SceneAccueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
}