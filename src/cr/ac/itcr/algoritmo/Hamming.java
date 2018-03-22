package cr.ac.itcr.algoritmo;

import java.util.ArrayList;
import java.util.List;

public class Hamming {
	private static String bits;
	private boolean paridad;
	private String p1, p2, p3, p4, p5;

	public Hamming() {
		paridad = true;
		setBits("");
	}

	public List<List<String>> start(String bits, boolean paridad) {
		this.paridad = paridad;
		List<List<String>> solucion = new ArrayList<List<String>>();
		this.setBits(bits);
		solucion.add(0, palabraDeDatosSinParidad());
		solucion.add(1, p1());
		solucion.add(2, p2());
		solucion.add(3, p3());
		solucion.add(4, p4());
		solucion.add(5, p5());
		solucion.add(6, palabraDeDatosConParidad());

		return solucion;
	}

	public List<List<String>> check(String bits, boolean paridad) {
		this.paridad = paridad;
		List<List<String>> solucion = new ArrayList<List<String>>();
		this.setBits(bits);
		solucion.add(0, palabraDeDatosRecibida());
		solucion.add(1, checkP1());
		System.out.println("P1: "+solucion.get(1).get(17));
		solucion.add(2, checkP2());
		System.out.println("P2: "+solucion.get(2).get(17));
		solucion.add(3, checkP3());
		System.out.println("P3: "+solucion.get(3).get(17));
		solucion.add(4, checkP4());
		System.out.println("P4: "+solucion.get(4).get(17));
		solucion.add(5, checkP5());
		System.out.println("P5: "+solucion.get(5).get(17));
		int paridadS=0;
		for(int i = 1; i < 6;i++) {
			if(solucion.get(i).get(17).equals("Error")) {
				paridadS+=Math.pow(2, i-1);
				
			}
			if(i>4&&paridadS>0) {
				solucion.add(6,correccion(solucion.get(0),paridadS-1));
				return solucion;
			}
		}
		List<String> exito = new ArrayList<String>();
		exito.add("Numero esta correcto!!!");
		solucion.add(6,exito);
		return solucion;
	}

	// ----------------------Revisar Resultado----------------------
	private List<String> palabraDeDatosRecibida() {
		List<String> lpalabraDeDatosSinParidad = new ArrayList<String>();

		for (int i = 0; i < bits.length(); i++) {
			lpalabraDeDatosSinParidad.add(i, Character.toString(this.getBits().charAt(i)));
		}
		for (int i = bits.length(); i < 17; i++) {
			lpalabraDeDatosSinParidad.add(lpalabraDeDatosSinParidad.size(), "-");
		}
		if (paridad) {
			lpalabraDeDatosSinParidad.add(17, "0");
		} else if (!paridad) {
			lpalabraDeDatosSinParidad.add(17, "1");
		}
		lpalabraDeDatosSinParidad.add(18, "-");
		System.out.println(lpalabraDeDatosSinParidad);
		return lpalabraDeDatosSinParidad;
	}

	private List<String> checkP1() {
		String resultado = "";
		int cantidad = 0;
		List<Integer> posiciones = new ArrayList<Integer>();
		posiciones.add(2);
		posiciones.add(4);
		posiciones.add(6);
		posiciones.add(8);
		posiciones.add(10);
		posiciones.add(12);
		posiciones.add(14);
		posiciones.add(16);

		for (int i = 0; i < bits.length(); i++) {
			if (posiciones.contains(i)) {
				resultado += bits.substring(i, i + 1);
				if (bits.substring(i, i + 1).equals("1")) {
					cantidad += 1;
				}
			} else {
				resultado += "-";
			}
		}
		for (int i = bits.length(); i < 17; i++) {
			resultado += "-";
		}

		List<String> lP = new ArrayList<String>();
		for (int i = 0; i < 17; i++) {
			lP.add(Character.toString(resultado.charAt(i)));
		}
		System.out
				.println("Bit paridad 1: " + bits.charAt(0) + " Paridad: " + paridad + " Cantidad: " + cantidad + "\n");
		if (paridad && cantidad % 2 == 0 && bits.charAt(0) == '0') {
			lP.add("Correcto");
			lP.add(bits.substring(0, 1));

		} else if ((!paridad) && cantidad % 2 == 1 && bits.charAt(0) == '0') {
			lP.add("Correcto");
			lP.add(bits.substring(0, 1));

		} else if (paridad && cantidad % 2 == 1 && bits.charAt(0) == '1') {
			lP.add("Correcto");
			lP.add(bits.substring(0, 1));

		} else if ((!paridad) && cantidad % 2 == 0 && bits.charAt(0) == '1') {
			lP.add("Correcto");
			lP.add(bits.substring(0, 1));

		} else {
			lP.add("Error");
			Integer rst = cantidad % 2;
			lP.add(rst.toString());
		}

		lP.set(0, bits.substring(0, 1));
		return lP;

	}

