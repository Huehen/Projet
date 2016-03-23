package Personnages;

public class Personnage {
    private Equipe equipeOwner;
    
    public Personnage(Equipe equipeOwner) {
        this.equipeOwner = equipeOwner;
    }
    
    public Equipe getEquipeOwner() { return this.equipeOwner; }
    
    public void setEquipeOwner(Equipe equipeOwner) { this.equipeOwner = equipeOwner; }
}
