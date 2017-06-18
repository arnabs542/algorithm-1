/**
 * Created by epingho on 2017/6/18.
 */
public class strStr {

    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null){
            return -1;
        }
        if (source.length() - target.length() >= 0) {
            for (int i = 0; i < source.length() - target.length(); i++) {
                if (source.substring(i, i + target.length()).equals(target)) {
                    return i;
                }
            }
        }

        return -1;
    }

}
