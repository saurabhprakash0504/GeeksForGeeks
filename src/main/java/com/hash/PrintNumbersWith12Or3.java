package com.hash;

public class PrintNumbersWith12Or3 {
	public static void main(String[] args) {
		int[] arr= {5,4};
		method1(arr);
		method2(arr);
	}

	static void method1(int[] a) {
		int n =a.length;
		 for(int i = 0; i < n; i++)
         {
             boolean flag=true;
             int temp=a[i];
             while(temp!=0){
                 int rem=temp%10;
                 if(rem!=1 && rem!=2 && rem !=3){
                     flag=false;
                     break;
                 }
                 temp=temp/10;
             }
             if(flag)
             System.out.print(a[i] +" ");

         }
	}


	static void method2(int[] a) {
		System.out.println("method2");
		 for(int i = 0; i < a.length; i++)
         {
			 String s =Integer.toString(a[i]);
			 if(!s.contains("1")&&!s.contains("2")&&!s.contains("3")) {
				 continue;
			 }
			 else {
				 System.out.println(a[i]);
			 }
         }
	}
}
