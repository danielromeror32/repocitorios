
package expedientes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;


public class colors {
    private ImageIcon imagen;
    private Icon icono;
    
     public void setColor(JPanel p) {
    
        p.setBackground(new Color(81,16,19));
}
    public void resetColor(JPanel p1) {
    
        p1.setBackground(new Color(185,17,22));
}
 
    // Metodos para el boton de 'csv'
    public void setColorcsv(JPanel p) {
    
        p.setBackground(new Color(11,116,64));
}
    public void resetColorcvs(JPanel p1) {
    
        p1.setBackground(new Color(29,163,97));
    }
    
     public void setColorNumber(JTextField p) {
    
        p.setForeground(new Color(0,0,0));
}
        
 public static class HeaderColor extends DefaultTableCellRenderer {
        public HeaderColor() {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean selected, boolean focused, int row, int column) 
        {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);        
           setBackground(new java.awt.Color(204,204,204));
           setFont(new Font ("Times New Roman", Font.BOLD, 14));
           //setOpaque(false);
           setForeground(new Color (0,0,0));
           //setRowHeight(25);
            //you can change the color that u want 
            return this;
        }
    }
    
    
}
