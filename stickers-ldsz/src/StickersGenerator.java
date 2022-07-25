import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {

    public void create(InputStream inputStream, String fileName) throws Exception {

        // =========== To do =========

        // reading image
        //InputStream inputStream = new FileInputStream(new File("entrance/movie.jpg"));

        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        
        BufferedImage originalImage = ImageIO.read(inputStream);

        // create new image in memory with transparency and with new size

        int imgWidth = originalImage.getWidth();
        int imgHeight = originalImage.getHeight();
        int imgNewHeight = imgHeight + 200;

        BufferedImage newImg = new BufferedImage(imgWidth, imgNewHeight, BufferedImage.TRANSLUCENT);

        // copy original image for the new image (in memory)

        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // font configuration

        var imgFont = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.GREEN);
        graphics.setFont(imgFont);

        // write a phrase in the new image

        graphics.drawString("GOODONE", 100, imgNewHeight - 100);

        // print the image in a file

        ImageIO.write(newImg, "png", new File(fileName));
    }
    
}
