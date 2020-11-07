/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pectab;

/**
 *
 * @author Lenovo
 */
public class StreamElement {

	private String ElementNo;
	private String Data;

	public StreamElement(String ElementNo, String Data) {
		this.ElementNo = ElementNo;
		this.Data = Data;
	}

	public StreamElement() {
	}

	public String getElementNo() {
		return ElementNo;
	}

	public void setElementNo(String ElementNo) {
		this.ElementNo = ElementNo;
	}

	public String getData() {
		return Data;
	}

	public void setData(String Data) {
		this.Data = Data;
	}

	public static StreamElement parse(String streams) {

		StreamElement k = new StreamElement();

		k.setElementNo(streams.substring(0, 2));
		k.setData(streams.substring(2));

		return k;
	}

	@Override
	public String toString() {
		return "\nStreamElement{" + "ElementNo=" + ElementNo + ", Data=" + Data + '}';
	}

}
