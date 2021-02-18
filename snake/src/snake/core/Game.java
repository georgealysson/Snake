
package snake.core;

import snake.scene.Background;
import snake.scene.Food;

import java.awt.Rectangle;

import snake.graphics.Rect;
import snake.graphics.Renderer;
import snake.scene.Snake;
import snake.util.Constantes;
import snake.util.GameUtils;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private Snake snake;
    private Food food;
    private Renderer renderer;
    
    public void start(){
        snake = new Snake();
        food = new Food();
        gameWindow = new GameWindow(snake); 
        renderer = gameWindow.getRenderer();
        addElementsToScreen();
        
        
        new Thread(this).start();
        
    }

    private void addElementsToScreen() {
        renderer.add(new Background());
        renderer.add(snake);
        renderer.add(food);
    }
    
    @Override
    public void run(){
        while (!isGameOuver()){
        	snake.move();
            gameWindow.repaint();
            GameUtils.sleep(30);
            
        }
        gameWindow.dispose();
    }
    
    private boolean isGameOuver(){
        return snake.collidswithItself() || isSnakeHitBounds();
    }
    
    private boolean isSnakeHitBounds() {
    	Rect head = snake.getFirstRect();
    	Rectangle drawingArea = gameWindow.getDrawingArea();
    	
    	int headX = (int) head.getLocation().getX();
    	int headY = (int) head.getLocation().getY();
    	
    	int areaX1 = (int) drawingArea.getMinX();
    	int areaY1 = (int) drawingArea.getMinY() - Constantes.SNAKE_PICE_SIZE * 2;
    	
    	int areaX2 = (int) drawingArea.getMaxX();
    	int areaY2 = (int) drawingArea.getMaxY();
    	
    	if(headX <= areaX1 || headX + Constantes.SNAKE_PICE_SIZE >= areaX2) {
    		return true;
    	}
    	
    	
    	if(headY <= areaY1 || headY + Constantes.SNAKE_PICE_SIZE >= areaY2) {
    		return true;
    	}
    	return false;
    	
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
