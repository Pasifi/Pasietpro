
import java.awt.Image;
import java.io.File;
import java.util.*;
import javax.swing.ImageIcon;

public class map {
    
    private Scanner m;
    private String map[] = new String[24];
    private Image grass,wall;
    
    public map(){
        
        ImageIcon img = new ImageIcon("src/res/grass.png");
        grass = img.getImage();
        img = new ImageIcon("src/res/wall.png");
        wall = img.getImage();
                
        openFile();
        readFile();
        closeFile();
    }
    
    public Image getGrass(){
        return grass;
    }
    public Image getWall(){
        return wall;
    }
    
    public String getMap(int x, int y){
        String index = map[y].substring(x,x+1);
        return index;
    }
    
    private File f;
    public void openFile(){
        try{
            f = new File("src/res/map.txt");
            System.out.println(f.getCanonicalPath());
            m = new Scanner(f);
        }catch(Exception e){ System.out.println("Error loading map\n"+e);}
    }
    
    public void readFile(){
        while(m.hasNext()){
            for(int i = 0; i < 24; i++){
                map[i] = m.next();
            }
        }
    }
    public void closeFile(){
        m.close();
    }
}
