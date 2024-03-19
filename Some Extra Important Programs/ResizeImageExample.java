import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ResizeImageExample
 {
    public static void main(String args[]) throws IOException
	{
        File input = new File("F:/Image/IMG_20200912_105036-min.jpg");
        BufferedImage image = ImageIO.read(input);

        Image tmp = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        File output = new File("F:/Image/IMG_20200912_105036-min-new.jpg");
        ImageIO.write(resized, "png", output);
    }
}