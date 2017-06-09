package umongo;

	import java.io.*;
	import java.security.*;
	import java.util.*;
	
	public class ConsistentHash {
	private int replicas;
	private SortedMap<Integer,String> ring = new TreeMap<Integer,String>();
	
	public ConsistentHash(List<String> shards, int replicas){		
	    
		  this.replicas=replicas;
	      for (String shard:shards){
	           addToRing(shard);
	      }
	}
	
	//add servers to points on the hash ring
	
	public void addToRing(String shard){
	      System.out.println();
	      
		  for (int i=0;i<replicas;i++){
	           ring.put(getMD5(shard).hashCode()+(i*1135262919),shard);
	           System.out.println(" "+shard+" "+(getMD5(shard).hashCode()+(i*1135262919)));
	
	                 
	      }
		  
	}
	
	public void removeFromRing(String shard){
		System.out.println();
		
		for(int i=0; i<replicas; i++){
			ring.remove(getMD5(shard).hashCode()+(i*1135262919),shard);
			System.out.println("Removed "+shard+" "+(getMD5(shard).hashCode()+(i*1135262919)));
		}
	}
	
	
	public void printRange(){
		
	
		for(Integer k  : ring.keySet()){
			System.out.println(" "+k+" "+ring.get(k));
		   }
		
	}
	//returns shard assigned to a key
	
	public String getShard (String s){
	
		int hash = getMD5(s).hashCode();
    //	    System.out.println("Hash is "+hash+"\n");
		if (!ring.containsKey(hash)){
	
			SortedMap<Integer,String> tmap = ring.tailMap(hash);
	        hash = tmap.isEmpty() ? ring.firstKey() : tmap.firstKey();
	    
		}
		
	    return ring.get(hash);
	}
	
	//MD5 Hash to generate a good hash
	
	private static String getMD5(String input) {
	 
		byte[] source;
	    try {
	          //Get byte according by specified coding.
	          source = input.getBytes("UTF-8");
	    }
	    catch (UnsupportedEncodingException e) {
	
	    	  source = input.getBytes();
	    }
	    
	String result = null;
	
	char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',	'8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	  try {
	 
		  MessageDigest md = MessageDigest.getInstance("MD5");
	      md.update(source);
	
  	    //The result should be one 128 integer
	
	      byte temp[] = md.digest();
	      char str[] = new char[16 * 2];
	      int k = 0;
	      for (int i = 0; i < 16; i++) {
	
	    	  byte byte0 = temp[i];
          	  str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	          str[k++] = hexDigits[byte0 & 0xf];
	      }
	    
	      result = new String(str);
	  }
	
	  catch (Exception e) {
	 
		  e.printStackTrace();
	
	  }
	  
	return result;
   }

	
}

