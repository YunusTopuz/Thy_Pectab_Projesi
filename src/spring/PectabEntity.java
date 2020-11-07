package spring;

public class PectabEntity {

	private String pectab;
	private String stream;
	private String template;
	
	public String getPectab() {
		return pectab;
	}
	public void setPectab(String pectab) {
		this.pectab = pectab;
	}
	
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	
	public PectabEntity() {}
	
	public PectabEntity(String pectab, String stream, String template) {
		super();
		this.pectab = pectab;
		this.stream = stream;
		this.template = template;
	}
	
	
	
}
