package geol_data;


import java.util.Comparator;

/**
 *  Класс для сравнения объектов типа MonolitData    */

public class MonolitDataComparator implements Comparator <MonolitData> {

    @Override
    public int compare(MonolitData o1, MonolitData o2) {
        int result = 0;
        if (o1.getDepth() > o2.getDepth()) {
            result = 1;
        }
        if (o1.getDepth() < o2.getDepth()) {
            result = -1;
        }
        if (o1.getDepth() == o2.getDepth()){
            result = 0;
        }
        return result;
    }
}
