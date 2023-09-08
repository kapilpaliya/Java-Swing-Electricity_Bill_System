// Class Import Statements.
import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    // Variable Declaration.
    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/bgImage.jpg"));
    JWindow w; JProgressBar pb; Timer timer; JLabel backImage = new JLabel(img);
    Main(){
        // JWindow Declaration.
        w = new JWindow();
        w.setBounds(300,100,800,455);
        w.add(backImage);

        // Set Process Bar.

        pb = new JProgressBar(0,100);
        pb.setForeground(Color.orange);
        pb.setBorder(null);
        pb.setBackground(Color.black);
        w.add(pb,BorderLayout.PAGE_END);

        // Define The Working Of Process Bar.
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = pb.getValue();
                if(x==100){
                    new Login();
                    w.dispose();
                    timer.stop();
                }
                else{
                    pb.setValue(x+4);
                }
            }
        });
        timer.start();
        pb.setValue(30);
        w.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}