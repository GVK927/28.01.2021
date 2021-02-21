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
        this.planets = new Planet[]{
                new Planet(sun, "Earth.png", 250, 365),
                new Planet(sun, "Mercury.png", 100, 88),
                new Planet(sun, "Venus.png", 175, 225),
                new Planet(sun, "Mars.png", 325, 686),
                new Planet(sun, "Jupiter.png", 400, 4380),
                new Planet(sun, "Saturn.png", 475, 10585),
                new Planet(sun, "Uranus.png", 550, 30660),
                new Planet(sun, "Neptune.png", 625, 60225)};
        this.timer = new Timer(25, e -> {
            for(Planet i:planets){
                i.move();
            }
            repaint();
        });
        timer.start();
    }
}
