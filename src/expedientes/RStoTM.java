/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Recibe un resultset y regresa un tablemodel
package expedientes;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class RStoTM {

    public static TableModel resultStoTM(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
            // Nombres de campos
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
                
            }
            // Registros
            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getString(i));
                }
                rows.addElement(newRow);
            }
            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
