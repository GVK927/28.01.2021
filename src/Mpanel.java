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
        this.timer = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                img.setX(img.getX()+1);
                img.setY(img.getY()+1);
                repaint();
                if(img.getX()==800||img.getY()==800){
                    img.setX(0);
                    img.setY(0);
                }
            }
        });

    }
}
