int x = 0;
int y = 150;
int xStep;
int yStep;
int i;
int variation = 10;
int tendancy = 0;

int boltSize = 3;



void setup()
{
  size(600,600);
  noLoop();
  background(0);
}
void draw()
{
	int i = 0;
	while(x < 600)
		{
			
			xStep = (int)(Math.random()* variation);
			yStep = (int)(Math.random()* variation - (variation/2) + tendancy);
			strokeWeight(boltSize);
			stroke(0, 0, 255);
			line(x, y, x + xStep, y + yStep);
			x = x + xStep;
			y = y + yStep;
			i++;
		}

	
}
void mousePressed()
{
	if (mouseButton == LEFT) {
		x = 0;
		y = mouseY;
		
	} else if (mouseButton == RIGHT) {
		background(0);
	}
	redraw();
}

void keyPressed()
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
	
}


/** IDEAS */
//Some element of control... maybe it goes where you click? 
//It splits off at a random point?
//A settings menu so that you can decide when it splits and what it does?
//Menus to 



//click to set starting x, click again to set 