import com.apple.eawt.Application;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class GameGUIDemo
{
        public static void main(String[] args)  throws IOException
        {
            new StartScreen();
            File imageFile = new File("Images/logo.png");
            Image image = ImageIO.read(imageFile);
            Application.getApplication().setDockIconImage(image);
        }
}
