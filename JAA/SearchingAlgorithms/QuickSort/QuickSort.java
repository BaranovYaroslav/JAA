package SearchingAlgorithms;

import java.util.Comparator;

public class QuickSort<T extends Comparable<T>> {

    private Comparator<T> defaultComparator = new Comparator<T>() {
        @Override
        public int compare(T el1, T el2) {
            return el1.compareTo(el2);
        }
    };

    public T[] sort(T[] array) {
        return sort(array, defaultComparator);
    }

    public T[] sort(T[] array, Comparator<T> comparator) {
        return quickSort(array, 0, array.length - 1, comparator);
    }

    private T[] quickSort(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
        int i = lowIndex;
        int j = highIndex;
        T medium = array[lowIndex + (highIndex - lowIndex) / 2];

        do {
            while (comparator.compare(array[i], medium) == -1) {
                i++;
            }
            while (comparator.compare(array[j], medium) == 1) {
                --j;
            }
            if (i <= j) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (lowIndex < j) {
            quickSort(array, lowIndex, j, comparator);
        }
        if (i < highIndex) {
            quickSort(array, i, highIndex, comparator);
        }
        return array;
    }

}
