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
 * The Class Persona.
 */
public class Persona implements java.io.Serializable{

/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

/** The codicefiscale. */
private String codicefiscale;

/** The cognome. */
private String cognome;

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
	Persona m=new Persona();
	m.set("DBLD19970904", "Bufalo");	//cambia solo questa riga di codice e la classe
	//non metto tutto il codice fossi scemo.
	m.save();

	Persona m1=new Persona();
	m1.load();
	m1.stampa();
}

/**
 * Instantiates a new persona.
 */
Persona()
{
	creaPersona();
}

/**
 * Crea persona.
 */
public void creaPersona()
{
	this.setCodicefiscale("000000");
	this.setCognome("Nessuno");
	this.setFilename("Persona.dat");
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
public void save() throws FileNotFoundException, IOException //questo metodo è il più generico e funziona per tutte le classi
{
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
	this.creaPersona();
	Persona object1 = null;

	// Deserialization
	try
	{
		// Reading the object from a file
		FileInputStream file = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(file);

		// Method for deserialization of object
		object1 = (Persona)in.readObject();

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
public void set(String x, String y)
{
	this.setCodicefiscale(x);
	this.setCognome(y);
	//this.setFilename(filenam);
}

/**
 * Assign.
 *
 * @param object1 the object 1
 */
public void assign(Persona object1)	//cambia solo il tipo e i set/get per il resto funziona uguale
{
	this.setCodicefiscale(object1.getCodicefiscale());
	this.setCognome(object1.getCognome());
}


/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
public String toString()
{
	String string = null;
	string="codiceFiscale :"+this.getCodicefiscale()+", Cognome:"+this.getCognome()+"\n";
	return string;
}

/**
 * Stampa.
 */
public void stampa()
{
	System.out.println(this.toString());
}

/**
 * Gets the codicefiscale.
 *
 * @return the codicefiscale
 */
public String getCodicefiscale() {
	return codicefiscale;
}

/**
 * Sets the codicefiscale.
 *
 * @param codicefiscale the new codicefiscale
 */
public void setCodicefiscale(String codicefiscale) {
	this.codicefiscale = codicefiscale;
}

/**
 * Gets the cognome.
 *
 * @return the cognome
 */
public String getCognome() {
	return cognome;
}

/**
 * Sets the cognome.
 *
 * @param cognome the new cognome
 */
public void setCognome(String cognome) {
	this.cognome = cognome;
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

}
