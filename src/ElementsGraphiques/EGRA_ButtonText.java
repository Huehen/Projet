package ElementsGraphiques;

import Scenes.Scene;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;

public class EGRA_ButtonText extends EGRA_TextObject {
    public EGRA_ButtonText(Scene sceneOwner, Graphics g) {
        super(sceneOwner, g);
    }
    
    public EGRA_ButtonText(Scene sceneOwner, Graphics g, String text) {
        super(sceneOwner, g, text);
    }
    
    @Override
    public void setText(String text) {
        super.setText(text);
        onModifyText();
    }
    
    @Override
    public void setFont(Font font) { 
        super.setFont(font);
        onModifyText();
    }
    
    private void onModifyText() {
        if (this.owner != null) {
            if (this.owner instanceof EGRA_Button) {
                EGRA_Button button = (EGRA_Button)this.owner;
                if (button.isAutoFit()) {
                    button.resizeImages();
                }
            }
        }
    }
}
