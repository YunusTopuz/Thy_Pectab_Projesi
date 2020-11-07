package pectab;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.FontSizeAction;



public class Gui extends JPanel {

	ImageIcon ic = new ImageIcon("C:\\Users\\Lenovo\\Downloads\\2.jpg");
	ImageIcon ic2 = new ImageIcon("C:\\Users\\Lenovo\\Downloads\\fotolia_4000899_XS.jpg");

	private Stream st;
	private Pectab pt;
	private Template tp;

	public Gui(Stream st, Pectab pt, Template tp) {
		this.st = st;
		this.pt = pt;
		this.tp = tp;

	}

	public Gui() {
	}

	public Pectab getPt() {
		return pt;
	}

	public void setPt(Pectab pt) {
		this.pt = pt;
	}

	public Stream getSt() {
		return st;
	}

	public void setSt(Stream st) {
		this.st = st;
	}

	public Template getTp() {
		return tp;
	}

	public void setTp(Template tp) {
		this.tp = tp;
	}

	public void paintComponent(Graphics g) {
		
		

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;		
		Graphics2D g3 = (Graphics2D) g;// sonradan eklendi

		g.drawImage(ic.getImage(), 0, 0, 720, 306, null);
		g.drawImage(ic2.getImage(), 30, 60, 60, 200, null);

		g.drawRect(0, 0, 720, 306);

		for (templateParse template : tp.getTemplateList()) {
			double sizeX = 72/* 190.5 */;
			double sizeY = 30.6/* 80.96 */;
			if (template.getElementDescription().equals("T")) {

//              -------------------------------------
				// DEGREE
				if (template.getOrientation().equals("0")) {
					// System.out.println(Degere.ROTATE_90.getVal());
					AffineTransform at = new AffineTransform();
					at.setToRotation(Math.toRadians(0), 300, 200);
					g2.setTransform(at);
				} else if (template.getOrientation().equals("1")) {
					AffineTransform at = new AffineTransform();
					at.setToRotation(Math.toRadians(90), 300, 200);
					g2.setTransform(at);
				} else if (template.getOrientation().equals("2")) {
					AffineTransform at = new AffineTransform();
					at.setToRotation(Math.toRadians(180), 300, 200);
					g2.setTransform(at);
				} else {
					AffineTransform at = new AffineTransform();
					at.setToRotation(Math.toRadians(270), 300, 200);
					g2.setTransform(at);
				}
				// FONT
				if (template.getFont().equals("AA")) {
					g2.setFont(new Font("Segoe Script", Font.PLAIN, 6));
				} else if (template.getFont().equals("FF")) {
					g2.setFont(new Font("Segoe Script", Font.PLAIN, 16));
				} else if (template.getFont().equals("LL")) {
					g2.setFont(new Font("Segoe Script", Font.PLAIN, 13));
				} /*
					 * else if (template.getFont().equals("MM")) { AffineTransform at = new
					 * AffineTransform(); at.setToRotation(Math.toRadians(180), 1000, OCR);
					 * g2.setTransform(at);
					 * 
					 * }
					 */ else if (template.getFont().equals("OO")) {
					g2.setFont(new Font("Segoe Script", Font.PLAIN, 13));
				} else {
					g2.setFont(new Font("Segoe Script", Font.PLAIN, 5));
				}

				float tempx = Float.parseFloat(template.getCoordinateX()) / 10f;
				float tempy = Float.parseFloat(template.getCoordinateY()) / 10f;

				double resultX = sizeX * tempx / (187.33) / (0.1);
				double resultY = sizeY * tempy / (82.55) / (0.1);

				g2.drawString(template.getData(), (float) resultX, (float) resultY);

				System.out.println("x :" + (float) resultX + "y :" + (float) resultY + " koordinatlarına "
						+ template.getData() + " verisi çizildi");

//				-------------------------------------
				// Box Kısmı
			} else {

				float resultLengthX = (float) (Float.parseFloat(template.getLengthX()) / (10f));

				float resultHeightX = (float) (Float.parseFloat(template.getHeightX()) / (10f));

				double boxX = ((sizeX * Float.parseFloat(template.getCoordinateX())) / (187.33f)) / (0.1f) / (10);
				double boxY = sizeY * Float.parseFloat(template.getCoordinateY()) / (82.55f) / (0.1f) / (10);
				double widthX = (sizeX * resultLengthX / (187.33f)) / (0.1f);
				double heightY = (sizeY * resultHeightX / (82.55f)) / (0.1f);

				Stroke s = g3.getStroke();

				g3.setColor(Color.black);
				double a = Float.parseFloat(template.getWidth()) / 10 * (sizeX) / (187.33) / (0.1);
				BasicStroke thickness = new BasicStroke((int) a);
				g3.setStroke(thickness);

				// g3.drawRect((int) boxX, (int) boxY - (int) heightY, (int) widthX, (int)
				// heightY);

				Rectangle2D rect = new Rectangle2D.Double(boxX, boxY - heightY, widthX, heightY);
				g3.draw(rect);

				g3.setStroke(s);

				System.out.println("x :" + ((int) boxX + "y :" + ((int) boxY - (int) heightY) + "uzunluk :"
						+ (int) widthX + "genişlik :" + (int) heightY));

			}

			// ----------------------------
		}

		float factorRow = 306f / 18f;
		float factorColumn = 720f / 72f;

//		for (int i = 1; i <= 18; i++) {
//			g.drawLine(0, (int) factorRow * i, 720, (int) factorRow * i);
//
//		}
//
//		for (int i = 1; i <= 72; i++) {
//			g.drawLine((int) factorColumn * i, 306, (int) factorColumn * i, 0);
//
//		}

		g.setColor(Color.BLACK);

		int size;
		for (Element element : pt.getElementList()) {

			for (StreamElement streamElement : st.getStreamElements()) {

				if (streamElement.getElementNo().equals(element.getElementNo())) {

					if (streamElement.getData().length() <= Integer.parseInt(element.getMaxLength())) {

						String c1 = new String(element.getSize());
						if (element.getSize().equals("Q"))
							size = c1.hashCode() - 80;
						else if (element.getSize().equals("D") || element.getSize().equals("E")
								|| element.getSize().equals("F"))
							size = c1.hashCode() - 55;
						else
							size = c1.hashCode() - 50;

						g.setFont(new Font("TimesRoman", Font.CENTER_BASELINE, size));
						g.setColor(Color.black);

						int idx = element.getRow().hashCode() - "@".hashCode();

						int calculationy = idx * 306 / 18;
						int calculationx = Integer.parseInt(element.getColumn()) * 720 / 72;

						g.drawString(streamElement.getData(), calculationx, calculationy);

						if (!(element.getColumn1() == null || element.getColumn1().equals(""))) {

							int idx2 = element.getRow1().hashCode() - "@".hashCode();

							int calculationy2 = idx2 * 306 / 18;
							int calculationx2 = Integer.parseInt(element.getColumn1()) * 720 / 72;

							g.drawString(streamElement.getData(), calculationx2, calculationy2);

						}

					} else

						JOptionPane.showMessageDialog(null, streamElement.getData() + " exced maximum length");

				}

			}
		}

	}
}
