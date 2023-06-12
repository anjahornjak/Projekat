package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnlDrawing = new PnlDrawing(this);

	private JToggleButton tglbtnPoint = new JToggleButton("Point");
	private JToggleButton tglbtnLine = new JToggleButton("Line");
	private JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
	private JToggleButton tglbtnCircle = new JToggleButton("Circle");
	private JToggleButton tglbtnDonut = new JToggleButton("Donut");

	private JToggleButton tglbtnSelection = new JToggleButton("Selection");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setTitle("Crtkajmo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 495);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnlDrawing.setBackground(Color.WHITE);
		contentPane.add(pnlDrawing, BorderLayout.CENTER);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(255, 128, 128));
		contentPane.add(pnlNorth, BorderLayout.NORTH);

		pnlNorth.add(tglbtnPoint);
		pnlNorth.add(tglbtnLine);
		pnlNorth.add(tglbtnCircle);
		pnlNorth.add(tglbtnDonut);
		pnlNorth.add(tglbtnRectangle);

		ButtonGroup btnGroup = new ButtonGroup();

		btnGroup.add(tglbtnPoint);
		btnGroup.add(tglbtnLine);
		btnGroup.add(tglbtnCircle);
		btnGroup.add(tglbtnDonut);
		btnGroup.add(tglbtnRectangle);
		btnGroup.add(tglbtnSelection);

		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setBackground(new Color(255, 128, 128));
		pnlSouth.add(tglbtnSelection);

		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (pnlDrawing.getSelectedShape() != null) {
					modify();
					pnlDrawing.getSelectedShape().setSelected(false);

				} else {
					JOptionPane.showMessageDialog(null, "Please, select what you want to modify!", "Error",
							JOptionPane.ERROR_MESSAGE);
					tglbtnSelection.setSelected(true);
				}
				pnlDrawing.setSelectedShape(null);
				tglbtnSelection.setSelected(false);

			}
		});
		pnlSouth.add(btnModify);
		btnGroup.add(btnModify);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				tglbtnSelection.setSelected(false);
			}
		});
		pnlSouth.add(btnDelete);
		btnGroup.add(btnDelete);

		pnlDrawing.repaint();
	}

	protected void delete() {

		Shape selectedShape = pnlDrawing.getSelectedShape();

		if (selectedShape != null) {
			int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Warning message",
					JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				pnlDrawing.getShapes().remove(selectedShape);
			}
		} else {
			JOptionPane.showMessageDialog(null, "You haven't selected any shape!", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
		pnlDrawing.setSelectedShape(null);
		pnlDrawing.repaint();
	}

	protected void modify() {

		Shape selectedShape = pnlDrawing.getSelectedShape();

		if (selectedShape != null) {

			if (selectedShape instanceof Point) {

				Point p = (Point) selectedShape;
				DlgPoint dialog = new DlgPoint();

				dialog.gettF1().setText("" + Integer.toString(p.getX()));
				dialog.gettF2().setText("" + Integer.toString(p.getY()));
				dialog.getBtnClr().setBackground(p.getColor());
				dialog.setVisible(true);

				if (dialog.isConfirm()) {
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getP());
					repaint();
				}

			} else if (selectedShape instanceof Donut) {

				Donut donut = (Donut) selectedShape;
				DlgDonut dialogd = new DlgDonut();

				dialogd.getTxtX().setText("" + Integer.toString(donut.getCenter().getX()));
				dialogd.getTxtY().setText("" + Integer.toString(donut.getCenter().getY()));
				dialogd.getTxtOR().setText("" + Integer.toString(donut.getR()));
				dialogd.getTxtIR().setText("" + Integer.toString(donut.getInnerR()));
				dialogd.getBtnIInnerClr().setBackground(donut.getInnerColor());
				dialogd.getBtnOuterClr().setBackground(donut.getColor());
				dialogd.setModal(true);
				dialogd.setVisible(true);

				if (dialogd.isConfirm()) {
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialogd.getDonut());
					repaint();
				}
			} else if (selectedShape instanceof Circle && (selectedShape instanceof Donut) == false) {

				Circle circle = (Circle) selectedShape;
				DlgCircle dialog = new DlgCircle();

				dialog.getTxtX().setText("" + Integer.toString(circle.getCenter().getX()));
				dialog.getTxtY().setText("" + Integer.toString(circle.getCenter().getY()));
				dialog.getTxtR().setText("" + Integer.toString(circle.getR()));
				dialog.getBtnInnerColor().setBackground(circle.getInnerColor());
				dialog.getBtnSetOuterColor().setBackground(circle.getColor());

				dialog.setVisible(true);
				dialog.setModal(true);

				if (dialog.isConfirm()) {
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getCircle());
					repaint();
				}

			} else if (selectedShape instanceof Line) {

				Line line = (Line) selectedShape;
				DlgLine dialog = new DlgLine();

				dialog.getTxtSPCX().setText("" + Integer.toString(line.getStartPoint().getX()));
				dialog.getTxtSPCY().setText("" + Integer.toString(line.getStartPoint().getY()));
				dialog.getTxtEPCX().setText("" + Integer.toString(line.getEndPoint().getX()));
				dialog.getTxtEPCY().setText("" + Integer.toString(line.getEndPoint().getY()));
				dialog.getBtnClr().setBackground(line.getColor());

				dialog.setVisible(true);

				if (dialog.isConfirm()) {

					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getL());
					repaint();
				}

			} else if (selectedShape instanceof Rectangle) {

				Rectangle rect = (Rectangle) selectedShape;
				DlgRectangle dialog = new DlgRectangle();

				dialog.getTxtX().setText("" + Integer.toString(rect.getUpperLeft().getX()));
				dialog.getTxtY().setText("" + Integer.toString(rect.getUpperLeft().getY()));
				dialog.getTxtH().setText("" + Integer.toString(rect.getHeight()));
				dialog.getTxtW().setText("" + Integer.toString(rect.getWidth()));
				dialog.getBtnInnerClr().setBackground(rect.getInnerColor());
				dialog.getBtnOuterClr().setBackground(rect.getColor());
				dialog.setModal(true);
				dialog.setVisible(true);

				if (dialog.isConfirm()) {
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getR());
					repaint();
				}
			}

		}
	}

	public PnlDrawing getPnlDrawing() {
		return pnlDrawing;
	}

	public void setPnlDrawing(PnlDrawing pnlDrawing) {
		this.pnlDrawing = pnlDrawing;
	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}

	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public void setTglbtnDonut(JToggleButton tglbtnDonut) {
		this.tglbtnDonut = tglbtnDonut;
	}

	public JToggleButton getTglbtnSelection() {
		return tglbtnSelection;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelection) {
		this.tglbtnSelection = tglbtnSelection;
	}

}
