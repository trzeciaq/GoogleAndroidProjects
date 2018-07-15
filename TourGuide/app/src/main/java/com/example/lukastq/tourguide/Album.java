package com.example.lukastq.tourguide;

public class Album {

    private String itemName;
    private String item_shortDesc;
    private String item_longDesc;
    private int itemImageId;

    public Album(String iName, String iShortDesc, String iLongDesc, int imageId) {
        itemName = iName;
        item_shortDesc = iShortDesc;
        item_longDesc = iLongDesc;
        itemImageId = imageId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemShortDesc() {
        return item_shortDesc;
    }

    public String getItemLongDesc() {
        return item_longDesc;
    }

    public int getImageId() { return itemImageId; }
}

