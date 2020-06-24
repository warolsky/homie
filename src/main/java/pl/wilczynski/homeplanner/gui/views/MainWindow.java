package pl.wilczynski.homeplanner.gui.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.wilczynski.homeplanner.gui.components.MenuBar;

import static com.vaadin.flow.component.tabs.Tabs.Orientation.VERTICAL;

@Route("")
public class MainWindow extends VerticalLayout {

    public MainWindow() {

        MenuBar menuBar = new MenuBar();
        add(menuBar.MenuBar(VERTICAL));

    }

}