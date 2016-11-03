/**
 * Created by ScorpionOrange on 2016/10/31.
 * www.lintcode.com/zh-cn/problem/hash-function/
 * 对几个数的和取余数，等于对这几个数分别取余数，再对余数的和取余数；
 * 定义： m % n = m - an = b (b < n);
 * 加法： (m + n) % p = (m % p + n % p) % p ;
 * 减法： (m - n) % p = (m % p - n % p) % p ;
 * 乘法： (m * n) % p = (m % p * n % p) % p ;
 */
public class HashCode {
    public static void main(String[] args){
        //String s = "abcd";
        //String s = "ubuntu";
        String s = "abcdefghijklmnopqrstuvwxyz";
        //String s = "Wrong answer or accepted?";

        char[] key = s.toCharArray();
        //int HASH_SIZE = 1000;
        //int HASH_SIZE = 1007;
        int HASH_SIZE = 2607;
        //int HASH_SIZE = 1000000007;
        System.out.println(new Solution().hashCode(key, HASH_SIZE));
    }
}

class Solution{
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    /*
    public int hashCode(char[] key, int HASH_SIZE){
        // write your code here

        int sum = 0;
        for(int i = 0; i < key.length; i++){
            int p = HASH_SIZE;
            int m = (int)key[i];
            int n = powerAndMod(33, key.length - i - 1, p);
            sum = sum + ((m % p) * (n % p)) % p;
        }
        int output = sum % HASH_SIZE;
        return output;
    }

    public int powerAndMod(int base, int index, int mod){
        long output = 0;
        for(int i = index; i > 0; i--){
            output = (output * base) % mod;
        }
        return (int)(output % mod);
    }
    */
    public int hashCode(char[] key,int HASH_SIZE) {
        int result = 0;
        for (int i = 0; i < key.length; i++) {
            result = helper(result, 33, HASH_SIZE);
            result = result + key[i];
            result = result % HASH_SIZE;
        }
        return result;
    }

    int helper(int num, int base, int mod) {
        int result = 0;
        int temp = num - mod;
        for (int i = 0; i < base; i++) {
            if (result + temp > 0) {
                result = result + temp;
            } else {
                result = result + num;
            }
        }
        return result;
    }
}
