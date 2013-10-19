package confidence;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ConfidenceCalculator {

	public LinkedHashMap<String, Integer> mixedMoveSupportMap;
	public LinkedHashMap<String, Integer> resultMoveSupportMap;
	public BufferedWriter writer;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConfidenceCalculator cc = new ConfidenceCalculator();
		try {
			cc.populateMixedResultSupportMap();
			cc.populateSupportMap();

			try {
				cc.calculateConfidenceForResult();
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void populateMixedResultSupportMap() throws FileNotFoundException {

		mixedMoveSupportMap = new LinkedHashMap<String, Integer>();

		Scanner scanner = new Scanner(new FileReader(
				"sequencesOf2/s2SupportMixed.txt"));

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			// System.out.println(line);
			String[] pieces = line.split(",");

			for (int i = 0; i < pieces.length; i += 2) {
				mixedMoveSupportMap.put(pieces[i],
						Integer.parseInt(pieces[i + 1]));
			}

			// for(String key : mixedMoveSupportMap.keySet()){
			// System.out.println(key + " : " + mixedMoveSupportMap.get(key));
			// }

		}
	}

	public void populateSupportMap() throws FileNotFoundException {

		resultMoveSupportMap = new LinkedHashMap<String, Integer>();

		Scanner scanner = new Scanner(new FileReader(
				"sequencesOf2/s2SupportDraw.txt"));

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			// System.out.println(line);
			String[] pieces = line.split(",");

			for (int i = 0; i < pieces.length; i += 2) {
				resultMoveSupportMap.put(pieces[i],
						Integer.parseInt(pieces[i + 1]));
			}

			// for(String key : resultMoveSupportMap.keySet()){
			// System.out.println(key + " : " + resultMoveSupportMap.get(key));
			// }

		}
	}

	public void calculateConfidenceForResult() throws IOException {
		writer = new BufferedWriter(
				new FileWriter("s2ConfidenceDraw.txt", true));

		for (String move : mixedMoveSupportMap.keySet()) {
			if (resultMoveSupportMap.containsKey(move)) {
				// System.out.println(resultMoveSupportMap.get(move) + " / " +
				// mixedMoveSupportMap.get(move));
				double confidence = (double) resultMoveSupportMap.get(move)
						/ (double) mixedMoveSupportMap.get(move) * 100;
				System.out.println(String.format(move + ",%.2f", confidence)
						+ "%");

				writer.write(String.format(move + ",%.2f", confidence) + "%");
				writer.newLine();
			}
		}
		writer.close();
	}
}
