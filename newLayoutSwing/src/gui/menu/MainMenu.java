package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.frame.ProjectPropertyFrame;

public class MainMenu extends JMenuBar {
    private JMenu settingsMenu = new JMenu("Settings");
    private JMenuItem projectPropertyItem = new JMenuItem("Project properties");

    public MainMenu(){
        this.init();

        this.setListeners();
    }

    private void init(){
        this.add(this.settingsMenu);
        this.settingsMenu.add(this.projectPropertyItem);
        this.setVisible(true);
    }

    private void setListeners(){
        this.projectPropertyItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProjectPropertyFrame();
            }
        });
    }
}
