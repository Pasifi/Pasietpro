
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

//just a test t. pro

public class board extends JPanel implements ActionListener {

    private Timer timer;
    private map m;
    private player p;
    public boolean left = false;
    public boolean right = false;
    public boolean up = false;
    public boolean down = false;

    public board() {

        m = new map();
        p = new player();

        addKeyListener(new board.Al());
        setFocusable(true);

        timer = new Timer(25, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 23; x++) {
                if (m.getMap(x, y).equals("g")) {
                    g.drawImage(m.getGrass(), x * 32, y * 32, null);
                }
                if (m.getMap(x, y).equals("w")) {
                    g.drawImage(m.getWall(), x * 32, y * 32, null);
                }
            }
        }

        g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null);
    }

    public class Al implements KeyListener {

        Set<Integer> pressed = new HashSet<Integer>();

        @Override
        public void keyPressed(KeyEvent e) {
            
            pressed.add(e.getKeyCode());
            System.out.println(pressed.size());
            for (Integer keycode : pressed) {
                if (keycode == KeyEvent.VK_W) {
                    if (!m.getMap(p.getTileX(), p.getTileY() - 1).equals("w")) {
                        p.moveY(-1);
                    }
                }
                if (keycode == KeyEvent.VK_S) {
                    if (!m.getMap(p.getTileX(), p.getTileY() + 1).equals("w")) {
                        p.moveY(1);
                    }
                }
                if (keycode == KeyEvent.VK_A) {
                    if (!m.getMap(p.getTileX() - 1, p.getTileY()).equals("w")) {
                        p.moveX(-1);
                    }
                }
                if (keycode == KeyEvent.VK_D) {
                    if (!m.getMap(p.getTileX() + 1, p.getTileY()).equals("w")) {
                        p.moveX(1);
                    }
                }

            }

        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            pressed.remove(e.getKeyCode());
        }
    }
}
