package client;

import aggregators.Aggregator;
import aggregators.MeanAggregator;
import aggregators.MinAggregator;

public class Application {

	public static void main(String[] args) {
		String filepath = "table.csv";
		Aggregator values = new MeanAggregator();
		values.add(100.93);
		values.add(101.32);
		values.add(103.41);
		values.add(107.87);
		values.add(100.90);
		values.add(98.76);
		
		Aggregator minValue = new MinAggregator(values.getValues());
				
		double result = minValue.calculate();
		
		//System.out.println(result);
		//readStockInfo readStockInfo = new readStockInfo();
		//readStockInfo.readFile(filepath);

		ReadFileCollectionBased readFileCollectionBased = new ReadFileCollectionBased();
		readFileCollectionBased.readFile(filepath);

		
	}

}
