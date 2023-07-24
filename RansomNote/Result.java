
import java.util.*;

class Result{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> magazineWords = new ArrayList<>();
        String input = "0";
        while(!input.equals("-1")){
            System.out.print("enter magazine word : \t" );
            input = scanner.nextLine();
            if (!input.equals("-1"))magazineWords.add(input);
        }
        List<String> noteWords = new ArrayList<>();
        String note = "";
        while(!note.equals("-1")){
            System.out.print("enter note : \t" );
            note = scanner.nextLine();
            if (!note.equals("-1"))noteWords.add(note);
        }
        System.out.println(Arrays.toString(magazineWords.toArray()));
        System.out.println(Arrays.toString(noteWords.toArray()));
        checkMagazine(magazineWords, noteWords);
    }

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> noteMap = new HashMap<>();
        Map<String, Integer> magazineMap = new HashMap<>();
        Integer occurrence = 0;
        for(String noteStr : note){
            occurrence = noteMap.get(noteStr);
            if(occurrence != null){
                noteMap.put(noteStr, ++occurrence);
            }else{
                noteMap.put(noteStr, 1);
            }
        }
        for(String magazineStr : magazine){
            occurrence = magazineMap.get(magazineStr);
             if(occurrence != null){
                magazineMap.put(magazineStr, ++occurrence);
            }else{
                magazineMap.put(magazineStr, 1);
            }
        }
        boolean isOK = true;
        for(String key : noteMap.keySet()){
            int noteOccurrence = noteMap.get(key);
            System.out.println(key + "---- note occ : " + noteOccurrence);
            int magazineOccurence = magazineMap.get(key) == null ? 0 : magazineMap.get(key);
            System.out.println(key + "----  mag occ : " + magazineOccurence);
            if(magazineOccurence < noteOccurrence){
                isOK = false;
            }
        }
        if(isOK){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}