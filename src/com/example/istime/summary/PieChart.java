package com.example.istime.summary;

import org.afree.chart.AFreeChart;
import org.afree.chart.ChartFactory;
import org.afree.chart.plot.PiePlot;
import org.afree.chart.title.TextTitle;
import org.afree.data.general.DefaultPieDataset;
import org.afree.data.general.PieDataset;
import org.afree.graphics.geom.Font;

import android.content.Context;
import android.graphics.Typeface;

public class PieChart extends DemoView{
    /**
     * constructor
     * @param context
     */
    public PieChart(Context context) {
        super(context);


        final PieDataset dataset = createDataset();
        final AFreeChart chart = createChart(dataset);


        setChart(chart);
    }


    /**
     * Creates a sample dataset.
     * @return a sample dataset.
     */
    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Work - 43.2%", new Double(43.2));
        dataset.setValue("Family - 36.8%", new Double(36.8));
        dataset.setValue("Friends- 20%", new Double(20.0));
        return dataset;
    }


    /**
     * Creates a chart.
     * @param dataset the dataset.
     * @return a chart.
     */
    private static AFreeChart createChart(PieDataset dataset) {


        AFreeChart chart = ChartFactory.createPieChart("Chart Analysis", // chart title
                dataset, // data
                true, // include legend
                true,
                false);
        TextTitle title = chart.getTitle();
        //title.setToolTipText("A title tooltip!");


        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Typeface.NORMAL, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;


    }
}
