
import java.awt.Image;
import javax.swing.ImageIcon;

public class player{
    
    private int x,y,tileX,tileY;
    
    private Image Player;
    
    public player(){
        
        ImageIcon img = new ImageIcon("src/res/player.png");
        Player = img.getImage();
        
        tileX = 1;
        tileY = 1;
    }
    
    public Image getPlayer(){
        return Player;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getTileX(){
        return tileX;
    }
    public int getTileY(){
        return tileY;
    }
    
    public void moveX(int dx){
        tileX += dx;
       
        
    }
    
    public void moveY(int y){
        tileY+=y;
        
    }
}

