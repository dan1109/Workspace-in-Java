import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class replaceString {

	public static void main(String args[]) throws Exception {

		Scanner begin = new Scanner(System.in);
		System.out.print("Directory dove modificare tutti i files: ");
		String srcFile = begin.nextLine();
		
		//String srcFile="C:\\Users\\Daniele\\Desktop\\kMeans-master\\src\\data";
		////ho ottenuto tutti i files!
		
		File folder = new File(srcFile);
    	File[] listOfFiles = folder.listFiles();
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
    	    
		////
		System.out.print("Verrà salvato un file corrispondente con estensione finale ZZ\n");
		/////rimpiazzo!
		
		String files2[]=new String[listOfFiles.length];
	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	    	  String temp=srcFile+"\\"+listOfFiles[i].getName();
	    	  temp = temp.replaceAll(".java", "ZZ.java");
	    	  files2[i]=temp;
	        //System.out.println(files[i]);
	      } else if (listOfFiles[i].isDirectory()) {
	    	  String temp=srcFile+"\\"+listOfFiles[i].getName();
	    	  temp = temp.replaceAll(".java", "ZZ.java");
	    	  files2[i]=temp;
  	        //System.out.println(files[i]);
	      }
	    }
	    
	    
		/////
		System.out.print("Stringa da togliere:");
		//String s1="sante";
		String s1 = begin.nextLine();
		System.out.print("Stringa da mettere :");
		String s2 = begin.nextLine();
		//String s2="Daniele Bufalo";
		String str;

		
		try {
			for (int i = 0; i < listOfFiles.length; i++) {
				//sostituisco ogni file dei due array
				String a=files[i];				
				String b=files2[i];
				FileInputStream fis = new FileInputStream(a);
				DataInputStream input = new DataInputStream(fis);
				FileOutputStream fos = new FileOutputStream(b);
				DataOutputStream output = new DataOutputStream(fos);

				while (null != ((str = input.readLine()))) {

					int x = 0;
					int y = 0;
					String result = "";
					while ((x = str.indexOf(s1, y)) > -1) {
						result += str.substring(y, x);
						result += s2;
						y = x + s1.length();
					}
					result += str.substring(y);
					str = result;

					if (str.indexOf("'',") != -1) {
						continue;
					} else {
						str = str + "\n";

						output.writeBytes(str);
					}
				}
				input.close();
				output.close();
			}

		} catch (IOException ex) {
			System.err.println("Problem.." + ex);
		}
		/////////////
		try {
			for (int i = 0; i < listOfFiles.length; i++) {
				String a=files[i];
				//elimino tutti i file originali
				Files.deleteIfExists(Paths.get(a));
			}
			
		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}

	}
}
