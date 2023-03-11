package app;

import dep.ConfigPathType;

public class AppVariable {
    private static AppVariable instance;
    private String layoutTableFile = "";
    private String layoutFolder = "";


    private AppVariable(){
    }

    public static AppVariable getInstance(){
        if (instance == null){
            instance = new AppVariable();
        }
        return instance;
    }

    public void setPathOfType(ConfigPathType type, String path) {
        if (type == ConfigPathType.TABLE_WITH_LAYOUT_DATA) {
            this.setLayoutTableFile(path);
        } else if (type == ConfigPathType.FOLDER_WITH_LAYOUT_IMAGES) {
            this.setLayoutFolder(path);
        }
    }
    
    public String getLayoutTableFile() {
        return layoutTableFile;
    }
    public void setLayoutTableFile(String layoutTableFile) {
        this.layoutTableFile = layoutTableFile;
    }
    public String getLayoutFolder() {
        return layoutFolder;
    }
    public void setLayoutFolder(String layoutFolder) {
        this.layoutFolder = layoutFolder;
    }

    
}
