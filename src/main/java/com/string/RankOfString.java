package com.string;
class RankOfString
{
    static int findRank(String S)
    {
        int[] arr = new int[S.length()];
        for(int i=0;i<S.length();i++){
            int count=0;
            for(int j=i+1;j<S.length();j++){
              if((S.charAt(i)) > (S.charAt(j))){
                  count++;
              }
              if(S.charAt(i) == S.charAt(j) ){
                  return 0;
              }

            }
            arr[i]=count;
        }

        int rank=0;

        int fact = fact(S.length());
        for(int i=0;i<S.length();i++){
            fact=fact/(S.length()-(i));
            rank=rank+(fact*arr[i]);
        }
        rank=rank+1;
        return rank%1000000007;
    }


    private static int fact(int length) {
    	int i=1;
    	for(int j=length;j>0;j--) {
    		i=i*j;
    	}
    	return i;
	}


	public static void main(String[] args) {
    	String s ="acb";
    	System.out.println(findRank(s));
	}
}