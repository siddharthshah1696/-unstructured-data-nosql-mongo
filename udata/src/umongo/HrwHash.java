package umongo;


import java.io.*;
import java.util.*;
import java.lang.*;


public class HrwHash {

	public HashMap<String,Integer> list=new HashMap<String,Integer>();
	
    public HrwHash(List<String> shards){
    	  for (String shard:shards){
	           list.put(shard,ConsistentHash.getMD5(shard).hashCode());
	      }
	}
	   


  
    public double compute_weighted_score(String node,String key){
	   
		  int score = MurmurHash.murmurhash3_x86_32(key, 0, key.length(),ConsistentHash.getMD5(node).hashCode());
	      return score*1.0/1000000000;
    }

	// Determines which node, of a set of nodes of various weights, is responsible for the provided key def 
    public String determine_responsible_node(String key){
	 
    	  double highest_score=-999999999; 
	      String champion=new String();
	   
	      for (String node : list.keySet()){
	     
	    	   double score = compute_weighted_score(node,key);
	    	   if(score > highest_score){
	    		   champion = node;
	    		   highest_score = score;
	    	   }

	      }
 //      System.out.println(champion+" : "+highest_score+"\n");
	   return champion;
	}
	   
}
