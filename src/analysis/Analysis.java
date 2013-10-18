package analysis;

import java.io.IOException;

public class Analysis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlgoApriori apriori = new AlgoApriori();
		try {
			//S1
			//apriori.runAlgorithm(0.0, "chessGamesWhite.csv", "chessResultsWhite.txt");
			//apriori.runAlgorithm(0.0, "chessGamesBlack.csv", "chessResultsBlack.txt");
			//apriori.runAlgorithm(0.0, "chessGamesDraw.csv", "chessResultsDraw.txt");
			//apriori.runAlgorithm(0.00265, "chessGamesMixed.csv", "chessResultsMixed.txt");
			
			//S2
			//apriori.runAlgorithm(0.0, "chessGamesWhite.csv", "chessResultsWhiteS2.txt");
			//apriori.runAlgorithm(0.0, "chessGamesBlack.csv", "chessResultsBlackS2.txt");
			//apriori.runAlgorithm(0.0, "chessGamesDraw.csv", "chessResultsDrawS2.txt");
			//apriori.runAlgorithm(0.00265, "chessGamesMixed.csv", "chessResultsMixedS2.txt");
			
			//S3
			apriori.runAlgorithm(0.0, "chessGamesWhite.csv", "s3SupportWhite.txt");
			//apriori.runAlgorithm(0.0, "chessGamesBlack.csv", "s3SupportBlack.txt");
			//apriori.runAlgorithm(0.0, "chessGamesDraw.csv", "s3SupportDraw.txt");
			//apriori.runAlgorithm(0.00265, "chessGamesMixed.csv", "s3SupportMixed.txt");
			
			//S4
			//apriori.runAlgorithm(0.0, "chessGamesWhite.csv", "s4SupportWhite.txt");
			//apriori.runAlgorithm(0.0, "chessGamesBlack.csv", "s4SupportBlack.txt");
			//apriori.runAlgorithm(0.0, "chessGamesDraw.csv", "s4SupportDraw.txt");
			//apriori.runAlgorithm(0.00265, "chessGamesMixed.csv", "s4SupportMixed.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
