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
        img = new DrawImg(20, 20, "C:\\java 4\\28.01.2021\\light_PNG14440.png");
        this.timer = new Timer(2, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                img.x++;
                img.y++;
                repaint();
                if(img.x==780||img.y==780){
                    timer.stop();
                }
            }
        });
        img.x = 20;
        img.y = 20;
        timer.start();
    }
}
