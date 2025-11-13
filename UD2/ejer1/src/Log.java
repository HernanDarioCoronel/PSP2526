import java.util.ArrayList;
import java.util.List;

public class Log {
    private List<Integer> items;

    public Log(){
        items = new ArrayList<>();
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }
}
