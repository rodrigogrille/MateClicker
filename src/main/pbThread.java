package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class pbThread extends Thread {
	JProgressBar pbar;
	JLabel MateNumber;
	float i;
	pbThread pr1;
	JButton button;

	public pbThread(JProgressBar pbar, JLabel MateNumber, pbThread pr1, JButton button) {
		this.pbar = pbar;
		this.MateNumber = MateNumber;
		this.pr1 = pr1;
		this.button = button;
	}

	public pbThread() {
	}

	public void run() {
		int min = 0;
		int max = 100;
		this.pbar.setMinimum(min);
		this.pbar.setMaximum(max);
		this.pbar.setValue(0);
		this.button.setEnabled(false);
		for (int i = min; i < max; i++) {
			this.pbar.setValue(i);
			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			this.i = (float) (this.i + 0.01f);
//			BigDecimal value = new BigDecimal(i);
//			value = value.setScale(2, RoundingMode.HALF_EVEN);
//			MateNumber.setText(value + "");
		}
		this.i = (float) (pr1.getI() + 0.01f);
		BigDecimal value = new BigDecimal(i);
		value = value.setScale(2, RoundingMode.HALF_EVEN);
		MateNumber.setText(value + "");
		this.pbar.setValue(min);
		this.button.setEnabled(true);
	}

	public float getI() {
		return i;
	}

	public void setI(float i) {
		this.i = i;
	}

}
