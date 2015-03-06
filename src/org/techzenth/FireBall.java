/**The Calculator
 * 
 */
package org.techzenth;

import javax.swing.SwingUtilities;

import org.techzenth.Controllers.CalcuController;
import org.techzenth.Models.CalcuModel;
import org.techzenth.Views.CalcuView;

/**
 * @author Andre_Bonner
 *
 */
public class FireBall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("****FireBall****");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CalcuModel model = new CalcuModel();
				CalcuView view = new CalcuView("FireBall");
				CalcuController controller = new CalcuController(model, view);
				controller.control();
			}
		});
	}

}
