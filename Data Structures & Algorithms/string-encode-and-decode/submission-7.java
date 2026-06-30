class Solution {

    public String encode(List<String> strs) {
        if(strs.size() < 1)
            return Character.toString((char) 258);
        String seperator = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s);
            sb.append(seperator);
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.equals(Character.toString((char) 258)))
            return new ArrayList<>();
        String seperator = Character.toString((char) 257);
        return new ArrayList(List.of(str.split(seperator, -1))); 
    }
}
