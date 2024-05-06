public class App {
    
    public static void main(String[] args) throws Exception {
        int[] arr= {49, 32, 14, 78, 90, 0, 11, 1};
        int n = arr.length;

        mergeSort(arr, 0,  n-1); // llamada al metodo de ordenamiento

    


        System.out.println("Arreglo ordenado:");

        for (int num : arr) {
            System.out.println(num + "");
            
        }



    }


    public static void mergeSort(int[] arr, int left, int right){

        if (left < right) {
            //Encuentra el punto medio del arreglo
            int mid= (left+right) / 2;

            //Ordena recursivamente la mitad izquierda
            mergeSort(arr, left, mid);
            //Ordena recursivamente la mitad derecha
            mergeSort(arr, mid + 1 , right);
            
            //Combina las dos mitades ordenadas
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right){

        //Tamaños de los subarreglos a fusionar
        int sizeLeft= mid-left+1;
        int sizeRight= right-mid;

        //Arreglos temporales para almacenar los subarreglos
        int[] tempLeft= new int[sizeLeft];
        int[] tempRight= new int[sizeRight];

        //Copia los datos a los arreglos temporales
        for (int i=0; i < sizeLeft; i++) {
            tempLeft[i]= arr[left+i];    
        }
        for (int j=0; j < sizeRight; j++) {
            tempRight[j]= arr[mid+1+j];
        }

        //Fusiona los subarreglos temporales en el arreglo original
        int i= 0, j= 0;
        int k= left; //indice inicial para el arreglo fucionado

        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k]= tempLeft[i];
                i++;
            } else {
                arr[k]= tempRight[j];
                j++;
                
            }
            k++;
            
        }

        //copia elementos restantes de tempLeft[] si los hay
        while (i < sizeLeft) {
            arr[k]= tempLeft[i];
            i++;    
            k++;
            
        }

        //copia elementos restantes de tempRigth si hay
        while (j < sizeRight) {
            arr[k]= tempRight[j];
            j++;
            k++;
            
        }


    }




}

