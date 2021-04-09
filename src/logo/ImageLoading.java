package logo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;
  
public class ImageLoading
{
    public ImageLoading()
    {
        BufferedImage image = loadImage();
        JLabel label = new JLabel(new ImageIcon(image));
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new JScrollPane(label));
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
  
    private BufferedImage loadImage()
    {
        BufferedImage image = null;
        String fileName = "src/logo/microImage.jpg";
        try
        {
            URL url = getClass().getResource(fileName);
            image = ImageIO.read(url);
        }
        catch(MalformedURLException mue)
        {
            System.err.println("url: " + mue.getMessage());
        }
        catch(IllegalArgumentException iae)
        {
            System.err.println("arg: " + iae.getMessage());
        }
        catch(IOException ioe)
        {
            System.err.println("read: " + ioe.getMessage());
        }
        if(image == null)
        {
            image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
            System.out.println("unable to load image, returning default");
        }
        return image;
    }
  
    public static void main(String[] args)
    {
        new ImageLoading();
    }
}