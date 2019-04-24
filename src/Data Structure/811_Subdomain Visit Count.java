//O(n)

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s: cpdomains){
            String[] log = s.split(" ");
            int count = Integer.parseInt(log[0]);
            String[] domains = log[1].split("\\.");

            String domain = "";
            for (int i = domains.length - 1; i >= 0; i --){
                if (i == domains.length - 1){
                    domain = domains[i];
                } else {
                    domain = domains[i] + "." + domain;
                }

                if (hm.containsKey(domain)){
                    hm.put(domain, hm.get(domain) + count);
                } else {
                    hm.put(domain, count);
                }
            }
        }
        
        List<String> result = new ArrayList<String>();
        for (String s: hm.keySet()){
            result.add(hm.get(s) + " " + s);
        }
        
        return result;
    }
}
