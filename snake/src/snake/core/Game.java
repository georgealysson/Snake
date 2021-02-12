
package snake.core;

import snake.scene.Background;
import snake.graphics.Renderer;
import snake.scene.Snake;
import snake.util.GameUtils;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private Snake snake;
    private Renderer renderer;
    
    public void start(){
        snake = new Snake();
        gameWindow = new GameWindow(snake); 
        renderer = gameWindow.getRenderer();
        addElementsToScreen();
        
        
        new Thread(this).start();
        
    }

    private void addElementsToScreen() {
        renderer.add(new Background());
        renderer.add(snake);
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
        return snake.collidswithItself();
    }
}
