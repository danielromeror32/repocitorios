
package JFrames;


import static JDalmacen.JFBuscarExpedientes.globalInt;
import SQL.ConexionBD;
import expedientes.RStoTM;
import expedientes.colors;
import expedientes.datos_docentes;
import expedientes.datos_empleado;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import main.Main_login;


public class buscar extends javax.swing.JPanel {

    String sentenc, tabla, campo, val, sen;
    String sentencia = null;
     private int file_count = 0;
     public static int globalInt_update = 0;
    String DATOS_COL_EMPLEADO = "id_empleado as ID,\n" +"nombre as Nombre,\n" +"fecha_ingreso as Fecha ,\n" +"rfc as RFC,\n" +
     "curp as CURP,\n" +"contrato as Contrato,\n" +"tp  as TP,\n" +"categoria as Categoria,\n" +"centro_costo as Centro,\n" +"tipo_puesto as Puesto,exp_digital_rfc AS RFC ,exp_digital_curp AS CURP,\n" +
"exp_digital_ide AS IDE";
    
    
    String DATOS_COL_DOCENTE = " d.id_docente AS ID,e.id_empleado, e.nombre AS Nombre,\n" +
"licenciatura as Lic, maestria Maestría, doctorado Doc,especialidad as Esp,exp_digital_tituloLic AS Título_LIC ,exp_digital_cedulaLic AS Cedula_LIC ,exp_digital_tituloEsp AS Título_Esp ,\n" +
"    exp_digital_cedulaEsp AS Cedula_Esp,exp_digital_tituloMtria AS Título_Mtria,exp_digital_cedulaMtria AS Cedula_Mtria,exp_digital_tituloDoc AS Título_Doc,exp_digital_cedulaDoc AS Cedula_Doc,exp_digital_disa AS DISA , \n" +
"    exp_digital_profordems AS Profordems,exp_digital_certidems AS Certidems ";
    
    ConexionBD Objmsql = new ConexionBD();
    Main_login objMain = new Main_login();
   
    colors objColor = new colors();
    RStoTM Objtm = new RStoTM();
    JFmenu objMenu = new JFmenu();
    
    
    public buscar() {
        initComponents();
        jTable1.getTableHeader().setDefaultRenderer( new HeaderColor());
       // objMain.pintarImagen(this.iconSearch, "src/Images/search.png");
    }

    
    // metodo para el estilo de la tabla 
   public class HeaderColor extends DefaultTableCellRenderer {
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
    