	private List<String> checkP2() {
		String resultado = "";
		int cantidad = 0;
		List<Integer> posiciones = new ArrayList<Integer>();
		posiciones.add(2);
		posiciones.add(5);
		posiciones.add(6);
		posiciones.add(9);
		posiciones.add(10);
		posiciones.add(13);
		posiciones.add(14);

		for (int i = 0; i < bits.length(); i++) {
			if (posiciones.contains(i)) {
				resultado += bits.substring(i, i + 1);
				if (bits.substring(i, i + 1).equals("1")) {
					cantidad += 1;
				}
			} else {
				resultado += "-";
			}
		}
		for (int i = bits.length(); i < 17; i++) {
			resultado += "-";
		}

		List<String> lP = new ArrayList<String>();
		for (int i = 0; i < 17; i++) {
			lP.add(Character.toString(resultado.charAt(i)));
		}
		System.out
				.println("Bit paridad 2: " + bits.charAt(1) + " Paridad: " + paridad + " Cantidad: " + cantidad + "\n");
		if (paridad && cantidad % 2 == 0 && bits.charAt(1) == '0') {
			lP.add("Correcto");
			lP.add(bits.substring(1, 2));

		} else if ((!paridad) && cantidad % 2 == 1 && bits.charAt(1) == '0') {
			lP.add("Correcto");
			lP.add(bits.substring(1, 2));

		} else if (paridad && cantidad % 2 == 1 && bits.charAt(1) == '1') {
			lP.add("Correcto");
			lP.add(bits.substring(1, 2));

		} else if ((!paridad) && cantidad % 2 == 0 && bits.charAt(1) == '1') {
			lP.add("Correcto");
			lP.add(bits.substring(1, 2));

		} else {
			lP.add("Error");
			Integer rst = cantidad % 2;
			lP.add(rst.toString());
		}

		
		lP.set(1, bits.substring(1, 2));

		return lP;
	}

	private List<String> checkP3() {
		String resultado = "";
		int cantidad = 0;
		List<Integer> posiciones = new ArrayList<Integer>();
		posiciones.add(4);
		posiciones.add(5);
		posiciones.add(6);
		posiciones.add(11);
		posiciones.add(12);
		posiciones.add(13);
		posiciones.add(14);

		for (int i = 0; i < bits.length(); i++) {
			if (posiciones.contains(i)) {
				resultado += bits.substring(i, i + 1);
				if (bits.substring(i, i + 1).equals("1")) {
					cantidad += 1;
				}
			} else {
				resultado += "-";
			}
		}
		for (int i = bits.length(); i < 17; i++) {
			resultado += "-";
		}

		List<String> lP = new ArrayList<String>();
		for (int i = 0; i < 17; i++) {
			lP.add(Character.toString(resultado.charAt(i)));
		}
		System.out
				.println("Bit paridad 3: " + bits.charAt(3) + " Paridad: " + paridad + " Cantidad: " + cantidad + "\n");
		if (paridad && cantidad % 2 == 0 && bits.charAt(3) == '0') {
			lP.add("Correcto");
			lP.add(bits.substring(3, 4));

		} else if ((!paridad) && cantidad % 2 == 1 && bits.charAt(3) == '0') {
			lP.add("Correcto");
			lP.add(bits.substring(3, 4));

		} else if (paridad && cantidad % 2 == 1 && bits.charAt(3) == '1') {
			lP.add("Correcto");
			lP.add(bits.substring(3, 4));

		} else if ((!paridad) && cantidad % 2 == 0 && bits.charAt(3) == '1') {
			lP.add("Correcto");
			lP.add(bits.substring(3, 4));

		} else {
			lP.add("Error");
			Integer rst = cantidad % 2;
			lP.add(rst.toString());
		}

		lP.set(3, bits.substring(3, 4));

		return lP;
	}

