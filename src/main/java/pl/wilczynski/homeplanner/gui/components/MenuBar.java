package pl.wilczynski.homeplanner.gui.components;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class MenuBar {

    private Tabs.Orientation orientation;
    private int numberOfCategories;
    private String[] categoryName = new String[10];
    private Tab[] category = new Tab[10];
    private Tabs tabs = new Tabs();


    public MenuBar() {

        //preset orientation
        tabs.setOrientation(orientation);

        for (int i = 0; i < numberOfCategories; i++) {
            category[i] = new Tab(categoryName[i]);
            tabs.add(category[i]);
        }

    }

    public Tabs.Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Tabs.Orientation orientation) {
        this.orientation = orientation;
    }

    public int getNumberOfCategories() {
        return numberOfCategories;
    }

    public void setNumberOfCategories(int numberOfCategories) {
        this.numberOfCategories = numberOfCategories;
    }

    public String[] getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String[] categoryName) {
        this.categoryName = categoryName;
    }

    public Tabs getTabs() {
        return tabs;
    }
}


