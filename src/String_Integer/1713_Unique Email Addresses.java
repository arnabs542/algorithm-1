class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        for (String s: emails){
            String name = s.substring(0, s.indexOf('@'));
            String domain = s.substring(s.indexOf('@'), s.length());
            name = name.replace(".", "");
            if (name.indexOf('+') > -1){
                name = name.replace(name.substring(name.indexOf('+'), name.length()), "");
            }
            hs.add(name + domain);
        }
        
        return hs.size();
    }
}
