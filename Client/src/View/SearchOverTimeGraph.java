package View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javalibrary.model.reponse.SearchOverTimeReponse;

public class SearchOverTimeGraph extends JFXPanel {

    SearchOverTimeReponse searchOverTimeReponse;
    List<String> keyseachs;
    boolean isdayformat=true;
    boolean ishourformat =false;
    boolean ishourminuteformat =false;
    DateFormat dayformat = new SimpleDateFormat("dd-MM-yyyy");
    DateFormat hourformat = new SimpleDateFormat("dd-MM-yyyy HH");
    DateFormat hourminuteformat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public SearchOverTimeGraph(List<String> keysearchs, SearchOverTimeReponse searchOverTimeReponse,boolean isdayformat,boolean ishourformat,boolean ishourminuteformat) {
        super();
        this.searchOverTimeReponse = searchOverTimeReponse;
        this.keyseachs = keysearchs;
        this.isdayformat = isdayformat;
        this.ishourformat = ishourformat;
        this.ishourminuteformat = ishourminuteformat;
        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                createScene();
            }
        });
    }
    
    private void createScene() {
        Group root = new Group();

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Year");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Care");

        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setMinWidth(1350);
        lineChart.setMinHeight(500);
        XYChart.Series<String, Number> data1 = new XYChart.Series<>();
        XYChart.Series<String, Number> data2 = new XYChart.Series<>();
        XYChart.Series<String, Number> data3 = new XYChart.Series<>();
        XYChart.Series<String, Number> data4 = new XYChart.Series<>();
        XYChart.Series<String, Number> data5 = new XYChart.Series<>();
        if (keyseachs.size() >= 1) {
            for (int j = 0; j < searchOverTimeReponse.getIndex().size(); j++) {
                long index = searchOverTimeReponse.getIndex().get(j);
                String result;
                if(isdayformat){
                    result = dayformat.format(new Date(index));
                }else if(ishourformat){
                    result = hourformat.format(new Date(index));
                }else {
                    result = hourminuteformat.format(new Date(index));
                }
                int data = searchOverTimeReponse.getOverTimeReponses().get(0).getNumber().get(j);
                System.out.println("number"+data);
                data1.setName(keyseachs.get(0));
                data1.getData().add(new XYChart.Data<>(result, data));
            }
        }
        if (keyseachs.size() >= 2) {
            for (int j = 0; j < searchOverTimeReponse.getIndex().size(); j++) {
                long index = searchOverTimeReponse.getIndex().get(j);
                 String result;
                if(isdayformat){
                    result = dayformat.format(new Date(index));
                }else if(ishourformat){
                    result = hourformat.format(new Date(index));
                }else {
                    result = hourminuteformat.format(new Date(index));
                }
                int data = searchOverTimeReponse.getOverTimeReponses().get(1).getNumber().get(j);
                data2.setName(keyseachs.get(1));
                data2.getData().add(new XYChart.Data<>(result, data));
            }
        }
        if (keyseachs.size() >= 3) {
            for (int j = 0; j < searchOverTimeReponse.getIndex().size(); j++) {
                long index = searchOverTimeReponse.getIndex().get(j);
                 String result;
                 if(isdayformat){
                    result = dayformat.format(new Date(index));
                }else if(ishourformat){
                    result = hourformat.format(new Date(index));
                }else {
                    result = hourminuteformat.format(new Date(index));
                }
                int data = searchOverTimeReponse.getOverTimeReponses().get(2).getNumber().get(j);
                data3.setName(keyseachs.get(2));
                data3.getData().add(new XYChart.Data<>(result, data));
            }
        }
        if (keyseachs.size() >= 4) {
            for (int j = 0; j < searchOverTimeReponse.getIndex().size(); j++) {
                long index = searchOverTimeReponse.getIndex().get(j);
                 String result;
                if(isdayformat){
                    result = dayformat.format(new Date(index));
                }else if(ishourformat){
                    result = hourformat.format(new Date(index));
                }else {
                    result = hourminuteformat.format(new Date(index));
                }
                int data = searchOverTimeReponse.getOverTimeReponses().get(3).getNumber().get(j);
                data4.setName(keyseachs.get(3));
                data4.getData().add(new XYChart.Data<>(result, data));
            }
        }
        if (keyseachs.size() >= 5) {
            for (int j = 0; j < searchOverTimeReponse.getIndex().size(); j++) {
                long index = searchOverTimeReponse.getIndex().get(j);
                 String result;
                if(isdayformat){
                    result = dayformat.format(new Date(index));
                }else if(ishourformat){
                    result = hourformat.format(new Date(index));
                }else {
                    result = hourminuteformat.format(new Date(index));
                }
                int data = searchOverTimeReponse.getOverTimeReponses().get(4).getNumber().get(j);
                data5.setName(keyseachs.get(4));
                data5.getData().add(new XYChart.Data<>(result, data));
            }
        }
        lineChart.getData().addAll(data1, data2, data3, data4, data5);
        root.getChildren().add(lineChart);

        this.setScene(new Scene(root));
        this.validate();
    }
}
