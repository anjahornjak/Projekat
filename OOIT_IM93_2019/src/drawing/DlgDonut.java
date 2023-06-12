package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

import geometry.Donut;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtOR;
	private JTextField txtIR;
	public boolean confirm; 
	public Donut d; 
	public JButton btnIInnerClr; 
	public JButton btnOuterClr; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 128));
		contentPanel.setForeground(new Color(255, 255, 128));
		contentPanel.setBorder(new LineBorder(new Color(49, 49, 49)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lbC = new JLabel("Set center of your Donut:");
			lbC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			lbC.setForeground(new Color(49, 49, 49));
			GridBagConstraints gbc_lbC = new GridBagConstraints();
			gbc_lbC.insets = new Insets(0, 0, 5, 5);
			gbc_lbC.gridx = 1;
			gbc_lbC.gridy = 1;
			contentPanel.add(lbC, gbc_lbC);
		}
		{
			JLabel lblX = new JLabel("Coordinate X: ");
			lblX.setForeground(new Color(49, 49, 49));
			lblX.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.anchor = GridBagConstraints.WEST;
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 2;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 2;
			gbc_txtX.gridy = 2;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Coordinate Y: ");
			lblY.setForeground(new Color(49, 49, 49));
			lblY.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.anchor = GridBagConstraints.WEST;
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 3;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtY = new JTextField();
			txtY.setColumns(10);
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 2;
			gbc_txtY.gridy = 3;
			contentPanel.add(txtY, gbc_txtY);
		}
		{
			JLabel lblOR = new JLabel("Set outer radius: ");
			lblOR.setForeground(new Color(49, 49, 49));
			lblOR.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			GridBagConstraints gbc_lblOR = new GridBagConstraints();
			gbc_lblOR.insets = new Insets(0, 0, 5, 5);
			gbc_lblOR.anchor = GridBagConstraints.WEST;
			gbc_lblOR.gridx = 1;
			gbc_lblOR.gridy = 5;
			contentPanel.add(lblOR, gbc_lblOR);
		}
		{
			txtOR = new JTextField();
			txtOR.setColumns(10);
			GridBagConstraints gbc_txtOR = new GridBagConstraints();
			gbc_txtOR.insets = new Insets(0, 0, 5, 0);
			gbc_txtOR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtOR.gridx = 2;
			gbc_txtOR.gridy = 5;
			contentPanel.add(txtOR, gbc_txtOR);
		}
		{
			JLabel lblIR = new JLabel("Set inner radius: ");
			lblIR.setForeground(new Color(49, 49, 49));
			lblIR.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			GridBagConstraints gbc_lblIR = new GridBagConstraints();
			gbc_lblIR.insets = new Insets(0, 0, 5, 5);
			gbc_lblIR.anchor = GridBagConstraints.WEST;
			gbc_lblIR.gridx = 1;
			gbc_lblIR.gridy = 6;
			contentPanel.add(lblIR, gbc_lblIR);
		}
		{
			txtIR = new JTextField();
			txtIR.setColumns(10);
			GridBagConstraints gbc_txtIR = new GridBagConstraints();
			gbc_txtIR.insets = new Insets(0, 0, 5, 0);
			gbc_txtIR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtIR.gridx = 2;
			gbc_txtIR.gridy = 6;
			contentPanel.add(txtIR, gbc_txtIR);
		}
		{
			btnOuterClr = new JButton("Select outer color");
			btnOuterClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color outerColor = JColorChooser.showDialog(null, "Choose outer color", btnOuterClr.getBackground());
				if (outerColor != null)
					btnOuterClr.setBackground(outerColor);
			}
		});
			btnOuterClr.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			btnOuterClr.setForeground(new Color(49, 49, 49));
			GridBagConstraints gbc_btnOuterClr = new GridBagConstraints();
			gbc_btnOuterClr.insets = new Insets(0, 0, 0, 5);
			gbc_btnOuterClr.gridx = 1;
			gbc_btnOuterClr.gridy = 7;
			contentPanel.add(btnOuterClr, gbc_btnOuterClr);
		
		{
			btnIInnerClr = new JButton("Select inner color");
			btnIInnerClr.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent e) {
					Color innerColor = JColorChooser.showDialog(null, "Choose inner color", btnIInnerClr.getBackground());
				if (innerColor != null) 
					btnIInnerClr.setBackground(innerColor);
				}
			});
			
			btnIInnerClr.setForeground(new Color(49, 49, 49));
			btnIInnerClr.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			GridBagConstraints gbc_btnIInnerClr = new GridBagConstraints();
			gbc_btnIInnerClr.gridx = 2;
			gbc_btnIInnerClr.gridy = 7;
			contentPanel.add(btnIInnerClr, gbc_btnIInnerClr);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); 
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						if (txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()
								|| txtOR.getText().trim().isEmpty() || txtIR.getText().trim().isEmpty()) {
							setConfirm(false);
							JOptionPane.showMessageDialog(null, "All fields are required!", "Error",
									JOptionPane.ERROR_MESSAGE);

						} else {
							try {
								if (Integer.parseInt(txtOR.getText().toString()) <= 0
										|| Integer.parseInt(txtIR.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0)
									JOptionPane.showMessageDialog(null, "Inserted values must be greater than 0!", "Error",
											JOptionPane.ERROR_MESSAGE);
								else {
									if (Integer.parseInt(txtIR.getText().toString()) < Integer
											.parseInt(txtOR.getText().toString())) {
										d = new Donut(
												new Point(Integer.parseInt(txtX.getText().toString()),
														Integer.parseInt(txtY.getText().toString())),
												Integer.parseInt(txtOR.getText().toString()),
												Integer.parseInt(txtIR.getText().toString()), false,
												btnOuterClr.getBackground(), btnIInnerClr.getBackground()); 

										setConfirm(true);
										setVisible(false);
									} else {
										JOptionPane.showMessageDialog(null,
												"Outer radius must be greater than inner radius!", "Error",
												JOptionPane.ERROR_MESSAGE);
									}

								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Enter numbers only!", "Error",
										JOptionPane.ERROR_MESSAGE);
							}

						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				}
			}
		}
	}
			public JTextField getTxtX() {
				return txtX;
			}

			public void setTxtX(JTextField txtX) {
				this.txtX = txtX;
			}

			public JTextField getTxtY() {
				return txtY;
			}

			public void setTxtY(JTextField txtY) {
				this.txtY = txtY;
			}

			public JTextField getTxtOR() {
				return txtOR;
			}

			public void setTxtOR(JTextField txtOR) {
				this.txtOR = txtOR;
			}

			public JTextField getTxtIR() {
				return txtIR;
			}

			public void setTxtInnerR(JTextField txtIR) {
				this.txtIR = txtIR;
			}

			public boolean isConfirm() {
				return confirm;
			}

			public void setConfirm(boolean confirm) {
				this.confirm = confirm;
			}

			public Donut getDonut() {
				return d;
			}

			public void setDonut(Donut donut) {
				this.d = donut;
			}

			public JButton getBtnIInnerClr() {
				return btnIInnerClr;
			}

			public void setBtnIInnerClr(JButton btnInnerColor) {
				this.btnIInnerClr = btnInnerColor;
			}

			public JButton getBtnOuterClr() {
				return btnOuterClr;
			}

			public void setBtnOutlineColor(JButton btnOuterColor) {
				this.btnOuterClr = btnOuterColor;
			}

		}
