
package snake.scene;

import snake.graphics.Shape;
import snake.core.Direction;
import snake.graphics.Rect;
import java.awt.Color;
import snake.util.Constantes;
import snake.util.GameUtils;

public class Snake extends Shape{
	private Direction direction;
	
	
	
    public Snake(){
        super(Constantes.SNAKE_COLOR);
        
        direction = Direction.NONE;
        Rect rect = new Rect(Constantes.SNAKE_INITIAL_X,Constantes.SNAKE_INITIAL_Y,Constantes.SNAKE_PICE_SIZE, Constantes.SNAKE_PICE_SIZE);
        addRect(rect);
        
        for (int i = 1; i < Constantes.SNAKE_SIZE; i++){
            rect = duplicate(rect, Direction.LEFT);
            rect.setColor(Constantes.SNAKE_COLOR);
            addRect(rect);
            
        }
    }
    //Metodo de movimento de retangulos
    public void move(){
    	if(direction != Direction.NONE) {
    		 Rect head = getFirstRect();
    	        GameUtils.moveRect(getRects());
    	        Rect newHead = duplicate(head, direction);
    	        getRects().set(0, newHead);
    	}
       
    }
    
    
    
    public void up(){
    	if(direction.canChangeTo(Direction.UP)) {
    		 direction = Direction.UP;
    	}
       
    }
    
    public void down(){
    	if(direction.canChangeTo(Direction.DOWN)) {
    		direction = Direction.DOWN;
   	}
    	
    }
    
    public void left(){
    	if(direction.canChangeTo(Direction.LEFT)) {
    		direction = Direction.LEFT;
   	}
    	
    }
    
    public void right(){
    	if(direction.canChangeTo(Direction.RICHT)) {
    		direction = Direction.RICHT;
   	}
    	
    }
    
    //Metodo de colisão
    public boolean collidswithItself() {
		Rect head = getFirstRect();
		
		for(int i = 1; i < getRects().size(); i++) {
			Rect rect = getRects().get(i);
			if(head.intersects(rect)) {
				return true;
				
			}
		}
    	return false;
    }
    
}





