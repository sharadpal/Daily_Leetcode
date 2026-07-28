class Solution {
    public String smallestPalindrome(String s) {
        int n= s.length();
        StringBuilder st= new StringBuilder();
        char[] ch=(s.substring(0,n/2)).toCharArray();
        Arrays.sort(ch);

        st.append(new String(ch));
        if(n%2!=0) st.append(s.charAt(n/2));

        st.append(new StringBuilder(new String(ch)).reverse());
        return st.toString();
    }
}