	private List<String> checkP4() {
		if (bits.length() > 7) {
			String resultado = "";
			int cantidad = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(8);
			posiciones.add(9);
			posiciones.add(10);
			posiciones.add(11);
			posiciones.add(12);
			posiciones.add(13);
			posiciones.add(14);

			for (int i = 0; i < bits.length(); i++) {
				if (posiciones.contains(i)) {
					resultado += bits.substring(i, i + 1);
					if (bits.substring(i, i + 1).equals("1")) {
						cantidad += 1;
					}
				} else {
					resultado += "-";
				}
			}
			for (int i = bits.length(); i < 17; i++) {
				resultado += "-";
			}

			List<String> lP = new ArrayList<String>();
			for (int i = 0; i < 17; i++) {
				lP.add(Character.toString(resultado.charAt(i)));
			}
			System.out.println(
					"Bit paridad 4: " + bits.charAt(7) + " Paridad: " + paridad + " Cantidad: " + cantidad + "\n");
			if (paridad && cantidad % 2 == 0 && bits.charAt(7) == '0') {
				lP.add("Correcto");
				lP.add(bits.substring(7, 8));

			} else if ((!paridad) && cantidad % 2 == 1 && bits.charAt(7) == '0') {
				lP.add("Correcto");
				lP.add(bits.substring(7, 8));

			} else if (paridad && cantidad % 2 == 1 && bits.charAt(7) == '1') {
				lP.add("Correcto");
				lP.add(bits.substring(7, 8));

			} else if ((!paridad) && cantidad % 2 == 0 && bits.charAt(7) == '1') {
				lP.add("Correcto");
				lP.add(bits.substring(7, 8));

			} else {
				lP.add("Error");
				Integer rst = cantidad % 2;
				lP.add(rst.toString());
			}
			
			lP.set(7, bits.substring(7, 8));

			return lP;
		} else {
			return relleno();
		}

	}

	private List<String> checkP5() {
		if (bits.length() > 12) {
			String resultado = "";
			int cantidad = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(16);

			for (int i = 0; i < bits.length(); i++) {
				if (posiciones.contains(i)) {
					resultado += bits.substring(i, i + 1);
					if (bits.substring(i, i + 1).equals("1")) {
						cantidad += 1;
					}
				} else {
					resultado += "-";
				}
			}
			for (int i = bits.length(); i < 17; i++) {
				resultado += "-";
			}

			List<String> lP = new ArrayList<String>();
			for (int i = 0; i < 17; i++) {
				lP.add(Character.toString(resultado.charAt(i)));
			}
			System.out.println(
					"Bit paridad 3: " + bits.charAt(15) + " Paridad: " + paridad + " Cantidad: " + cantidad + "\n");
			if (paridad && cantidad % 2 == 0 && bits.charAt(15) == '0') {
				lP.add("Correcto");
				lP.add(bits.substring(15, 16));

			} else if ((!paridad) && cantidad % 2 == 1 && bits.charAt(15) == '0') {
				lP.add("Correcto");
				lP.add(bits.substring(15, 16));

			} else if (paridad && cantidad % 2 == 1 && bits.charAt(15) == '1') {
				lP.add("Correcto");
				lP.add(bits.substring(15, 16));

			} else if ((!paridad) && cantidad % 2 == 0 && bits.charAt(15) == '1') {
				lP.add("Correcto");
				lP.add(bits.substring(15, 16));

			} else {
				lP.add("Error");
				Integer rst = cantidad % 2;
				lP.add(rst.toString());
			}

			
			lP.set(15, bits.substring(15, 16));

			return lP;
		} else {
			return relleno();
		}
	}

