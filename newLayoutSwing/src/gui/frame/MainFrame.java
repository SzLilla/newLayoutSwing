package gui.frame;

import java.awt.*;
import javax.swing.*;

import app.ProjectPropertyInteractor;
import app.constant.AppConstants;
import gui.menu.MainMenu;

public class MainFrame extends JFrame {
    private JMenuBar menu = new MainMenu();
    
    public MainFrame(){
        this.init();
    }

    private void init(){
        this.initDesign();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initDesign(){
        this.setTitle(AppConstants.mainWindowTitle);
        this.setSize(AppConstants.mainWindowSize);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.setLayout(new BorderLayout());
        this.add(this.menu, BorderLayout.NORTH);

    }

}
