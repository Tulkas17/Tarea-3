package Ejercicios;

/**
 * Programa principal donde se aplican operaciones de reducción sobre un stream
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EjercicioSeccion3
{
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        System.out.println();
        System.out.println();
        System.out.println("Peliculas estrenadas desde el año 2000:");
        peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .forEach(p -> System.out.println(p));

        System.out.println();
        System.out.println();

        String nombresPeliculasSteven = peliculas.stream()
                .filter(p -> p.getDirector() == "Steven Spielberg")
                .map(p -> p.getTitulo())
                .collect(Collectors.joining(", ",
                        "Nombres de peliculas de Steven Spielberg: ", ""));
        System.out.println(nombresPeliculasSteven);

        System.out.println();
        System.out.println();

        System.out.println("Peliculas ordenadas por nombre alfabeticamente:");
        Comparator<Pelicula> cNombre = (p1, p2) -> p1.getTitulo().compareTo(p2.getTitulo());
        peliculas.stream()
                .sorted(cNombre)
                .forEach(System.out::println);
    }
}
