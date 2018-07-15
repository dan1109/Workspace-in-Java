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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Videoteca.
 */
public class Videoteca implements java.io.Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codice ultimo video. */
	private static int codiceUltimoVideo = 0;

	/** The password. */
	private transient String password;	//non la salva la password sarà null

	/** The catalogo video. */
	private HashMap<Integer,Video> catalogoVideo;

	/** The elenco iscritti. */
	private ArrayList<Persona> elencoIscritti;

	/** The numero prestiti. */
	private int numeroPrestiti;

	/** The filename. */
	private static String filename="Videoteca.dat";

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Videoteca m= new Videoteca();
		m.AddElementsElenco(5);
		m.AddElementsCatalogo(5);
		m.setNumeroPrestiti(50);
		m.save();
		Videoteca m1= new Videoteca();
		m1.load();
		m1.stampa();
	}

	/**
	 * Instantiates a new videoteca.
	 */
	Videoteca()
	{
		creaVideoteca();
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
		this.creaVideoteca();
		Videoteca object1 = null;

		// Deserialization
		try
		{
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			object1 = (Videoteca)in.readObject();

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
	 * Assign.
	 *
	 * @param object1 the object 1
	 */
	public void assign(Videoteca object1)	//cambia solo il tipo e i set/get per il resto funziona uguale
	{
		this.setCatalogoVideo(object1.getCatalogoVideo());
		this.setElencoIscritti(object1.getElencoIscritti());
		this.setPassword(object1.getPassword());
		this.setNumeroPrestiti(object1.getNumeroPrestiti());
	}

/**
 * Adds the elements elenco.
 *
 * @param num the num
 */
public void AddElementsElenco(int num)
{
	int i=0;
	while(i<num)
	{
		Persona value = new Persona();
		value.set("Titol"+value.getCharForNumber(value.casuale(0,23)),"Ross"+value.getCharForNumber(value.casuale(0,23)));
		this.elencoIscritti.add(value);
		i++;
	}
}

/**
 * Stampa.
 */
public void stampa()
{
	System.out.println("*************************************\n");
	System.out.println("codiceUltimoVideo: "+Videoteca.codiceUltimoVideo);
	System.out.println("password: "+this.password);
	this.stampaElenco();
	this.stampaCatalogo();
	System.out.println("*************************************\n");
}

/**
 * Stampa elenco.
 */
public void stampaElenco()
{
 System.out.println("Elenco");
 System.out.print(Arrays.asList(this.elencoIscritti));	//cambia solo il this.--- ...
}

/**
 * Crea videoteca.
 */
public void creaVideoteca()
{
	this.setNumeroPrestiti(0);
	this.elencoIscritti= new ArrayList<Persona>();
	this.catalogoVideo= new HashMap<Integer,Video>();
	this.setPassword("*****");
}

/**
 * Stampa catalogo.
 */
public void stampaCatalogo()
{
	System.out.println("Catalogo");
 System.out.print(Arrays.asList(this.catalogoVideo));
}

/**
 * Adds the elements catalogo.
 *
 * @param num the num
 */
public void AddElementsCatalogo(int num)
{
	int i=0;
	while(i<num)
	{
		Video value = new Video();
		value.set("A"+value.getCharForNumber(value.casuale(0, 23)),value.casuale(1890,2018));
		this.catalogoVideo.put(i, value);
		i++;
	}
}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the codice ultimo video.
	 *
	 * @return the codice ultimo video
	 */
	public static int getCodiceUltimoVideo() {
		return codiceUltimoVideo;
	}

	/**
	 * Sets the codice ultimo video.
	 *
	 * @param codiceUltimoVideo the new codice ultimo video
	 */
	public static void setCodiceUltimoVideo(int codiceUltimoVideo) {
		Videoteca.codiceUltimoVideo = codiceUltimoVideo;
	}

	/**
	 * Gets the catalogo video.
	 *
	 * @return the catalogo video
	 */
	public HashMap<Integer,Video> getCatalogoVideo() {
		return catalogoVideo;
	}

	/**
	 * Sets the catalogo video.
	 *
	 * @param catalogoVideo the catalogo video
	 */
	public void setCatalogoVideo(HashMap<Integer,Video> catalogoVideo) {
		this.catalogoVideo = catalogoVideo;
	}

	/**
	 * Gets the elenco iscritti.
	 *
	 * @return the elenco iscritti
	 */
	public ArrayList<Persona> getElencoIscritti() {
		return elencoIscritti;
	}

	/**
	 * Sets the elenco iscritti.
	 *
	 * @param elencoIscritti the new elenco iscritti
	 */
	public void setElencoIscritti(ArrayList<Persona> elencoIscritti) {
		this.elencoIscritti = elencoIscritti;
	}

	/**
	 * Gets the numero prestiti.
	 *
	 * @return the numero prestiti
	 */
	public int getNumeroPrestiti() {
		return numeroPrestiti;
	}

	/**
	 * Sets the numero prestiti.
	 *
	 * @param numeroPrestiti the new numero prestiti
	 */
	public void setNumeroPrestiti(int numeroPrestiti) {
		this.numeroPrestiti = numeroPrestiti;
	}

}
