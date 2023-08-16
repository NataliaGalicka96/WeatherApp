package weatherapp.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import weatherapp.App;
import weatherapp.controller.BaseController;
import weatherapp.controller.MainWindowController;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewFactoryTest {

    private ViewFactory viewFactory;
    private FXMLLoader fxmlLoaderMock;
    private BaseController controllerMock;
    private Parent parentMock;
    private Scene sceneMock;
    private Stage stageMock;

    /*
    @BeforeEach
    void setUp() {
        viewFactory = new ViewFactory();
        fxmlLoaderMock = mock(FXMLLoader.class);
        controllerMock = mock(MainWindowController.class);
        parentMock = mock(Parent.class);
        sceneMock = mock(Scene.class);
        stageMock = mock(Stage.class);

        when(controllerMock.getFxmlName()).thenReturn("your_fxml_file.fxml");
    }

    @Test
    void testShowCurrentWeatherWindow() throws IOException {
        // Arrange
        when(fxmlLoaderMock.load()).thenReturn(parentMock);
        when(parentMock.getScene()).thenReturn(sceneMock);
        when(App.class.getResource("your_fxml_file.fxml")).thenReturn(getClass().getResource("your_fxml_file.fxml"));
        doNothing().when(stageMock).setScene(sceneMock);

        // Używanie atrap w klasie ViewFactory
        viewFactory.fxmlLoader = fxmlLoaderMock;
        viewFactory.stage = stageMock;

        // Act
        viewFactory.showCurrentWeatherWindow();

        // Assert
        verify(fxmlLoaderMock).setController(controllerMock);
        verify(fxmlLoaderMock).load();
        verify(parentMock).getScene();
        verify(sceneMock).getRoot();
        verify(App.class).getResource("your_fxml_file.fxml");
        verify(stageMock).setScene(sceneMock);
        verify(stageMock).setTitle("WeatherApp by Natalia Galicka");
        verify(stageMock).setResizable(false);
        verify(stageMock).show();
    }
    */
}