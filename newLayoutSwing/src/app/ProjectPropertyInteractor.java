package app;

import javax.swing.JFrame;

import dep.ConfigPathType;
import dep.DataFileHandler;
import gui.frame.ProjectPropertyFrame;


public class ProjectPropertyInteractor {
    private ProjectPropertyFrame container;

    public ProjectPropertyInteractor(ProjectPropertyFrame container){
        this.container = container;
    }

    public void getDataFromConfigFile(){
        String folder = DataFileHandler.getInstance().getStringDataFromConfigFile(ConfigPathType.FOLDER_WITH_LAYOUT_IMAGES.getKeyWord());
        String table = DataFileHandler.getInstance().getStringDataFromConfigFile(ConfigPathType.TABLE_WITH_LAYOUT_DATA.getKeyWord());

        System.out.println("folder: " + folder);
        System.out.println("table: " + table);

        if (!(folder.isEmpty())){
            this.container.getFolderPathTextField().setText(folder);
        }

        if (!(table.isEmpty())){
            this.container.getFilePathTextField().setText(table);
        }

    }
}
