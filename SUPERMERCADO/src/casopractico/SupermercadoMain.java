package casopractico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.List;

public class SupermercadoMain {
	static Scanner entrada = new Scanner(System.in);
	static ArrayList<String> productos = new ArrayList<String>(Arrays.asList("Tomate", "Aceite", "Pan", "Leche",
			"Yogur", "Queso", "Jamón", "Harina", "Champú", "Manzana", "Cereales", "Galletas", "Arroz", "Lentejas",
			"Atún", "Pescado", "Carne", "Huevos", "Leche", "Agua"));
	static HashSet<String> carrito = new HashSet<>();

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("********** ACCESO *******");
		System.out.println("1. Personal del supermercado");
		System.out.println("2. Cliente");
		System.out.println();
		System.out.println("Introduce como quieres iniciar sesión ");
		int acceso = entrada.nextInt();
		
		if(acceso!=1 || acceso!=2) {
			System.out.println("No has introducido lo que se pedía, vuelve a intentarlo");
		}

		// ACCESO DE
		// PERSONAL--------------------------------------------------------------------------
		if (acceso == 1) {
			String contrasena = "J4v4d0n4";
			int option = 0;
			for (int i = 0; i <= 2; i++) {
				if (option != 5) {
					System.out.println("Introduce la contraseña :");
					String contrausuario = entrada.next();
					if (contrausuario.equals(contrasena)) {
						while (option != 5) {
							System.out.println("********** MENÚ *******");
							System.out.println("1. Mostrar productos del supermercado");
							System.out.println("2. Añadir productos");
							System.out.println("3. Eliminar producto");
							System.out.println("4. Modificar producto");
							System.out.println("5. Salir");
							System.out.println();
							System.out.print("Introduce una opción: ");
							System.out.println();

							option = entrada.nextInt();

							if (option != 5) {
								switch (option) {
								case 1:
									MostrarProductos();
									break;
								case 2:
									AñadirProductosPersonal();
									break;
								case 3:
									EliminarProductosPersonal();
									break;
								case 4:
									ModificarProductosPersonal();
									break;
								default:
									System.out.println("Opción no válida. Por favor introduce una opción válida.");
									break;
								}
							} else {
								System.out.println("Gracias por usar la aplicación. ¡Hasta pronto!");
							}
						}
					}

					if (!contrausuario.equals(contrasena)) {
						System.out.println("La contraseña introducida es incorrecta te quedan " + (2 - i) + " intentos");
					}
				}
			}
		}

