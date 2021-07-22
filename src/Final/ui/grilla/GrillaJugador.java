/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final.ui.grilla;

import Final.objetos.Jugador;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Gaston
 */
public class GrillaJugador extends AbstractTableModel
{
    private ArrayList<Jugador> jugadores = new ArrayList<>();  
    
    public GrillaJugador(ArrayList<Jugador> datos) {
        this.jugadores = datos;
    }

    @Override
    public int getRowCount() {
        return jugadores.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jugador jugador = jugadores.get(rowIndex);
        switch(columnIndex){
              case 0: return jugador.getId();
              case 1: return jugador.getApellido();
              case 2: return jugador.getNombre();
              case 3: return jugador.getDoc();
              case 4: return jugador.getEdad();
              case 5: return jugador.getPosicion();
              default: return "";
          }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Apellido";
            case 2: return "Nombre";
            case 3: return "Documento";
            case 4: return "Edad";
            case 5: return "Posicilon";
            default: return "";
        }
    }

    public Jugador getJugadorFromRow(int rowIndex)
   {
       return jugadores.get(rowIndex);
   }
}
