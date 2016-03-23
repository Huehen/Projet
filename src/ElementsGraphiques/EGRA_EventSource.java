package ElementsGraphiques;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.newdawn.slick.GameContainer;

public class EGRA_EventSource {
    private List<EGRA_EventListener> listeners = new ArrayList<>();
    private EGRA_Object sender;
    
    public EGRA_EventSource() {
        this.sender = null;
    }
    
    public EGRA_EventSource(EGRA_EventListener listener) {
        this.sender = null;
        this.addEventListener(listener);
    }
    
    public void setSender(EGRA_Object sender) {
        this.sender = sender;
    }
    
    public EGRA_Object getSender() { return this.sender; }
    
    public synchronized void addEventListener(EGRA_EventListener listener) {
        listeners.add(listener);
    }
    
    public synchronized void removeEventListener(EGRA_EventListener listener) {
        listeners.remove(listener);
    }
    
    public synchronized void fireEvent(EGRA_Object sender, GameContainer gc, int t) {
        Iterator i = listeners.iterator();
        while (i.hasNext()) {
            ((EGRA_EventListener) i.next()).onClick(sender, gc, t);
        }
    }
}
