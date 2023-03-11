package dep;

public enum ConfigPathType {
    TABLE_WITH_LAYOUT_DATA("table_of_layout_data"),
    FOLDER_WITH_LAYOUT_IMAGES("folder_of_layout_images");


    private String keyWord;
 
    ConfigPathType(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getKeyWord() {
        return this.keyWord;
    }
}
