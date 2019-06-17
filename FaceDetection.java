import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.*;
import org.opencv.core.Core; 
public class FaceDetection {
    public static void ImageShow(String link){
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon(link);
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input image path: ");
        String link = in.next();
        in.close();
        ImageShow(link);
    }
}//Will be updated soon. Stay tuned for that
