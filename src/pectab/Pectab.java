package pectab;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pectab {

	private char separatorChar;
	private char unreadableChar;
	private char formatCode;
	private int version;
	private List<Element> elementList = new ArrayList<Element>();

	public Pectab(char separatorChar, char unreadableChar, char formatCode, int version) {
		this.separatorChar = separatorChar;
		this.unreadableChar = unreadableChar;
		this.formatCode = formatCode;
		this.version = version;
	}

	public Pectab() {
	}

	public char getSeparatorChar() {
		return separatorChar;
	}

	public void setSeparatorChar(char separatorChar) {
		this.separatorChar = separatorChar;
	}

	public char getUnreadableChar() {
		return unreadableChar;
	}

	public void setUnreadableChar(char unreadableChar) {
		this.unreadableChar = unreadableChar;
	}

	public char getFormatCode() {
		return formatCode;
	}

	public void setFormatCode(char formatCode) {
		this.formatCode = formatCode;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Element> getElementList() {
		return elementList;
	}

	public static Pectab parse(String pectab) {

		Pectab p = new Pectab();

		String[] element;

		p.setSeparatorChar(pectab.charAt(3));
		p.setUnreadableChar(pectab.charAt(4));
		p.setFormatCode(pectab.charAt(5));
		p.setVersion(pectab.charAt(6));

		String tempPectap = pectab.substring(82);

		element = tempPectap.split(Character.toString(p.getSeparatorChar()));

		for (int i = 0; i < element.length; i++) {
			Element temp = Element.parse(element[i]);
			p.getElementList().add(temp);
		}

		return p;

	}

	@Override
	public String toString() {
		return "Pectab{" + "separatorChar=" + separatorChar + ", unreadableChar=" + unreadableChar + ", formatCode="
				+ formatCode + ", version=" + version + ",\n elementList=" + elementList + '}';
	}

}
