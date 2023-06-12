package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.border.LineBorder;

import geometry.Line;
import geometry.Point;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSPCX;
	private JTextField txtSPCY;
	private JTextField txtEPCX;
	private JTextField txtEPCY;
	private JButton btnClr; 
	private boolean confirm;
	private Line l; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setBounds(100, 100, 382, 445);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 128, 128));
		contentPanel.setBackground(new Color(255, 255, 128));
		contentPanel.setBorder(new LineBorder(new Color(49, 49, 49), 2, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPoint = new JLabel("Set start point: \r\n");
			lblStartPoint.setForeground(new Color(49, 49, 49));
			lblStartPoint.setFont(new Font("Yu Gothic UI", Font.PLAIN, 21));
			GridBagConstraints gbc_lblStartPoint = new GridBagConstraints();
			gbc_lblStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPoint.gridx = 0;
			gbc_lblStartPoint.gridy = 0;
			contentPanel.add(lblStartPoint, gbc_lblStartPoint);
		}
		{
			JLabel lblSPCX = new JLabel("Coordinate X: ");
			lblSPCX.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
			lblSPCX.setForeground(new Color(49, 49, 49));
			GridBagConstraints gbc_lblSPCX = new GridBagConstraints();
			gbc_lblSPCX.insets = new Insets(0, 0, 5, 5);
			gbc_lblSPCX.gridx = 0;
			gbc_lblSPCX.gridy = 2;
			contentPanel.add(lblSPCX, gbc_lblSPCX);
		}
		{
			txtSPCX = new JTextField();
			txtSPCX.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			GridBagConstraints gbc_txtSPCX = new GridBagConstraints();
			gbc_txtSPCX.insets = new Insets(0, 0, 5, 0);
			gbc_txtSPCX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSPCX.gridx = 2;
			gbc_txtSPCX.gridy = 2;
			contentPanel.add(txtSPCX, gbc_txtSPCX);
			txtSPCX.setColumns(10);
		}
		{
			JLabel lblSPCY = new JLabel("Coordinate Y: ");
			lblSPCY.setForeground(new Color(49, 49, 49));
			lblSPCY.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
			GridBagConstraints gbc_lblSPCY = new GridBagConstraints();
			gbc_lblSPCY.insets = new Insets(0, 0, 5, 5);
			gbc_lblSPCY.gridx = 0;
			gbc_lblSPCY.gridy = 3;
			contentPanel.add(lblSPCY, gbc_lblSPCY);
		}
		{
			txtSPCY = new JTextField();
			txtSPCY.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			GridBagConstraints gbc_txtSPCY = new GridBagConstraints();
			gbc_txtSPCY.insets = new Insets(0, 0, 5, 0);
			gbc_txtSPCY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSPCY.gridx = 2;
			gbc_txtSPCY.gridy = 3;
			contentPanel.add(txtSPCY, gbc_txtSPCY);
			txtSPCY.setColumns(10);
		}
		{
			JLabel lblEndPoint = new JLabel("Set end point: ");
			lblEndPoint.setForeground(new Color(49, 49, 49));
			lblEndPoint.setFont(new Font("Yu Gothic UI", Font.PLAIN, 21));
			GridBagConstraints gbc_lblEndPoint = new GridBagConstraints();
			gbc_lblEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPoint.gridx = 0;
			gbc_lblEndPoint.gridy = 5;
			contentPanel.add(lblEndPoint, gbc_lblEndPoint);
		}
		{
			JLabel lblEPCX = new JLabel("Coordinate X: ");
			lblEPCX.setForeground(new Color(49, 49, 49));
			lblEPCX.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
			GridBagConstraints gbc_lblEPCX = new GridBagConstraints();
			gbc_lblEPCX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEPCX.gridx = 0;
			gbc_lblEPCX.gridy = 7;
			contentPanel.add(lblEPCX, gbc_lblEPCX);
		}
		{
			txtEPCX = new JTextField();
			txtEPCX.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			GridBagConstraints gbc_txtEPCX = new GridBagConstraints();
			gbc_txtEPCX.insets = new Insets(0, 0, 5, 0);
			gbc_txtEPCX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEPCX.gridx = 2;
			gbc_txtEPCX.gridy = 7;
			contentPanel.add(txtEPCX, gbc_txtEPCX);
			txtEPCX.setColumns(10);
		}
		{
			JLabel lblEPCY = new JLabel("Coordinate Y: ");
			lblEPCY.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
			GridBagConstraints gbc_lblEPCY = new GridBagConstraints();
			gbc_lblEPCY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEPCY.gridx = 0;
			gbc_lblEPCY.gridy = 8;
			contentPanel.add(lblEPCY, gbc_lblEPCY);
		}
		{
			txtEPCY = new JTextField();
			txtEPCY.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			GridBagConstraints gbc_txtEPCY = new GridBagConstraints();
			gbc_txtEPCY.insets = new Insets(0, 0, 5, 0);
			gbc_txtEPCY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEPCY.gridx = 2;
			gbc_txtEPCY.gridy = 8;
			contentPanel.add(txtEPCY, gbc_txtEPCY);
			txtEPCY.setColumns(10);
		}
		{
			btnClr = new JButton("COLOR");
			btnClr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color color = JColorChooser.showDialog(null, "Choose color", btnClr.getBackground()); 
					if (color != null)
						btnClr.setBackground(color);
				}
			});
			btnClr.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
			GridBagConstraints gbc_btnClr = new GridBagConstraints();
			gbc_btnClr.gridx = 2;
			gbc_btnClr.gridy = 10;
			contentPanel.add(btnClr, gbc_btnClr);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtSPCX.getText().trim().isEmpty() || txtSPCY.getText().trim().isEmpty()
								|| txtEPCX.getText().trim().isEmpty() || txtEPCY.getText().trim().isEmpty()) {
							confirm = false;
							JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(txtSPCX.getText().toString()) < 0
										|| Integer.parseInt(txtSPCY.getText().toString()) < 0
										|| Integer.parseInt(txtEPCX.getText().toString()) < 0
										|| Integer.parseInt(txtEPCY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Inserted values must be greater than 0!", "Error",
											JOptionPane.ERROR_MESSAGE);

								} else {
									l = new Line(
											new Point(Integer.parseInt(txtSPCX.getText().toString()),
													Integer.parseInt(txtSPCY.getText().toString())),
											new Point(Integer.parseInt(txtEPCX.getText().toString()),
													Integer.parseInt(txtEPCY.getText().toString())),
											false, btnClr.getBackground());

									confirm = true;
									setVisible(false);

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

	public JTextField getTxtSPCX() {
		return txtSPCX;
	}

	public void setTxtSPCX(JTextField txtSPCX) {
		this.txtSPCX = txtSPCX;
	}

	public JTextField getTxtSPCY() {
		return txtSPCY;
	}

	public void setTxtSPCY(JTextField txtSPCY) {
		this.txtSPCY = txtSPCY;
	}

	public JTextField getTxtEPCX() {
		return txtEPCX;
	}

	public void setTxtEPCX(JTextField txtEPCX) {
		this.txtEPCX = txtEPCX;
	}

	public JTextField getTxtEPCY() {
		return txtEPCY;
	}

	public void setTxtEPCY(JTextField txtEPCY) {
		this.txtEPCY = txtEPCY;
	}

	public JButton getBtnClr() {
		return btnClr;
	}

	public void setBtnClr(JButton btnClr) {
		this.btnClr = btnClr;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public Line getL() {
		return l;
	}

	public void setL(Line l) {
		this.l = l;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
	

}
