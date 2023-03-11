package gui.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.AppVariable;
import app.ProjectPropertyInteractor;
import app.constant.AppConstants;
import dep.ConfigPathType;
import dep.DataFileHandler;
import utilities.SpringUtilities;

public class ProjectPropertyFrame extends JFrame {
    private ProjectPropertyInteractor interactor;

    private JLabel folderLabel = new JLabel("Select folder containing layout images:");
    private JLabel fileLabel = new JLabel("Select table file containing layout data:");

    private JTextField folderPath = new JTextField("Selected folder path...");
    private JTextField filePath = new JTextField("Selected table file path...");

    private JButton browseFolder = new JButton("Browse");
    private JButton browseFile = new JButton("Browse");

    public ProjectPropertyFrame(){
        this.interactor = new ProjectPropertyInteractor(this);
        this.initMainDesign();
        this.initContent();
        this.setPopUpFileChoosers();

        this.setVisible(true);
    }
    
    private void initMainDesign(){
        this.setTitle(AppConstants.projectPropertyWindowTitle);
        this.setSize(AppConstants.projectPropertyWindowSize);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initContent(){
        JPanel panel = new JPanel(new SpringLayout());

        panel.add(this.folderLabel);
        panel.add(this.folderPath);
        panel.add(this.browseFolder);
        this.folderLabel.setLabelFor(this.folderPath);

        panel.add(this.fileLabel);
        panel.add(this.filePath);
        panel.add(this.browseFile);
        this.fileLabel.setLabelFor(this.filePath);

        this.interactor.getDataFromConfigFile();

        SpringUtilities.makeCompactGrid(panel,
                                        2, 3, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad
        panel.setOpaque(true);
        this.setContentPane(panel);
        this.pack();
    }
    
    private void setPopUpFileChoosers() {
        this.browseFolder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser filechooser = new JFileChooser();
				filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = filechooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String selectedFile = filechooser.getSelectedFile().toString();
					saveFileData(ConfigPathType.FOLDER_WITH_LAYOUT_IMAGES, selectedFile);
                    setFolderPathTextField(selectedFile);
				}
            }

        });

        this.browseFile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser filechooser = new JFileChooser();
				filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnVal = filechooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String selectedFile = filechooser.getSelectedFile().toString();
					saveFileData(ConfigPathType.TABLE_WITH_LAYOUT_DATA, selectedFile);
                    setFilePathTextField(selectedFile);
				}
            }

        });
    }

    private void saveFileData(ConfigPathType type, String fileData){
        AppVariable.getInstance().setPathOfType(type, fileData);
        DataFileHandler.replaceKeyData(type.getKeyWord(), fileData);
    }

    public JTextField getFolderPathTextField() {
        return folderPath;
    }
    public void setFolderPathTextField(String folderPath) {
        this.folderPath.setText(folderPath);
    }
    public JTextField getFilePathTextField() {
        return filePath;
    }
    public void setFilePathTextField(String filePath) {
        this.filePath.setText(filePath);
    }


    

}
