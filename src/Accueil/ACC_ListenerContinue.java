package Accueil;

import ElementsGraphiques.EGRA_EventListener;
import ElementsGraphiques.EGRA_Object;
import Scenes.SceneAccueil;
import org.newdawn.slick.GameContainer;

public class ACC_ListenerContinue implements EGRA_EventListener {
    @Override
    public void onClick(EGRA_Object sender, GameContainer gc, int t) {
        SceneAccueil scene = (SceneAccueil)sender.getSceneOwner();
        scene.continueGame();
    }
    
}
