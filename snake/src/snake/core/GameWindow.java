
package snake.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import snake.util.Constantes;
import snake.graphics.Renderer;
import snake.scene.Snake;

public class GameWindow extends JFrame implements KeyListener{
    private Renderer renderer;
    private Snake snake;
    
    //Construct
    public GameWindow(Snake snake){
        renderer = new Renderer();
        this.snake = snake;
        
        setTitle(Constantes.GAME_TITLE);
        setSize(Constantes.WINDOW_WIDTH, Constantes.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        renderer.render(g);
    }
    
      @Override
      //Receber tecla precionada
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){ 
            snake.up();
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            snake.down();
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            snake.left();
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            snake.right();
        }else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }
    
    public Renderer getRenderer(){
        return renderer;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
