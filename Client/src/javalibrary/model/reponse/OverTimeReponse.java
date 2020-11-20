package javalibrary.model.reponse;

import java.util.List;

public class OverTimeReponse {
    List<Integer> number;

    public OverTimeReponse() {
    }

    public OverTimeReponse(List<Integer> number) {
        this.number = number;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }

}
