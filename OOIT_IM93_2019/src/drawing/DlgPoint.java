package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextPane;

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tF1;
	private JTextField tF2;
	private Point p; 
	private boolean confirm; 
	private JButton btnClr; 
	private Color c = Color.red; 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setTitle("Modify Point");
		setModal(true);
		setResizable(false);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCoordinateX = new JLabel("Coordinate X:");
			lblCoordinateX.setForeground(new Color(49, 49, 49));
			lblCoordinateX.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
			GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
			gbc_lblCoordinateX.anchor = GridBagConstraints.WEST;
			gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateX.gridx = 1;
			gbc_lblCoordinateX.gridy = 1;
			contentPanel.add(lblCoordinateX, gbc_lblCoordinateX);
		}
		{
			tF1 = new JTextField();
			GridBagConstraints gbc_tF1 = new GridBagConstraints();
			gbc_tF1.insets = new Insets(0, 0, 5, 5);
			gbc_tF1.fill = GridBagConstraints.HORIZONTAL;
			gbc_tF1.gridx = 3;
			gbc_tF1.gridy = 1;
			contentPanel.add(tF1, gbc_tF1);
			tF1.setColumns(20);
		}
		{
			JLabel lblCoordinateY = new JLabel("Coordinate Y:");
			lblCoordinateY.setForeground(new Color(0, 0, 0));
			lblCoordinateY.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
			GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
			gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateY.anchor = GridBagConstraints.WEST;
			gbc_lblCoordinateY.fill = GridBagConstraints.VERTICAL;
			gbc_lblCoordinateY.gridx = 1;
			gbc_lblCoordinateY.gridy = 3;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			tF2 = new JTextField();
			GridBagConstraints gbc_tF2 = new GridBagConstraints();
			gbc_tF2.insets = new Insets(0, 0, 5, 5);
			gbc_tF2.fill = GridBagConstraints.HORIZONTAL;
			gbc_tF2.gridx = 3;
			gbc_tF2.gridy = 3;
			contentPanel.add(tF2, gbc_tF2);
			tF2.setColumns(20);
		}
		
		{
			btnClr = new JButton("COLOR");
			btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color outerColor = JColorChooser.showDialog(null, "Choose outer color", btnClr.getBackground());
				if (outerColor != null)
					btnClr.setBackground(outerColor);
			}

		});
			btnClr.setBackground(Color.WHITE);
			btnClr.setFont(new Font("Yu Gothic UI", Font.PLAIN, 25));
			GridBagConstraints gbc_btnClr = new GridBagConstraints();
			gbc_btnClr.insets = new Insets(0, 0, 0, 5);
			gbc_btnClr.gridx = 3;
			gbc_btnClr.gridy = 5;
			contentPanel.add(btnClr, gbc_btnClr);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (tF1.getText().trim().isEmpty() || tF2.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {

							try {
								if (Integer.parseInt(tF1.getText().toString()) < 0
										|| Integer.parseInt(tF2.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Inserted values must be greater than 0!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} else {
									

									p = new Point(Integer.parseInt(tF1.getText().toString()),
											Integer.parseInt(tF2.getText().toString()), false,
											btnClr.getBackground());
									//p = new Point(Integer.parseInt(tF1.getText().toString()), Integer.parseInt(tF2.getText().toString()), false, Color.black);
									
									confirm = true;
									setVisible(false);

								}
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Enter numbers only!", "Error",
										JOptionPane.ERROR_MESSAGE);

							}
						}
				
					}
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCncl = new JButton("Cancel");
				btnCncl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCncl.setActionCommand("Cancel");
				buttonPane.add(btnCncl);
			}
		}
	}

	public JTextField gettF1() {
		return tF1;
	}

	public void settF1(JTextField tF1) {
		this.tF1 = tF1;
	}

	public JTextField gettF2() {
		return tF2;
	}

	public void settF2(JTextField tF2) {
		this.tF2 = tF2;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public JButton getBtnClr() {
		return btnClr;
	}

	public void setBtnClr(JButton btnClr) {
		this.btnClr = btnClr;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

}
