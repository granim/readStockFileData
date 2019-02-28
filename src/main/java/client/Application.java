package client;

import aggregators.Aggregator;
import aggregators.MeanAggregator;
import aggregators.MinAggregator;

import java.util.LinkedList;
import java.util.List;

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
		
		System.out.println(result);
		readStockInfo ReadStockInfo = new readStockInfo();
		List<readStockInfo> myList = ReadStockInfo.readFile(filepath);
	    System.out.println(ReadStockInfo.parseBeans(myList,25));
	    System.out.println(myList.get(0).getHigh());
	    System.out.println(ReadStockInfo.highs(myList));

	//	ReadFileCollectionBased readFileCollectionBased = new ReadFileCollectionBased();
	//	readFileCollectionBased.readFile(filepath);
	//	System.out.println(readFileCollectionBased.getOpen());
		
	}

}
