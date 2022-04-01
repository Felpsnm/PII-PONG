import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	
	public boolean rightCpu,leftCpu,rightPla,leftPla;
	public double x,y;
	public int width,height;		
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40; 
		this.height = 5;
	}
	
	public void tick()	{
		if(Game.singleplayer == true) {
		x+= (Game.ball.x - x - 6) * 0.07		;
		
		if(rightCpu) {
			x++;
		}
		else if(leftCpu) {
			x--;
		}
		if(x+width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}
		else if(x< 0){
			x = 0;
			}
		}
		if(Game.coop == true){
			if(rightPla) {
				x++;
			}
			else if(leftPla) {
				x--;
			}
			if(x+width > Game.WIDTH) {
				x = Game.WIDTH - width;
			}
			else if(x< 0){
				x = 0;
				}
			}	
		}
	
	public void render(Graphics g){
		g.setColor(Color.magenta);
		g.fillRect((int)x, (int)y, width, height);
	}
}
