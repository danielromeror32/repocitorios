package main;

import JFrames.JFmenu;
import SQL.ConexionBD;
import expedientes.colors;
import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Main_login extends javax.swing.JFrame {

    // OBJETOS
    colors objColor = new colors();
    ConexionBD Objmsql = new ConexionBD();
    // Atributos 
    private ImageIcon imagen;
    private Icon icono;
    String sentence;
    String ultimo;
    ResultSet resc = null;
    int xMouse, yMouse;
    
    public Main_login() {
        initComponents();
        Header.setBackground(new java.awt.Color(185,17,22));
        setLocationRelativeTo(null);
        this.pintarImagen(this.jLabel4, "src/Images/garza.png");
        this.pintarImagen(this.jLabel8, "src/Images/uaeh1.png");
    }

    
     // Metodo para consultar usuario y contraseña  
    public String consulta (int user){
        
        
        sentence = "select * from administrador;";
        try{
            resc = Objmsql.consultarAlgo(sentence);
            while (resc.next()){
                ultimo = resc.getString(user);       
            }
        }catch (SQLException ex){
           // java.util.logging.Logger.getLogger(JFEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }       
         System.out.println("Existen "+ ultimo + "Empleados");
        return ultimo;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonClose = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_usuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        buttonLogin = new javax.swing.JPanel();
        labelLogin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 500));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(185, 17, 22));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cinzel", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Área de planeación");
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 20));

        buttonClose.setBackground(new java.awt.Color(185, 17, 22));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
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

        javax.swing.GroupLayout buttonCloseLayout = new javax.swing.GroupLayout(buttonClose);
        buttonClose.setLayout(buttonCloseLayout);
        buttonCloseLayout.setHorizontalGroup(
            buttonCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );
        buttonCloseLayout.setVerticalGroup(
            buttonCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INICIAR SESIÓN");
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 40));
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 71, 260, -1));

        jLabel6.setFont(new java.awt.Font("Cinzel", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("USUSARIO");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        tf_usuario.setFont(new java.awt.Font("Be Vietnam", 0, 14)); // NOI18N
        tf_usuario.setForeground(new java.awt.Color(153, 153, 153));
        tf_usuario.setText("Ingrese su usuario");
        tf_usuario.setBorder(null);
        tf_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_usuarioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tf_usuarioMousePressed(evt);
            }
        });
        bg.add(tf_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 200, 20));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 200, 20));

        jLabel5.setFont(new java.awt.Font("Cinzel", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Contraseña");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        tf_password.setText("********");
        tf_password.setBorder(null);
        tf_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tf_passwordMousePressed(evt);
            }
        });
        tf_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_passwordKeyPressed(evt);
            }
        });
        bg.add(tf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 200, 20));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 200, 20));

        buttonLogin.setBackground(new java.awt.Color(185, 17, 22));
        buttonLogin.setPreferredSize(new java.awt.Dimension(119, 31));

        labelLogin.setFont(new java.awt.Font("Cinzel", 0, 14)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(255, 255, 255));
        labelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogin.setText("Login");
        labelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelLoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonLoginLayout = new javax.swing.GroupLayout(buttonLogin);
        buttonLogin.setLayout(buttonLoginLayout);
        buttonLoginLayout.setHorizontalGroup(
            buttonLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        buttonLoginLayout.setVerticalGroup(
            buttonLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        bg.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 100, 100));
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 140, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_usuarioMousePressed
        // Color y texto de campos de texto del field usuario
        if (tf_usuario.getText().equals("Ingrese su usuario")){
            tf_usuario.setText("");
            tf_usuario.setForeground(Color.BLACK);
        }
        if (String.valueOf(tf_password.getPassword()).isEmpty()){
            tf_password.setText("********");
            tf_password.setForeground(Color.GRAY);
        }

    }//GEN-LAST:event_tf_usuarioMousePressed
boolean typed = true;
    private void tf_passwordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_passwordMousePressed
        // Color y texto de campos de texto del field contraseña
        if (String.valueOf(tf_password.getPassword()).equals("********")){
            tf_password.setText("");
            tf_password.setForeground(Color.BLACK);
        }

        if(tf_usuario.getText().isEmpty()){
            tf_usuario.setText("Ingrese su usuario");
            tf_usuario.setForeground(Color.GRAY);
        }
       
    }//GEN-LAST:event_tf_passwordMousePressed

    private void labelLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLoginMouseEntered
        // Button login 
       objColor.setColor(buttonLogin);
    }//GEN-LAST:event_labelLoginMouseEntered

    private void labelLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLoginMouseExited
        // Button login salir 
        objColor.resetColor(buttonLogin);
    }//GEN-LAST:event_labelLoginMouseExited

    private void labelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLoginMouseClicked
        // Button login clicked
        System.out.println("march"+consulta(3));
        if (tf_usuario.getText().equals(consulta(3))&& tf_password.getText().equals(consulta(4)) ){  
            JOptionPane.showMessageDialog(this, "Usuario y contraseña correctas");
            this.dispose();
           JFmenu ventana = new JFmenu();
            ventana.setVisible(true);
        }else{
           
            JOptionPane.showMessageDialog(this, "Usuario/contraseña incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_labelLoginMouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // Button cerrar
        objColor.setColor(buttonClose);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // Button cerrar 
         objColor.resetColor(buttonClose);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // Button cerrar clicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        // mause pressed  
         xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen(); 
        this.setLocation(x - xMouse, y - yMouse);
                                        
    }//GEN-LAST:event_HeaderMouseDragged

    private void tf_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_usuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usuarioMouseClicked

    private void tf_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_passwordKeyPressed
        // clear field password
         if (typed== true){
            tf_password.setText("");
            typed = false;
        
        }
    }//GEN-LAST:event_tf_passwordKeyPressed

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
            java.util.logging.Logger.getLogger(Main_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_login().setVisible(true);
            }
        });
    }
       public void pintarImagen(JLabel lbl, String ruta){
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(), 
                        lbl.getHeight(), 
                        Image.SCALE_SMOOTH
                )
        );
        lbl.setIcon(this.icono);
        this.repaint();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel buttonClose;
    private javax.swing.JPanel buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_usuario;
    // End of variables declaration//GEN-END:variables
}