	private List<String> correccion(List<String> entrada, Integer paridad) {
		System.out.println("Entrada: " + entrada);
		System.out.println("Bit a corregir: " + paridad);
		String salida = "";
		for(int i = 0;i < entrada.size();i++) {
			if(entrada.get(i+1).equals("-")) {
				entrada = entrada.subList(0, i);
				break;
			}
		}
		System.out.println("Entrada sin '-': " + entrada);
		String corregir = entrada.get(paridad);
		
		if (corregir.equals("0")) {
			entrada.set(paridad, "1");
			for (int i = 0; i < entrada.size(); i++) {
				salida+=entrada.get(i);
			}
		} else {
			entrada.set(paridad, "0");
			for (int i = 0; i < entrada.size(); i++) {
				salida+=entrada.get(i);
			}
		}
		
		List<String> salidaL = new ArrayList<String>();
		salidaL.add(salida);
		System.out.println(salidaL);
		return salidaL;

	}
	
	// --------------------------------------------------------------
	// ------------------------Crear Tabla---------------------------
	private List<String> palabraDeDatosSinParidad() {
		List<String> lpalabraDeDatosSinParidad = new ArrayList<String>();
		int j = 0;
		for (int i = 0; i < 17; i++) {
			if (i == 0 || i == 1 || i == 3 || i == 7 || i == 15) {
				lpalabraDeDatosSinParidad.add(i, "-");
			} else if (j < bits.length()) {
				lpalabraDeDatosSinParidad.add(i, Character.toString(this.getBits().charAt(j)));
				j++;
			} else {
				lpalabraDeDatosSinParidad.add(i, "-");
			}
		}
		return lpalabraDeDatosSinParidad;

	}

