/**
 * @author Daniele Bufalo
 * @version 1.0
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class mattone.
 */
public class mattone implements java.io.Serializable {

/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

/** The diametro. */
private int  diametro;


/**
 * The main method.
 *
 * @param args the arguments
 * @throws FileNotFoundException the file not found exception
 * @throws IOException Signals that an I/O exception has occurred.
 */
public static void main(String[] args) throws FileNotFoundException, IOException
{
	mattone m=new mattone();
	m.setDiametro(50);
	m.save();

	mattone m1=new mattone();
	m1.load();
	m1.visualizzaMattone();
}

/**
 * Instantiates a new mattone.
 */
mattone()
{
	 creaMattone();	//una misura di default
}

/**
 * Crea mattone.
 */
public void creaMattone()
{
	setDiametro(0);
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
public String toString() {
	   String s;
	   if(this.getDiametro()==0)
	   {
		   s="il mattone non c'è";
	   }
	   else
	   {
		   s="diametro:"+this.getDiametro()+" cm";
	   }
	   return s;

	}


/**
 * Visualizza mattone.
 */
public void visualizzaMattone()
{
	System.out.println(toString());
}


/**
 * Gets the diametro.
 *
 * @return the diametro
 */
public int getDiametro() {
	return diametro;
}


/**
 * Sets the diametro.
 *
 * @param diametro the new diametro
 */
public void setDiametro(int diametro) {
	this.diametro = diametro;
}


/**
 * Save.
 *
 * @throws FileNotFoundException the file not found exception
 * @throws IOException Signals that an I/O exception has occurred.
 */
public void save() throws FileNotFoundException, IOException
{
	String filename = "mattone.dat";
	// Serialization
	try
	{
		//Saving of object in a file
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(file);

		// Method for serialization of object
		out.writeObject(this);

		out.close();
		file.close();

		System.out.println("Object has been serialized");

	}

	catch(IOException ex)
	{
		System.out.println("IOException is caught");
	}

}


/**
 * Load.
 *
 * @throws FileNotFoundException the file not found exception
 * @throws IOException Signals that an I/O exception has occurred.
 */
public void load() throws FileNotFoundException, IOException
{
	this.creaMattone();
	String filename = "mattone.dat";
	mattone object1 = null;

	// Deserialization
	try
	{
		// Reading the object from a file
		FileInputStream file = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(file);

		// Method for deserialization of object
		object1 = (mattone)in.readObject();

		in.close();
		file.close();

		System.out.println("Object has been deserialized ");
		//carica valore
		this.setDiametro(object1.getDiametro());
	}

	catch(IOException ex)
	{
		System.out.println("IOException is caught");
	}

	catch(ClassNotFoundException ex)
	{
		System.out.println("ClassNotFoundException is caught");
	}
}
//
}
