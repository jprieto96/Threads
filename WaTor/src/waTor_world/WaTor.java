package waTor_world;

public class WaTor {

	static AnimalThread[][] arrayMapa = new AnimalThread[20][20];
	static int X = 20;
	static int Y = 20;
	static int TIB_MAS = 5;
	static int TIB_FEM = 5;
	static int PEZ_MAS = 50;
	static int PEZ_FEM = 50;

	public void nacer(Animal esp, int x, int y) {
		AnimalThread th = new AnimalThread(esp, x, y);
		th.setName(esp.nombre + "" + esp.genero + "N");
		th.start();
		arrayMapa[x][y] = th;
	}

	public static void main(String[] args) {

		int x = 0;
		int y = 0;

		for (int i = 0; i < WaTor.PEZ_FEM; i++) {
			Animal pez = new Animal("P", "H");
			x = (int) (Math.random() * WaTor.arrayMapa.length);
			y = (int) (Math.random() * WaTor.arrayMapa.length);
			AnimalThread th = new AnimalThread(pez, x, y);
			th.setName(pez.nombre + "" + pez.genero);
			th.start();
		}

		for (int i = 0; i < WaTor.PEZ_MAS; i++) {
			Animal pez = new Animal("P", "M");
			x = (int) (Math.random() * WaTor.arrayMapa.length);
			y = (int) (Math.random() * WaTor.arrayMapa.length);
			AnimalThread th = new AnimalThread(pez, x, y);
			th.setName(pez.nombre + "" + pez.genero);
			th.start();
		}

		for (int i = 0; i < WaTor.TIB_FEM; i++) {
			Animal tiburon = new Animal("T", "H");
			x = (int) (Math.random() * WaTor.arrayMapa.length);
			y = (int) (Math.random() * WaTor.arrayMapa.length);
			AnimalThread th = new AnimalThread(tiburon, x, y);
			th.setName(tiburon.nombre + "" + tiburon.genero);
			th.start();
		}

		for (int i = 0; i < WaTor.TIB_MAS; i++) {
			Animal tiburon = new Animal("T", "M");
			x = (int) (Math.random() * WaTor.arrayMapa.length);
			y = (int) (Math.random() * WaTor.arrayMapa.length);
			AnimalThread th = new AnimalThread(tiburon, x, y);
			th.setName(tiburon.nombre + "" + tiburon.genero);
			th.start();
		}

		while (true) {
			try {

				for (int i = 0; i < WaTor.arrayMapa.length; i++) {
					for (int j = 0; j < WaTor.arrayMapa[i].length; j++) {
						if (WaTor.arrayMapa[i][j] == null) {
							if (j == 19) {
								System.out.println("0]");
							} else if (j == 0) {
								System.out.print("[0, ");
							} else {
								System.out.print("0, ");
							}
						} else {
							if (j == 19) {
								System.out.println(WaTor.arrayMapa[i][j].getName() + "]");
							} else if (j == 0) {
								System.out.print("[" + WaTor.arrayMapa[i][j].getName() + ", ");
							} else {
								System.out.print(WaTor.arrayMapa[i][j].getName() + ", ");
							}
						}

					}
				}
				System.out.println("");
				System.out.println("");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Interrupcion Thread");
			}
		}
	}
}
