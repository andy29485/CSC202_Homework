//Andriy Zasypkin
//2015-09-18
//Homework 03

import java.io.*;

public class Stat {
  public static String getStatment(BufferedReader input) throws IOException {
    StringBuffer strbIn = new StringBuffer("");
    //Statments end with a period(".") not a \n
    //  so the readLine() method may not give the needed output
    //  Instead one char wll be read at a time - untill the delimiter(".")
    //  is found - at which point a string is returned
    do {
      strbIn.append((char)input.read());
    } while(strbIn.indexOf(".") == -1);
    return strbIn.toString();
  }
  
  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
        = new BufferedReader(new InputStreamReader(System.in));
    
    /*strTmpStatment
     *  tmp placeholder for the current statment
     *  that is being processed
     *strLargestStatment
     *  largest statment so far
     *nvowels
     *  number of vowels(per statment)
     *nTotalE
     *  number of 'e'(or 'E') (overall)
     *nTotalChars
     *  number of chars(overall)
     *nTotalVowels
     *  number of vowels(overall)
     *nTotalConsonants
     *  number of consonants(overall)
     *nLargestStatmentIndex
     *  number of largest statment
     *nMostVowels
     *  number of vowels in statment with the most vowels
     *nMostVowelsIndex
     *  index of statment with the most vowels
     */
    String strTmpStatment        = "";
    String strLargestStatment    = null;
    int    nvowels               = 0;
    int    nTotalE               = 0;
    int    nTotalChars           = 0;
    int    nTotalVowels          = 0;
    int    nTotalConsonants      = 0;
    int    nLargestStatmentIndex = 0;
    int    nMostVowels           = 0;
    int    nMostVowelsIndex      = 0;
    
    for(int i=0; i<4; i++) {
      //reset char count:
      nvowels = 0;
      
      //INPUT:
      //Ask for a string and save it as the current statment
      System.out.println("Enter a statment - end with a period(\".\"):");
      strTmpStatment = getStatment(input);
      
      if(strLargestStatment == null) {//set initial value of largest statment
        strLargestStatment    = strTmpStatment;
        nLargestStatmentIndex = i+1;
      }
      
      for(Character ch : strTmpStatment.toCharArray()) {
        if(Character.toLowerCase(ch) == 'e') {
          nTotalE++;  //increase 'e' count
        }
        if("aeiouAEIOU".indexOf(ch) >= 0) {
          //OUTPUT:
          //print vowels as they are found
          System.out.print(ch);
          nvowels++;      //increase vowel count
          nTotalVowels++; //increase total vowel count
        }
        else if(Character.isLetter(ch)) {
          nTotalConsonants++;//increase total consonants count 
        }
      }
      //OUTPUT:
      //pint num vowels and size of current statment
      System.out.printf("\nNum vowels: %d\nSize of line: %d\n\n",
                        nvowels, strTmpStatment.length());
      //if current statment is larger than current largest statment
      //  set largest to current and save index
      if(strLargestStatment.compareTo(strTmpStatment) < 0) {
        strLargestStatment    = strTmpStatment;
        nLargestStatmentIndex = i+1;
      }
      //if current statment has more vowels than the one that used to have
      //  the most vowels - overwrite its position as the one with the most
      //  vowels
      if(nMostVowels < nvowels) {
        nMostVowels = nvowels;
        nMostVowelsIndex = i+1;
      }
      //Increase total chars
      nTotalChars += strTmpStatment.length();
    }
    
    //OUTPUT:
    //print overall stats
    System.out.println("\nTotal doument statistics:");
    System.out.printf("Total vowels:                  %7d\n", nTotalVowels);
    System.out.printf("Ratio of 'e' to other vowels:  %6f\n",
                  (double)nTotalVowels/(double)(nTotalVowels-nTotalE));
    System.out.printf("Ratio of vowels to consonants: %6f\n",
                  (double)nTotalE/(double)nTotalConsonants);
    System.out.printf("Number of chars (in bytes):    %7d(bytes)\n",
                  nTotalChars*2);
    System.out.printf("Statment #%d had the most vowels(%d)\n",
                   nMostVowelsIndex, nMostVowels);
    System.out.printf("Statment #%d was the larges(by ASCII value)\n",
                   nLargestStatmentIndex);
    System.exit(0);
  }
}
