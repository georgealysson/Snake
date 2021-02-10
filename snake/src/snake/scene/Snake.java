
package snake.scene;

import snake.graphics.Shape;
import snake.graphics.Rect;
import java.awt.Color;
import snake.util.Constantes;

public class Snake extends Shape{
    public Snake(){
        super(Color.WHITE);
        
        Rect rect = new Rect(Constantes.SNAKE_INITIAL_X,Constantes.SNAKE_INITIAL_Y,Constantes.SNAKE_PICE_SIZE, Constantes.SNAKE_PICE_SIZE);
        addRect(rect);
        
        for (int i = 1; i < Constantes.SNAKE_SIZE; i++){
            rect = duplicate(rect);
            rect.setColor(Color.WHITE);
            addRect(rect);
            
        }
    }
    
    public void up(){
        System.out.println("Up");
    }
    
    public void down(){
        
    }
    
    public void left(){
        
    }
    
    public void right(){
        
    }
    
    public void escape(){
        
    }
}





