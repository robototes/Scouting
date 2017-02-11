package org.usfirst.team2412.scouting.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Checkbox;

/**
 * Made with eclipse's WindowBuilder plugin
 */
public class SetupFrame {

	private JFrame frame;
	
	private static enum Types {
		INTEGER("int"), STRING("String"), DECIMAL("double/decimal"), BOOLEAN("bool/true/false");
		
		public String display;
		
		private Types(String display) {
			this.display = display;
		}
		
		public String getDisplay() {
			return display;
		}
	}
	
	private static class Triplet<A, B, C> {
		A a;
		B b;
		C c;
		
		public Triplet(){}
		public Triplet(A a, B b, C c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}


	public SetupFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Setup");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label label = new Label("Variable Name");
		label.setBounds(10, 10, 130, 24);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Variable Type");
		label_1.setBounds(146, 10, 130, 24);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Default Value");
		label_2.setBounds(292, 10, 130, 24);
		frame.getContentPane().add(label_2);
		
		Button button = new Button("New");
		button.setBounds(10, 219, 198, 24);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("Ok");
		button_1.setBounds(214, 219, 98, 24);
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("Cancel");
		button_2.setBounds(324, 219, 98, 24);
		frame.getContentPane().add(button_2);
		
		Checkbox checkbox = new Checkbox("New check box");
		checkbox.setBounds(10, 40, 108, 24);
		frame.getContentPane().add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox("New check box");
		checkbox_1.setBounds(10, 70, 108, 24);
		frame.getContentPane().add(checkbox_1);
		
		Label label_3 = new Label("New label");
		label_3.setBounds(146, 40, 130, 24);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label("New label");
		label_4.setBounds(292, 40, 130, 24);
		frame.getContentPane().add(label_4);
		
		
		
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				// Change component locations
			}
		});
	}
	
	private void addVariable(String name, Types type, String defaultV, int off) {
		
	}
	
	
	public void waitForClose() {
		while (frame.isDisplayable()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
