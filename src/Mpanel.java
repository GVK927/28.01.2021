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
        this.timer = new Timer(2, e -> {
            repaint();
            img.x++;
            img.y++;
            if(img.x==800||img.y==800){
                img.x = -30;
                img.y = -30;
            }
        });
        timer.start();
    }
}
