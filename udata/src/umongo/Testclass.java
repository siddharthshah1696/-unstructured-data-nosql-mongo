package umongo;
import java.net.UnknownHostException;
import java.util.*;
import java.io.*;
import java.math.*;
import java.security.*;

import java.text.*;
import java.lang.*;
import com.mongodb.*;

public class Testclass {
	
        
 	  public static void main (String[] args) throws IOException{

 		  final long startTime = System.nanoTime();
          List<String> shards= new ArrayList<String>();
          shards.add("PC1shard1");
          shards.add("PC1shard2");
          shards.add("PC1shard3");
          shards.add("PC1shard4");
          shards.add("PC1shard5");
          shards.add("PC1shard6");

          ConsistentHash c1= new ConsistentHash(shards,5);
          System.out.println();
          System.out.println(c1.getShard("01/07/2018"));
          System.out.println(c1.getShard("31/08/2015"));
          System.out.println(c1.getShard("31/08/2015"));
          System.out.println(c1.getShard("03/07/2005"));
          System.out.println(c1.getShard("01/09/2015"));
          System.out.println(c1.getShard("12/10/2014"));
          System.out.println(c1.getShard("11/06/2013")); 
          
          c1.removeFromRing("PC1shard6");
          System.out.println();
          System.out.println(c1.getShard("01/07/2018"));
          System.out.println(c1.getShard("31/08/2015"));
          System.out.println(c1.getShard("31/08/2015"));
          System.out.println(c1.getShard("03/07/2005"));
          System.out.println(c1.getShard("01/09/2015"));
          System.out.println(c1.getShard("12/10/2014"));
          System.out.println(c1.getShard("11/06/2013")); 
     }

}

