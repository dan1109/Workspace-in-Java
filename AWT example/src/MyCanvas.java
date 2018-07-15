/**
 * @author Daniele Bufalo
 * @version 1.0
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

// TODO: Auto-generated Javadoc
/*
 * Exception in thread "main" java.lang.NullPointerException
	at MyCanvas.paint(MyCanvas.java:20)
	at MyCanvas.main(MyCanvas.java:16)

help me pls
 */

/**
 * The Class MyCanvas.
 */
public class MyCanvas extends Canvas{

/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[])
	{
		Graphics g = null;
		MyCanvas o= new MyCanvas();
		o.paint(g);
	}

/* (non-Javadoc)
 * @see java.awt.Canvas#paint(java.awt.Graphics)
 */
public void paint(Graphics g){
g.drawString("java",10,10);
g.setColor(Color.red);
g.drawLine(10,5,35,5);
}}