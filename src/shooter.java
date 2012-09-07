
import javax.swing.JFrame;

public class shooter{
    public static void main(String[] args){
        new shooter();
    }
    
    public shooter(){
        JFrame f = new JFrame();
        f.setTitle("Pasigame");
        f.add(new board());
        f.setSize(750,800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}