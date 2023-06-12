package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtW;
	private JTextField txtH;
	public boolean confirm;
	public Rectangle r; 
	private JButton btnOuterClr; 
	private JButton btnInnerClr; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(49, 49, 49));
		contentPanel.setBackground(new Color(255, 255, 128));
		contentPanel.setBorder(new LineBorder(new Color(49, 49, 49)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblULP = new JLabel("Set upper left point: ");
			lblULP.setForeground(new Color(49, 49, 49));
			lblULP.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			GridBagConstraints gbc_lblULP = new GridBagConstraints();
			gbc_lblULP.insets = new Insets(0, 0, 5, 5);
			gbc_lblULP.gridx = 1;
			gbc_lblULP.gridy = 2;
			contentPanel.add(lblULP, gbc_lblULP);
		}
		{
			JLabel lblX = new JLabel("Coordinate X:");
			lblX.setForeground(new Color(49, 49, 49));
			lblX.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.anchor = GridBagConstraints.WEST;
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 3;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 2;
			gbc_txtX.gridy = 3;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Coordinate Y:");
			lblY.setForeground(new Color(49, 49, 49));
			lblY.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.anchor = GridBagConstraints.WEST;
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 4;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtY = new JTextField();
			txtY.setColumns(10);
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 2;
			gbc_txtY.gridy = 4;
			contentPanel.add(txtY, gbc_txtY);
		}
		{
			JLabel lblSetWidth = new JLabel("Set width: ");
			lblSetWidth.setForeground(new Color(49, 49, 49));
			lblSetWidth.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			GridBagConstraints gbc_lblSetWidth = new GridBagConstraints();
			gbc_lblSetWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblSetWidth.anchor = GridBagConstraints.WEST;
			gbc_lblSetWidth.gridx = 1;
			gbc_lblSetWidth.gridy = 6;
			contentPanel.add(lblSetWidth, gbc_lblSetWidth);
		}
		{
			txtW = new JTextField();
			txtW.setColumns(10);
			GridBagConstraints gbc_txtW = new GridBagConstraints();
			gbc_txtW.insets = new Insets(0, 0, 5, 0);
			gbc_txtW.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtW.gridx = 2;
			gbc_txtW.gridy = 6;
			contentPanel.add(txtW, gbc_txtW);
		}
		{
			JLabel lblSetHeight = new JLabel("Set height: ");
			lblSetHeight.setForeground(new Color(49, 49, 49));
			lblSetHeight.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
			GridBagConstraints gbc_lblSetHeight = new GridBagConstraints();
			gbc_lblSetHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblSetHeight.anchor = GridBagConstraints.WEST;
			gbc_lblSetHeight.gridx = 1;
			gbc_lblSetHeight.gridy = 7;
			contentPanel.add(lblSetHeight, gbc_lblSetHeight);
		}
		{
			txtH = new JTextField();
			txtH.setColumns(10);
			GridBagConstraints gbc_txtH = new GridBagConstraints();
			gbc_txtH.insets = new Insets(0, 0, 5, 0);
			gbc_txtH.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtH.gridx = 2;
			gbc_txtH.gridy = 7;
			contentPanel.add(txtH, gbc_txtH);
		}
		{
			btnOuterClr = new JButton("Set outer color");
			btnOuterClr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color outerClr = JColorChooser.showDialog(null, "Choose outer color", btnOuterClr.getBackground());
					if (outerClr != null)
						btnOuterClr.setBackground(outerClr);
				}
			});
			btnOuterClr.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			GridBagConstraints gbc_btnOuterClr = new GridBagConstraints();
			gbc_btnOuterClr.insets = new Insets(0, 0, 5, 5);
			gbc_btnOuterClr.gridx = 1;
			gbc_btnOuterClr.gridy = 9;
			contentPanel.add(btnOuterClr, gbc_btnOuterClr);
		}
		{
			btnInnerClr = new JButton("Set inner color");
			btnInnerClr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color innerColor = JColorChooser.showDialog(null, "Choose inner color", btnInnerClr.getBackground());
					if (innerColor != null)
						btnInnerClr.setBackground(innerColor);
				}
			});
			btnInnerClr.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			GridBagConstraints gbc_btnInnerClr = new GridBagConstraints();
			gbc_btnInnerClr.insets = new Insets(0, 0, 5, 0);
			gbc_btnInnerClr.gridx = 2;
			gbc_btnInnerClr.gridy = 9;
			contentPanel.add(btnInnerClr, gbc_btnInnerClr);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						try {
							if (txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty() || 
									txtW.getText().trim().isEmpty() || txtH.getText().trim().isEmpty()) {
								setConfirm(false); 
								JOptionPane.showMessageDialog(null, "All fields are required" , "ERROR", 
										JOptionPane.ERROR_MESSAGE);
							} else {
								if (Integer.parseInt(txtW.getText().toString()) <= 0
										|| Integer.parseInt(txtH.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Inserted values must be greater than 0!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} else {
									r = new Rectangle (
											new Point(Integer.parseInt(getTxtX().getText().toString()),
														Integer.parseInt(getTxtY().getText().toString())), 
														Integer.parseInt(getTxtW().getText().toString()), 
														Integer.parseInt(getTxtH().getText().toString()), false, 
														btnOuterClr.getBackground(), btnInnerClr.getBackground());
									setConfirm(true);
									setVisible(false); 
								}
							}
							
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Enter numbers only!", "Error",
									JOptionPane.ERROR_MESSAGE);
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
					public void actionPerformed (ActionEvent e) {
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

	public JTextField getTxtW() {
		return txtW;
	}

	public void setTxtW(JTextField txtW) {
		this.txtW = txtW;
	}

	public JTextField getTxtH() {
		return txtH;
	}

	public void setTxtH(JTextField txtH) {
		this.txtH = txtH;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public Rectangle getR() {
		return r;
	}

	public void setR(Rectangle r) {
		this.r = r;
	}

	public JButton getBtnOuterClr() {
		return btnOuterClr;
	}

	public void setBtnOuterClr(JButton btnOuterClr) {
		this.btnOuterClr = btnOuterClr;
	}

	public JButton getBtnInnerClr() {
		return btnInnerClr;
	}

	public void setBtnInnerClr(JButton btnInnerClr) {
		this.btnInnerClr = btnInnerClr;
	}
	
}
