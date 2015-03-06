/**
 * 
 */
package org.techzenth.Views;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import org.techzenth.Models.CalcuModel;

/**
 * @author Andre_Bonner
 *
 */
public class CalcuView {
	private CalcuModel caModel;
	private JFrame frame;
	private JPanel pan, buttonPanel;
	private JMenuBar menubar;
	private JMenu View;
	private JMenu Edit;
	private JMenu Help;
	public JRadioButtonMenuItem Standard;
	public JRadioButtonMenuItem Scientific;
	public JMenuItem Copy;
	public JMenuItem Paste;
	public JMenuItem History;
	public JMenuItem ViewHelp;
	public JMenuItem About;
	public JTextField calDisplay;
	public JButton[] calButton;

	public CalcuView() {

	}

	public CalcuView(String title) {
		caModel = new CalcuModel();
		caModel.setAppName(title);
		frame = new JFrame(caModel.getAppName());

		frame.setSize(400, 500);

		frame.setLocationRelativeTo(null);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		initGUI();
		frame.pack();
	}

	private void initGUI() {
		// TODO - Initialize GUI
		menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		View = new JMenu("View");
		Edit = new JMenu("Edit");
		Help = new JMenu("Help");

		Standard = new JRadioButtonMenuItem("Standard");
		Scientific = new JRadioButtonMenuItem("Scientific");
		Copy = new JMenuItem("Copy");
		Paste = new JMenuItem("Paste");
		History = new JMenuItem("History");
		ViewHelp = new JMenuItem("View Help");
		About = new JMenuItem("About");

		menubar.add(View);
		menubar.add(Edit);
		menubar.add(Help);

		View.add(Standard);
		View.add(Scientific);

		Edit.add(Copy);
		Edit.add(Paste);
		Edit.addSeparator();
		Edit.add(History);

		Help.add(ViewHelp);
		Help.addSeparator();
		Help.add(About);

		calDisplay = new JTextField();
		calDisplay.setHorizontalAlignment(JTextField.RIGHT);
		calDisplay.setEditable(false);
		calDisplay.setFont(new Font("monospaced", Font.PLAIN, 20));

		pan = new JPanel();
		buttonPanel = new JPanel();
		calDisplay.setText("0");
		calDisplay.setSize(130, 140);
		// calDisplay.setBounds(110,120,130,140);
		pan.setLayout(new BorderLayout(4, 4));
		pan.add(calDisplay, BorderLayout.NORTH);

		buttonPanel.setLayout(new GridLayout(6, 5, 10, 15));

		calButton = new JButton[30];

		// buttonPanel.setBackground(Color.CYAN);

		String[] buttons = { "MC", "MR", "MS", "M+", "M-", "Bck", "CE", "C",
				"+/-", "Sqrt", "7", "8", "9", "/", "%", "4", "5", "6", "*",
				"1/x", "1", "2", "3", "-", "", "0", "", ".", "+", "=" };

		for (int i = 0; i < buttons.length; i++) {

			if (i == 24 || i == 26) {
				calButton[i] = new JButton(".");
				buttonPanel.add(calButton[i]);
				calButton[i].setVisible(false);
			} else {
				calButton[i] = new JButton(buttons[i]);
				buttonPanel.add(calButton[i]);
			}
		}

		pan.add(buttonPanel, BorderLayout.CENTER);

		// Put everything together, using the content pane's BorderLayout.
		frame.setContentPane(pan);
	}

	public JFrame getFrame() {
		return this.frame;
	}

}
