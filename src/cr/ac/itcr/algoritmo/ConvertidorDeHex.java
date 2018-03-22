package cr.ac.itcr.algoritmo;

import java.util.HashMap;
import java.util.Map;

public class ConvertidorDeHex {
	String bin;
	String hex;
	Map<String, String> map = new HashMap<String, String>();

	public ConvertidorDeHex() {
		map.put("0", "0000");
		map.put("1", "0001");
		map.put("2", "0010");
		map.put("3", "0011");
		map.put("4", "0100");
		map.put("5", "0101");
		map.put("6", "0110");
		map.put("7", "0111");
		map.put("8", "1000");
		map.put("9", "1001");
		map.put("A", "1010");
		map.put("B", "1011");
		map.put("C", "1100");
		map.put("D", "1101");
		map.put("E", "1110");
		map.put("F", "1111");
		map.put("a", "1010");
		map.put("b", "1011");
		map.put("c", "1100");
		map.put("d", "1101");
		map.put("e", "1110");
		map.put("f", "1111");

	}

	public String hexABin(String hex) {
		bin = "";
		for (int i = 0; i < hex.length(); i++) {
			bin += map.get(Character.toString(hex.charAt(i)));
		}
		return bin;
	}

	public boolean revisarHex(String hex) {
		if (hex.length() > 3) {
			return false;
		} else if (map.containsKey(Character.toString(hex.charAt(0)))) {
			if (hex.length() >= 2) {
				if (map.containsKey(Character.toString(hex.charAt(1)))) {
					if (hex.length() == 2) {
						return true;
					} else {
						if (map.containsKey(Character.toString(hex.charAt(2)))) {
							return true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}

			} else {
				return true;
			}
		} else {
			return false;
		}

	}

	public boolean revisarBin(String bin) {
		if (bin.length() > 17) {
			return false;
		} else {
			for (int i = 0; i < bin.length(); i++) {
				if (bin.charAt(i) == '1' || bin.charAt(i) == '0') {
				} else {
					return false;
				}
			}
			return true;
		}
	}
}
