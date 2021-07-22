/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final.objetos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gaston
 */
public class Equipo 
{
    int id;
    String nombre;
    int capitan;
    Date fecha_alta;
    
    ArrayList<Jugador> jugadores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapitan() {
        return capitan;
    }

    public void setCapitan(int capitan) {
        this.capitan = capitan;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
    
    public String toString() {
        return "" + nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
}
