
package snake.core;

import snake.scene.Background;
import snake.graphics.Renderer;
import snake.scene.Snake;

public class Game {
    private GameWindow gameWindow;
    private Snake snake;
    private Renderer renderer;
    
    public void start(){
        snake = new Snake();
        gameWindow = new GameWindow(snake);
        
        
        renderer = gameWindow.getRenderer();
        addElementsToScreen();
        
        run();
    }

    private void addElementsToScreen() {
        renderer.add(new Background());
        renderer.add(snake);
    }
    
    public void run(){
        while (!isGameOuver()){
            gameWindow.repaint();
        }
    }
    
    private boolean isGameOuver(){
        return false;
    }
}
