import java.awt.image.RGBImageFilter;
import java.util.Random;

class ImgFilter extends RGBImageFilter {
    private static Random random;
    static{
        random = new Random();
    }
    @Override
    public int filterRGB(int x, int y, int rgb) {
        int r = rgb >> 16;
        int g = rgb >> 8;
        int b = rgb & 0xff;

        int nr = random.nextInt(128);
        int ng = random.nextInt(128);
        int nb = random.nextInt(128);

        if(r+nr<=255) {
            r+=nr;
        }else{
            if(r-nr>=0) r-=nr;
        }
        if(g+ng<=255) {
            g+=ng;
        }else{
            if(g-ng>=0) g-=ng;
        }
        if(b+nb<=255) {
            b+=nb;
        }else{
            if(b-nb>=0) b-=nb;
        }

        return (rgb>>24)|(r<<16)|(g<<8)|b;
    }
}