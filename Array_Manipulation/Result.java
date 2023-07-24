import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result{
    public static void main(String[] args) {
        List<List<Integer>> listOfIntList = new ArrayList<>();

        List<Integer> intList = new ArrayList<>();
        intList.add(0, 1);
        intList.add(1, 5);
        intList.add(2, 3);

        listOfIntList.add(0, intList);

        List<Integer> intList2 = new ArrayList<>();
        intList2.add(0, 4);
        intList2.add(1, 8);
        intList2.add(2, 7);

        listOfIntList.add(1, intList2);

        List<Integer> intList3  = new ArrayList<>();
        intList3.add(0, 6);
        intList3.add(1, 9);
        intList3.add(2, 1);

        listOfIntList.add(2, intList3);

        arrayManipulation(10, listOfIntList);

        // for(int i=0; i<listOfIntList.size(); i++){
        //     for(int j=0; j < listOfIntList.get(i).size(); j++){
        //         System.out.print(listOfIntList.get(i).get(j) + "\t") ;
        //     }
        //     System.out.println("");
        // }        
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long arr[] = new long[n+2];
        int a, b, k;
        long max = Long.MIN_VALUE;
        for(int i=0; i < queries.size(); i++){
            a = queries.get(i).get(0);
            b = queries.get(i).get(1);
            k = queries.get(i).get(2);
            arr[a] += k;
            arr[b+1] -= k;
            System.out.println(Arrays.toString(arr));
        }

        for(int i =0; i < arr.length; i++){
            if(i != 0){
                arr[i] = arr[i] + arr[i-1];
            }
            max = Math.max(max, arr[i]);

        }

        System.out.println(Arrays.toString(arr));

        return max;

    }


}