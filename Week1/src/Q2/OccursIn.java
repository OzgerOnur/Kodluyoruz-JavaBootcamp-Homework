package Q2;

public class OccursIn {

    public static boolean occursIn(String pattern, String str){
        String[] indexOfParts = pattern.split("\\*");


        for(int i = 0,j=0; i < indexOfParts.length; i++){

            if (str.indexOf(indexOfParts[i], j) >= 0) {
                j = str.indexOf(indexOfParts[i], j);
            }
            else{
                return false;
            }

        }
        return true;

    }
}
