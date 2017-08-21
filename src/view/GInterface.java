package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.property.*;
import java.util.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class GInterface extends Application implements UserInterface
{
    private static Map<String, XYChart.Series> series = new TreeMap<String,XYChart.Series>();
    private static int startYear;
    private static int endYear;

    public GInterface()
    {
        
    }

    public GInterface(int startYear, int endYear)
    {
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public void run()
    {
        launch();
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Business Simulator");

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,0,20,20));

        NumberAxis xAxis = new NumberAxis(startYear, endYear, 1);
        xAxis.setLabel("Years"); 
        
        //Defining the y axis   
        NumberAxis yAxis = new NumberAxis(); 
        yAxis.setLabel("Company Values"); 
        
        //Creating the line chart 
        LineChart lineChart = new LineChart(xAxis, yAxis);


        Collection<XYChart.Series> values = this.series.values();

        System.out.println(values.size());

        for (XYChart.Series serie : values)
        {
            lineChart.getData().add(serie);
        }


        Group root = new Group(lineChart);
         
        //Creating a scene object 
        Scene scene = new Scene(root, 600, 400); 

        //Adding scene to the stage 
        primaryStage.setScene(scene);
	   
        //Displaying the contents of the stage 
        primaryStage.show();

    }

    public void update(List<Company> companies, long year)
    {
        XYChart.Series current;

        if (series.size() == 0)
            initialiseSeries(companies);


        for (Company company : companies)
        {
            current = series.get(company.getName());
            current.getData().add(new XYChart.Data(year, company.getValue()));
            series.put(company.getName(), current);
        }
    }

    public void initialiseSeries(List<Company> companies)
    {
        XYChart.Series current;

        //Add a series for each of the companies
        for (Company company : companies)
        {
            current = new XYChart.Series();
            current.setName(company.getName());
            series.put(company.getName(), current);
        }
    }

    public void output(Exception e)
    {
        System.out.println(e.getMessage());
    }
}