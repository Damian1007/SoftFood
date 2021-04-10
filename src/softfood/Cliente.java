package softfood;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cliente extends javax.swing.JFrame {

    PreparedStatement ps;
    ResultSet rs;

    int cualusurioes;
    int restaurante;
    static Vector carrito = new Vector();
    static Vector cant = new Vector();
    float valorFinal = 0;
    int siguiente1;
    int siguiente2;


    public Cliente() {
        initComponents();
        mostrarDatos();
        mostrarFecha();
        mostrarDatosP();
        mostrarCedulas();
    }

    public Cliente(int cualusuario, int restaurante) {
        initComponents();
        mostrarDatos();
        mostrarFecha();
        mostrarDatosP();
        mostrarCedulas();
        this.cualusurioes = cualusuario;
        this.restaurante = restaurante;
    }

    public void mostrarDatos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTableCliente.setModel(modelo);
            Conexion con = new Conexion();
            Connection cone = con.getConec();

            String sql = "SELECT Cedula,Nombre,Telefono,Mesa FROM cliente";
            ps = cone.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();

            modelo.addColumn("Cedula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Telefono");
            modelo.addColumn("Mesa");

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void mostrarDatosP() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTableProducto.setModel(modelo);
            Conexion con = new Conexion();
            Connection cone = con.getConec();

            String sql = "SELECT Codigo,Nombre,Valor FROM producto";
            ps = cone.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();

            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Valor");

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void mostrarFecha() {
        LocalDate fecha = LocalDate.now();

        fechaLabel.setText(Date.valueOf(fecha).toString());
    }

    public void mostrarCedulas() {
        try {
            Conexion con = new Conexion();
            Connection cone = con.getConec();

            String sql = "SELECT Cedula FROM cliente";
            ps = cone.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cedulaCli.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public int idAutoincrementado(String s) {
        int idSiguiente = 0;
        Conexion con = new Conexion();
        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("SELECT MAX(Codigo) FROM " + s + ";");
            rs = ps.executeQuery();
            rs.next();
            idSiguiente = 1 + Integer.parseInt(rs.getString(1));
            return idSiguiente;
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idSiguiente;
    }

    public void limpiar() {
        cedulaText.setText("");
        nombreText.setText("");
        telefonoText.setText("");
        mesaText.setText("");
        CodProd.setText("");
        valorProd.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cedulaText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        telefonoText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mesaText = new javax.swing.JTextField();
        bAgregar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jBtnMenu1 = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProducto = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jBAgregarP = new javax.swing.JButton();
        jBTerminarP = new javax.swing.JButton();
        cedulaCli = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        jBCargarP = new javax.swing.JButton();
        jBorrarP = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        CodProd = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        valorProd = new javax.swing.JLabel();
        cantidadProd = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jBCargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENTE");

        jLabel2.setText("Cedula");

        jLabel3.setText("Nombre");

        jLabel4.setText("Telefono");

        jLabel5.setText("Mesa");

        bAgregar.setText("Agregar");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jBtnMenu1.setText("Menu Principal");
        jBtnMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMenu1ActionPerformed(evt);
            }
        });

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreText)
                            .addComponent(telefonoText)
                            .addComponent(mesaText, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cedulaText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bBuscar)
                                .addGap(3, 3, 3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(bAgregar)
                .addGap(34, 34, 34)
                .addComponent(bModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(Eliminar)
                .addGap(39, 39, 39)
                .addComponent(btnLimpiar)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnMenu1)
                .addGap(212, 212, 212))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cedulaText)
                        .addComponent(bBuscar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreText, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mesaText, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAgregar)
                    .addComponent(bModificar)
                    .addComponent(Eliminar)
                    .addComponent(btnLimpiar))
                .addGap(28, 28, 28)
                .addComponent(jBtnMenu1)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CRUD CLIENTE", jPanel1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ingresar Pedido");

        jTableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Valor"
            }
        ));
        jTableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProducto);

        jLabel7.setText("Codigo Producto");

        jLabel8.setText("Cedula Cliente");

        jBAgregarP.setText("Agregar Pedido");
        jBAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarPActionPerformed(evt);
            }
        });

        jBTerminarP.setText("Terminar Pedido");
        jBTerminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTerminarPActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha");

        jBCargarP.setText("Cargar");
        jBCargarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCargarPActionPerformed(evt);
            }
        });

        jBorrarP.setText("Borrar Todo Pedido");
        jBorrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorrarPActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Productos Disponibles");

        jLabel11.setText("Valor Producto");

        jLabel12.setText("Cantidad Producto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBorrarP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jBAgregarP)
                        .addGap(54, 54, 54)
                        .addComponent(jBTerminarP)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(CodProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cedulaCli, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cantidadProd))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBCargarP)
                .addGap(230, 230, 230))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCargarP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(valorProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cantidadProd)))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedulaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregarP)
                    .addComponent(jBTerminarP)
                    .addComponent(jBorrarP))
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("TOMAR PEDIDO", jPanel3);

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Telefono", "Mesa"
            }
        ));
        jScrollPane1.setViewportView(jTableCliente);

        jBCargar.setText("Cargar");
        jBCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jBCargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jBCargar)
                .addGap(0, 129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MOSTRAR CLIENTE", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        Conexion con = new Conexion();

        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("INSERT INTO cliente (Cedula,Nombre,Telefono,Mesa) VALUES(?,?,?,?)");
            ps.setInt(1, Integer.parseInt(cedulaText.getText()));
            ps.setString(2, nombreText.getText());
            ps.setString(3, telefonoText.getText());
            ps.setInt(4, Integer.parseInt(mesaText.getText()));

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Cliente Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar Cliente ");
            }

            cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_bAgregarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        Conexion con = new Conexion();

        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("UPDATE cliente SET Cedula=?, Nombre=?, Telefono=?, Mesa=? WHERE Cedula=?");
            ps.setInt(1, Integer.parseInt(cedulaText.getText()));
            ps.setString(2, nombreText.getText());
            ps.setString(3, telefonoText.getText());
            ps.setInt(4, Integer.parseInt(mesaText.getText()));
            ps.setString(5, cedulaText.getText());

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Cliente Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar Cliente ");
                limpiar();
            }

            cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        Conexion con = new Conexion();

        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("DELETE FROM cliente WHERE Cedula=?");
            ps.setFloat(1, Float.parseFloat(cedulaText.getText()));

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Cliente ");
                limpiar();
            }

            cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        bAgregar.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jBtnMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMenu1ActionPerformed
        Menu_Principal menu = new Menu_Principal(cualusurioes, restaurante);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnMenu1ActionPerformed

    private void jBCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargarActionPerformed
        mostrarDatos();
    }//GEN-LAST:event_jBCargarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        bAgregar.setEnabled(false);

        Conexion con = new Conexion();

        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("SELECT * FROM cliente  WHERE Cedula = ?");
            ps.setInt(1, Integer.parseInt(cedulaText.getText()));

            rs = ps.executeQuery();

            if (rs.next()) {
                cedulaText.setText(rs.getString("Cedula"));
                nombreText.setText(rs.getString("Nombre"));
                telefonoText.setText(rs.getString("Telefono"));
                mesaText.setText(rs.getString("Mesa"));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no Encontrado");
                limpiar();
            }
        cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    private void jBCargarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargarPActionPerformed
        mostrarDatosP();
    }//GEN-LAST:event_jBCargarPActionPerformed

    private void jBAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarPActionPerformed
        if (CodProd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningun Producto");
        } else {
            carrito.addElement(CodProd.getText());
            cant.addElement(cantidadProd.getText());
            valorFinal = valorFinal + (Float.valueOf(valorProd.getText()) * Float.valueOf(cantidadProd.getText()));
            for (int i = 0; i < carrito.size(); i++) {
                System.out.println(carrito.elementAt(i));
                System.out.println(cant.elementAt(i));
            }
            JOptionPane.showMessageDialog(this, "Producto Agregado a la Orden");
        }
    }//GEN-LAST:event_jBAgregarPActionPerformed

    private void jBorrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBorrarPActionPerformed
        carrito.clear();
        cant.clear();
        valorFinal = 0;
        JOptionPane.showMessageDialog(this, "Orden Borrada");
    }//GEN-LAST:event_jBorrarPActionPerformed

    private void jBTerminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTerminarPActionPerformed
        Conexion con = new Conexion();
        siguiente1 = idAutoincrementado("pedido");
        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("INSERT INTO pedido (Codigo,Fecha,Cedula_Cliente,Restaurante,Valor_Total) VALUES(?,?,?,?,?)");
            ps.setInt(1, siguiente1);
            ps.setDate(2, Date.valueOf(fechaLabel.getText()));
            ps.setInt(3, Integer.valueOf((String) cedulaCli.getSelectedItem()));
            ps.setInt(4, restaurante);
            ps.setFloat(5, valorFinal);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Pedido Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Registrar Pedido");
            }

            cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        
        for (int i = 0; i < carrito.size(); i++){
            siguiente2 = idAutoincrementado("incluye");
            try {
                Connection cone = con.getConec();
                ps = cone.prepareStatement("INSERT INTO incluye (Codigo,Cod_Producto,Cod_Pedido,Cantidad) VALUES(?,?,?,?)");
                ps.setInt(1, siguiente2);
                ps.setInt(2, Integer.valueOf((String) carrito.elementAt(i)));
                ps.setInt(3, siguiente1);
                ps.setInt(4, Integer.valueOf((String) cant.elementAt(i)));
                
                ps.executeUpdate();

                cone.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_jBTerminarPActionPerformed

    private void jTableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductoMouseClicked
        cantidadProd.setText("1");
        
        try {
            Conexion con = new Conexion();
            Connection cone = con.getConec();

            int fila = jTableProducto.getSelectedRow();
            String codigo = jTableProducto.getValueAt(fila, 0).toString();
            String valor = jTableProducto.getValueAt(fila, 2).toString();

            ps = cone.prepareStatement("SELECT Codigo, Valor \n"
                    + "FROM producto \n"
                    + "WHERE Codigo = ?");
            ps.setInt(1, Integer.parseInt(codigo));
            //ps.setFloat(2, Float.valueOf(valor));
            rs = ps.executeQuery();

            while (rs.next()) {
                CodProd.setText(rs.getString("codigo"));
                valorProd.setText(rs.getString("valor"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jTableProductoMouseClicked

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CodProd;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JTextField cantidadProd;
    private javax.swing.JComboBox<String> cedulaCli;
    private javax.swing.JTextField cedulaText;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JButton jBAgregarP;
    private javax.swing.JButton jBCargar;
    private javax.swing.JButton jBCargarP;
    private javax.swing.JButton jBTerminarP;
    private javax.swing.JButton jBorrarP;
    private javax.swing.JButton jBtnMenu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTableProducto;
    private javax.swing.JTextField mesaText;
    private javax.swing.JTextField nombreText;
    private javax.swing.JTextField telefonoText;
    private javax.swing.JLabel valorProd;
    // End of variables declaration//GEN-END:variables
}
