package client;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class readStockInfo {

    @CsvBindByName
    private String Open;
    @CsvBindByName
    private String High;
    @CsvBindByName
    private String Low;
    @CsvBindByName
    private String Close;
    @CsvBindByName
    private String Volume;
    @CsvBindByName
    private String Adj_Close;

    public String getOpen() {
        return Open;
    }

    public void setOpen(String open) {
        Open = open;
    }

    public String getHigh() {
        return High;
    }

    public void setHigh(String high) {
        High = high;
    }

    public String getLow() {
        return Low;
    }

    public void setLow(String low) {
        Low = low;
    }

    public String getClose() {
        return Close;
    }

    public void setClose(String close) {
        Close = close;
    }

    public String getVolume() {
        return Volume;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public String getAdj_Close() {
        return Adj_Close;
    }

    public void setAdj_Close(String adj_Close) {
        Adj_Close = adj_Close;
    }

    public static List readFile(String filepath) {
        List<readStockInfo> beans = new LinkedList<>();
        try {
            beans = new CsvToBeanBuilder(new FileReader(filepath))
                    .withType(readStockInfo.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return beans;
    }

    public static Object parseBeans(List list, Integer index){
        return list.get(index);
    }

    //A method that takes the list of beans and returns all the highs
    public static List<String> highs(List<readStockInfo> list) {
        List<String> listOfHighs = new ArrayList<>();
        for(readStockInfo find : list) {
            listOfHighs.add(find.getHigh());
        }
       return  listOfHighs;
    }

    public static List<String> lows(List<readStockInfo> list) {
        List<String> listOfLows = new ArrayList<>();
        for(readStockInfo find : list) {
            listOfLows.add(find.getLow());
        }
        return  listOfLows;
    }





    public static List<String> findHigh(List<String> list) {
        List<String> returnList = new ArrayList<>();
        for (String high : list) {
                 if(high.contains("High")) {
                     returnList.add(high);
                 }
        }
        return returnList;
    }


    @Override
    public String toString() {
        return "readStockInfo{" +
                "Open='" + Open + '\'' +
                ", High='" + High + '\'' +
                ", Low='" + Low + '\'' +
                ", Close='" + Close + '\'' +
                ", Volume='" + Volume + '\'' +
                ", Adj_Close='" + Adj_Close + '\'' +
                '}';
    }




}
