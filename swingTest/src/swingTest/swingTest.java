package swingTest;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class swingTest extends JFrame{
	private JLabel jLabel;
	private JTextField jTextField;
	private JButton jButton;
	
	public swingTest()
	{
		super();
		this.setSize(300, 200);
		this.getContentPane().setLayout(null);
		this.add(getJLabel(), null);
		this.add(getJTextField(), null);
		this.add(getJButton(), null);
		this.setTitle("Hello.world");
	}
	
	private JLabel getJLabel() {
		if (jLabel == null) {
			jLabel = new JLabel();
			jLabel.setBounds(34, 49, 53, 18);
			jLabel.setText("Name:");
		}
		return jLabel;
	}
	
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(96, 49, 160, 20);
		}
		return jTextField;
	}
	
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(103, 110, 71, 27);
			jButton.setText("OK");
		}
		return jButton;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		swingTest t = new swingTest();
		t.setVisible(true);
	}

}