	private List<String> p1() {
		String bitParidad = "0";
		if (bits.length() == 4) {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(3);
			posiciones.add(5);
			posiciones.add(7);
			List<String> resultado = new ArrayList<String>();
			p1 = bitParidad + "-" + bits.substring(0, 1) + "-" + bits.substring(1);
			for (int i = 1; i < 8; i++) {
				if (posiciones.contains(i)) {
					if (p1.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p1 = bitParidad + "-" + bits.substring(0, 1) + "-" + bits.substring(1, 2) + "-" + bits.substring(3);
			for (int i = 0; i < 7; i++) {
				resultado.add(p1.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 7) {
					resultado.add(i, Character.toString(p1.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		}
		if (bits.length() == 8) {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(3);
			posiciones.add(5);
			posiciones.add(7);
			posiciones.add(9);
			posiciones.add(11);
			List<String> resultado = new ArrayList<String>();
			p1 = bitParidad + "-" + bits.substring(0, 1) + "-" + bits.substring(1, 2) + "-" + bits.substring(3, 4) + "-"
					+ bits.substring(4, 5) + "-" + bits.substring(6, 7) + "-";
			for (int i = 1; i < 12; i++) {
				if (posiciones.contains(i)) {
					if (p1.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p1 = bitParidad + "-" + bits.substring(0, 1) + "-" + bits.substring(1, 2) + "-" + bits.substring(3, 4) + "-"
					+ bits.substring(4, 5) + "-" + bits.substring(6, 7) + "-";
			for (int i = 0; i < 11; i++) {
				resultado.add(p1.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 12) {
					resultado.add(i, Character.toString(p1.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		} else {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(3);
			posiciones.add(5);
			posiciones.add(7);
			posiciones.add(9);
			posiciones.add(11);
			posiciones.add(13);
			posiciones.add(15);
			List<String> resultado = new ArrayList<String>();
			p1 = bitParidad + "-" + bits.substring(0, 1) + "-" + bits.substring(1, 4) + "-" + bits.substring(4, 11)
					+ "-" + bits.substring(11);
			for (int i = 1; i < 18; i++) {
				if (posiciones.contains(i)) {
					if (p1.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p1 = bitParidad + "-" + bits.substring(0, 1) + "-" + bits.substring(1, 2) + "-" + bits.substring(3, 4) + "-"
					+ bits.substring(4, 5) + "-" + bits.substring(6, 7) + "-" + bits.substring(8, 9) + "-"
					+ bits.substring(10, 11) + "-" + bits.substring(11);
			for (int i = 0; i < 15; i++) {
				resultado.add(p1.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 17) {
					resultado.add(i, Character.toString(p1.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		}
	}

	private List<String> p2() {
		String bitParidad = "0";
		if (bits.length() == 4) {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(3);
			posiciones.add(6);
			posiciones.add(7);
			List<String> resultado = new ArrayList<String>();
			p2 = "-" + bitParidad + bits.substring(0, 1) + "--" + bits.substring(2);
			for (int i = 1; i < 8; i++) {
				if (posiciones.contains(i)) {
					if (p2.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p2 = "-" + bitParidad + bits.substring(0, 1) + "--" + bits.substring(2);
			for (int i = 0; i < 7; i++) {
				resultado.add(p2.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 7) {
					resultado.add(i, Character.toString(p2.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		}
		if (bits.length() == 8) {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(3);
			posiciones.add(6);
			posiciones.add(7);
			posiciones.add(10);
			posiciones.add(11);
			List<String> resultado = new ArrayList<String>();
			p2 = "-" + bitParidad + bits.substring(0, 1) + "--" + bits.substring(2, 4) + "--" + bits.substring(5, 7)
					+ "-";
			for (int i = 1; i < 12; i++) {
				if (posiciones.contains(i)) {
					if (p2.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p2 = "-" + bitParidad + bits.substring(0, 1) + "--" + bits.substring(2, 4) + "--" + bits.substring(5, 7)
					+ "-";
			for (int i = 0; i < 11; i++) {
				resultado.add(p2.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 12) {
					resultado.add(i, Character.toString(p2.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		} else {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(3);
			posiciones.add(6);
			posiciones.add(7);
			posiciones.add(10);
			posiciones.add(11);
			posiciones.add(14);
			posiciones.add(15);
			List<String> resultado = new ArrayList<String>();
			p2 = "-" + bitParidad + bits.substring(0, 1) + "--" + bits.substring(2, 4) + "--" + bits.substring(5, 7)
					+ "--" + bits.substring(9, 11) + "--";
			for (int i = 1; i < 18; i++) {
				if (posiciones.contains(i)) {
					if (p2.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p2 = "-" + bitParidad + bits.substring(0, 1) + "--" + bits.substring(2, 4) + "--" + bits.substring(5, 7)
					+ "--" + bits.substring(9, 11) + "--";
			for (int i = 0; i < 15; i++) {
				resultado.add(p2.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 17) {
					resultado.add(i, Character.toString(p2.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		}
	}

	private List<String> p3() {
		String bitParidad = "0";
		if (bits.length() == 4) {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(5);
			posiciones.add(6);
			posiciones.add(7);
			List<String> resultado = new ArrayList<String>();
			p3 = "---" + bitParidad + bits.substring(1, 4);
			for (int i = 1; i < 8; i++) {
				if (posiciones.contains(i)) {
					if (p3.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p3 = "---" + bitParidad + bits.substring(1, 4);
			for (int i = 0; i < 7; i++) {
				resultado.add(p3.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 7) {
					resultado.add(i, Character.toString(p3.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		}
		if (bits.length() == 8) {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(5);
			posiciones.add(6);
			posiciones.add(7);
			posiciones.add(12);
			List<String> resultado = new ArrayList<String>();
			p3 = "---" + bitParidad + bits.substring(1, 4) + "----" + bits.substring(7, 8);
			for (int i = 1; i < 8; i++) {
				if (posiciones.contains(i)) {
					if (p3.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p3 = "---" + bitParidad + bits.substring(1, 4) + "----" + bits.substring(7, 8);
			for (int i = 0; i < 11; i++) {
				resultado.add(p3.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 12) {
					resultado.add(i, Character.toString(p3.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		} else {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(5);
			posiciones.add(6);
			posiciones.add(7);
			posiciones.add(12);
			posiciones.add(13);
			posiciones.add(14);
			posiciones.add(15);
			List<String> resultado = new ArrayList<String>();
			p3 = "---" + bitParidad + bits.substring(1, 4) + "----" + bits.substring(7, 11) + "--";
			for (int i = 1; i < 18; i++) {
				if (posiciones.contains(i)) {
					if (p3.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p3 = "---" + bitParidad + bits.substring(1, 4) + "----" + bits.substring(7, 11) + "--";
			for (int i = 0; i < 15; i++) {
				resultado.add(p3.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 17) {
					resultado.add(i, Character.toString(p3.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		}
	}

	private List<String> p4() {
		String bitParidad = "0";
		if (bits.length() == 4) {
			List<String> resultado = new ArrayList<String>();
			for (int i = 0; i < 17; i++) {
				resultado.add(i, "-");
			}
			return resultado;
		}
		if (bits.length() == 8) {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(9);
			posiciones.add(10);
			posiciones.add(11);
			posiciones.add(12);
			List<String> resultado = new ArrayList<String>();
			p4 = "-------" + bitParidad + bits.substring(4, 8);
			for (int i = 1; i < 13; i++) {

				if (posiciones.contains(i)) {
					if (p4.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}

			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p4 = "-------" + bitParidad + bits.substring(4, 8);
			for (int i = 0; i < 11; i++) {
				resultado.add(p4.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 12) {
					resultado.add(i, Character.toString(p4.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}

			return resultado;
		} else {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(9);
			posiciones.add(10);
			posiciones.add(11);
			posiciones.add(12);
			posiciones.add(13);
			posiciones.add(14);
			posiciones.add(15);
			List<String> resultado = new ArrayList<String>();
			p4 = "-------" + bitParidad + bits.substring(4, 11) + "--";
			for (int i = 1; i < 18; i++) {
				if (posiciones.contains(i)) {
					if (p4.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p4 = "-------" + bitParidad + bits.substring(4, 11) + "--";
			for (int i = 0; i < 15; i++) {
				resultado.add(p4.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 17) {
					resultado.add(i, Character.toString(p4.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		}
	}

	private List<String> p5() {
		String bitParidad = "0";
		if (bits.length() == 4) {
			List<String> resultado = new ArrayList<String>();
			for (int i = 0; i < 17; i++) {
				resultado.add(i, "-");
			}
			return resultado;
		}
		if (bits.length() == 8) {
			List<String> resultado = new ArrayList<String>();
			for (int i = 0; i < 17; i++) {
				resultado.add(i, "-");
			}
			return resultado;
		} else {
			int contadorDe1 = 0;
			List<Integer> posiciones = new ArrayList<Integer>();
			posiciones.add(17);
			List<String> resultado = new ArrayList<String>();
			p5 = "---------------" + bitParidad + bits.substring(11);
			for (int i = 1; i < 18; i++) {
				if (posiciones.contains(i)) {
					if (p5.charAt(i - 1) == '1') {
						contadorDe1++;
					}
				}
			}
			if (contadorDe1 % 2 == 0) {
				if (paridad) {
					bitParidad = "0";
				} else {
					bitParidad = "1";
				}
			} else {
				if (paridad) {
					bitParidad = "1";
				} else {
					bitParidad = "0";
				}
			}
			p5 = "---------------" + bitParidad + bits.substring(11);
			for (int i = 0; i < 15; i++) {
				resultado.add(p5.substring(i, i + 1));
			}
			for (int i = 0; i < 17; i++) {
				if (i < 17) {
					resultado.add(i, Character.toString(p5.charAt(i)));
				} else {
					resultado.add(i, "-");
				}
			}
			return resultado;
		}
	}

	private List<String> palabraDeDatosConParidad() {
		List<String> lP = new ArrayList<String>();
		lP = palabraDeDatosSinParidad();
		lP.set(0, p1().get(0));
		lP.set(1, p2().get(1));
		lP.set(3, p3().get(3));
		lP.set(7, p4().get(7));
		lP.set(15, p5().get(15));
		return lP;
	}

	// -------------------------------------------------------------
	public String getBits() {
		return bits;
	}

	public void setBits(String bits) {
		Hamming.bits = bits;
	}

	public List<String> relleno() {
		List<String> relleno = new ArrayList<String>();
		for (int i = 0; i < 19; i++) {
			relleno.add("-");
		}
		return relleno;
	}
}
