/**
 * 
 */
package org.techzenth.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.text.DefaultEditorKit;

import org.techzenth.Models.CalcuModel;
import org.techzenth.Views.CalcuView;

/**
 * @author Andre_Bonner
 *
 */
public class CalcuController {
	private CalcuModel caModel;
	private CalcuView caView;
	private Action Standard;
	private Action Scientific;
	private Action Copy;
	private Action Paste;
	private Action History;
	private Action ViewHelp;
	private Action About;
	private ActionMap m;
	private ActionListener actionL;

	public CalcuController() {

	}

	public CalcuController(CalcuModel cM, CalcuView cV) {
		this.caModel = cM;
		this.caView = cV;
	}

	public void control() {
		Standard = new AbstractAction("Standard") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 814884533848591603L;

			public void actionPerformed(ActionEvent e) {
				// is Calculator in standard mode
				// change to Standard
			}
		};
		
		caView.Standard.addActionListener(Standard);

		Scientific = new AbstractAction("Scientific") {
			/**
			 * 
			 */
			private static final long serialVersionUID = -1238267795147961379L;

			public void actionPerformed(ActionEvent e) {
				// is Calculator in scientific mode
				// change to Scientific
			}
		};
		caView.Scientific.addActionListener(Scientific);

		History = new AbstractAction("History") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4352522460203020080L;

			public void actionPerformed(ActionEvent e) {
				// does the Calculator contain history
				// show history
			}
		};

		caView.History.addActionListener(History);
		ViewHelp = new AbstractAction("View Help") {
			/**
			 * 
			 */
			private static final long serialVersionUID = -1578212424745266719L;

			public void actionPerformed(ActionEvent e) {
				// show help files
			}
		};

		caView.ViewHelp.addActionListener(ViewHelp);
		About = new AbstractAction("About") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3822367506510012006L;

			public void actionPerformed(ActionEvent e) {
				// About dialog
			}
		};
		
		caView.About.addActionListener(About);
		m = caView.calDisplay.getActionMap();
		Copy = m.get(DefaultEditorKit.copyAction);
		Paste = m.get(DefaultEditorKit.pasteAction);

		actionL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (((JButton) e.getSource()).getText()) {
				case "9":
				case "8":
				case "7":
				case "6":
				case "5":
				case "4":
				case "3":
				case "2":
				case "1":
				case "0":
					caModel.firstNumber = caModel.firstNumber 
							+ ((JButton) e.getSource()).getText();
					float calVal = Float.parseFloat(caModel.firstNumber);
					caView.calDisplay.setText(String.valueOf(calVal));
					break;
				case "+":
				case "-":
				case "*":
				case "/":
					// operators 
					break;
				case "=":
					// equal sign
					break;
				case "+/-":
					caView.calDisplay.setText("-" + caView.calDisplay.getText());
					break;
				case ".":
					caModel.firstNumber = caModel.firstNumber 
					+ ((JButton) e.getSource()).getText();
					caView.calDisplay.setText(caModel.firstNumber);
					break;
				case "Bck":
					caView.calDisplay.setText(caView.calDisplay.getText().substring(0, caView.calDisplay.getText().length() - 1));
					break;
				case "CE":
				case "C":
					caView.calDisplay.setText("0");
					break;
				case "%":
					// do percentage on value
					break;
				case "1/x":
					// do reciprocal on value
					break;
				case "Sqrt":
					// do square root on value
					break;
				case "MC":
					// do memory clear 
					break;
				case "MR":
					// do memory read 
					break;
				case "M+":
					// do memory add 
					break;
				case "M-":
					// do memory minus 
					break;
				}
				// JOptionPane.showMessageDialog(caView.getFrame(),
				// "The button "+ ((JButton)e.getSource()).getText()
				// +" has be pressed", "Action", JOptionPane.PLAIN_MESSAGE);
			}
		};

		for (int i = 0; i < caView.calButton.length; i++) {
			caView.calButton[i].addActionListener(actionL);
		}

	}
}
