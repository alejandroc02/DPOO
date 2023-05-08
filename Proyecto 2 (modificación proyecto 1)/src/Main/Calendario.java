package Main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendario {
    private Map<LocalDate, List<Tarifa>> eventos;
    private static DateTimeFormatter formatter;

    public Calendario() {
        eventos = new HashMap<>();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void registrarEvento(Tarifa tarfia, LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate fecha = fechaInicio;
        while (!fecha.isAfter(fechaFin)) {
        	
            List<Tarifa> listaEventos = eventos.getOrDefault(fecha, new ArrayList<>());
            listaEventos.add(tarfia);
            eventos.put(fecha, listaEventos);
            fecha = fecha.plusDays(1);
        }
    }

    public List<Tarifa> obtenerEventos(LocalDate fecha) {
        return eventos.getOrDefault(fecha, new ArrayList<>());
    }

    public DayOfWeek obtenerDiaSemana(LocalDate fecha) {
        return fecha.getDayOfWeek();
    }
    /**
    public void editarEvento(String nombreEventoAnterior, String nuevoNombreEvento, LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate fecha = fechaInicio;
        while (!fecha.isAfter(fechaFin)) {
            List<Tarifa> listaEventos = eventos.getOrDefault(fecha, new ArrayList<>());
            for (int i = 0; i < listaEventos.size(); i++) {
                if (listaEventos.get(i).equals(nombreEventoAnterior)) {
                    listaEventos.set(i, nuevoNombreEvento);
                }
            }
            eventos.put(fecha, listaEventos);
            fecha = fecha.plusDays(1);
        }
    }
    **/
    public void eliminarEvento(String id,LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate fecha = fechaInicio;
        while (!fecha.isAfter(fechaFin)) {

        	
        	List<Tarifa> listaEventos = eventos.getOrDefault(fecha, new ArrayList<>());
            
            int o=0;
        	while(o<=listaEventos.size()) {;
        		Tarifa tarfiaActual=listaEventos.get(o);
        		if(tarfiaActual.esId(id)) {
        			listaEventos.remove(o);
        		}else {
        			continue;
        		}
        		o+=1;
        	}
            eventos.put(fecha, listaEventos);
            fecha = fecha.plusDays(1);
        }
    }
    
    public List<Tarifa> consultarEventosEntreF(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Tarifa> eventosEnPeriodo = new ArrayList<>();
        eventos.forEach((fecha, listaEventos) -> {
            if (!fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin)) {
                eventosEnPeriodo.addAll(listaEventos);
            }
        });
        return eventosEnPeriodo;
    }
    
    public LocalDate obtenerProximaFechaSinEventos(LocalDate fechaInicio) {
    	LocalDate fechaFin;
    	if (fechaInicio.isLeapYear()) {
    		fechaFin=fechaInicio.plusDays(366);
    	}else {
    		fechaFin=fechaInicio.plusDays(365);
    	}
        LocalDate fecha = LocalDate.now();
        while (!fecha.isAfter(fechaFin)) {
            if (!eventos.containsKey(fecha)) {
                return fecha;
            }
            fecha = fecha.plusDays(1);
        }
        return null;
    }

    
}
