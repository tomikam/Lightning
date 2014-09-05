import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Lightning extends PApplet {

int x = 0;
int y = 150;
int xStep;
int yStep;
int i;
int variation = 10;
int tendancy = 0;
boolean drawBackground = false;
int boltSize = 3;

//Button small, medium, large, pretty;

public void setup()
{
  size(600,600);
  noLoop();
  background(0);
}
public void draw()
{
	int i = 0;
	while(x < 600)
		{
			if (drawBackground) {
				background(0);
			}
			xStep = (int)(Math.random()* variation);
			yStep = (int)(Math.random()* variation - (variation/2) + tendancy);
			strokeWeight(boltSize);
			stroke(0, 0, 255);
			line(x, y, x + xStep, y + yStep);
			x = x + xStep;
			y = y + yStep;
			i++;
		}

	/*small = new Button(50, 500, 100, 50, 10);
	medium = new Button();
	large = new Button();
	pretty = new Button();
	small.show();*/
}
public void mousePressed()
{
	if (mouseButton == LEFT) {
		x = 0;
		y = mouseY;
		
	} else if (mouseButton == RIGHT) {
		background(0);
	}
	redraw();
}
public void keyPressed()
{
	if (key == 'q' || key == 'Q') 
	{
		variation +=10;
	} 
	else if (key == 'a' || key == 'A') 
	{
		if (variation > 10) 
		{
			variation -= 10;
		}
	} 
	else if (key == 'w' || key == 'W') 
	{
		tendancy +=3;
	} 
	else if (key =='s' || key == 'S')  
	{
		tendancy -=3;
	} 
	else if (key == 'z' || key == 'Z') {
		x = 0;
		y = mouseY;
		redraw();
	} 
	else if (key == 'e' || key == 'E') 
	{
		boltSize += 2;
		variation += 2;
	}
	else if (key =='d' || key == 'D') 
	{
		if (boltSize > 1 && variation > 10) {
			boltSize -= 2;
			variation -=2;
		}
	}
	else if (key == 'x' || key == 'X') {
		drawBackground = !drawBackground;
	}
}

/*class Button
{
	int myX, myY, myL, myH, mytext;
	Button(int x, int y, int l, int h, int btnText)
	{
		myX = x;
		myY = y;
		myL = l;
		myH = h;
		myText = btnText;
	}
	void checkIfInside() {
		if (mouseX > myX && mouseX < myX + myL && mouseY > myY && mouseY < myY + myH) {
			return true;
		}
		return false;
	}
	void show() 
	{
		fill(255, 125, 98);
		rect(myX, myY, myL, myH);
		stroke(0);
		text(myText, myX + 10, myY + 10);
	}

}
*/
/** IDEAS */
//Some element of control... maybe it goes where you click? 
//It splits off at a random point?
//A settings menu so that you can decide when it splits and what it does?
//Menus to 



//click to set starting x, click again to set 
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightning" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
