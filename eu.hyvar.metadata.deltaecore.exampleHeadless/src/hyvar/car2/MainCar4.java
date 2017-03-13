package hyvar.car2;

import org.yakindu.scr.ecu_c.ECU_CStatemachine;
import org.yakindu.scr.ecu_c.*;
import org.yakindu.scr.ecu_c.ECU_CStatemachine.State;
import org.yakindu.scr.ecu_c.IECU_CStatemachine.SCIDataOperationCallback;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.*;

public class MainCar4 extends JPanel implements SCIDataOperationCallback{
	JLabel pictureLabel;
	
	//public static Boolean featureA, featureE, featureN,featureU, featureG,featureS;
	public static String featureA, featureE, featureN,featureU, featureG,featureS;
	
	
public MainCar4(String GUISet) {
	super(new BorderLayout());
	
}


public static void createAndShowGUI(String GUISet) {
	//Create and set up the window.
	JFrame frame = new JFrame("HyvarDemo");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//Create and set up the content pane.
	JComponent newContentPane = new MainCar4(GUISet);
	newContentPane.setOpaque(true); //content panes must be opaque
	frame.setContentPane(newContentPane);

	//Display the window.
	frame.pack();
	frame.setVisible(true);
	}
public static StringBuilder sb = new StringBuilder();

public static void main(String[] args) {
//	javax.swing.SwingUtilities.invokeLater(new Runnable() {
//public void run() {
	MainCar4 obj = new MainCar4("abc");
	obj.callStatechart();
	System.out.println("feature = " + sb);
	//JLabel lbl = new JLabel(new ImageIcon((sb +".png"));
	ImageIcon io = new ImageIcon(MainCar4.class.getResource(sb +".png"));
	
	JLabel lbl = new JLabel(io);
    JOptionPane.showMessageDialog(null, lbl, "HyvarDemo", 
                                 JOptionPane.PLAIN_MESSAGE, null);

		
	}
private void callStatechart() {
ECU_CStatemachine car2 = new ECU_CStatemachine();

car2.getSCIData().setSCIDataOperationCallback(this);
car2.init();
car2.enter();
car2.runCycle();
car2.runCycle();

/*try {
	Method m = car2.getClass().getMethod("raiseECU", null);
	m.invoke(car2, null);
} catch (NoSuchMethodException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SecurityException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IllegalArgumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (InvocationTargetException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}*/

car2.runCycle();

/////////

if (featureA == "A")
{
	
	sb = sb.append("a");
}
else
{
	sb = sb.append("-");
	
}
if (featureN == "N")
{
	
	
	sb = sb.append("n");
}
else
{
	sb = sb.append("-");

}
 if (featureE == "E")
{
	
	sb = sb.append("e");
	
}
 else
	{
		sb = sb.append("-");
	
	}
 if (featureS == "S")
{
	
	sb = sb.append("s");
}
 else
	{
		sb = sb.append("-");
		
	}
 if (featureG == "G")
{
	
	sb = sb.append("g");
}
 else
	{
		sb = sb.append("-");
		
	}
 if(featureU == "U")
{
	
	sb = sb.append("u");
}
 else
	{
		sb = sb.append("-");
		
	}

///////


}

	
	public String operE() {
		// TODO Auto-generated method stub
		System.out.println( "E");
		featureE = "E";
		return "E";
	}
	
	public String operA() {
		System.out.println( "A");
		featureA = "A";
		// TODO Auto-generated method stub
	return "A";	
	}
	public String operG() {
		System.out.println( "G");
		featureG = "G";
		// TODO Auto-generated method stub
		return "G";
	}
	public String operU() {
		System.out.println( "U");
		featureU = "U";
		// TODO Auto-generated method stub
		return "U";
	}
	public String operS() {
		System.out.println( "S");
		featureS = "S";
		// TODO Auto-generated method stub
		return "S";
	}
	public String operN() {
		featureN = "N";
		System.out.println( "N");
		// TODO Auto-generated method stub
		return "N";
	}


	public void initFiat() {
		// TODO Auto-generated method stub
		
	}

	
	public void initChrysler() {
		// TODO Auto-generated method stub
		
	}

}
