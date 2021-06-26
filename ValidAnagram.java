//UMPIRE

//UNDERSTAND: 
    // t needs to be an anagram of s; no null strings, s and t are lower case english
    // letters -- no symbols
    // anagram - characters in s can be rearranged into t, and viceversa
    // most efficient time 

//MATCH:
    //hashmap - need to build the map that has a letter and the number of times the 
    //the letter appears
    // O(n) space, O(1) lookup and insertion

//PLAN
    //1) check if string lengths are the same
        //a) if not return false
    //2) create a hashmap
    //3) insertion
        // a) insert string s chars into hashmap 
                // if exists already increment value by 1
                // else add the key and value = 1
    //4) Check hashmap with string t (decrease to 0)
        // a) loop through characters in t, for each character check in hashmap if 
        // key exists (if not, return false)
        // if character does exist, decrease its value in hm by 1
        // else return false

    //5) Check that all values in hashmap are 0
        // if not return false

// a: 2, n:0, g:0, r:1 , m:1 
class Solution {
    
    //IMPLEMENT
    public boolean isAnagram(String s, String t) {
        
        // 1
        if (s.length() != t.length()) return false;
        
        // 2
        HashMap <Character, Integer> map = new HashMap <>();
        
        //3 - loop through s, add to map
        for (int i=0; i< s.length(); i++){
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        
        //4 - loop through t, check if exists in hm, subtract
        for (int j = 0; j < t.length(); j++){
            if(map.containsKey(t.charAt(j))) {
                //System.out.println("4 --- " + t.charAt(j) +"  "+ map.get(t.charAt(j)));
                
                int value = map.get(t.charAt(j));
                value--;
                
                
                if( value < 0)
                {
                    return false;
                }
                map.remove(t.charAt(j));
                map.put(t.charAt(j), value);
                
                //map.put(t.charAt(j), map.get(t.charAt(j)-1));
                //System.out.println("4 --- " + t.charAt(j) +"  "+ map.get(t.charAt(j)));
            }
            else {
                return false;
            }
                        
        }
        
        System.out.println(map.entrySet());
        //5 - check that all values in map == 0
        for (int i=0; i< map.size(); i++){
            
            //System.out.println("\n\n" + map.get(i));
            if (map.get(i) != null) return false;
            
        }
        return true;
        
    }
}

/*
REVIEW

s = "anagram", t = "nagaram"

line 38: true, skips return
line 41: creates hashmap
line 44: {a:3, n:1, g:1, r:1, m:1 }
line 54: {a:0, n:0, g:0, r:0, m:0 }
line 65: exists loop
line 68: returns true

Space = O(n), Time = O(n)


*/

/*
REVIEW 2

s = "rat", t = "car"

line 38: same length, skip
create hashmap
line 44: {r:1, a:1, t:1}
line 54: {c} does not exist as a key in map, so return false

*/
