package StarSystem;

public class Planet extends CelestialBody {
    private int r;
    private double angle;
    private double angle_speed;
    private int period;
    private int dx;
    private int dy;

    {
        angle = 0;
    }

    public Planet(CelestialBody star, String path, int r, int period){
        super(star.center_x+r, star.center_y, path);
        this.r = r;
        this.period = period;
        this.angle_speed = 2*Math.PI/period;
        this.dx = star.center_x;
        this.dy = star.center_y;
    }

    public void move(){
        angle = (angle+angle_speed)%(2*Math.PI);
        center_x = (int)(r * Math.cos(angle));
        center_y = (int)(r * Math.sin(angle));
        this.x = this.center_x-this.img.getWidth()/2+dx;
        this.y = this.center_y-this.img.getHeight()/2+dy;
    }
}