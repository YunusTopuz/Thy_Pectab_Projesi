package pectab;

public enum Degree {

	HORIZONTAL(0), ROTATE_90(1), ROTATE_180(2), ROTATE_270(3);

	private String value;
	private int val;

	Degree(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

}
