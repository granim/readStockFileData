package client;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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
        List<readStockInfo> beans = null;
        try {
            beans = new CsvToBeanBuilder(new FileReader(filepath))
                    .withType(readStockInfo.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(beans);
        System.out.println(beans.get(0) + " Zeroith index");
        System.out.println(beans.get(1) + "first index");
        System.out.println(beans.get(1).High);
        System.out.println(beans);

        return beans;
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
