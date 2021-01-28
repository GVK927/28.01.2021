import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DrawImg {
    public int x, y;
    private BufferedImage image;
    public DrawImg(int x, int y, String path){
        this.x = x;
        this.y = y;
        try{
            this.image = ImageIO.read(new File(path));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics g){
        g.drawImage(image, x, y, 50, 50, null);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