    // metodo para mostrar y seleccionar las opciones del combobox 
    public void agregaCB(){
        
        
        tabla = (String) jComboBox1.getSelectedItem();
        jComboBox2.addItem("nombre");
        if (tabla.equals("Empleados")){    
            sentencia = "datos_empleado";   
        }else{
            sentencia = "datos_docente";
        }              
        sentenc = new String ("SHOW COLUMNS FROM " + sentencia);
        jComboBox2. removeAllItems();
        ResultSet resc = null;
        try{
            resc = Objmsql.consultarAlgo(sentenc);
             jComboBox2.addItem("nombre");
            while (resc.next()){
                jComboBox2.addItem(String.valueOf(resc.getString("field")));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    /* Metodo para mostrar resultados en la tabla de acuerdo a 
       los criterios seleccionados */
    public void showresult() {
        TableModel tm;
       
        tabla = String.valueOf(jComboBox1.getSelectedItem());
        campo = String.valueOf(jComboBox2.getSelectedItem());
        String datosTabla = "";
        String nombre_docentes = null;
        // seleccion de comobox 
        if (tabla.equals("Empleados")){
            tabla = "datos_empleado";  
            datosTabla = DATOS_COL_EMPLEADO;
            nombre_docentes = "empleado";
        }else if (tabla.equals("TODO")){
            tabla = "datos_docente d\n" +
            "INNER JOIN datos_empleado e ON d.id_empleado = e.id_empleado;";
            datosTabla = "*";
        }  
        else if (tabla.equals("Expedientes")){
            tabla = "datos_docente d\n" +
            "INNER JOIN datos_empleado e ON d.id_empleado = e.id_empleado";            
            datosTabla = DATOS_COL_DOCENTE;
            nombre_docentes = "docente";
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay registros que coincidan "
                    + "con la búsqueda", "Error", JOptionPane.ERROR_MESSAGE);              
        }  
        
        
        val = tx_criterio.getText();
        ResultSet resc = null;
        ResultSet re = null;
        if (val.equals("")) {
           
            sentenc = new String("SELECT "+datosTabla+" FROM " + tabla); 
            
           /* if (checkbox_val.isSelected()){
                sentenc = new String("SELECT * FROM " + tabla); 
            }else{
                
                sentenc = new String("SELECT e.id_empleado , e.nombre ,v.validacion, v.tipo_validacion\n" +
                "FROM (validacion as v INNER JOIN datos_empleado as e ON v.id_empleado = e.id_empleado)where validacion = 0; ; "); 
            }
            */
        }
        else {
            if (nombre_docentes.equals("docente")){
                sentenc = new String("SELECT "+DATOS_COL_DOCENTE+" FROM " + tabla + " WHERE " + campo + " LIKE'%" + val + "%'"); 
                System.out.println("tas" + sentenc);
            }else{
                sentenc = new String("SELECT * FROM " + tabla + " WHERE " + campo + " LIKE'%" + val + "%'");  
                System.out.println("bien" + sentenc);
            }
            
               
        }      
        try {
            resc = Objmsql.consultarAlgo(sentenc); 
           
            if (resc != null ) {
                tm = Objtm.resultStoTM(resc);
               
                jTable1.setModel(tm);
                
            }
            else{        
                JOptionPane.showMessageDialog(null, "No hay registros que coincidan con la búsqueda", "Error", JOptionPane.ERROR_MESSAGE);              
            }
        }
            catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Metodo para editar una fila seleccionada y editarla en su frame correspondiente 
    public void editarColumna (){
        globalInt_update++;
        ResultSet resc = null;
        String sentence, tabla, campo, idsel;
        int i;
        
        tabla = String.valueOf(jComboBox1.getSelectedItem());
        i = jTable1.getSelectedRow(); // select row 
        idsel = (String) jTable1.getValueAt(i, 0);
        //idsel = "id_empleado";
        campo = jTable1.getColumnName(0);
       String campos;
        System.out.println(campo);
        if (tabla.equals("Empleados")){
            tabla = "datos_empleado";  
              campos = "id_empleado";
        }else{
            tabla = "datos_docente";
             campos = "id_docente";
        }  
        sentence = "SELECT * FROM " + tabla + " WHERE " + campos + " = '" + idsel + "'";
        System.out.println("Fila seleccionada: " + i + "\n id seleccionado: " + campos);
        System.out.println(sentence);
        try {
            resc = Objmsql.consultarAlgo(sentence);
            if (tabla.equals("datos_empleado")){
                
                datos_empleado objEmp = new datos_empleado();
                while (resc.next()){
                    objEmp.setDatosEmpleado(resc.getString("id_empleado"), resc.getString("nombre"),
                    resc.getString("fecha_ingreso"), resc.getString("curp"),
                    resc.getString("rfc"), resc.getString("contrato"),
                    resc.getString("tp"),resc.getString("categoria"),
                    resc.getString("tipo_puesto"),resc.getString("centro_costo"),
                    resc.getString("exp_digital_rfc"),resc.getString("exp_digital_curp"),
                    resc.getString("exp_digital_ide"));
                } 
            JDEmpleado modEmp = new JDEmpleado(objEmp);
            modEmp.setVisible(true);
            }
            if (tabla.equals("datos_docente")){
                datos_docentes objDoc = new datos_docentes();
               
                while (resc.next()){
                    objDoc.setDatosDocentes(resc.getString("id_docente"), resc.getString("id_empleado"),
                        resc.getString("licenciatura"), resc.getString("especialidad"),
                        resc.getString("maestria"), resc.getString("doctorado"), 
                        resc.getString("exp_digital_tituloLic"), resc.getString("exp_digital_cedulaLic"),
                        resc.getString("exp_digital_tituloEsp"), resc.getString("exp_digital_cedulaEsp"),
                        resc.getString("exp_digital_tituloMtria"), resc.getString("exp_digital_cedulaMtria"),
                        resc.getString("exp_digital_tituloDoc"), resc.getString("exp_digital_cedulaDoc"), 
                        resc.getString("exp_digital_disa"), resc.getString("exp_digital_profordems"),
                        resc.getString("exp_digital_certidems"));
                }
             
                
            JDDocente modDoc = new JDDocente(objDoc);
            modDoc.setVisible(true);
            
            
            
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Metodo para eliminar una fila seleccionada
    public void eliminarRegistro(){
        
        ResultSet resc=null;
        String sentence, tabla, campo, idsel;
        int i;
        String campos;
        tabla = String.valueOf(jComboBox1.getSelectedItem());
        i = jTable1.getSelectedRow();
        idsel = (String) jTable1.getValueAt(i, 0);
        campo = jTable1.getColumnName(0);
        if (tabla.equals("Empleados")){
            tabla = "datos_empleado";
            campos = "id_empleado";
        }else{
            tabla = "datos_docente";
            campos = "id_docente";
        }
        
         sentence = "SELECT * FROM " + tabla + " WHERE " + campos + " = '" + idsel + "'";
        System.out.println("Fila seleccionada: " + i + "\n id seleccionado: " + campos);
        System.out.println(sentence);
        try {
            resc = Objmsql.consultarAlgo(sentence);
            if (tabla.equals("datos_empleado")){
                
                datos_empleado objEmp = new datos_empleado();
                while (resc.next()){
                    objEmp.setDatosEmpleado(resc.getString("id_empleado"), resc.getString("nombre"),
                            resc.getString("fecha_ingreso"), resc.getString("curp"),
                            resc.getString("rfc"), resc.getString("contrato"),
                            resc.getString("tp"),resc.getString("categoria"),
                            resc.getString("tipo_puesto"),resc.getString("centro_costo"),
                            resc.getString("exp_digital_rfc"),resc.getString("exp_digital_curp"),
                            resc.getString("exp_digital_ide"));    
              int e = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar los datos seleccionados?");
              if (e==0){
                Objmsql.dalateAlgo(tabla, campos, objEmp.getId_empleado());
                JOptionPane.showMessageDialog(this, "Eliminacion exitosa");
                //System.out.println("Eliminacion exitosa");
            }else{
                  
                //System.out.println("No se elimino nada");
                 JOptionPane.showMessageDialog(this, "No se elimino nada", "Error", JOptionPane.ERROR_MESSAGE);
            }
                }
            }
           if (tabla.equals("datos_docente")){
                datos_docentes objDoc = new datos_docentes();
                while (resc.next()){
                    objDoc.setDatosDocentes(resc.getString("id_docente"), resc.getString("id_empleado"),
                            resc.getString("licenciatura"), resc.getString("especialidad"),
                            resc.getString("maestria"), resc.getString("doctorado"), 
                            resc.getString("exp_digital_tituloLic"), resc.getString("exp_digital_cedulaLic"),
                            resc.getString("exp_digital_tituloEsp"), resc.getString("exp_digital_cedulaEsp"),
                            resc.getString("exp_digital_tituloMtria"), resc.getString("exp_digital_cedulaMtria"),
                            resc.getString("exp_digital_tituloDoc"), resc.getString("exp_digital_cedulaDoc"), 
                            resc.getString("exp_digital_disa"), resc.getString("exp_digital_profordems"),
                            resc.getString("exp_digital_certidems"));
                
              int e = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar los datos seleccionados?");
              if (e==0){
                Objmsql.dalateAlgo(tabla, campos, objDoc.getId_docente());
                //System.out.println("Eliminacion exitosa");
                JOptionPane.showMessageDialog(this, "Eliminacion exitosa");
            }else{
                System.out.println("No se elimino nada");
                JOptionPane.showMessageDialog(this, "No se elimino nada", "Error", JOptionPane.ERROR_MESSAGE);
            }
                }
                } 
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "No se elimino nada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPane_ruta = new javax.swing.JTextPane();
        ButtonCVS = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tx_criterio = new javax.swing.JTextField();
        iconSearch = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelButtonMod = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelButtonEliminar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelCancelar2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Buscar");

        setMinimumSize(new java.awt.Dimension(1360, 600));
        setPreferredSize(new java.awt.Dimension(1360, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1 = new JTable(){

            public boolean isCellEditable (int row, int column ){

                for(int i=0; i< jTable1.getRowCount(); i++){

                    if (row == i ){

                        return false;
                    }
                }
                return true;
            }

        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setFocusable(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(185, 17, 22));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1310, 368));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Buscar:");

        jComboBox1.setFont(new java.awt.Font("Be Vietnam Light", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Empleados", "Expedientes", "TODO" }));
        jComboBox1.setBorder(null);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Por:");

        jComboBox2.setFont(new java.awt.Font("Be Vietnam Light", 0, 14)); // NOI18N
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Abrir archivo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        textPane_ruta.setBorder(null);
        textPane_ruta.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        textPane_ruta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textPane_rutaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(textPane_ruta);

        ButtonCVS.setBackground(new java.awt.Color(29, 163, 97));

        jLabel2.setFont(new java.awt.Font("Be Vietnam", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Export CVS");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout ButtonCVSLayout = new javax.swing.GroupLayout(ButtonCVS);
        ButtonCVS.setLayout(ButtonCVSLayout);
        ButtonCVSLayout.setHorizontalGroup(
            ButtonCVSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );
        ButtonCVSLayout.setVerticalGroup(
            ButtonCVSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tx_criterio.setFont(new java.awt.Font("Be Vietnam", 0, 14)); // NOI18N
        tx_criterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_criterioActionPerformed(evt);
            }
        });

        iconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        iconSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconSearchMouseClicked(evt);
            }
        });
        iconSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iconSearchKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Criterio:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tx_criterio, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iconSearch)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(ButtonCVS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(ButtonCVS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(iconSearch)
                                            .addComponent(jButton1))))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tx_criterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, -1));

        panelButtonMod.setBackground(new java.awt.Color(185, 17, 22));

        jLabel3.setFont(new java.awt.Font("Cinzel", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Modificar");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelButtonModLayout = new javax.swing.GroupLayout(panelButtonMod);
        panelButtonMod.setLayout(panelButtonModLayout);
        panelButtonModLayout.setHorizontalGroup(
            panelButtonModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        panelButtonModLayout.setVerticalGroup(
            panelButtonModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(panelButtonMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 492, -1, -1));

        panelButtonEliminar.setBackground(new java.awt.Color(185, 17, 22));

        jLabel4.setFont(new java.awt.Font("Cinzel", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Eliminar");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelButtonEliminarLayout = new javax.swing.GroupLayout(panelButtonEliminar);
        panelButtonEliminar.setLayout(panelButtonEliminarLayout);
        panelButtonEliminarLayout.setHorizontalGroup(
            panelButtonEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        panelButtonEliminarLayout.setVerticalGroup(
            panelButtonEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(panelButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 490, -1, -1));

        panelCancelar2.setBackground(new java.awt.Color(185, 17, 22));
        panelCancelar2.setPreferredSize(new java.awt.Dimension(119, 30));

        jLabel9.setFont(new java.awt.Font("Cinzel", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cancelar");
        jLabel9.setToolTipText("");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelCancelar2Layout = new javax.swing.GroupLayout(panelCancelar2);
        panelCancelar2.setLayout(panelCancelar2Layout);
        panelCancelar2Layout.setHorizontalGroup(
            panelCancelar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        panelCancelar2Layout.setVerticalGroup(
            panelCancelar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(panelCancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 492, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // ComboBox 1
        agregaCB();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void tx_criterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_criterioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_criterioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // action button buscar
        showresult();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         // Al seleccionar una fila de la tabla se manda al textPane_ruta  
        if (evt.getClickCount() == 2){
            int i, e;
            i = jTable1.getSelectedRow(); // select row 
            e = jTable1.getSelectedColumn();
            String idsel = (String) jTable1.getValueAt(i, e);
            // JOptionPane.showMessageDialog(rootPane, idsel );
            this.textPane_ruta.setText(idsel);
            // textPane_ruta.selectAll();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // button abrir
        String ruta =textPane_ruta.getText();

        // selectCell ();
        //String url = "c:/ServicioSocial/ACOSTA GARCIA NORMA/Acosta_Garcia_Norma_CURP - Norma Acosta.pdf";
        if (ruta.equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese una ruta");
        }

        ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c",ruta);
        try {
            p.start();
        } catch (IOException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void textPane_rutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPane_rutaMouseClicked
        // Al dar click en textPane_ruta atuomaticamente selecciona todo al darle click
        textPane_ruta.selectAll();
    }//GEN-LAST:event_textPane_rutaMouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // color de button cvs:
        objColor.setColorcsv(ButtonCVS);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        objColor.resetColorcvs(ButtonCVS);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

         // Button excel
        ConexionBD Objmsql = new ConexionBD ();
        String inner = null;
        String headers = null;
        ResultSet resc = null;
        String nameFile = null;
        
        tabla = String.valueOf(jComboBox1.getSelectedItem());
        // Consultas de acuerdo a la seleccion del combobox 
        if (tabla.equals("Empleados")){
            tabla = "datos_empleado";   
            headers = "SELECT 'id_empleado', 'nombre', 'fecha_ingreso', 'rfc', 'curp', 'contrato', 'tp', 'categoria', \n" +
            "'centro_costos', 'exp_digital_rfc', 'exp_digital_curp', 'exp_digital_ide','tipo_puesto'\n" +
            "UNION ALL";
            inner ="";
           nameFile = JOptionPane.showInputDialog("Nombre de archivo");     
        }else if (tabla.equals("TODO")){
            tabla ="datos_empleado e" ;
            headers = "SELECT 'id_empleado', 'nombre', 'fecha_ingreso', 'rfc', 'curp', 'contrato', 'tp', 'categoria', \n" +
            "'centro_costos', 'exp_digital_rfc', 'exp_digital_curp', 'exp_digital_ide','tipo_puesto','id_docente', 'licenciatura', 'maestria', 'doctorado', 'exp_digital_tituloLic', \n" +
            "'exp_digital_cedulaLic', 'exp_digital_tituloEsp', 'exp_digital_cedulaEsp', 'exp_digital_tituloMtria',\n" +
            " 'exp_digital_cedulaMtria', 'exp_digital_tituloDoc', 'exp_digital_cedulaDoc', 'exp_digital_disa',\n" +
            " 'exp_digital_profordems', 'exp_digital_certidems', 'especialidad'\n" +
            " UNION ALL";
            inner = "INNER JOIN datos_docente d ON e.id_empleado = d.id_empleado";
            nameFile = JOptionPane.showInputDialog("Nombre de archivo");
                    }
        else if(tabla.equals("Expedientes")){
            
            tabla = "datos_docente";
            headers = "SELECT 'id_docente', 'id_empleado', 'licenciatura', 'maestria', 'doctorado', 'exp_digital_tituloLic', \n" +
            "'exp_digital_cedulaLic', 'exp_digital_tituloEsp', 'exp_digital_cedulaEsp', 'exp_digital_tituloMtria',\n" +
            " 'exp_digital_cedulaMtria', 'exp_digital_tituloDoc', 'exp_digital_cedulaDoc', 'exp_digital_disa',\n" +
            " 'exp_digital_profordems', 'exp_digital_certidems', 'especialidad'\n" +
            "UNION ALL";
            inner = "";
            nameFile = JOptionPane.showInputDialog("Nombre de archivo");
        }
        
        // Nombre del archivo 
       if (nameFile.equals("") ){
           file_count++;
           nameFile="Reporte"+file_count+"";    
       } 
        // La sentencia realizar una consulta en sql para guardar un archivo csv
         sentenc = ""+headers+" SELECT * FROM "+tabla+"\n "+inner+" " +
        "INTO OUTFILE 'C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads"
        + "\\\\"+nameFile+".csv'\n" +
        "CHARACTER SET  latin1 \n" +
        "FIELDS TERMINATED BY ',' \n" +
        "ESCAPED BY '\\\\'\n" +
        "LINES TERMINATED BY '\\n' ;";      
        try {
             resc = Objmsql.consultarAlgo(sentenc);
             JOptionPane.showMessageDialog(null, "Exportación exitosa");
        } catch (Exception ex) {
             //java.util.logging.Logger.getLogger(JFDocentes.class.getName()).log(Level.SEVERE, null, ex);
             Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No hay registros que coincidan con la búsqueda", "Error", JOptionPane.ERROR_MESSAGE);              

        }   
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // Button modificar color
        objColor.setColor(panelButtonMod);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // Button modificar color
        objColor.resetColor(panelButtonMod);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // Button modificar eliminar
         objColor.setColor(panelButtonEliminar);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        //  Button modificar eliminar
        objColor.resetColor(panelButtonEliminar);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // CLIKED BUTTON MODIFICAR
        editarColumna();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // cliked button eliminar
        eliminarRegistro();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void iconSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iconSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_iconSearchKeyPressed

    private void iconSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconSearchMouseClicked
        // TODO add your handling code here:
        showresult();
    }//GEN-LAST:event_iconSearchMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
         //this.dispose();
       JFmenu ventana = new JFmenu();
        ventana.setVisible(true);
     
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        objColor.setColor(panelCancelar2);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        objColor.resetColor(panelCancelar2);
    }//GEN-LAST:event_jLabel9MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonCVS;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelButtonEliminar;
    private javax.swing.JPanel panelButtonMod;
    private javax.swing.JPanel panelCancelar;
    private javax.swing.JPanel panelCancelar1;
    private javax.swing.JPanel panelCancelar2;
    private javax.swing.JTextPane textPane_ruta;
    private javax.swing.JTextField tx_criterio;
    // End of variables declaration//GEN-END:variables
}
