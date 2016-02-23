import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
  
public class FullscreenExample {
  
	public static void drawEllipse(int newX, int newY, float xradius, float yradius, float r, float g, float b, float a )
	{
		GL11.glColor4f(r,g,b,a);
		GL11.glPushMatrix();
		GL11.glTranslatef(newX, newY, 0);
		GL11.glScalef(xradius, yradius, 1);

		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glVertex2f(0, 0);
		for(int i = 0; i <= 50; i++){ //NUM_PIZZA_SLICES decides how round the circle looks.
		    double angle = Math.PI * 2 * i / 50;
		    GL11.glVertex2f((float)Math.cos(angle), (float)Math.sin(angle));
		}
		GL11.glEnd();

		GL11.glPopMatrix();
	}
	
	public static void drawRect(int newX, int newY, int width, int height, float r, float g, float b, float a){
		GL11.glColor4f(r,g,b,a);
		GL11.glBegin(GL11.GL_QUADS);
        	GL11.glVertex2f(newX,newY);
        	GL11.glVertex2f(newX+width,newY);
        	GL11.glVertex2f(newX+width,newY+height);
        	GL11.glVertex2f(newX,newY+height);
        GL11.glEnd();
    }
	
    public void start() {
        try {
        Display.setDisplayMode(new DisplayMode(800,600));
        Display.create();
    } catch (LWJGLException e) {
        e.printStackTrace();
        System.exit(0);
    }
  
    // init OpenGL
    GL11.glMatrixMode(GL11.GL_PROJECTION);
    GL11.glLoadIdentity();
    GL11.glOrtho(0, 800, 0, 600, 1, -1);
    GL11.glMatrixMode(GL11.GL_MODELVIEW);
    
    
  
    while (!Display.isCloseRequested()) {
        // Clear the screen and depth buffer
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);  
         
             
        
        drawRect(200,100,200,70,0.5f,0.5f,1.0f,0.0f);
        drawEllipse(400,200,50,300,1f,1f,0f,0.0f);
        
        Display.update();
    }
  
    Display.destroy();
    }
  
    public static void main(String[] argv) {
        FullscreenExample quadExample = new FullscreenExample();
        quadExample.start();
    }
}