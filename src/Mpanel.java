import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.util.Random;

public class Mpanel extends JPanel{
    private final Timer timer;
    private final DrawImg img;
    private static boolean x_add;
    private final Random random = new Random();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img.draw(g);
    }

    public Mpanel(){
        setLayout(null);
        setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
        int x = random.nextInt(Window.WIDTH- DrawImg.WIDTH);
        int y = random.nextInt(Window.HEIGHT- DrawImg.HEIGHT);
        img = new DrawImg(x, y, "jixzbg9GT.png");
        this.timer = new Timer(5, e -> {
            if (img.x <= 0) {
                img.a = -img.a;
                x_add = true;
                img.c = img.y;
            }
            if (img.x >= Window.WIDTH - DrawImg.WIDTH){
                img.a = -img.a;
                x_add = false;
                img.c = - DrawImg.HEIGHT - img.y;
            }
            if (img.y >= Window.HEIGHT - DrawImg.HEIGHT) {
                img.a = -img.a;
                img.c = Window.HEIGHT - DrawImg.HEIGHT;
                img.d = -img.x;
            }
            if (img.y <= 0) {
                img.a = -img.a;
                img.c = 0;
                img.d = -img.x;
            }
            img.x=x_add?img.x+1:img.x-1;
            img.animation_func();
            repaint();
        });
        timer.start();
    }
    private class DrawImg {
        private static final int WIDTH = 210;
        private static final int HEIGHT = 130;
        private double a;
        private int x, y;
        private int c, d;
        private Image image;
        private final ImgFilter filter = new ImgFilter();

        {
            a = 1;
            c = 0;
            d = 0;
        }

        public DrawImg(int x, int y, String path){
            this.x = x;
            this.y = y;
            try{
                this.image = ImageIO.read(new File(path));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        private void animation_func () {
            this.y = this.c + (int) this.a * (this.x + this.d);
        }

        public void draw(Graphics g){
            g.drawImage(image, this.x, this.y, null);
        }
        private void changeColor(){
            this.image = createImage(new FilteredImageSource(image.getSource(), filter));
        }
    }
}
