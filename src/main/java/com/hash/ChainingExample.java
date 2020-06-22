package com.hash;

import java.util.ArrayList;

public class ChainingExample {
	public static void main(String[] args) {

	}

	public static void separateChaining(int arr[], int n,ArrayList<ArrayList<Integer>> hashTable, int hashSize){
			    for(int i=0;i<n;i++){
			        int hash= arr[i]%hashSize;
			        ArrayList<Integer> temp = new ArrayList<>();
			        temp.add(arr[i]);
			        if( hashTable.get(hash)!= null)
			             hashTable.get(hash).add(arr[i]);
			        else{
			            ArrayList<Integer> t = new ArrayList<>();
			            hashTable.add(hash,temp);
			        }
			    }
			}
}
