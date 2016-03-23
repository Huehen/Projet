package Fonctions;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class FCT_Fonctions {
    private static FCT_Fonctions instance = null;
    
    private FCT_Fonctions() {}
    
    public static synchronized FCT_Fonctions getInstance() {
        if (instance == null) instance = new FCT_Fonctions();
        return instance;
    }
    
    public static boolean testMouse(Input in, Image img, int x, int y) {
        return (in.getMouseX() > x && in.getMouseX() < x + img.getWidth() && in.getMouseY() > y && 
                in.getMouseY() < y + img.getHeight());
    }
    
    public static boolean testMouse(Input in, int x, int y, int width, int height) {
        return (in.getMouseX() > x && in.getMouseX() < x + width && in.getMouseY() > y && 
                in.getMouseY() < y + height);
    }
    
    public static void nextAlphaClignotement(Image img) {
        float alpha = img.getAlpha();
        
        if (alpha == 0f) img.setAlpha(0.01f);
        else if (alpha == 0.99f) img.setAlpha(1f);
        else if (alpha % 0.02f == 0f) img.setAlpha(alpha - 0.02f);
        else img.setAlpha(alpha + 0.02f);
    }
    
    public static String getCharFromInput(Input i) {
        if (i.isKeyPressed(Input.KEY_NUMPAD0)) return "0";
        else if (i.isKeyPressed(Input.KEY_NUMPAD1)) return "1";
        else if (i.isKeyPressed(Input.KEY_NUMPAD2)) return "2";
        else if (i.isKeyPressed(Input.KEY_NUMPAD3)) return "3";
        else if (i.isKeyPressed(Input.KEY_NUMPAD4)) return "4";
        else if (i.isKeyPressed(Input.KEY_NUMPAD5)) return "5";
        else if (i.isKeyPressed(Input.KEY_NUMPAD6)) return "6";
        else if (i.isKeyPressed(Input.KEY_NUMPAD7)) return "7";
        else if (i.isKeyPressed(Input.KEY_NUMPAD8)) return "8";
        else if (i.isKeyPressed(Input.KEY_NUMPAD9)) return "9";
        else if (i.isKeyPressed(Input.KEY_A)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "A";
            else return "a";
        }
        else if (i.isKeyPressed(Input.KEY_B)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "B";
            else return "b";
        }
        else if (i.isKeyPressed(Input.KEY_C)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "C";
            else return "c";
        }
        else if (i.isKeyPressed(Input.KEY_D)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "D";
            else return "d";
        }
        else if (i.isKeyPressed(Input.KEY_E)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "E";
            else return "e";
        }
        else if (i.isKeyPressed(Input.KEY_F)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "F";
            else return "f";
        }
        else if (i.isKeyPressed(Input.KEY_G)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "G";
            else return "g";
        }
        else if (i.isKeyPressed(Input.KEY_H)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "H";
            else return "h";
        }
        else if (i.isKeyPressed(Input.KEY_I)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "I";
            else return "i";
        }
        else if (i.isKeyPressed(Input.KEY_J)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "J";
            else return "j";
        }
        else if (i.isKeyPressed(Input.KEY_K)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "K";
            else return "k";
        }
        else if (i.isKeyPressed(Input.KEY_L)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "L";
            else return "l";
        }
        else if (i.isKeyPressed(Input.KEY_M)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "M";
            else return "m";
        }
        else if (i.isKeyPressed(Input.KEY_N)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "N";
            else return "n";
        }
        else if (i.isKeyPressed(Input.KEY_O)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "O";
            else return "o";
        }
        else if (i.isKeyPressed(Input.KEY_P)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "P";
            else return "p";
        }
        else if (i.isKeyPressed(Input.KEY_Q)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "Q";
            else return "q";
        }
        else if (i.isKeyPressed(Input.KEY_R)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "R";
            else return "r";
        }
        else if (i.isKeyPressed(Input.KEY_S)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "S";
            else return "s";
        }
        else if (i.isKeyPressed(Input.KEY_T)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "T";
            else return "t";
        }
        else if (i.isKeyPressed(Input.KEY_U)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "U";
            else return "u";
        }
        else if (i.isKeyPressed(Input.KEY_V)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "V";
            else return "v";
        }
        else if (i.isKeyPressed(Input.KEY_W)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "W";
            else return "w";
        }
        else if (i.isKeyPressed(Input.KEY_X)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "X";
            else return "x";
        }
        else if (i.isKeyPressed(Input.KEY_Y)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "Y";
            else return "y";
        }
        else if (i.isKeyPressed(Input.KEY_Z)) {
            if (i.isKeyDown(Input.KEY_LSHIFT) || i.isKeyDown(Input.KEY_RSHIFT)) return "Z";
            else return "z";
        }
        else if (i.isKeyPressed(Input.KEY_SPACE)) return " ";
        else return "";
    }    
}
