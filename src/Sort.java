import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {

        int[] array = {2, 123, 121, 545, 1, 0, -19, 24, 50, 57, 3234, 23, 1, -111, 34, 57, -159};
        String[] m = {"abc", "xyz", "abcd", "bcd", "abc"};
        //printInSortedOrder(m);


        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        //HeapSort hp = new HeapSort();
        //hp.sort(array);

        //TreeSort tr = new TreeSort();
        //tr.treeins(array);
        //tr.inorderRec(tr.root);

        //mergeSort(array, 0, array.length);
        //selectionSort(array);
        //quickSort(array, 0, array.length-1);
        //bubbleSort(array);
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    static void printInSortedOrder(String[] array){
        Trie trie = new Trie();
        for(int i = 0; i < array.length; i++){
            trie.insert(array[i], i);
        }
        trie.traversePreorder(array);
    }

    static void quickSort(int[] m, int low, int high){
        if(m.length == 0){
            return;
        }
        if(low >= high){
            return;
        }

        int middle = low + (high - low) / 2;
        int opora = m[middle];
        int i = low, j = high;

        while(i <= j){
            while(m[i] < opora){
                i++;
            }
            while(m[j] > opora){
                j--;
            }
            if(i <= j){
                int temp = m[i];
                m[i] = m[j];
                m[j] = temp;
                i++;
                j--;
            }
        }
        if(i < high){
            quickSort(m, i, high);
        }
        if(j > low){
            quickSort(m, low, j);
        }
    }

    static void bubbleSort(int[] m){
        int n = m.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(m[j] > m[j+1]){
                    int temp = m[j];
                    m[j] = m[j+1];
                    m[j+1] = temp;
                }
            }
        }
    }

    static void selectionSort(int[] m){
        int n = m.length;
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(m[min] > m[j]){
                    min = j;
                }
            }
            int temp = m[min];
            m[min] = m[i];
            m[i] = temp;
        }
    }

    static void mergeSort(int[] m, int low, int high){
        if(low+1 < high){
            int mid = (low + high) >>> 1;
            mergeSort(m, mid, high);
            mergeSort(m, low, mid);

            int size = high - low;
            int[] b = new int[size];
            int i = low;
            int j = mid;

            for(int k = 0; k < size; k++){
                if(j >= high || i < mid && m[i] < m[j]){
                    b[k] = m[i++];
                }
                else {
                    b[k] = m[j++];
                }
            }
            System.arraycopy(b, 0, m, low, size);
        }
    }
}

