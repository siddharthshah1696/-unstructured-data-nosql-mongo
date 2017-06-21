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
          
 		  
          HashSet<String> fcon1=new HashSet<String>();
          HashSet<String> fcon2=new HashSet<String>();
          HashSet<String> fcon3=new HashSet<String>();
          HashSet<String> fcon4=new HashSet<String>();
          HashSet<String> fcon5=new HashSet<String>();
          HashSet<String> fcon6=new HashSet<String>();
         
          HashSet<String> fhrw1=new HashSet<String>();
          HashSet<String> fhrw2=new HashSet<String>();
          HashSet<String> fhrw3=new HashSet<String>();
          HashSet<String> fhrw4=new HashSet<String>();
          HashSet<String> fhrw5=new HashSet<String>();
          HashSet<String> fhrw6=new HashSet<String>();
          
          File flist = new File("/home/Sid/input1000000");
         

/////////////////////////////////////////////////////////////////////////          
// Insertion for consistent hashing     
          
          final long startcon = System.nanoTime();
          ConsistentHash c1= new ConsistentHash(shards,10);
          
          
          long cc1=0,cc2=0,cc3=0,cc4=0,cc5=0,cc6=0,cc=0;
        
          for( File f : flist.listFiles()){
        	  String s=c1.getShard(f.getName());
        	   if(s.equals("PC1node1")){
        		   cc1++;
        		   fcon1.add(f.getAbsolutePath());
        	   }
        	   else if(s.equals("PC1node2")){
            		   cc2++;
        	   fcon2.add(f.getAbsolutePath());
   	           }
        	   else if(s.equals("PC1node3")){
            		   cc3++;
        	   fcon3.add(f.getAbsolutePath());
 	  		   }
        	   else if(s.equals("PC1node4")){
            		   cc4++;
        	   fcon4.add(f.getAbsolutePath());
               }
        	   else if(s.equals("PC1node5")){
            		   cc5++;
        	   fcon5.add(f.getAbsolutePath());
          	   }
        	   else if(s.equals("PC1node6")){
            		   cc6++;
        	   fcon6.add(f.getAbsolutePath());
         	   }
        	   
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
          
          System.out.println(durationcon+" seconds\n"+"--------------------------------------------\n");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
// Insertion  for HRW hashing  
          
          final long starthrw = System.nanoTime();
          HrwHash h1 = new HrwHash(shards);          
 		  
          
          long hh1=0,hh2=0,hh3=0,hh4=0,hh5=0,hh6=0,hh=0;

          for( File f : flist.listFiles()){
        	  
        	  String s= h1.determine_responsible_node(f.getName());
                  	   
        	  if(s.equals("PC1node1")){
          		       hh1++;
          		       fhrw1.add(f.getAbsolutePath());
        	  }
          	  else if(s.equals("PC1node2")){
              		   hh2++;
              		   fhrw2.add(f.getAbsolutePath());
         	  }
          	  else if(s.equals("PC1node3")){
              		   hh3++;
              		   fhrw3.add(f.getAbsolutePath());
         	  }
          	  else if(s.equals("PC1node4")){
              		   hh4++;
              		   fhrw4.add(f.getAbsolutePath());
         	  }
          	  else if(s.equals("PC1node5")){
              		   hh5++;
              		   fhrw5.add(f.getAbsolutePath());
         	  }
          	  else if(s.equals("PC1node6")){
              		   hh6++;
              		   fhrw6.add(f.getAbsolutePath());
         	  }
          	   
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
          
          System.out.println(durationhrw+" seconds\n"+"--------------------------------------------\n");
          
////////////////////////////////////////////////////////////////////////////        
// Retrieval time for consistent hashing
          final long startconret = System.nanoTime();
          
          int rcc=0;
          for( File f : flist.listFiles()){
        	  String s=c1.getShard(f.getName());
        	   if(s.equals("PC1node1")&&fcon1.contains(f.getAbsolutePath())){
        		 rcc++;
        	   }
        	   else if(s.equals("PC1node2")&&fcon2.contains(f.getAbsolutePath())){
            		   rcc++;
        	  
   	           }
   	           else if(s.equals("PC1node3")&&fcon3.contains(f.getAbsolutePath())){
            		   rcc++;
        	  
   	           }
   	           else if(s.equals("PC1node4")&&fcon4.contains(f.getAbsolutePath())){
            		   rcc++;
        	  
   	           }
   	           else if(s.equals("PC1node5")&&fcon5.contains(f.getAbsolutePath())){
            		   rcc++;
        	  
   	           }
   	           else if(s.equals("PC1node6")&&fcon6.contains(f.getAbsolutePath())){
            		   rcc++;
        	  
   	           }
          }
          System.out.println("\nDONE\nTotal keys :"+rcc+"\n");
          long durconret = System.nanoTime() - startconret;
          double durationconret = (durconret*1.0/1000000000)/cc;
      
          System.out.println(durationconret+" seconds\n"+"--------------------------------------------\n");
          
        	   
                   
 
////////////////////////////////////////////////////////////////////////////
//Retrieval time for consistent hashing

          final long starthrwret = System.nanoTime();
          int rch=0;
          
          for( File f : flist.listFiles()){
        	  String s= h1.determine_responsible_node(f.getName());
        	  
        	  if(s.equals("PC1node1")&&fhrw1.contains(f.getAbsolutePath())){
        		  rch++;
        	  }
        	  else if(s.equals("PC1node2")&&fhrw2.contains(f.getAbsolutePath())){
        		  rch++;

        	  }
        	  else if(s.equals("PC1node3")&&fhrw3.contains(f.getAbsolutePath())){
        		  rch++;

        	  }
        	  else if(s.equals("PC1node4")&&fhrw4.contains(f.getAbsolutePath())){
        		  rch++;

        	  }
        	  else if(s.equals("PC1node5")&&fhrw5.contains(f.getAbsolutePath())){
        		  rch++;

        	  }
        	  else if(s.equals("PC1node6")&&fhrw6.contains(f.getAbsolutePath())){
        		  rch++;

        	  }
          }

          System.out.println("\nDONE\nTotal keys :"+rch+"\n");
          long durhrwret = System.nanoTime() - starthrwret;
          double durationhrwret = (durhrwret*1.0/1000000000)/cc;

          System.out.println(durationhrwret+" seconds\n"+"--------------------------------------------\n");
////////////////////////////////////////////////////////////////////////////
hh1=hh2=hh3=hh4=hh5=hh6=0;
hh=0;
h1.list.remove("PC1node4");
h1.list.remove("PC1node5");
          for( File f : flist.listFiles()){
           	   String s= h1.determine_responsible_node(f.getName());
        	   if(s.equals("PC1node1")){
        		   hh1++;
        	   }
        	   else if(s.equals("PC1node2")){
            		   hh2++;
   	           }
        	   else if(s.equals("PC1node3")){
            		   hh3++;
 	  		   }
        	   else if(s.equals("PC1node4")){
            		   hh4++;
               }
        	   else if(s.equals("PC1node5")){
            		   hh5++;
          	   }
        	   else if(s.equals("PC1node6")){
            		   hh6++;
         	   }
        	   
        	   hh++;
          }
          
          System.out.println(100.0*hh1/hh + "%");
          System.out.println(100.0*hh2/hh + "%");
          System.out.println(100.0*hh3/hh + "%");
          System.out.println(100.0*hh4/hh + "%");
          System.out.println(100.0*hh5/hh + "%");
          System.out.println(100.0*hh6/hh + "%");
            
          
          
          
///////////////////////////////////////////////////////////////////////////          
          
          /*     
          MongoClient mongo11 = new MongoClient("localhost",27017);
         DB db11             = mongo11.getDB("Info");
       //  MongoClient mongo12 = new MongoClient("localhost",27018);
       //  DB db12             = mongo12.getDB("Info");
      //   MongoClient mongo13 = new MongoClient("localhost",27019);
      //   DB db13             = mongo13.getDB("Info");
     //    MongoClient mongo14 = new MongoClient("localhost",27022);
      //   DB db14             = mongo14.getDB("Info");
         
       */
     }

}




