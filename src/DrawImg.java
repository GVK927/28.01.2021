import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DrawImg {
    private int x, y;
    private BufferedImage image;
    public DrawImg(int x, int y){
        this.x = x;
        this.y = y;
        try{
            this.image = ImageIO.read(new File("D:\\Java projects\\untitled\\light_PNG14440.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics g){
        g.drawImage(image, x, y, 50, 50, null);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
