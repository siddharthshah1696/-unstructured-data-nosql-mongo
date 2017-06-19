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
          
 		  final long startcon = System.nanoTime();
          ConsistentHash c1= new ConsistentHash(shards,10);
        
          
          long cc1=0,cc2=0,cc3=0,cc4=0,cc5=0,cc6=0,cc=0;
          File flist = new File("/home/Sid/input50000");
          for( File f : flist.listFiles()){
        	  String s=c1.getShard(f.getName());
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
          }
          
          System.out.println(100.0*cc1/cc + "%");
          System.out.println(100.0*cc2/cc + "%");
          System.out.println(100.0*cc3/cc + "%");
          System.out.println(100.0*cc4/cc + "%");
          System.out.println(100.0*cc5/cc + "%");
          System.out.println(100.0*cc6/cc + "%");
  
    
          System.out.println("\nDONE\nTotal keys :"+cc+"\n");
          long durcon = System.nanoTime() -startcon;
          double durationcon = durcon*1.0/1000000000;
          
          System.out.println(durcon+"\n");
          System.out.println(durationcon+" seconds\n"+"--------------------------------------------\n");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
   
          final long starthrw = System.nanoTime();
          HrwHash h1 = new HrwHash(shards);          
 		  long hh1=0,hh2=0,hh3=0,hh4=0,hh5=0,hh6=0,hh=0;

          for( File f : flist.listFiles()){
        	  String s=c1.getShard(f.getName());
        	  s= h1.determine_responsible_node(f.getName());
                  	   
        	  if(s.equals("PC1node1"))
          		   hh1++;
          	   else if(s.equals("PC1node2"))
              		   hh2++;
          	   else if(s.equals("PC1node3"))
              		   hh3++;
          	   else if(s.equals("PC1node4"))
              		   hh4++;
          	   else if(s.equals("PC1node5"))
              		   hh5++;
          	   else if(s.equals("PC1node6"))
              		   hh6++;
          	   
          	   hh++;
             
         
          }
          
          System.out.println(100.0*hh1/hh + "%");
          System.out.println(100.0*hh2/hh + "%");
          System.out.println(100.0*hh3/hh + "%");
          System.out.println(100.0*hh4/hh + "%");
          System.out.println(100.0*hh5/hh + "%");
          System.out.println(100.0*hh6/hh + "%");
          System.out.println("\nDONE\nTotal keys :"+cc+"\n");

          long durhrw = System.nanoTime() - starthrw;
          double durationhrw = durhrw*1.0/1000000000;
          
          System.out.println(durhrw+"\n");
          System.out.println(durationhrw+" seconds\n"+"--------------------------------------------\n");
          
          
          
          
          
          
          
          
          
          
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




