package view;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class microStarViews extends JDesktopPane {

    public microStarViews() {
        initUI();
    }

    private void initUI() {       

        ImageIcon ii = loadImage();
        JLabel label = new JLabel(ii);
        createLayout(label);
        //setTitle("Image");
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

    }



    private ImageIcon loadImage() {

        ImageIcon ii = new ImageIcon("src/logo/microImage.png");
        return ii;
    }



    private void createLayout(JComponent... arg) {

        Container pane = getRootPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setHorizontalGroup(gl.createSequentialGroup()

                .addComponent(arg[0])

        );
        gl.setVerticalGroup(gl.createParallelGroup()

                .addComponent(arg[0])

        );

    }
    
    


}

