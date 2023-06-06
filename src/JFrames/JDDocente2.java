
package JFrames;

import expedientes.datos_docentes;
import conexion_sql.ConexionBD;
import java.awt.Color;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import JFrames.JDDocente;

public class JDDocente2 extends javax.swing.JDialog {

    static datos_docentes objetoDocentes = new datos_docentes();
    datos_docentes doc;
    
    public static PreparedStatement sentencia_preparada;
     // atributos barra de ventana 
    int xMouse, yMouse;
    ConexionBD metodos = new ConexionBD();
    buscar objBuscar = new buscar();
    
    //JDDocente objDoc = new JDDocente();
    
    public JDDocente2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    public JDDocente2 (datos_docentes obp){
       
        initComponents();
        setLocationRelativeTo(null);
        doc = obp;
        label_iddocente.setText(String.valueOf(obp.getId_docente()));
        label_idempleado.setText(String.valueOf(obp.getId_empleado()));
        label_lic.setText(String.valueOf(obp.getLicenciatura()));
        label_esp.setText(String.valueOf(obp.getEspecialidad()));
        label_mtra.setText(String.valueOf(obp.getMaestria()));
        label_doc.setText(String.valueOf(obp.getDoctorado()));
        label_ed_titulo.setText(String.valueOf(obp.getEd_tituloLic()));
        label_ed_cedLic.setText(String.valueOf(obp.getEd_cedulaLic()));
        label_ed_tituloEsp.setText(String.valueOf(obp.getEd_tituloEsp()));
        label_edCedulaEsp.setText(String.valueOf(obp.getEd_cedulaEsp()));
        label_tituloMtria.setText(String.valueOf(obp.getEd_tituloMtria()));
        label_cedulaMtria.setText(String.valueOf(obp.getEd_cedulaMtria()));
        label_edTituloDoc.setText(String.valueOf(obp.getEd_tituloDoc()));
        llabel_cedulaDoc.setText(String.valueOf(obp.getEd_cedulaDoc()));
        label_edDSIA.setText(String.valueOf(obp.getEd_disa()));
        label_edPro.setText(String.valueOf(obp.getEd_profordems()));
        label_edcerti.setText(String.valueOf(obp.getEd_certidems()));
                      
    }
    
    public void saveDocentes (){
        ConexionBD Objmsql = new ConexionBD();
        String sentence = new String ("INSERT INTO `expedientes_digitales`.`datos_docente`"
                        +"(id_docente,id_empleado,licenciatura,maestria,doctorado,"
                + "especialidad,exp_digital_tituloLic,exp_digital_cedulaLic,exp_digital_tituloEsp,"
                + "exp_digital_cedulaEsp,exp_digital_tituloMtria,exp_digital_cedulaMtria,exp_digital_tituloDoc,"
                + "exp_digital_cedulaDoc,exp_digital_disa,exp_digital_profordems,exp_digital_certidems)"
                + "VALUES ("
                + doc.getId_docente() + ","
                + doc.getId_empleado() + ",'"
                + doc.getLicenciatura() + "','"
                + doc.getEspecialidad() + "','"
                + doc.getMaestria() + "','"
                + doc.getDoctorado() + "','"
                + doc.getEd_tituloLic() + "','"
                + doc.getEd_cedulaLic() + "','"
                + doc.getEd_tituloEsp()+ "','"
                + doc.getEd_cedulaEsp() + "','"
                + doc.getEd_tituloMtria() + "','"
                + doc.getEd_cedulaMtria () + "','"
                + doc.getEd_tituloDoc() + "','"
                + doc.getEd_cedulaDoc() + "','"
                + doc.getEd_disa() + "','"
                + doc.getEd_profordems() + "','"
                + doc.getEd_certidems() + "')");
        System.out.println("SQL " + sentence );
        Objmsql.guardarAlgo(sentence);
        System.out.println("Docente guardado");
    }
    
