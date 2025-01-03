class Solution {
    public String solution(String my_string) {
        String[] arr = {"a","e","i","o","u"};
        for (int i = 0; i < arr.length; i++) {
            if(my_string.contains(arr[i])){
                my_string = my_string.replace(arr[i],"");
            }
        }
        return my_string;
    }
}