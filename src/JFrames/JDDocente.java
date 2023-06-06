
package JFrames;


import expedientes.datos_docentes;
import expedientes.colors;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class JDDocente extends javax.swing.JDialog {

   static datos_docentes objetoDocente = new datos_docentes ();
   
    SQL.ConexionBD Objmsql = new SQL.ConexionBD();
    colors objColor = new colors();
    String id_docente;
    // atributos sql
    String sentence;
    int ultimo;
    String name;
    ResultSet resc = null;
    // atributos barra de ventana 
    int xMouse, yMouse;
    String ruta;
    Toolkit tk = Toolkit.getDefaultToolkit();
    
    
    public JDDocente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.setIconImage (tk.getImage(getClass().getResource("/images/garza.png")));
        setLocationRelativeTo(null);
        int num_id = queryDocente();
        if (queryDocente() != null){
            id_docente = String.valueOf(queryDocente () + 1); // num id 
            
        }
        tf_iddocente.setText(id_docente);
        addEmpleado();
         //String nombre = queryName(num_id) ;
       //  System.out.println("aaa" + nombre);
      /*  if (queryName(num_id) != null){
            jLabel5.setText(nombre);
        //
        }
        */
        
       
    }

   
    
     public JDDocente (datos_docentes doc){
        initComponents();
        //this.setVisible(true);
        this.setLocationRelativeTo(null);
        addEmpleado();
        this.tf_iddocente.setText(String.valueOf(doc.getId_docente()));
        this.tf_lic.setText(doc.getLicenciatura());
        this.tf_esp.setText(doc.getEspecialidad());
        this.tf_mtria.setText(doc.getMaestria());
        this.tf_doc.setText(doc.getDoctorado());
        this.tf_ed_titulo.setText(doc.getEd_tituloLic());
        this.tf_ed_cLic.setText(doc.getEd_cedulaLic());
        this.tf_ed_tituloEsp.setText(doc.getEd_tituloEsp());
        this.tf_ed_cedEsp.setText(doc.getEd_cedulaEsp());
        this.tf_ed_tituloM.setText(doc.getEd_tituloMtria());
        this.tf_ed_cedM.setText(doc.getEd_cedulaMtria());
        this.tf_ed_tituloDoc.setText(doc.getEd_tituloDoc());
        this.tf_ed_cedDoc.setText(doc.getEd_cedulaDoc());
        this.tf_ed_dsia.setText(doc.getEd_disa());
        this.tf_ed_prof.setText(doc.getEd_profordems());
        this.tf_ed_cert.setText(doc.getEd_certidems());
        this.cb_idempleado.setSelectedItem(String.valueOf(doc.getId_empleado()));
    }

   
    
    
    public Integer queryDocente (){
        
        sentence = "SELECT MAX(id_docente) FROM datos_docente";
        System.out.println("max " + sentence );
        try{
            resc = Objmsql.consultarAlgo(sentence);
            while (resc.next()){
                ultimo = resc.getInt("MAX(id_docente)");
            }
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(JDDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Existen "+ ultimo + "Docentes");
        return ultimo;
    }
    
    /*public String queryName (int id){
        sentence = "SELECT nombre FROM datos_empleado where id_empleado = 172";
        System.out.println("consulta " + sentence );
        try{
            resc = Objmsql.consultarAlgo(sentence);
            while (resc.next()){
                
             name = resc.getString("nombre");
            }
            
            //jLabel5.setText(String.valueOf(resc.getString("nombre")));
        }catch(Exception e){
             e.printStackTrace();
        }
        System.out.println("Existen "+ name );
        return name;
    }*/
    

    //id forain Key
    public void addEmpleado (){
         
         sentence = new String ("SELECT id_empleado FROM datos_empleado");
         
         try{
             resc = Objmsql.consultarAlgo(sentence);
             while (resc.next()){
                 cb_idempleado.addItem(String.valueOf(resc.getString("id_empleado")));
             }
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
     public String savePath(){
        String button = null;
        String LAST_USED_FOLDER = "";
        String a = "C:\\EXPEDIENTES DIGITALES PERSONAL PREPA UNO";
        Preferences prefs = Preferences.userRoot().node(getClass().getName());
        JFileChooser chooser = new JFileChooser(prefs.get(LAST_USED_FOLDER,
        new File("C:\\EXPEDIENTES DIGITALES PERSONAL PREPA UNO").getAbsolutePath()));
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
         // do something
        prefs.put(LAST_USED_FOLDER, chooser.getSelectedFile().getParent());
        String fichero = chooser.getSelectedFile ().getPath();  
        fichero = fichero.replace('\\', '/');
        button = (fichero);  
    
            }
        return button ;  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        label_exit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tf_iddocente = new javax.swing.JTextField();
        tf_lic = new javax.swing.JTextField();
        tf_esp = new javax.swing.JTextField();
        tf_mtria = new javax.swing.JTextField();
        tf_doc = new javax.swing.JTextField();
        tf_ed_titulo = new javax.swing.JTextField();
        tf_ed_cLic = new javax.swing.JTextField();
        tf_ed_tituloEsp = new javax.swing.JTextField();
        tf_ed_tituloM = new javax.swing.JTextField();
        tf_ed_cedM = new javax.swing.JTextField();
        tf_ed_tituloDoc = new javax.swing.JTextField();
        tf_ed_cedDoc = new javax.swing.JTextField();
        tf_ed_dsia = new javax.swing.JTextField();
        tf_ed_prof = new javax.swing.JTextField();
        tf_ed_cert = new javax.swing.JTextField();
        cb_idempleado = new javax.swing.JComboBox<>();
        tf_ed_cedEsp = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelCancelar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelSiguiente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(185, 17, 22));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cinzel", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Expedientes DIGITALES");

        jPanel5.setBackground(new java.awt.Color(185, 17, 22));

        label_exit.setFont(new java.awt.Font("Cinzel", 1, 18)); // NOI18N
        label_exit.setForeground(new java.awt.Color(255, 255, 255));
        label_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_exit.setText("X");
        label_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_exitMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(label_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(label_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 565, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("ID Docente:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("ID Empleado:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Licenciatura:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Doctorado:");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Maestría:");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel28.setText("Especialidad");

        tf_iddocente.setEditable(false);
        tf_iddocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_iddocenteActionPerformed(evt);
            }
        });
        tf_iddocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_iddocenteKeyTyped(evt);
            }
        });

        tf_lic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_licActionPerformed(evt);
            }
        });

        tf_esp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_espActionPerformed(evt);
            }
        });

        tf_mtria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mtriaActionPerformed(evt);
            }
        });

        tf_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_docActionPerformed(evt);
            }
        });

        tf_ed_titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_ed_tituloMouseClicked(evt);
            }
        });
        tf_ed_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_tituloActionPerformed(evt);
            }
        });

        tf_ed_cLic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_cLicActionPerformed(evt);
            }
        });

        tf_ed_tituloEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_tituloEspActionPerformed(evt);
            }
        });

        tf_ed_tituloM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_tituloMActionPerformed(evt);
            }
        });

        tf_ed_cedM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_cedMActionPerformed(evt);
            }
        });

        tf_ed_tituloDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_tituloDocActionPerformed(evt);
            }
        });

        tf_ed_cedDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_cedDocActionPerformed(evt);
            }
        });

        tf_ed_dsia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_dsiaActionPerformed(evt);
            }
        });

        tf_ed_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_profActionPerformed(evt);
            }
        });

        tf_ed_cert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ed_certActionPerformed(evt);
            }
        });

        cb_idempleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cb_idempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_idempleadoActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Exp. digital. titulo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Exp. digital cédula Lic.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Exp. digital. título esp.");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Exp. digital Cedula esp.");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Exp. digital. título Mtria.");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Exp. digital. cédula Mtria.");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Exp. digital. título Doc.");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Exp. digital. cédula Doc.");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Exp. digital DSIA");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Exp. digital PROFORDEMS");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Exp. digital CERTIDEMS");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel28)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_lic)
                    .addComponent(tf_esp)
                    .addComponent(tf_mtria)
                    .addComponent(tf_doc)
                    .addComponent(tf_ed_cLic)
                    .addComponent(tf_ed_tituloEsp)
                    .addComponent(tf_ed_tituloM)
                    .addComponent(tf_ed_cedM)
                    .addComponent(tf_ed_tituloDoc)
                    .addComponent(tf_ed_cedDoc)
                    .addComponent(tf_ed_dsia)
                    .addComponent(tf_ed_prof)
                    .addComponent(tf_ed_cert)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(tf_iddocente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cb_idempleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_ed_cedEsp, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(tf_ed_titulo))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_iddocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_idempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tf_lic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(tf_esp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addComponent(tf_mtria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tf_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_cLic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_tituloEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_cedEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_tituloM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_cedM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_tituloDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_cedDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_dsia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ed_cert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addContainerGap())
        );

        jScrollPane6.setViewportView(jPanel7);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 740, 340));

        jLabel3.setFont(new java.awt.Font("Cinzel", 0, 24)); // NOI18N
        jLabel3.setText("Agregar Docente");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 50));

        panelCancelar.setBackground(new java.awt.Color(185, 17, 22));
        panelCancelar.setPreferredSize(new java.awt.Dimension(119, 30));

        jLabel1.setFont(new java.awt.Font("Cinzel", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cancelar");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelCancelarLayout = new javax.swing.GroupLayout(panelCancelar);
        panelCancelar.setLayout(panelCancelarLayout);
        panelCancelarLayout.setHorizontalGroup(
            panelCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        panelCancelarLayout.setVerticalGroup(
            panelCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel3.add(panelCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        panelSiguiente.setBackground(new java.awt.Color(185, 17, 22));
        panelSiguiente.setPreferredSize(new java.awt.Dimension(119, 30));

        jLabel2.setFont(new java.awt.Font("Cinzel", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Siguiente");
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

        javax.swing.GroupLayout panelSiguienteLayout = new javax.swing.GroupLayout(panelSiguiente);
        panelSiguiente.setLayout(panelSiguienteLayout);
        panelSiguienteLayout.setHorizontalGroup(
            panelSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        panelSiguienteLayout.setVerticalGroup(
            panelSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel3.add(panelSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 790, 515));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exitMouseClicked
        dispose();
    }//GEN-LAST:event_label_exitMouseClicked

    private void label_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exitMouseEntered
        //Hover label close
        label_exit.setBackground(Color.WHITE);
    }//GEN-LAST:event_label_exitMouseEntered

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void tf_iddocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_iddocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_iddocenteActionPerformed

    private void tf_licActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_licActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_licActionPerformed

    private void tf_espActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_espActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_espActionPerformed

    private void tf_mtriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mtriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_mtriaActionPerformed

    private void tf_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_docActionPerformed

    private void tf_ed_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_tituloActionPerformed

    private void tf_ed_cLicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_cLicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_cLicActionPerformed

    private void tf_ed_tituloEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_tituloEspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_tituloEspActionPerformed

    private void tf_ed_tituloMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_tituloMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_tituloMActionPerformed

    private void tf_ed_cedMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_cedMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_cedMActionPerformed

    private void tf_ed_tituloDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_tituloDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_tituloDocActionPerformed

    private void tf_ed_cedDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_cedDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_cedDocActionPerformed

    private void tf_ed_dsiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_dsiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_dsiaActionPerformed

    private void tf_ed_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_profActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_profActionPerformed

    private void tf_ed_certActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ed_certActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ed_certActionPerformed

    private void cb_idempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_idempleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_idempleadoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Button titulo expediente digital
        this.tf_ed_titulo.setText(savePath());

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.tf_ed_cLic.setText(savePath());

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.tf_ed_tituloEsp.setText(savePath());

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.tf_ed_cedEsp.setText(savePath());

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // BUTTON titulo maestria
        this.tf_ed_tituloM.setText(savePath());

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.tf_ed_cedM.setText(savePath());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        this.tf_ed_tituloDoc.setText(savePath());

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        this.tf_ed_cedDoc.setText(savePath());
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        this.tf_ed_dsia.setText(savePath());

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        this.tf_ed_prof.setText(savePath());
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        this.tf_ed_cert.setText(savePath());
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        objColor.setColor(panelCancelar);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        objColor.resetColor(panelCancelar);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (tf_lic.getText().equals("") || tf_esp.getText().equals("") || tf_mtria.getText().equals("")||
            tf_doc.getText().equals("") || tf_ed_titulo.getText().equals("") ||
            tf_ed_titulo.getText().equals("") || tf_ed_cLic.getText().equals("")||
            tf_ed_tituloEsp.getText().equals("") || tf_ed_cedEsp.getText().equals("")||
            tf_ed_tituloM.getText().equals("") || tf_ed_cedM.getText().equals("") ||
            tf_ed_tituloDoc.getText().equals("") || tf_ed_cedDoc.getText().equals("") ||
            tf_ed_cedDoc.getText().equals("") || tf_ed_dsia.getText().equals("") ||
            tf_ed_prof.getText().equals("") || tf_ed_cert.getText().equals("")
        ){
            JOptionPane.showMessageDialog(this, "Ingrese todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            objetoDocente.setDatosDocentes(tf_iddocente.getText(), String.valueOf(cb_idempleado.getSelectedItem()),
                tf_lic.getText(),tf_esp.getText(), tf_mtria.getText(), tf_doc.getText(), tf_ed_titulo.getText(),
                tf_ed_cLic.getText(), tf_ed_tituloEsp.getText(), tf_ed_cedEsp.getText(),tf_ed_tituloM.getText(),
                tf_ed_cedM.getText(), tf_ed_tituloDoc.getText(),tf_ed_cedDoc.getText(),tf_ed_dsia.getText(),
                tf_ed_prof.getText(),tf_ed_cert.getText());

           JDDocente2 docentes2 = new JDDocente2 (objetoDocente);
            this.setVisible(false);
            docentes2.setVisible(true);
            this.dispose();
            docentes2.setVisible (true);

        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        objColor.setColor(panelSiguiente);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        objColor.resetColor(panelSiguiente);
    }//GEN-LAST:event_jLabel2MouseExited

    private void tf_iddocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_iddocenteKeyTyped
        // clear texffield id
       
    }//GEN-LAST:event_tf_iddocenteKeyTyped

    private void tf_ed_tituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_ed_tituloMouseClicked
        // TODO add your handling code here:
        this.tf_ed_titulo.setText("NO");
    }//GEN-LAST:event_tf_ed_tituloMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JDEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(JDEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(JDEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(JDEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
                JDDocente dialog = new JDDocente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_idempleado;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel label_exit;
    private javax.swing.JPanel panelCancelar;
    private javax.swing.JPanel panelSiguiente;
    private javax.swing.JTextField tf_doc;
    private javax.swing.JTextField tf_ed_cLic;
    private javax.swing.JTextField tf_ed_cedDoc;
    private javax.swing.JTextField tf_ed_cedEsp;
    private javax.swing.JTextField tf_ed_cedM;
    private javax.swing.JTextField tf_ed_cert;
    private javax.swing.JTextField tf_ed_dsia;
    private javax.swing.JTextField tf_ed_prof;
    private javax.swing.JTextField tf_ed_titulo;
    private javax.swing.JTextField tf_ed_tituloDoc;
    private javax.swing.JTextField tf_ed_tituloEsp;
    private javax.swing.JTextField tf_ed_tituloM;
    private javax.swing.JTextField tf_esp;
    private javax.swing.JTextField tf_iddocente;
    private javax.swing.JTextField tf_lic;
    private javax.swing.JTextField tf_mtria;
    // End of variables declaration//GEN-END:variables
}
