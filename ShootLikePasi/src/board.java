import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
//test
public class board extends JPanel implements ActionListener{
    
    private Timer timer;
    private map m;
    private player p;
    
    public boolean left = false;
    public boolean right = false;
    public boolean up = false;
    public boolean down = false;
    
    public board(){
        
        m = new map();
        p = new player();
        
        addKeyListener(new Al());
        setFocusable(true);
        
        timer = new Timer(25, this);
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        for(int y = 0;y < 24;y++){
            for(int x = 0;x < 23;x++){
                if(m.getMap(x,y).equals("g")){
                    g.drawImage(m.getGrass(), x*32, y*32, null);
                }
                if(m.getMap(x,y).equals("w")){
                    g.drawImage(m.getWall(), x*32, y*32, null);
                }
            }
        }
        
        g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null);
    }
    
    public class Al extends KeyAdapter{
        
        
        @Override
        public void keyPressed(KeyEvent e){
            int keycode = e.getKeyCode();
            
           if(keycode == KeyEvent.VK_W){
               if(!m.getMap(p.getTileX(), p.getTileY() - 1).equals("w")){
                    p.move(0, -1);
               }
            }
            if(keycode == KeyEvent.VK_S){
                if(!m.getMap(p.getTileX(), p.getTileY() + 1).equals("w")){
                    p.move(0, 1);
                }
            }
            if(keycode == KeyEvent.VK_A){
                if(!m.getMap(p.getTileX() - 1, p.getTileY()).equals("w")){
                    p.move(-1, 0);
                }
            }
            if(keycode == KeyEvent.VK_D){
                if(!m.getMap(p.getTileX() + 1, p.getTileY()).equals("w")){
                    p.move(1, 0);
                }
            }
        }
    }
}
