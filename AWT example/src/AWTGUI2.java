/**
 * @author Daniele Bufalo
 * @version 1.0
 */
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class AWTGUI2.
 */
public class AWTGUI2{

/**
 * The main method.
 *
 * @param args the arguments
 */
public static void main(String[]args){

/*Frame frame=new Frame();
TextArea ta=new TextArea("JavaAWT",
4,10,TextArea.SCROLLBARS_VERTICAL_ONLY);
frame.add(ta);
frame.pack();
frame.setVisible(true);*/

Frame f=new Frame("MenuBar");
MenuBar mb=new MenuBar();
Menu m1=new Menu("File");
Menu m2=new Menu("Edit");
Menu m3=new Menu("Help");
mb.add(m1);mb.add(m2);
MenuItem mi1=new MenuItem("New");
MenuItem mi2=new MenuItem("Open");
MenuItem mi3=new MenuItem("Save");
MenuItem mi4=new MenuItem("Quit");
m1.add(mi1);m1.add(mi2);m1.add(mi3);
m1.addSeparator();m1.add(mi4);
mb.setHelpMenu(m3);
f.setMenuBar(mb);}
}