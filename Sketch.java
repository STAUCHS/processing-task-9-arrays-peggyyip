import processing.core.PApplet;

public class Sketch extends PApplet {

  // Related arrays for the (x, y) coordinate of the snowflakes
  float[] snowX = new float[42];
  float[] snowY = new float[42];
  int snowDiameter = 10;
  boolean upPressed = false;
  boolean downPressed = false;
  float fltCircleX = 0;
  float fltCircleY = 0;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);
    
    // Generate random x and y values for snowflakes
    for(int i = 0; i < snowX.length; i++) {
      snowX[i] = random(width);
      snowY[i] = random(height);
    }
  }

  public void draw() {
    background(0);

    // Draw snow
    snow();
    
  }
      private void movingSun() {
        // Add player logo
        fill(128, 191, 242);
        circle(fltCircleX, fltCircleY, 80);
        if (key == 'w' || key == 'W' ) {
          fltCircleY--;
        }
        else if (key == 's' || key == 'S' ) {
          fltCircleY++;
        }
        else if (key == 'a' || key == 'A') {
          fltCircleX--;
        }
        else if (key == 'd' || key == 'D') {
          fltCircleX++;
        }
      }
  
  public void snow(){
    fill(255);
    for(int i = 0; i < snowX.length; i++) {
      circle(snowX[i], snowY[i], snowDiameter);

      snowY[i] += 2;

      // Reset snowflakes
      if (snowY[i] > height) {
        snowY[i] = 0;
      }
    }
      // Make snow fall faster
    if(downPressed) {
      for(int i = 0; i < snowX.length; i++) {
        circle(snowX[i], snowY[i], snowDiameter);
          snowY[i] += 5;
      }
    } else if(upPressed) {
      for(int i = 0; i < snowX.length; i++) {
        circle(snowX[i], snowY[i], snowDiameter);
          snowY[i] --;
      } 
    }
  }

  public void keyPressed() {
    if (keyCode == DOWN) {
      downPressed = true;
    }
    else if (keyCode == UP) {
      upPressed = true;
    }
  }
  public void keyReleased() {
    if (keyCode == DOWN) {
      downPressed = false;
     }
     else if (keyCode == UP) {
      upPressed = false;
      }
    }

    
}