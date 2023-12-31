import java.awt.*;
import java.awt.image.*;

public class ColorImage extends BufferedImage
{
    private BufferedImage image;


    /**
     * Create a ColorImage copied from a BufferedImage
     * Convert to 24-bit direct colour
     * @param image The image to copy
     */
    public ColorImage(BufferedImage image)
    {
        super(image.getWidth(), image.getHeight(), TYPE_INT_RGB);
        int width = image.getWidth();
        int height = image.getHeight();
        for (int y=0; y<height; y++)
            for (int x=0; x<width; x++)
                setRGB(x, y, image.getRGB(x,y));
    }

    /**
     * Create a ColorImage with specified size and 24-bit direct colour
     * @param width The width of the image
     * @param height The height of the image
     */
    public ColorImage(int width, int height)
    {
        super(width, height, TYPE_INT_RGB);
    }

    /**
     * Set a given pixel of this image to a specified color.
     * The color is represented as an (r,g,b) value.
     * @param x The x position of the pixel
     * @param y The y position of the pixel
     * @param col The color of the pixel
     */
    public void setPixel(int x, int y, Color col)
    {
        int pixel = col.getRGB();
        setRGB(x, y, pixel);
    }

    /**
     * Get the color value at a specified pixel position
     * @param x The x position of the pixel
     * @param y The y position of the pixel
     * @return The color of the pixel at the given position
     */
    public Color getPixel(int x, int y)
    {
        int pixel = getRGB(x, y);
        return new Color(pixel);
    }

//    public ColorImage(BufferedImage image) {
//        this.image = image;
//    }

    public BufferedImage getImage() {
        return image;
    }

    public void applyFilter(String filter) {
        // Apply the specified filter to the image

        System.out.println("Applying filter: " + filter);
        // Implementation of filter logic goes here


    }

    public void display() {
        // Display the image
        // Implementation of image display goes here
    }
}


