/**
 * 
 */
package org.techzenth.Models;

/**
 * @author Andre_Bonner
 *
 */
public class CalcuModel {
	private int calcu;
	private String AppName;
	public String firstNumber,secondNumber;
	

	public CalcuModel() {
		this.firstNumber="";
		this.secondNumber="";
	}

	public CalcuModel(int c) {
		this.calcu = c;
		this.firstNumber="";
		this.secondNumber="";
	}

	public int getCalcuValue() {
		return calcu;
	}

	public void setAppName(String aN) {
		this.AppName = aN;
	}

	public String getAppName() {
		return AppName;
	}
}
