package pectab;

import java.util.ArrayList;
import java.util.List;

public class Template {

	private String templateID;
	private String separator;

	private List<templateParse> templateList = new ArrayList<templateParse>();

	public Template(String templateID, String separator, List<templateParse> templateList) {

		this.templateID = templateID;
		this.separator = separator;

		this.templateList = templateList;
	}

	public Template() {

	}

	public String getTemplateID() {
		return templateID;
	}

	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public List<templateParse> getTemplateList() {
		return templateList;
	}

	public static Template parse(String template) {

		Template t = new Template();
		t.setTemplateID(template.substring(2, 4));
		t.setSeparator(template.substring(4, 5));
		System.out.println(t.getSeparator());

		String tempTemplate = template.substring(5);
		String[] templateSequence;
		templateSequence = tempTemplate.split((t.getSeparator()));

		for (int i = 0; i < templateSequence.length; i++) {
			templateParse temp = templateParse.parse(templateSequence[i]);
			t.getTemplateList().add(temp);
		}

		return t;
	}

	@Override
	public String toString() {
		return "Template [templateID=" + templateID + ", separator=" + separator + ", templateList=" + templateList
				+ "]";
	}

}
