
package snake.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Renderer {
    private List<Drawable> drawables;
    public Renderer(){
        drawables = new ArrayList<>();
    }
    
    public void add(Drawable drawable){
        drawables.add(drawable);
    }
    
    public synchronized void remove(Drawable drawable){
        drawables.remove(drawable);
    }
    
    
    
    public synchronized void render(Graphics g){
        for (Drawable d : drawables){
            g.setColor(d.getColor());
            d.draw(g);
        }
    }
}
