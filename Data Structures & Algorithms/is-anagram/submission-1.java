class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else
                map.put(c,1);
        }
        for(Character c : t.toCharArray()){
            boolean contains = map.containsKey(c);
            if(!contains || map.get(c) == 0)
                return false;
            else{
                    map.put(c, map.get(c)-1);
            }
        }
        for (int v : map.values()) {
            if (v != 0) return false;
        }
        return  true;
    }
}
