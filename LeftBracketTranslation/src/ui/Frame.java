package ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import util.LeftBracketTranslation;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	private DiaplayPanel p = new DiaplayPanel();
	
	public Frame() {
		super("Left Bracket Translation");
		this.setSize(600, 500);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ss = kit.getScreenSize();
		this.setLocation((ss.width-this.getWidth())/2, (ss.height-this.getHeight())/2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(p);
		this.setVisible(true);
	}

	private class DiaplayPanel extends JPanel {
		private JLabel l1 = new JLabel("Source");
		private JLabel l2 = new JLabel("Result");
		private JTextArea source = new JTextArea();
		private JTextArea result = new JTextArea();
		private JScrollPane sp1 = new JScrollPane(source);
		private JScrollPane sp2 = new JScrollPane(result);
		private JButton translate = new JButton("Translate");
		
		public DiaplayPanel() {
			GridBagLayout l = new GridBagLayout();
			GridBagConstraints c = new GridBagConstraints(); 
			setLayout(l);
			
			c.fill = GridBagConstraints.BOTH;
			c.gridwidth = GridBagConstraints.REMAINDER;
			c.weighty = 1;
			c.weightx = 100;
			l.setConstraints(l1, c);
			add(l1);
			
			c.weighty = 100;
			l.setConstraints(sp1, c);
			add(sp1);
			
			c.weighty = 1;
			l.setConstraints(l2, c);
			add(l2);
			
			c.weighty = 100;
			l.setConstraints(sp2, c);
			add(sp2);
			
			c.fill = GridBagConstraints.NONE;
			c.gridwidth = 1;
			c.weighty = 1;
			c.anchor = GridBagConstraints.EAST;
			l.setConstraints(translate, c);
			add(translate);
			
			translate.addActionListener(new Listener());
		}
		private class Listener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					result.setText(LeftBracketTranslation.translation(source.getText()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
			
		}
	}
}
