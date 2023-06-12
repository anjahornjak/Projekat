package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtR;
	public boolean confirm;
	public JButton btnSetInnerColor;
	public JButton btnSetOuterColor;
	public Circle c; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 128));
		contentPanel.setBorder(new LineBorder(new Color(249, 249, 0), 1, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenter = new JLabel("Set center of your circle:");
			lblCenter.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			GridBagConstraints gbc_lblCenter = new GridBagConstraints();
			gbc_lblCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenter.gridx = 1;
			gbc_lblCenter.gridy = 1;
			contentPanel.add(lblCenter, gbc_lblCenter);
		}
		{
			JLabel lblCY = new JLabel("Coordinate X: ");
			lblCY.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
			lblCY.setForeground(new Color(49, 49, 49));
			GridBagConstraints gbc_lblCY = new GridBagConstraints();
			gbc_lblCY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCY.anchor = GridBagConstraints.WEST;
			gbc_lblCY.gridx = 1;
			gbc_lblCY.gridy = 2;
			contentPanel.add(lblCY, gbc_lblCY);
		}
		{
			txtX = new JTextField();
			txtX.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 2;
			gbc_txtX.gridy = 2;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblCY = new JLabel("Coordinate Y: ");
			lblCY.setForeground(new Color(49, 49, 49));
			lblCY.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
			GridBagConstraints gbc_lblCY = new GridBagConstraints();
			gbc_lblCY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCY.anchor = GridBagConstraints.WEST;
			gbc_lblCY.gridx = 1;
			gbc_lblCY.gridy = 3;
			contentPanel.add(lblCY, gbc_lblCY);
		}
		{
			txtY = new JTextField();
			txtY.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtY.setColumns(10);
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 2;
			gbc_txtY.gridy = 3;
			contentPanel.add(txtY, gbc_txtY);
		}
		{
			JLabel lblRadius = new JLabel("Set radius: ");
			lblRadius.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.anchor = GridBagConstraints.WEST;
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 5;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtR = new JTextField();
			txtR.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			txtR.setColumns(10);
			GridBagConstraints gbc_txtR = new GridBagConstraints();
			gbc_txtR.insets = new Insets(0, 0, 5, 0);
			gbc_txtR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtR.gridx = 2;
			gbc_txtR.gridy = 5;
			contentPanel.add(txtR, gbc_txtR);
		}
		{
			btnSetInnerColor = new JButton("Set inner color");
			btnSetInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color innerColor = JColorChooser.showDialog(null, "Set inner color", btnSetInnerColor.getBackground());
					if (innerColor != null)
						btnSetInnerColor.setBackground(innerColor);

				}
			});
			btnSetInnerColor.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
			GridBagConstraints gbc_btnSetInnerColor = new GridBagConstraints();
			gbc_btnSetInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnSetInnerColor.gridx = 1;
			gbc_btnSetInnerColor.gridy = 7;
			contentPanel.add(btnSetInnerColor, gbc_btnSetInnerColor);
		}
		{
			btnSetOuterColor = new JButton("Set outer color");
			btnSetOuterColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color outlineColor = JColorChooser.showDialog(null, "Set outline color",
							btnSetOuterColor.getBackground());
					if (outlineColor != null)
						btnSetOuterColor.setBackground(outlineColor);

				}
			});
			btnSetOuterColor.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
			GridBagConstraints gbc_btnSetOuterColor = new GridBagConstraints();
			gbc_btnSetOuterColor.gridx = 2;
			gbc_btnSetOuterColor.gridy = 7;
			contentPanel.add(btnSetOuterColor, gbc_btnSetOuterColor);
		}
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()
								|| txtR.getText().trim().isEmpty()) {
							setConfirm(false);
							JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(txtR.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Insert values greather than 0!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} else {
									c = new Circle(

											new Point(Integer.parseInt(txtX.getText().toString()),
													Integer.parseInt(txtY.getText().toString())),
											Integer.parseInt(txtR.getText().toString()), false,
											btnSetOuterColor.getBackground(), btnSetInnerColor.getBackground());
								
									setConfirm(true);
									setVisible(false);
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Enter numbers only", "Error",
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

	public JTextField getTxtR() {
		return txtR;
	}

	public void setTxtR(JTextField txtR) {
		this.txtR = txtR;
	}

	public Circle getCircle() {
		return c;
	}

	public void setCircle(Circle circle) {
		this.c = circle;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public JButton getBtnInnerColor() {
		return btnSetInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnSetInnerColor = btnInnerColor;
	}

	public JButton getBtnSetOuterColor() {
		return btnSetOuterColor;
	}

	public void setBtnOutlineColor(JButton btnOuterColor) {
		this.btnSetOuterColor = btnOuterColor;
	}

}
