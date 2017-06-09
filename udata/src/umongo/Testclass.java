package umongo;
import java.net.*;
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
          shards.add("PC1node1");
          shards.add("PC1node2");
          shards.add("PC1node3");
          shards.add("PC1node4");
          shards.add("PC1node5");
          shards.add("PC1node6");
          
          
          ConsistentHash c1= new ConsistentHash(shards,5);
          /*
          System.out.println("\n Ranges of shards : ");
          c1.printRange();
          System.out.println(" End of Ranges \n ");
          
          System.out.println();
          System.out.println(c1.getShard("01/07/2018"));
          System.out.println(c1.getShard("31/08/2015"));
          System.out.println(c1.getShard("31/08/2015"));
          System.out.println(c1.getShard("03/07/2005"));
          System.out.println(c1.getShard("01/09/2015"));
          System.out.println(c1.getShard("12/10/2014"));
          System.out.println(c1.getShard("11/06/2013"));  
          */
      
          File flist = new File("/home/Sid/Desktop");
          for( File f : flist.listFiles()){
      //      System.out.println(c1.getShard(f.lastModified().toString().substring(0,10)));
        	  System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(new Date(f.lastModified())));
          }
     }

}

