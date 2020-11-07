package pectab;

public class templateParse {

	private String formatcode;
	private String elementDescription;
	private String coordinateX;
	private String coordinateY;
	private String heightX;
	private String lengthX;
	private String width;
	private String orientation;
	private String charOrientation;
	private String fontDomain;
	private String font;
	private String charExpension;
	private String indicator;
	private String data;

	public templateParse(String formatcode, String elementDescription, String coordinateX, String coordinateY,
			String heightX, String lengthX, String width, String orientation, String charOrientation, String fontDomain,
			String font, String charExpension, String indicator, String data) {
		super();
		this.formatcode = formatcode;
		this.elementDescription = elementDescription;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.heightX = heightX;
		this.lengthX = lengthX;
		this.width = width;
		this.orientation = orientation;
		this.charOrientation = charOrientation;
		this.fontDomain = fontDomain;
		this.font = font;
		this.charExpension = charExpension;
		this.indicator = indicator;
		this.data = data;
	}

	public String getElementDescription() {
		return elementDescription;
	}

	public void setElementDescription(String elementDescription) {
		this.elementDescription = elementDescription;
	}

	public String getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(String coordinateX) {
		this.coordinateX = coordinateX;
	}

	public String getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(String coordinateY) {
		this.coordinateY = coordinateY;
	}

	public String getHeightX() {
		return heightX;
	}

	public void setHeightX(String heightX) {
		this.heightX = heightX;
	}

	public String getLengthX() {
		return lengthX;
	}

	public void setLengthX(String lengthX) {
		this.lengthX = lengthX;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public templateParse() {

	}

	public String getFormatcode() {
		return formatcode;
	}

	public void setFormatcode(String formatcode) {
		this.formatcode = formatcode;

	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getCharOrientation() {
		return charOrientation;
	}

	public void setCharOrientation(String charOrientation) {
		this.charOrientation = charOrientation;
	}

	public String getFontDomain() {
		return fontDomain;
	}

	public void setFontDomain(String fontDomain) {
		this.fontDomain = fontDomain;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getCharExpension() {
		return charExpension;
	}

	public void setCharExpension(String charExpension) {
		this.charExpension = charExpension;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static templateParse parse(String tempParse) {
		templateParse tp = new templateParse();

		tp.setFormatcode(tempParse.substring(0, 2));
		tp.setElementDescription(tempParse.substring(2, 3));

		if (tp.getElementDescription().equals("B")) {
			tp.setCoordinateX(tempParse.substring(3, 7));
			tp.setCoordinateY(tempParse.substring(7, 10));
			tp.setHeightX(tempParse.substring(10, 13));
			tp.setLengthX(tempParse.substring(13, 17));
			tp.setWidth(tempParse.substring(17, 20));
			tp.setIndicator(tempParse.substring(20, 25));
		}

		else {
			tp.setCoordinateX(tempParse.substring(3, 7));
			tp.setCoordinateY(tempParse.substring(7, 10));
			tp.setOrientation(tempParse.substring(10, 11));
			tp.setCharOrientation(tempParse.substring(11, 12));
			tp.setFontDomain(tempParse.substring(12, 13));
			tp.setFont(tempParse.substring(13, 15));
			tp.setCharExpension(tempParse.substring(15, 16));
			tp.setIndicator(tempParse.substring(16, 21));
			tp.setData(tempParse.substring(21));

		}

		return tp;

	}

	@Override
	public String toString() {
		return "\ntemplateParse [formatcode=" + formatcode + ", elementDescription=" + elementDescription
				+ ", coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + ", heightX=" + heightX
				+ ", lengthX=" + lengthX + ", width=" + width + ", orientation=" + orientation + ", charOrientation="
				+ charOrientation + ", fontDomain=" + fontDomain + ", font=" + font + ", charExpension=" + charExpension
				+ ", indicator=" + indicator + ", data=" + data + "]";
	}

}
