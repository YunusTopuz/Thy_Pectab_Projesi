package pectab;

public class Element {

	private String elementNo;
	private String maxLength;
	private String row;
	private String column;
	private String row1;
	private String column1;
	private String size;

	public Element(String elementNo, String maxLength, String row, String column, String row1, String column1,
			String size) {
		this.elementNo = elementNo;
		this.maxLength = maxLength;
		this.row = row;
		this.column = column;
		this.row1 = row1;
		this.column1 = column1;
		this.size = size;
	}

	public Element() {
	}

	public String getElementNo() {
		return elementNo;
	}

	public void setElementNo(String elementNo) {
		this.elementNo = elementNo;
	}

	public String getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getRow1() {
		return row1;
	}

	public void setRow1(String row1) {
		this.row1 = row1;
	}

	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public static Element parse(String element) {

		Element e = new Element();

		e.setElementNo(element.substring(0, 2));
		e.setMaxLength(element.substring(2, 4));
		e.setRow(element.substring(4, 5));
		e.setColumn(element.substring(5, 7));

		if (element.length() > 8) {
			e.setRow1(element.substring(7, 8));
			e.setColumn1(element.substring(8, 10));
			e.setSize(element.substring(10, 11));
		} else {
			e.setSize(element.substring(7, 8));
		}

		return e;

	}

	@Override
	public String toString() {
		return "\nElement{" + "elementNo=" + elementNo + " maxLength=" + maxLength + " row=" + row + ", column="
				+ column + ", row1=" + row1 + ", column1=" + column1 + ", size=" + size + '}';
	}

}
