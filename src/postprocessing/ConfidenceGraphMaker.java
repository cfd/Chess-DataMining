package postprocessing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ConfidenceGraphMaker {

	public LinkedHashMap<String, Double> graphData;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConfidenceGraphMaker cgm = new ConfidenceGraphMaker();

		try {
			cgm.run("sequencesOf4/s4ConfidenceBlack.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run(String fileToGraph) throws IOException {

		graphData = new LinkedHashMap<String, Double>();

		Scanner scanner = new Scanner(new FileReader(fileToGraph));

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			String[] pieces = line.split(",");

			for (int i = 0; i < pieces.length; i += 2) {
				graphData.put(pieces[i], Double.parseDouble(pieces[i + 1]
						.substring(0, pieces[i + 1].length() - 1)));
			}

		}

		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		for (String key : graphData.keySet()) {
			if (graphData.get(key) >= 50.00) {

				ds.addValue(graphData.get(key), "A", key);
			}

		}

		JFreeChart bc = ChartFactory.createBarChart("Best 4-move Sequences for Black", "Sequences",
				"Confidence", ds, PlotOrientation.VERTICAL, false, false, false);
		
		CategoryAxis axis = bc.getCategoryPlot().getDomainAxis();
		axis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		// ChartFrame cf = new ChartFrame("Test", bc);
		// cf.setSize(4000, 2600);
		// cf.setVisible(true);
		ChartUtilities.saveChartAsPNG(new File("s4BlackSmall.png"), bc, 400, 260);

	}
}
