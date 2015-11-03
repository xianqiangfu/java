package swingTest2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JToggleButton;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseMotionAdapter;

public class test {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();;
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 460, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is 1!");
				textField.setText("1");
			}
		});
		button.setBounds(21, 41, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is 2!");
				textField.setText("2");
			}
		});
		button_1.setBounds(160, 41, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is 3");
				textField.setText("3");
			}
		});
		button_2.setBounds(295, 41, 93, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is 4");
				textField.setText("4");
			}
		});
		button_3.setBounds(21, 86, 93, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is 5");
				textField.setText("5");
			}
		});
		button_4.setBounds(160, 86, 93, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is 6");
				textField.setText("6");
			}
		});
		button_5.setBounds(295, 86, 93, 23);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is 7");
				textField.setText("7");
			}
		});
		button_6.setBounds(21, 137, 93, 23);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is 8");
				textField.setText("8");
			}
		});
		button_7.setBounds(160, 137, 93, 23);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is 9");
				textField.setText("9");
			}
		});
		button_8.setBounds(295, 137, 93, 23);
		frame.getContentPane().add(button_8);
		
		textField = new JTextField();
		textField.setText("10");
		textField.setBounds(21, 196, 367, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"q", "w", "e"}));
		comboBox.setToolTipText("q\r\nw\r\ne");
		comboBox.setBounds(40, 269, 74, 21);
		frame.getContentPane().add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println("State changed!");
			}
		});
		rdbtnNewRadioButton.setBounds(170, 268, 121, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(340, 268, 29, 22);
		frame.getContentPane().add(spinner);
		
		JSlider slider = new JSlider();
		slider.setBounds(40, 295, 200, 23);
		frame.getContentPane().add(slider);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(147, 289, 0, -19);
		frame.getContentPane().add(separator);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("123456789!!!");
			}
		});
		tglbtnNewToggleButton.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				System.out.println("mouse moved!!!!");
			}
		});
		tglbtnNewToggleButton.setBounds(249, 237, 135, 23);
		frame.getContentPane().add(tglbtnNewToggleButton);
	}
}
