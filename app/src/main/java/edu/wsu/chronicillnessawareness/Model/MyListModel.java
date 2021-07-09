package edu.wsu.chronicillnessawareness.Model;


public class MyListModel{
    String name;
    private String description;
    private int imgId;
    public MyListModel(String name,String description, int imgId) {
        this.name = name;
        this.imgId = imgId;
        this.imgId = imgId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

