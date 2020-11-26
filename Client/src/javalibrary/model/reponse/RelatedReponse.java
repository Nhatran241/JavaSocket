package javalibrary.model.reponse;

public class RelatedReponse {
    String name, rising, top;
    public RelatedReponse() {
        
    }
    
    public RelatedReponse(String name, String rising) {
        this.name = name;
        this.rising = rising;
    }

    public RelatedReponse(String name, String rising, String top) {
        this.name = name;
        this.rising = rising;
        this.top = top;
    }

    public String getRising() {
        return rising == null || rising.length() ==0 ? "0":rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }

    public String getTop() {
        return top == null || top.length() == 0? "0" : top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
