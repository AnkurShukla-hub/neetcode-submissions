class Solution {

    public String encode(List<String> strs) {
       StringBuilder sb=new StringBuilder();
       for(String str:strs){
        sb.append(str.length()).append('#').append(str);
       }
       return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int  j=str.indexOf('#',i);
            int length=Integer.parseInt(str.substring(i,j));
            i=j+1;
            String orignalStr=str.substring(i,i+length);
            result.add(orignalStr);
            i+=length;
        }
        return result;
    }
}