		// ACCESO DE
		// CLIENTE-------------------------------------------------------------------------------
		if (acceso == 2) {
			int option = 0;

			while (option != 6) {
				System.out.println("********** MENÚ *******");
				System.out.println("1. Mostrar productos del supermercado");
				System.out.println("2. Añadir productos al carrito");
				System.out.println("3. Mostrar carrito de la compra");
				System.out.println("4. Consultar producto de carrito");
				System.out.println("5. Cambiar un producto por otro");
				System.out.println("6. Salir");
				System.out.println();
				System.out.print("Introduce una opción: ");
				System.out.println();

				option = entrada.nextInt();

				if (option != 6) {
					switch (option) {
					case 1:
						MostrarProductos();
						break;
					case 2:
						AñadirProductos();
						break;
					case 3:
						MostrarCarrito();
						break;
					case 4:
						ConsultarProductos();
						break;
					case 5:
						CambiarProductos();
						break;
					default:
						System.out.println("Opción no válida. Por favor introduce una opción válida.");
						break;
					}
				} else {
					System.out.println("Gracias por usar la aplicación. ¡Hasta pronto!");
				}
			}
		}
	}

	public static void MostrarProductos() {
		TreeSet<String> conjunto = new TreeSet<>();
		conjunto.addAll(productos);
		System.out.println();
		System.out.println(conjunto);
		System.out.println();
	}

	public static void AñadirProductos() {
		System.out.print("Introduce los productos a añadir separados por ','");
		System.out.println();
		String producto = entrada.next();
		String[] array = producto.split(",");
		LinkedHashSet<String> array2 = new LinkedHashSet<>();

		for (int i = 0; i < array.length; i++) {
			array2.add(array[i]);
		}

		if (productos.containsAll(array2) && !carrito.containsAll(array2)) {
			carrito.addAll(array2);
			System.out.println(array2 + " añadidos al carrito correctamente ");
			System.out.println();
		} else if (!productos.containsAll(array2)) {
			System.out.println(array2 + " no están a la venta en el supermercado. Por favor, elige otros productos. ");
			System.out.println();

		} else {
			System.out.println(
					array2 + " ya han sido añadido al carrito anteriormente. Por favor, elige otros productos. ");
			System.out.println();

		}
	}

	public static void MostrarCarrito() {
		HashSet<String> carritolleno = new HashSet<>(carrito);
		if (!carritolleno.isEmpty()) {
			System.out.println("El carrito de la compra es " + carritolleno);
			System.out.println();
		} else {
			System.out.println("Tu carrito de la compra está vacío, añade elementos e intentalo de nuevo ");
			System.out.println();
		}
	}

	public static void ConsultarProductos() {
		System.out.print("Introduce el producto que deseas consultar: ");
		String productoaconsultar = entrada.next();

		if (carrito.contains(productoaconsultar)) {
			System.out.println("Sí, " + productoaconsultar + " se encuentra en tu carrito.");
			System.out.println();
		} else {
			System.out.println("No, " + productoaconsultar + " no se encuentra en tu carrito.");
			System.out.println();
		}
	}

	public static void CambiarProductos() {
		System.out.println("¿Qué producto quieres cambiar?");
		String productoacambiar = entrada.next();
		if (carrito.contains(productoacambiar)) {
			carrito.remove(productoacambiar);
			System.out.println(productoacambiar + " borrado correctamente del carrito");
			System.out.println();
			System.out.println("Porfavor introduce un producto para reemplazar a " + productoacambiar);
			String nuevoproducto = entrada.next();
			if (productos.contains(nuevoproducto)) {
				carrito.add(nuevoproducto);
				System.out.println(nuevoproducto + " añadido correctamente");
				System.out.println();
				System.out.println("Tu carro queda ahora así " + carrito);
			} else {
				System.out.println("Ese producto no se encuentra a la venta");
				System.out.println();
			}
		}

	}

	public static void AñadirProductosPersonal() {
		System.out.println("¿Cuántos productos quieres añadir?");
		int num = entrada.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.println("Introduce el producto que quieres añadir");
			String producto = entrada.next();
			if (!productos.contains(producto)) {
				productos.add(producto);
			} else {
				System.out.println("El producto que deseas añadir ya está en la lista, introduce otro");
				i--;
			}
		}
	}

	public static void EliminarProductosPersonal() {
		System.out.println("¿Cuántos productos vas a querer eliminar?");
		int num = entrada.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.println("¿Qué producto quieres eliminar?");
			String producto = entrada.next();
			if (productos.contains(producto)) {
				productos.remove(producto);
				System.out.println(producto + ", ha sido eliminado con éxito.");
				System.out.println();
			} else {
				System.out.println("El producto que quieres eliminar no existe.");
				System.out.println();
				i--;

			}
		}

	}

	public static void ModificarProductosPersonal() {
		System.out.println("¿Cuantos productos vas a querer modificar?");
		int num = entrada.nextInt();
		for (int i = 1; i <= num; i++) {
			System.out.println("Introduce el producto " + i + " a eliminar.");
			String producto = entrada.next();

			if (!productos.contains(producto)) {
				System.out.println("El producto introducido no concuerda con ninguno del supermercado.");
				System.out.println();
				i--;
			} else {
				for (int j = 0; j < productos.size(); j++) {
					if (productos.get(j).equals(producto)) {
						System.out.println("Introduce el producto a sustituir por " + producto);
						String nuevoproducto = entrada.next();
						productos.set(j, nuevoproducto);
					}
				}

			}
		}
	}

}
