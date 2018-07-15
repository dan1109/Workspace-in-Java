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
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Video.
 */
public class Video implements java.io.Serializable{

/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

/** The titolo. */
private String titolo;

/** The anno. */
private int anno;

/** The filename. */
private String filename;	//nome del file da dove pescare salvataggi

/**
 * The main method.
 *
 * @param args the arguments
 * @throws FileNotFoundException the file not found exception
 * @throws IOException Signals that an I/O exception has occurred.
 */
public static void main(String[] args) throws FileNotFoundException, IOException
{
	Video m=new Video();
	m.set("Titanic",1969);
	m.save();

	Video m1=new Video();
	m1.load();
	m1.stampa();
}

/**
 * Instantiates a new video.
 */
Video(){
	creaVideo();
}

/**
 * Crea video.
 */
public void creaVideo()
{
	this.setAnno(0);
	this.setTitolo("Nessuno");
	this.setFilename("Video.dat");
}

/**
 * Casuale.
 *
 * @param min the min
 * @param max the max
 * @return the int
 */
public int casuale(int min,int max)
{
	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
}

/**
 * Gets the char for number.
 *
 * @param i the i
 * @return the char for number
 */
public String getCharForNumber(int i) {
    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
}

/**
 * Save.
 *
 * @throws FileNotFoundException the file not found exception
 * @throws IOException Signals that an I/O exception has occurred.
 */
public void save() throws FileNotFoundException, IOException
{
	//questo metodo è il più generico e funziona per tutte le classi
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
	this.creaVideo();
	Video object1 = null;

	// Deserialization
	try
	{
		// Reading the object from a file
		FileInputStream file = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(file);

		// Method for deserialization of object
		object1 = (Video)in.readObject();

		in.close();
		file.close();

		System.out.println("Object has been deserialized ");
		//carica valore con la funzione set
		assign(object1);
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

/**
 * Sets the.
 *
 * @param x the x
 * @param y the y
 */
public void set(String x, int y)
{
	this.setTitolo(x);
	this.setAnno(y);
	//this.setFilename(filenam);
}

/**
 * Assign.
 *
 * @param object1 the object 1
 */
public void assign(Video object1)
{
	this.setTitolo(object1.getTitolo());
	this.setAnno(object1.getAnno());
}

/**
 * Gets the anno.
 *
 * @return the anno
 */
public int getAnno() {
	return anno;
}

/**
 * Sets the anno.
 *
 * @param anno the new anno
 */
public void setAnno(int anno) {
	this.anno = anno;
}

/**
 * Gets the titolo.
 *
 * @return the titolo
 */
public String getTitolo() {
	return titolo;
}

/**
 * Sets the titolo.
 *
 * @param titolo the new titolo
 */
public void setTitolo(String titolo) {
	this.titolo = titolo;
}

/**
 * Gets the filename.
 *
 * @return the filename
 */
public String getFilename() {
	return filename;
}

/**
 * Sets the filename.
 *
 * @param filename the new filename
 */
public void setFilename(String filename) {
	this.filename = filename;
}


/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
public String toString()
{
	String string = null;
	string="Titolo :"+this.getTitolo()+", Anno:"+this.getAnno()+"\n";
	return string;
}

/**
 * Stampa.
 */
public void stampa()
{
	System.out.println(this.toString());
}
}
