import processing.core.PApplet;

public class Sketch extends PApplet {

  // Related arrays for the (x, y) coordinate of the snowflakes
  float[] snowX = new float[42];
  float[] snowY = new float[42];

  // Determining size of snowflakes
  int snowDiameter = 10;

  // Key values
  boolean upPressed = false;
  boolean downPressed = false;
  boolean wPressed = false;
  boolean sPressed = false;
  boolean aPressed = false;
  boolean dPressed = false;

  // Initializing speed variables
  float fltCircleX = 0;
  float fltCircleY = 0;
  float fltPlayerX = 0;
  float fltPlayerY = 0;

  // Defining variables
  int playerLives = 3;

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
    
    if(key == 'w' || key == 'W' || key == 's' || key == 'S' || key == 'a' || key == 'A' || key == 'd' || key == 'D' || keyCode == DOWN || keyCode == UP) {
      movingPlayer();
    }
  }
    private void movingPlayer() {
      if (wPressed) {
        fltPlayerY -= 2;
      }
      else if (sPressed ) {
        fltPlayerY += 2;
      }
      else if (aPressed) {
        fltPlayerX -= 2;
      }
      else if (dPressed) {
        fltPlayerX += 2;
      }

      // Add player representative
      fill(128, 191, 242);
      circle(fltPlayerX, fltPlayerY, 20);

      // Create boundaries
      fltPlayerX = Math.max(20, Math.min(fltPlayerX, width - 20));
      fltPlayerY = Math.max(20, Math.min(fltPlayerY, height - 20));

      // Check for collision with snowflakes
      for (int i = 0; i < 42; i++) {
      if (snowY[i] >= height - 10 && Math.abs(snowX[i] - fltPlayerX) < 20 + 10) {
          playerLives--;
          if (playerLives == 0) {
              background(255);
              System.out.println("Game Over!");
          }
      }
    }
      if (playerLives == 2 || playerLives == 1) {
        
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
    if (key == 'w' || key == 'W') {
      wPressed = true;
    }
    else if (key == 's' || key == 'S') {
      sPressed = true;
    }
    else if (key == 'a' || key == 'A') {
      aPressed = true;
    }
    else if (key == 'd' || key == 'D') {
      dPressed = true;
    }
  }
  
  public void keyReleased() {
    if (keyCode == DOWN) {
      downPressed = false;
     }
    else if (keyCode == UP) {
      upPressed = false;
    }

    if (key == 'w' || key == 'W') {
      wPressed = false;
    }
    else if (key == 's' || key == 'S') {
      sPressed = false;
    }
    else if (key == 'a' || key == 'A') {
      aPressed = false;
    }
    else if (key == 'd' || key == 'D') {
      dPressed = false;
    }
  }

    
}