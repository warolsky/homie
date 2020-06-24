package pl.wilczynski.homeplanner.gui.components;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class MenuBar {

    Tabs tabs = new Tabs();

    public Tabs MenuBar(Tabs.Orientation orientation) {

        //preset orientation
        tabs.setOrientation(orientation);

        //for now static value, in future there will be an option for adding new tabs from settings
        Tab categoryMain = new Tab("Strona główna");
        Tab categoryBudget = new Tab("Budżet domowy");
        Tab categoryReceipts = new Tab("Paragony");

        tabs.add(categoryMain, categoryBudget, categoryReceipts);

        return tabs;
    }

}


