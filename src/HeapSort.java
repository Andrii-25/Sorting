public class HeapSort {

    public void sort(int[] m){
        int n = m.length;

        for(int i = n/2-1; i >= 0; i--){
            heapify(m, n, i);
        }

        for(int i = n-1; i > 0; i--){
            int temp = m[i];
            m[i] = m[0];
            m[0] = temp;

            heapify(m, i, 0);
        }
    }

    void heapify(int[] m, int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l < n && m[l] > m[largest]){
            largest = l;
        }
        if(r < n && m[r] > m[largest]){
            largest = r;
        }
        if(largest != i){
            int swap = m[i];
            m[i] = m[largest];
            m[largest] = swap;

            heapify(m, n, largest);
        }
    }

    static void printArray(int[] m){
        int n = m.length;
        for(int i = 0; i < n; i++){
            System.out.print(m[i]+" ");
            System.out.println();
        }
    }
}
