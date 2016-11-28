public class BinarySearch{

    public static int find(int[] array, int element){

        int index = -1;

        int low = 0;
        int high = array.length;
        int middle = 0;

        while (low <= high) {
            middle = (low + high) / 2;
            if(array[middle] == element){
                index = middle;
                break;
            }
            else {
                if(array[middle] < element){
                    low = middle + 1;
                }
                else{
                    high = middle - 1;
                }
            }
        }
        return index;
    }

}
