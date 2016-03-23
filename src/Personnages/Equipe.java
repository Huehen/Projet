package Personnages;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private int xp;
    private int niveau;
    private List<Personnage> personnages;
    
    public Equipe() {
        this.xp = 0;
        this.niveau = 1;
        this.personnages = new ArrayList<>();
    }
}
