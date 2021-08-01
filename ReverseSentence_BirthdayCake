/*  Birthday Cake Reverse String Problem

I call this the birthday cake problem :) because the original example had a sentence like "steal the cake", and it's also my friend's bday today! 

UMPIRE

U - reverse the words in a string. a word: non space character sequence

M - match to reverse a string we COULD use a stack but if we just use two pointers we can swap the letters and keep the space complexity at O(1) while using a stack would push it up to O(N). but we ended up using a char array anyway so o(n) space complexity

P - plan

go steal cake 
ekac laets og
cake steal go 

0. go through string, clean of ALL extra spaces (extra start, middle, and end)
1. set pointer 1 to index 0
2. set pointer 2 to length of string -1
3. swap pointer 1 character with pointer 2 character until ! pointer1< pointer2 (use while, include spaces)
4. once your entire string is swapped, we have to swap each individual word
5. swap each individual word

ideally, we use ONE swapping method for both the entire string and individual words 

CHECK FOR EDGE CASES

*/

class Solution {
    public String reverseWords(String s) {
        
        // 0. Variables
        int p1, p2;
        
        // 1. Clean up string from spaces 
        s = s.trim();                        // delete initial and ending spaces
        s = s.replaceAll(" +", " ");        // replace extra spaces just for one
        
        // 2. Add characters of string to ARRAY
        int cleanSize = s.length();
        char charArray[] = new char[cleanSize];  // character array
        
        for (int i=0; i< cleanSize; i++){  // loop through string characters, add to char array
            charArray[i] = s.charAt(i);   // i hope this also adds spaces
        }
        
        // 3. set pointers 1 and 2 
        p1 = 0;                    // pointer 1 starts at the beginning of the character array
        p2 = cleanSize-1;                    // pointer 2 starts at the end of the array
        
        // 4. set up WHILE LOOP, swap pointers
        while (p1 < p2){   // until the pointers meet
            // swap letter in pointer 1 with letter in pointer 2
            Character temp = charArray[p2];  
            charArray[p2] = charArray[p1];
            charArray[p1] = temp;
            
            // move pointers along array
            p1++;
            p2--;
        }
        
        // sentence is now scrambled
        
        // 5. use same swap method to swap individual words
        p1 =0;  //reset
        p2 =0;
        int nextp1 = 0;
        
        for (int i=0; i<= cleanSize-1; i++){
            // set p2 pointer at end of word (if there is a space after the word OR it's the end of the sentence)
            if (i == cleanSize-1 || charArray[i+1] == ' '){
                
                if (nextp1 !=0){
                    p1 = nextp1;
                }
                
                p2 = i;                      // we found a p2
                nextp1 = p2 + 2; // OR + 1? 
                
                // swap p1 and p2 for the whole word 
                while (p1 < p2){
                    Character temp = charArray[p2];  
                    charArray[p2] = charArray[p1];
                    charArray[p1] = temp;  
                    
                    p1++;
                    p2--;
                }
            }
            p2++;
        }
        
        // 6. return String but in correct reversed order 
        String answer = new String(charArray);
        
        return answer;
    }
}

// implement & evaluate
// to - do: what is a more efficient way to solve this problem?
