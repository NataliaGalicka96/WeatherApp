package weatherapp.model;

import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.util.Map;
import java.util.stream.Collectors;

public class AutoComplete extends TextField {

    public static void autoComplete(TextField textField, Map<String, Integer> citiesMap) {
        TextFields.bindAutoCompletion(textField, t -> citiesMap.keySet().stream()
        		.filter(elem -> elem.toLowerCase().startsWith(t.getUserText().toLowerCase()))
        		.collect(Collectors.toList()));
    }

}
