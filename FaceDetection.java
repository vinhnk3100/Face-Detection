import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.*;
import org.opencv.core.Core; 
import org.opencv.core.Mat; 
import org.opencv.core.MatOfRect; 
import org.opencv.core.Point; 
import org.opencv.core.Rect; 
import org.opencv.core.Scalar; 
import org.opencv.imgcodecs.Imgcodecs; 
import org.opencv.imgproc.Imgproc; 
import org.opencv.objdetect.CascadeClassifier; 
public class Face {
    public static void ImageShow(String link){
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon(link);
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void FaceDetect(String link){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
        CascadeClassifier faceDetector = new CascadeClassifier(); 
        //To load your own Cascade just copy the path of your haarcascade_frontalface_alt.xml at which you determined it when installation happens
        faceDetector.load("D:\\My Netbeans\\OPenCV\\opencv\\sources\\samples\\winrt\\FaceDetection\\FaceDetection\\Assets\\haarcascade_frontalface_alt.xml"); 
        Mat image = Imgcodecs.imread(link); 
        MatOfRect faceDetections = new MatOfRect(); 
        faceDetector.detectMultiScale(image, faceDetections); 
        for (Rect rect : faceDetections.toArray()) 
        { 
            Imgproc.rectangle(image, new Point(rect.x, rect.y), 
            new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(10, 300, 20)); 
        } 
        String filename = "Face_Detected.jpg"; 
        Imgcodecs.imwrite("H:\\"+filename, image); 
        ImageShow("H:/Face_Detected.jpg");
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input image path: ");
        String link = in.next();
        in.close();
        ImageShow(link);
        FaceDetect(link);
    }
}
