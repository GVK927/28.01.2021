import StarSystem.CelestialBody;
import StarSystem.Planet;

import javax.swing.*;
import java.awt.*;

public class Mpanel extends JPanel{
    private final Timer timer;
    private CelestialBody sun;
    private Planet[] planets;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sun.getImg(), sun.getX(), sun.getY(), null);
        for(Planet i:planets){
            g.drawImage(i.getImg(), i.getX(), i.getY(), null);
        }
    }

    public Mpanel () {
        setLayout(null);
        setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
        this.sun = new CelestialBody(Window.WIDTH/2, Window.HEIGHT/2, "Sun.png");
        this.planets = new Planet[]{new Planet(sun, "Earth.png", 350, 365)};
        this.timer = new Timer(25, e -> {
            for(Planet i:planets){
                i.move();
            }
            repaint();
        });
        timer.start();
    }
}
