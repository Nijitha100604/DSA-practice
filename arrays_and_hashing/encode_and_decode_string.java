package arrays_and_hashing;

/*
Given a list of strings, design an algorithm to encode it into a single string. 
The encoded string is then sent over the network and is decoded back to the original list of strings.
Please implement the encode and decode methods.

Example 1:
strings = ["Hello","World"]
Output: ["Hello","World"]
*/

import java.util.*;

public class encode_and_decode_string {

    public static String encode(String[] str){
        StringBuilder enc = new StringBuilder();
        for(String s: str){
            enc.append(s.length());
            enc.append("#");
            enc.append(s);
        }
        return enc.toString();
    }

    public static List<String> decode(String str){
        List<String> dec = new ArrayList<>();
        int length = str.length();
        int i=0;
        while(i < length){
            int j = i;
            while(str.charAt(j) != '#')
                j++;
            int size = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j+1, j+1+size);
            dec.add(word);
            i = j+1+size;
        }
        return dec;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] str = new String[num];
        for(int count = 0; count < num; count++){
            String value = sc.next();
            str[count] = value;
        }
        String encodedString = encode(str);
        System.out.println("Encoded String: " + encodedString);
        List<String> decodedStrings = decode(encodedString);
        System.out.println("Decoded Strings: " + decodedStrings);
        sc.close();
    }
}
