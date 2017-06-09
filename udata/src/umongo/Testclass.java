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
          int cc1=0,cc2=0,cc3=0,cc4=0,cc5=0,cc6=0,cc=0;
          File flist = new File("/home/Sid/rfiles1");
          for( File f : flist.listFiles()){
        	  String s=c1.getShard(f.getName());
        	//  String s=c1.getShard(new SimpleDateFormat("dd/MM/yyyy").format(new Date(f.lastModified())));
        	   if(s.equals("PC1node1"))
        		   cc1++;
        	   else if(s.equals("PC1node2"))
            		   cc2++;
        	   else if(s.equals("PC1node3"))
            		   cc3++;
        	   else if(s.equals("PC1node4"))
            		   cc4++;
        	   else if(s.equals("PC1node5"))
            		   cc5++;
        	   else if(s.equals("PC1node6"))
            		   cc6++;
        	   
        	   cc++;
             //   System.out.println(s+" : "+f.getName());
        	//   System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(new Date(f.lastModified())));
          }
          
          System.out.println(100.0*cc1/cc + "%");
          System.out.println(100.0*cc2/cc + "%");
          System.out.println(100.0*cc3/cc + "%");
          System.out.println(100.0*cc4/cc + "%");
          System.out.println(100.0*cc5/cc + "%");
          System.out.println(100.0*cc6/cc + "%");
  
    
          System.out.println("\nDONE\n");
          final long duration = System.nanoTime() - startTime;
          System.out.println(duration+"\n");
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          /*     
          MongoClient mongo11 = new MongoClient("localhost",27017);
         DB db11             = mongo11.getDB("Info");
        //  MongoClient mongo12 = new MongoClient("localhost",27018);
       //   DB db12             = mongo12.getDB("Info");
        //  MongoClient mongo13 = new MongoClient("localhost",27019);
         // DB db13             = mongo13.getDB("Info");
       //   MongoClient mongo14 = new MongoClient("localhost",27022);
      //    DB db14             = mongo14.getDB("Info");
         
       */
     }

}




