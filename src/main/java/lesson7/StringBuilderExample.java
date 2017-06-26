package lesson7;

/**
 * Created by Dell-SSD on 26.04.2017.
 */
public class StringBuilderExample {
    public static void main(String[] args) {


        StringBuilder builder = new StringBuilder();
        int startOfSubstrIncl = 3;
        int endOfSubstrExcl = 5;
        int indexOffset = 4;
        int charIndex = 4;
        builder.append("new ending");
        builder.delete(startOfSubstrIncl, endOfSubstrExcl);
        builder.insert(indexOffset, "some sub string");
        builder.replace(startOfSubstrIncl,
                endOfSubstrExcl, "replace");
        builder.setCharAt(charIndex, 'a');
        String builderString = builder.toString();
        System.out.println(builderString);

           /* public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
            char x ;
            int n = 3;*/

    }
}
