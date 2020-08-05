class Solution {
    public void print(String s, String out, int i, int dot, ArrayList <String> l) {
        if(dot == 4 && i == s.length()) {
            l.add(out.substring(1,out.length()));
            return ;
        }
        if(dot >= 4)
        return ;
        String str = "";
        for(int j = i; j < Math.min(s.length(), i + 3);j++) {
            str += s.charAt(j);
            int cc = str.length();
            int nn = Integer.parseInt(str);
            if((str.charAt(0) == '0') && (str.length() > 1))
                continue;
            if((dot < 4) && (nn < 256)) {
                print(s, out+"."+str, j+1, dot+1, l);
            } 
        }
    }
    public ArrayList<String> genIp(String s) {
         ArrayList <String> l = new ArrayList <String>();
         String s1 = "67", s2 = "255";
         print(s, "", 0, 0, l);
         //System.out.println(s1.compareTo(s2));
         return l;
         
    }
}