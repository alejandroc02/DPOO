package Main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendario {
    private Map<LocalDate, List<String>> eventos;
    private static DateTimeFormatter formatter;

    public Calendario() {
        eventos = new HashMap<>();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void registrarEvento(String nombreEvento, LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate fecha = fechaInicio;
        while (!fecha.isAfter(fechaFin)) {
            List<String> listaEventos = eventos.getOrDefault(fecha, new ArrayList<>());
            listaEventos.add(nombreEvento);
            eventos.put(fecha, listaEventos);
            fecha = fecha.plusDays(1);
        }
    }

    public List<String> obtenerEventos(LocalDate fecha) {
        return eventos.getOrDefault(fecha, new ArrayList<>());
    }

    public DayOfWeek obtenerDiaSemana(LocalDate fecha) {
        return fecha.getDayOfWeek();
    }
    
    public void editarEvento(String nombreEventoAnterior, String nuevoNombreEvento, LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate fecha = fechaInicio;
        while (!fecha.isAfter(fechaFin)) {
            List<String> listaEventos = eventos.getOrDefault(fecha, new ArrayList<>());
            for (int i = 0; i < listaEventos.size(); i++) {
                if (listaEventos.get(i).equals(nombreEventoAnterior)) {
                    listaEventos.set(i, nuevoNombreEvento);
                }
            }
            eventos.put(fecha, listaEventos);
            fecha = fecha.plusDays(1);
        }
    }
    
    public void eliminarEvento(String nombreEvento, LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate fecha = fechaInicio;
        while (!fecha.isAfter(fechaFin)) {
            List<String> listaEventos = eventos.getOrDefault(fecha, new ArrayList<>());
            listaEventos.removeIf(evento -> evento.equals(nombreEvento));
            eventos.put(fecha, listaEventos);
            fecha = fecha.plusDays(1);
        }
    }
    
    public List<String> consultarEventosEntreF(LocalDate fechaInicio, LocalDate fechaFin) {
        List<String> eventosEnPeriodo = new ArrayList<>();
        eventos.forEach((fecha, listaEventos) -> {
            if (!fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin)) {
                eventosEnPeriodo.addAll(listaEventos);
            }
        });
        return eventosEnPeriodo;
    }
    
    public LocalDate obtenerProximaFechaSinEventos(LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate fecha = LocalDate.now();
        while (!fecha.isAfter(fechaFin)) {
            if (!eventos.containsKey(fecha)) {
                return fecha;
            }
            fecha = fecha.plusDays(1);
        }
        return null;
    }

    public static void main(String[] args) {
        Calendario calendario = new Calendario();

        LocalDate fechaInicio = LocalDate.of(2023, 4, 1);
        LocalDate fechaFin = LocalDate.of(2023, 4, 30);

        calendario.registrarEvento("Evento 1", fechaInicio, fechaFin);
        calendario.registrarEvento("Evento 2", LocalDate.of(2023, 4, 5), LocalDate.of(2023, 4, 20));
        calendario.registrarEvento("Evento 3", LocalDate.of(2023, 4, 5), LocalDate.of(2023, 5, 18));
        
        calendario.editarEvento("Evento 1", "Lunes,Martes,Miercoles", fechaInicio, fechaFin);
        
        calendario.eliminarEvento("Evento 3", LocalDate.of(2023, 4, 7), LocalDate.of(2023, 4, 10));
        LocalDate fechaS= calendario.obtenerProximaFechaSinEventos(LocalDate.of(2023, 4, 20), LocalDate.of(2023, 5, 22));
        LocalDate fecha = LocalDate.of(2023, 4, 4);
        List<String> eventos = calendario.consultarEventosEntreF(fecha,LocalDate.of(2023, 5, 1));
        DayOfWeek diaSemana = calendario.obtenerDiaSemana(fecha);

        System.out.println("Eventos en la fecha " + formatter.format(fecha) + ":");
        for (String evento : eventos) {
            System.out.println("- " + evento);
        }
        System.out.println(fechaS);

        System.out.println("El día de la semana de la fecha " + formatter.format(fecha) + " es " + diaSemana);
    }
}
