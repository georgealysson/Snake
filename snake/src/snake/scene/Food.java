package snake.scene;

import static java.awt.Color.GREEN;
import static snake.util.Constantes.FOOD_SIZE;

import java.awt.Color;

import snake.graphics.Rect;
import snake.util.Constantes;

public class Food extends Rect{

	public Food() {
		super(50,50,FOOD_SIZE, FOOD_SIZE);
		setColor(GREEN);
		// TODO Auto-generated constructor stub
	}
	
}
