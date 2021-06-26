// UMPIRE

// understand: same length, always string characters? or symbols as well? time/space constraints? NO characters - true, 
// match: arrays, comparing values, hashmaps better bc faster! and key/value SO HASHMAP :)
// plan! 

class Solution {
    
    // PLAN
    // populate the "key" of the hashmap with string s and populate the "value" of the hashmap with string t
    // 1. find the length of the strings
    //  a) if not same length, return false
    // 2) create hashmap (creating hashmap O(n) space)
    // 3) use for loop to iterate through all the values and populate hashmap
    // if key alrady exists in the hashmap
    //  a) check if the value equals the char we want 
            //i) if it doesnt, then return false
    //  b) if it doesn't exist,
        // i) add the key and the value
    //4) return true
    
    
    //IMPLEMENT
    public boolean isIsomorphic(String s, String t) {
        
        //1) check the length of the stengths
        if (s.length() != t.length()){
            return false;
        }
        
        //edge case - null 
        if(s==null || t==null){
            return false;
        }
        
        //2) create hashmap 
        HashMap<Character, Character> map = new HashMap<>();
        
        //3) use for loop to iterate through values and populate hashmap
        for (int i=0; i < s.length(); i++){
            if ( map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) != t.charAt(i) ){
                    return false;
                }
            } else{
                if( map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        
        return true;
        
    }
    
    /*
    
    TEST CASES
    
    
    s = "map", t = "car"
    
    line 27: true, skip
    line 32: creates hashmap
    line 34: 
    i   |   s   |  t    | map
    ___________________________
    0   |   m   | c     | {m:c}
    ________________________________
    1   |   a   | a     | {m:c, a:a}
    ________________________________
    2   |   p   | r     | {m:c, a:a, p:r}
    
    Line 45: return true
    
    
    
    */
}
