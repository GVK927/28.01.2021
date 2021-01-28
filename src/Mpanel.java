import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mpanel extends JPanel{
    private Timer timer;
    private DrawImg img;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img.draw(g);
    }

    public Mpanel(){
        setLayout(null);
        img = new DrawImg(100, 100, "C:\\java 4\\28.01.2021\\light_PNG14440.png");
        this.timer = new Timer(2, new ActionListener() {
            int c = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (c){
                    case 0:
                        img.y++;
                        repaint();
                        break;
                    case 1:
                        img.x++;
                        repaint();
                        break;
                    case 2:
                        img.y--;
                        repaint();
                        break;
                    case 3:
                        img.x--;
                        repaint();
                        break;
                }
                if(img.y == 300&&img.x == 100) c = 1;
                if(img.y == 300&&img.x == 300) c = 2;
                if(img.y == 100&&img.x == 300) c = 3;
                if(img.y == 100&&img.x == 100) c = 0;
            }
        });
        timer.start();
    }
}
