package pectab;

public class a {

	public static void main(String[] args) {

		String pectab = "TT03_02B0260450180022000600000_03B0570450180035000600000_04B1000450180022000600000_05B1600650145022000600000_07B1330650145025000600000_20T030033000ALL@00000GATE/KAPI_21T065031000ALL@00000BOARDING TIME_22T066534000ALL@00000BINIS SAATI_23T103033000ALL@00000SEAT/KOLTUK_24T026066500ALL@00000SEC NO:_25T045066500ALL@00000BAG:_26T073062000ALL@00000GROUP:_27T065066500ALL@00000AGT:_28T135062000AFF@00000GROUP_30T026071500P20@00000BOARDING ENDS 20MIN BEFORE DEPARTURE/UCAGA KABUL KALKIS SAATINE 20DK KALA BITER._";

		Template pt = Template.parse(pectab);
		System.out.println(pt);

	}

}
//