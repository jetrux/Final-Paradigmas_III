/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final.ui.grilla;

import Final.objetos.Equipo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;;

/**
 *
 * @author Gaston
 */
public class GrillaEquipo extends AbstractTableModel
{
    private ArrayList<Equipo> equipos = new ArrayList<>();
    
    public GrillaEquipo(ArrayList<Equipo> datos) {
        this.equipos = datos;
    }
    
    @Override
    public int getRowCount() {
        return equipos.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equipo equipo = equipos.get(rowIndex);
        switch(columnIndex){
              case 0: return equipo.getId();
              case 1: return equipo.getNombre();
              case 2: return equipo.getCapitan();
              case 3: return equipo.getFecha_alta();
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Capitan";
            case 3: return "Fecha Alta";
            default: return "";
        }
    }
    
    public Equipo getEquipoFromRow(int rowIndex)
   {
       return equipos.get(rowIndex);
   }
}