    public void UpdateDocentes (){
         ConexionBD Objmsql = new ConexionBD();
         String sentence = new String ("UPDATE `expedientes_digitales`.`datos_docente` SET "
                + "id_empleado = '" + doc.getId_empleado() + "',"
                + "licenciatura ='"+doc.getLicenciatura()+"',"
                + "maestria='"+doc.getMaestria()+"',doctorado='"+doc.getDoctorado()+"',"
                + "especialidad='"+doc.getEspecialidad()+"',"
                + "exp_digital_tituloLic='"+doc.getEd_tituloLic()+"',"
                + "exp_digital_cedulaLic='"+doc.getEd_cedulaLic()+"',"
                + "exp_digital_tituloEsp='"+doc.getEd_tituloEsp()+"',"
                + "exp_digital_cedulaEsp='"+doc.getEd_cedulaEsp()+"',"
                + "exp_digital_tituloMtria='"+doc.getEd_tituloMtria()+"'"
                + ",exp_digital_cedulaMtria='"+doc.getEd_cedulaMtria ()+"',"
                + "exp_digital_tituloDoc='"+doc.getEd_tituloDoc()+"',"
                + "exp_digital_cedulaDoc='"+doc.getEd_cedulaDoc()+"',"
                + "exp_digital_disa='"+doc.getEd_disa()+"',"
                + "exp_digital_profordems='"+doc.getEd_profordems()+"',"
                + "exp_digital_certidems='"+doc.getEd_certidems()+"' "
                + "WHERE (`id_docente`= "+doc.getId_docente()+");");
         System.out.println("SQL " + sentence );
         Objmsql.guardarAlgo(sentence);
        // Objmsql.guardarAlgo(sentence);
        System.out.println("Docente actualizado");
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        label_exit3 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        label_iddocente = new javax.swing.JLabel();
        label_idempleado = new javax.swing.JLabel();
        label_lic = new javax.swing.JLabel();
        label_esp = new javax.swing.JLabel();
        label_mtra = new javax.swing.JLabel();
        label_doc = new javax.swing.JLabel();
        label_ed_titulo = new javax.swing.JLabel();
        label_ed_cedLic = new javax.swing.JLabel();
        label_ed_tituloEsp = new javax.swing.JLabel();
        label_tituloMtria = new javax.swing.JLabel();
        label_cedulaMtria = new javax.swing.JLabel();
        label_edTituloDoc = new javax.swing.JLabel();
        llabel_cedulaDoc = new javax.swing.JLabel();
        label_edDSIA = new javax.swing.JLabel();
        label_edPro = new javax.swing.JLabel();
        label_edcerti = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        label_edCedulaEsp = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(185, 17, 22));
        jPanel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel11MouseDragged(evt);
            }
        });
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cinzel", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EXPEDIENTES DIGITALES");

        jPanel12.setBackground(new java.awt.Color(185, 17, 22));

        label_exit3.setFont(new java.awt.Font("Cinzel", 1, 18)); // NOI18N
        label_exit3.setForeground(new java.awt.Color(255, 255, 255));
        label_exit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_exit3.setText("X");
        label_exit3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_exit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_exit3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_exit3MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addComponent(label_exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(label_exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 685, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("ID Docente:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("ID Empleado:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Licenciatura:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Doctorado:");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Maestría:");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Exp. digital. titulo");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Exp. digital cédula Lic.");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Exp. digital. título esp.");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setText("Exp. digital. título Doc.");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("Exp. digital. título Mtria.");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setText("Exp. digital. cédula Mtria.");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setText("Exp. digital. cédula Doc.");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel26.setText("Exp. digital DSIA");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel27.setText("Exp. digital PROFORDEMS");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel28.setText("Especialidad");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel29.setText("Exp. digital CERTIDEMS");

        label_iddocente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_iddocente.setText("jLabel1");

        label_idempleado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_idempleado.setText("jLabel2");

        label_lic.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_lic.setText("jLabel3");

        label_esp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_esp.setText("jLabel5");

        label_mtra.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_mtra.setText("jLabel6");

        label_doc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_doc.setText("jLabel7");

        label_ed_titulo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_ed_titulo.setText("jLabel8");

        label_ed_cedLic.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_ed_cedLic.setText("jLabel9");

        label_ed_tituloEsp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_ed_tituloEsp.setText("jLabel10");

        label_tituloMtria.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_tituloMtria.setText("jLabel11");

        label_cedulaMtria.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cedulaMtria.setText("jLabel12");

        label_edTituloDoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_edTituloDoc.setText("jLabel13");

        llabel_cedulaDoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        llabel_cedulaDoc.setText("jLabel30");

        label_edDSIA.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_edDSIA.setText("jLabel31");

        label_edPro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_edPro.setText("jLabel32");

        label_edcerti.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_edcerti.setText("jLabel33");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel34.setText("Exp. digital cedula esp.");

        label_edCedulaEsp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_edCedulaEsp.setText("jLabel35");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel28)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_iddocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_idempleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_lic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_esp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_mtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_doc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_ed_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_ed_cedLic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_ed_tituloEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_tituloMtria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_cedulaMtria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_edTituloDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(llabel_cedulaDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_edDSIA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_edPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_edcerti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_edCedulaEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(label_iddocente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(label_idempleado))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(label_lic))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_esp))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_mtra))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_doc))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(label_ed_titulo))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(label_ed_cedLic))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_ed_tituloEsp)
                    .addComponent(jLabel21))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_edCedulaEsp)
                    .addComponent(jLabel34))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(label_tituloMtria)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(label_cedulaMtria))))
                .addGap(25, 25, 25)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(label_edTituloDoc))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(llabel_cedulaDoc))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(label_edDSIA))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(label_edPro))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(label_edcerti))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel14);

        jPanel13.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 820, 400));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Be Vietnam", 0, 14)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 480, 110, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Be Vietnam", 0, 14)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 120, 40));

        jButton3.setFont(new java.awt.Font("Be Vietnam", 0, 14)); // NOI18N
        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 120, 40));

        jLabel3.setFont(new java.awt.Font("Cinzel", 0, 18)); // NOI18N
        jLabel3.setText("CONFIRMAR DATOS DEL DOCENTE");
        jPanel13.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(531, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_exit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exit3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_label_exit3MouseClicked

    private void label_exit3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exit3MouseEntered
        //Hover label close
        label_exit.setBackground(Color.WHITE);
    }//GEN-LAST:event_label_exit3MouseEntered

    private void jPanel11MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel11MouseDragged

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel11MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // button guardar

        /*this.dispose();
        // 10 <= 11
        if (doc.getId_docente() <= objJDocentes.queryDocente() ){
            UpdateDocentes ();
            JOptionPane.showMessageDialog(this, "Se ha actualizado fabrica correctamente");
        } else{
            saveDocentes ();
        }
        super.dispose();*/
        if (objBuscar.globalInt_update > 0) {
            //System.out.println(buscar.globalInt );
            UpdateDocentes();
        }else{
            //System.out.println(buscar.globalInt );
            saveDocentes();
        }

        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Button modificar
        this.dispose();
        JDDocente ventana = new JDDocente(doc);
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JDDocente2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDDocente2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDDocente2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDDocente2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDDocente2 dialog = new JDDocente2(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel label_cedulaMtria;
    private javax.swing.JLabel label_doc;
    private javax.swing.JLabel label_edCedulaEsp;
    private javax.swing.JLabel label_edDSIA;
    private javax.swing.JLabel label_edPro;
    private javax.swing.JLabel label_edTituloDoc;
    private javax.swing.JLabel label_ed_cedLic;
    private javax.swing.JLabel label_ed_titulo;
    private javax.swing.JLabel label_ed_tituloEsp;
    private javax.swing.JLabel label_edcerti;
    private javax.swing.JLabel label_esp;
    private javax.swing.JLabel label_exit;
    private javax.swing.JLabel label_exit1;
    private javax.swing.JLabel label_exit2;
    private javax.swing.JLabel label_exit3;
    private javax.swing.JLabel label_iddocente;
    private javax.swing.JLabel label_idempleado;
    private javax.swing.JLabel label_lic;
    private javax.swing.JLabel label_mtra;
    private javax.swing.JLabel label_tituloMtria;
    private javax.swing.JLabel llabel_cedulaDoc;
    // End of variables declaration//GEN-END:variables
}
