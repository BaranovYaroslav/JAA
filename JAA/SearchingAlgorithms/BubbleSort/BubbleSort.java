package SearchingAlgorithms;

import java.util.Comparator;

/**
 * Created by Ярослав on 09.10.2016.
 */
public class BubbleSort<T extends Comparable> {

    public T[] sort(T[] array) {
        return sort(array, new Comparator<T>() {
            @Override
            public int compare(T el1, T el2) {
                return el1.compareTo(el2);
            }
        });
    }

    public T[] sort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) == 1) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

}
