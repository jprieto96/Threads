package waTor_world;

public class AnimalThread extends Thread {

	Animal animal;
	WaTor wator = new WaTor();
	int x;
	int y;

	public AnimalThread(Animal animal, int x, int y) {
		this.animal = animal;
		this.x = x;
		this.y = y;
		WaTor.arrayMapa[x][y] = this;
	}

	public void mover() {
		int movimiento = (int) ((Math.random() * 4) + 1);

		if (movimiento == 1) {
			if (x == 0) {
				x = WaTor.X - 1;
			} else {
				x--;
			}
		}
		if (movimiento == 2) {
			if (x == WaTor.X - 1) {
				x = 0;
			} else {
				x++;
			}
		}

		if (movimiento == 3) {
			if (y == 0) {
				y = WaTor.Y - 1;
			} else {
				y--;
			}
		}
		if (movimiento == 4) {
			if (y == WaTor.Y - 1) {
				y = 0;
			} else {
				y++;
			}
		}

	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				WaTor.arrayMapa[x][y] = null;
				mover();
				AnimalThread map = WaTor.arrayMapa[x][y];
				if (map != null) {
					if (map.animal.nombre.equals(animal.nombre) && map.animal.genero.equals(animal.genero)) {
						map.interrupt();
						WaTor.arrayMapa[x][y] = this;
					} else if (map.animal.nombre.equals(animal.nombre) && !map.animal.genero.equals(animal.genero)) {
						Animal newAnimal = new Animal();
						int random = (int) ((Math.random() * 2) + 1);
						if (random == 1) {
							newAnimal.genero = "M";
						} else {
							newAnimal.genero = "H";
						}
						newAnimal.nombre = map.animal.nombre;
						map.interrupt();
						this.interrupt();
						wator.nacer(newAnimal, x, y);
					} else if (map.animal.nombre.equals("T") && animal.nombre.equals("P")) {
						this.interrupt();
					} else if (map.animal.nombre.equals("P") && animal.nombre.equals("T")) {
						map.interrupt();
						WaTor.arrayMapa[x][y] = this;
					}
				} else {
					WaTor.arrayMapa[x][y] = this;
				}
			} catch (InterruptedException e) {
			}
		}
	}

}
