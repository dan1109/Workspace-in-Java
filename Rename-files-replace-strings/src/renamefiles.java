import java.io.File;
import java.util.Scanner;

public class renamefiles 
{
    public static void main(String[] args)
    {	
    	Scanner keyboard = new Scanner(System.in);
    	System.out.print("Dammi il percorso nel quale sono presenti tutti i file da rinominare:");
    	String srcFile=keyboard.nextLine();
    	System.out.print("Del nome file cosa vuoi togliere?:");
    	String togli=keyboard.nextLine();
    	System.out.print("Qual'è l'estensione del file?:");
    	String estensione=keyboard.nextLine();
    	////ho ottenuto tutti i files!
    			
    			File folder = new File(srcFile);
    	    	File[] listOfFiles = folder.listFiles();
    	    	String files2[]=new String[listOfFiles.length];
    		    for (int i = 0; i < listOfFiles.length; i++) {
    		      if (listOfFiles[i].isFile()) {
    		    	  String temp=srcFile+"\\"+listOfFiles[i].getName();
    		    	  temp = temp.replaceAll(togli+estensione, estensione);
    		    	  files2[i]=temp;
    		        //System.out.println(files[i]);
    		      } else if (listOfFiles[i].isDirectory()) {
    		    	  String temp=srcFile+"\\"+listOfFiles[i].getName();
    		    	  temp = temp.replaceAll(togli+estensione, estensione);
    		    	  files2[i]=temp;
    	  	        //System.out.println(files[i]);
    		      }
    		    }
    		    
    		    
    		    String files[]=new String[listOfFiles.length];
        	    for (int i = 0; i < listOfFiles.length; i++) {
        	      if (listOfFiles[i].isFile()) {
        	    	  String temp=srcFile+"\\"+listOfFiles[i].getName();
        	    	  files[i]=temp;
        	        //System.out.println(files[i]);
        	      } else if (listOfFiles[i].isDirectory()) {
        	    	  String temp=srcFile+"\\"+listOfFiles[i].getName();
        	    	  files[i]=temp;
          	        //System.out.println(files[i]);
        	      }
        	    } 
 //______________________________________________________________________________________
        	    
    	    	    for (int i = 0; i < listOfFiles.length; i++) {
    	    			File oldfile =new File(files2[i]);
    	    			File newfile =new File(files[i]);
    	    				if(oldfile.renameTo(newfile)){
    	    					System.out.println("Rename succesful");
    	    				}else{
    	    					System.out.println("Rename failed");
    	    				}
    	    	    }
    	    	    try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	
    }
}