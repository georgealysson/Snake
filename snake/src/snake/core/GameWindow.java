
package snake.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.constant.Constable;
import java.nio.Buffer;

import javax.swing.JFrame;
import snake.util.Constantes;
import snake.graphics.Renderer;
import snake.scene.Snake;

public class GameWindow extends JFrame implements KeyListener{
    private Renderer renderer;
    private Snake snake;
	private Image buffer;
	private Graphics gImage;
	private Rectangle drawingArea;
	private long lestKeyboardEventTime;
    
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
        
        
        buffer = createImage(Constantes.WINDOW_WIDTH, Constantes.WINDOW_HEIGHT);
        gImage = buffer.getGraphics();
        
        defineDrawingArea();
    }
    
    private void defineDrawingArea() {
    	int upperY = Constantes.WINDOW_HEIGHT - (int)getContentPane().getSize().getHeight();
    	drawingArea = new Rectangle(0, upperY, Constantes.WINDOW_WIDTH, Constantes.WINDOW_HEIGHT - upperY);
    }

    public void repaint(Graphics g) {
        renderer.render(g);
    }
    
      
      //Receber tecla precionada
    public void keyPressed(KeyEvent e) {
    	long now = System.currentTimeMillis();
    	if(now - lestKeyboardEventTime < Constantes.GAME_MIN_TIME_BETWEEN_KEYBOARD_EVENTS) {
    		return;
    	}
    	
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
        
        lestKeyboardEventTime = now;
    }
    
   @Override
   public void paint(Graphics gScreen) {
	   if(renderer != null && gImage != null && buffer != null) {
		   renderer.render(gImage);
		   gScreen.drawImage(buffer, 0,0,null);  
	   }
	   
   }
   
   public Renderer getRenderer() {
	   return renderer;
   }

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

public Rectangle getDrawingArea() {
	return drawingArea;
}
}
