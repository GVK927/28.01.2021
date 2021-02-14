package StarSystem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class CelestialBody{
    protected int center_x;
    protected int x;
    protected int center_y;
    protected int y;
    protected BufferedImage img;

    public CelestialBody (int x, int y, String img_path){
        try {
            this.img = ImageIO.read(new File(img_path));
        }catch (Exception e){
            e.printStackTrace();
        }
        this.center_x = x;
        this.center_y = y;
        this.x = this.center_x-this.img.getWidth()/2;
        this.y = this.center_y-this.img.getHeight()/2;
    }

    public BufferedImage getImg () {
        return img;
    }

    public int getX () {
        return this.x;
    }
    public int getY () {
        return this.y;
    }
}