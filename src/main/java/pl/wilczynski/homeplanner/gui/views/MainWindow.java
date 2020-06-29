package pl.wilczynski.homeplanner.gui.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.wilczynski.homeplanner.gui.components.MenuBar;

import java.awt.*;

import static com.vaadin.flow.component.tabs.Tabs.Orientation.VERTICAL;

@Route("")
public class MainWindow extends VerticalLayout {

    public MainWindow() {

        String[] categoryNames = new String[10];
        MenuBar menuBar = new MenuBar();
        menuBar.setOrientation(VERTICAL);
        menuBar.setNumberOfCategories(4);

        //preset category names
        categoryNames[0] = "Strona główna";
        categoryNames[1] = "Budżet";
        categoryNames[2] = "Paragony";
        categoryNames[3] = "Ustawienia";

        menuBar.setCategoryName(categoryNames);

        Image logo = new Image("https://i.imgur.com/uKHZGp5.png", "homie logo");
        logo.

        add(logo, menuBar.getTabs());


    }

}