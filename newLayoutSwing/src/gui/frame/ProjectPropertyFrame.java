package gui.frame;

import java.awt.*;
import javax.swing.*;

import app.constant.appConstants;

public class ProjectPropertyFrame extends JFrame {
    public ProjectPropertyFrame(){
        this.init();
    }
    

    private void init(){
        this.setTitle(appConstants.projectPropertyWindowTitle);
        this.setSize(appConstants.projectPropertyWindowSize);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

    }
}
