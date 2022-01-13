/*
* Liam Geyer
* IST242 - Java Review Practice Quiz
* lfg5289@psu.edu
 */

public class Review {

    /*
    Returns the number of lowercase vowels in a string
    @param s
     */
    public static int countLowerVowels(String s){
        int count = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        //  iterate through the entire string
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            // determine if the current character is lowercase
            if (Character.isLowerCase(temp)){
                //  determine if the current character is a vowel
                for (char vowel : vowels){
                    if (vowel == temp){
                        //  increase the count
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /*
    Determines if each character is a string is unique
    @param s
     */
    public static boolean isAllDiff(String s){
        //  nested loop to compare each character in the string
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j < s.length(); j++){

                //  return false if it isn't unique
                if (s.charAt(i) == s.charAt(j)){
                    return false;
                }
            }
        }

        return true;
    }

    /*
    Converts an integer to a binary string
    @param n
     */
    public static String intToBin(int n){
        String s = "";

        //  convert the number to binary
        do {
            s = s.concat(String.valueOf(n % 2));
            n = n / 2;
        } while (n > 0);

        //  return the reversed string
        return new StringBuilder(s).reverse().toString();
    }

    /*
    Returns the acronym for a string/sentence
    @param s
     */
    public static String deriveAcronym(String s){
        //  create an array of each word in the sentence
        String[] words = s.split(" ");
        String acronym = "";

        for (String word : words){
            //  ensure the word starts with a capital letter
            char first = word.charAt(0);

            if (Character.isUpperCase(first)){
                //  Add the first letter to the acronym
                acronym = acronym.concat(String.valueOf(first));
            }
        }

        return acronym;
    }

    public static void main(String[] args) {
        System.out.println(countLowerVowels("aaaa")); // should return the value 4)
        System.out.println(countLowerVowels("abai")); // should return the value 3
        System.out.println(countLowerVowels("abaI")); // should return the value 2

        System.out.println(isAllDiff("eiEIo")); // should return true
        System.out.println(isAllDiff("abba")); // should return false (two b chars)
        System.out.println(isAllDiff("")); // should return true (trivial case)

        System.out.println(intToBin(8));   // should return 1000
        System.out.println(intToBin(19));  // should return 10011

        System.out.println(deriveAcronym("Institute of Electrical and Electronics Engineers")); // should return IEEE
        System.out.println(deriveAcronym("Self Contained Underwater Breathing Apparatus"));     // should return SCUBA
    }
}
