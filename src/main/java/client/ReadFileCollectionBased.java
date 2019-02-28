package client;


import com.opencsv.bean.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ReadFileCollectionBased {

    @CsvBindAndSplitByName(elementType = String.class, collectionType = ArrayList.class, splitOn = ",")
    List<? extends String> Open;

    @CsvBindAndSplitByName(elementType = Float.class)
    Collection<Float> High;

    @CsvBindAndSplitByName(elementType = Float.class)
    Collection<Float> Low;

    @CsvBindAndSplitByName(elementType = Float.class)
    Collection<Float> Close;

    @CsvBindAndSplitByName(elementType = Float.class)
    Collection<Float> Volume;

    @CsvBindAndSplitByName(elementType = Float.class)
    Collection<Float> Adj_Close;

    public List<? extends String> getOpen() {
        return Open;
    }

    public void setOpen(List<? extends String> open) {
        Open = open;
    }

    public Collection<Float> getHigh() {
        return High;
    }

    public void setHigh(Collection<Float> high) {
        High = high;
    }

    public Collection<Float> getLow() {
        return Low;
    }

    public void setLow(Collection<Float> low) {
        Low = low;
    }

    public Collection<Float> getClose() {
        return Close;
    }

    public void setClose(Collection<Float> close) {
        Close = close;
    }

    public Collection<Float> getVolume() {
        return Volume;
    }

    public void setVolume(Collection<Float> volume) {
        Volume = volume;
    }

    public Collection<Float> getAdj_Close() {
        return Adj_Close;
    }

    public void setAdj_Close(Collection<Float> adj_Close) {
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
        System.out.println();
        return beans;

    }

    @Override
    public String toString() {
        return "ReadFileCollectionBased{" +
                "Open=" + Open +
                ", High=" + High +
                ", Low=" + Low +
                ", Close=" + Close +
                ", Volume=" + Volume +
                ", Adj_Close=" + Adj_Close +
                '}';
    }
}
