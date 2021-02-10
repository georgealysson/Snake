
package snake.scene;

import snake.graphics.Rect;
import java.awt.Color;
import snake.util.Constantes;

public class Background extends Rect{
    
    public Background() {
        super(0, 0, Constantes.WINDOW_WIDTH, Constantes.WINDOW_HEIGHT);
        setColor(Color.BLACK);
    }
    
}
