package softfood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Producto extends javax.swing.JFrame {

    PreparedStatement ps, ps1;
    ResultSet rs, rs1;

    int cualusurioes = 1;

    int codigoContiene = 0;

    public Producto() {
        initComponents();
        mostrarDatos();
        mostrarDatosInsumoContenido();
        jPanelAgregarInsumos.setVisible(false);
        codigoText.setText("" + idAutoincrementado("producto") + "");
    }

    public Producto(int cualusuario) {
        initComponents();
        mostrarDatos();
        mostrarDatosInsumoContenido();
        this.cualusurioes = cualusuario;
        jPanelAgregarInsumos.setVisible(false);
        codigoText.setText("" + idAutoincrementado("producto") + "");
    }

    public void mostrarDatos() {
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

    public void mostrarDatosInsumoContenido() {

        String campo = codigoproductotext.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = "WHERE c.Cod_Producto = '" + campo + "'";
        }

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTableInsumoContenido.setModel(modelo);
            Conexion con = new Conexion();
            Connection cone = con.getConec();
            ps = cone.prepareStatement("SELECT C.Codigo, c.Cod_Producto, c.Cod_Insumo, i.Nombre, c.Cantidad \n"
                    + "FROM softfood.contiene c INNER JOIN softfood.insumo i ON c.Cod_Insumo=i.Codigo "
                    + where);

            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();

            modelo.addColumn("Codigo");
            modelo.addColumn("Cod_Producto");
            modelo.addColumn("Cod_insumo");
            modelo.addColumn("Nombre Insumo");
            modelo.addColumn("Cantidad");

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

    public void limpiar() {
        nombreText.setText("");
        valorText.setText("");
        codigoText.setText("" + idAutoincrementado("producto") + "");
        AgregarCantidadIsnumoText.setText("");
        AgregarIsnumoText.setText("");
        codigoproductotext.setText("");
        nombreInsumoText.setText("");
        cantidadInsumoText.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codigoText = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        valorText = new javax.swing.JTextField();
        bAgregar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jBtnMenu = new javax.swing.JButton();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanelAgregarInsumos = new javax.swing.JPanel();
        jBnAgregarInsumo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        AgregarIsnumoText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AgregarCantidadIsnumoText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducto = new javax.swing.JTable();
        jBCargar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInsumoContenido = new javax.swing.JTable();
        jBCargarInsumoProducto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        codigoproductotext = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nombreInsumoText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cantidadInsumoText = new javax.swing.JTextField();
        btnModificarInsumoProducto = new javax.swing.JButton();
        btnEliminarInsumoContenido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PRODUCTOS");

        jLabel1.setText("Codigo:");

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Valor:");

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

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jBtnMenu.setText("Menu Principal");
        jBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMenuActionPerformed(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO PREPARADA", "PREPARADA" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo:");

        jBnAgregarInsumo.setText("Agregar Insumo");
        jBnAgregarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnAgregarInsumoActionPerformed(evt);
            }
        });

        jLabel6.setText("Inusmo:");

        jLabel7.setText("Cantidad:");

        javax.swing.GroupLayout jPanelAgregarInsumosLayout = new javax.swing.GroupLayout(jPanelAgregarInsumos);
        jPanelAgregarInsumos.setLayout(jPanelAgregarInsumosLayout);
        jPanelAgregarInsumosLayout.setHorizontalGroup(
            jPanelAgregarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgregarInsumosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAgregarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(32, 32, 32)
                .addGroup(jPanelAgregarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAgregarInsumosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jBnAgregarInsumo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelAgregarInsumosLayout.createSequentialGroup()
                        .addGroup(jPanelAgregarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AgregarIsnumoText, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(AgregarCantidadIsnumoText))
                        .addContainerGap())))
        );
        jPanelAgregarInsumosLayout.setVerticalGroup(
            jPanelAgregarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAgregarInsumosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAgregarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(AgregarIsnumoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAgregarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(AgregarCantidadIsnumoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBnAgregarInsumo)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jBtnMenu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(valorText))
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(codigoText)
                                    .addGap(18, 18, 18)
                                    .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(nombreText))))
                    .addComponent(jPanelAgregarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanelAgregarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAgregar)
                    .addComponent(bModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jBtnMenu)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("CRUD PRODUCTOS", jPanel1);

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
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProducto);

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jBCargar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(jBCargar)
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("MOSTRAR PRODUCTOS", jPanel2);

        jTableInsumoContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Cod_Producto", "Cod_Insumo", "Nombre insumo", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInsumoContenido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInsumoContenidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableInsumoContenido);

        jBCargarInsumoProducto.setText("Cargar");
        jBCargarInsumoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCargarInsumoProductoActionPerformed(evt);
            }
        });

        jLabel8.setText("Codigo producto:");

        jLabel9.setText("Nombre Insumo:");

        jLabel10.setText("Cantidad Insumo:");

        btnModificarInsumoProducto.setText("Modificar");
        btnModificarInsumoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarInsumoProductoActionPerformed(evt);
            }
        });

        btnEliminarInsumoContenido.setText("Eliminar");
        btnEliminarInsumoContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInsumoContenidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nombreInsumoText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(codigoproductotext, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadInsumoText)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jBCargarInsumoProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(btnModificarInsumoProducto)
                                .addGap(45, 45, 45)
                                .addComponent(btnEliminarInsumoContenido)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(codigoproductotext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(nombreInsumoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cantidadInsumoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCargarInsumoProducto)
                    .addComponent(btnModificarInsumoProducto)
                    .addComponent(btnEliminarInsumoContenido))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MODIFICAR INSUMOS", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        bAgregar.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        Conexion con = new Conexion();

        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("DELETE FROM producto WHERE Codigo=?");
            ps.setInt(1, Integer.parseInt(codigoText.getText()));

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto ");
                limpiar();
            }

            cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed

        Conexion con = new Conexion();

        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("UPDATE producto SET Nombre=?, Valor=? WHERE Codigo=?");
            ps.setString(1, nombreText.getText());
            ps.setFloat(2, Float.parseFloat(valorText.getText()));
            ps.setString(3, codigoText.getText());

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Producto modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar producto ");
                limpiar();
            }

            cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        Conexion con = new Conexion();
        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("INSERT INTO producto (Codigo,Nombre,Valor) VALUES(?,?,?)");
            ps.setInt(1, Integer.parseInt(codigoText.getText()));
            ps.setString(2, nombreText.getText());
            ps.setFloat(3, Float.parseFloat(valorText.getText()));

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Producto Guardado");
                if (cbxTipo.getSelectedIndex() != 2) {
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar producto ");
            }

            cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_bAgregarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        bAgregar.setEnabled(false);
        Conexion con = new Conexion();
        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("SELECT * FROM producto  WHERE Codigo = ?");
            ps.setInt(1, Integer.parseInt(codigoText.getText()));

            rs = ps.executeQuery();

            if (rs.next()) {
                codigoText.setText(rs.getString("Codigo"));
                nombreText.setText(rs.getString("Nombre"));
                valorText.setText(rs.getString("Valor"));
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
                limpiar();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    private void jBCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargarActionPerformed
        mostrarDatos();
    }//GEN-LAST:event_jBCargarActionPerformed

    private void jBtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMenuActionPerformed
        Menu_Principal menu = new Menu_Principal(cualusurioes);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnMenuActionPerformed

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

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        int OpcionComboBox = cbxTipo.getSelectedIndex();
        if (OpcionComboBox == 1) {
            jPanelAgregarInsumos.setVisible(true);
        } else {
            jPanelAgregarInsumos.setVisible(false);
        }
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void jBnAgregarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnAgregarInsumoActionPerformed
        //Con esta primera conexion a la BD verifico que el nombre del insumo corresponda a un insumo ya registrado
        Conexion con = new Conexion();
        int codigoinsumo = 0;
        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("SELECT * FROM insumo WHERE Nombre = ?");
            ps.setString(1, AgregarIsnumoText.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                codigoinsumo = Integer.parseInt(rs.getString(1));
                //Agrego los datos a la tabla contiene
                try {
                    ps1 = cone.prepareStatement("INSERT INTO contiene(Codigo,Cod_Producto,Cod_Insumo,Cantidad) VALUES(?,?,?,?)");
                    ps1.setInt(1, idAutoincrementado("contiene"));
                    ps1.setInt(2, Integer.parseInt(codigoText.getText()));
                    ps1.setInt(3, codigoinsumo);
                    ps1.setInt(4, Integer.parseInt(AgregarCantidadIsnumoText.getText()));

                    int res = ps1.executeUpdate();

                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Insumo agregado al producto");
                        AgregarCantidadIsnumoText.setText("");
                        AgregarIsnumoText.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar insumo");
                    }

                    cone.close();
                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Primero debes agregar el producto para poder agregar los insumos");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Insumo no encontrado");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jBnAgregarInsumoActionPerformed

    private void jBCargarInsumoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargarInsumoProductoActionPerformed
        mostrarDatosInsumoContenido();
        limpiar();
    }//GEN-LAST:event_jBCargarInsumoProductoActionPerformed

    private void jTableInsumoContenidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInsumoContenidoMouseClicked
        try {
            Conexion con = new Conexion();
            Connection cone = con.getConec();

            int fila = jTableInsumoContenido.getSelectedRow();
            String codigo = jTableInsumoContenido.getValueAt(fila, 0).toString();

            ps = cone.prepareStatement("SELECT C.Codigo, c.Cod_Producto, c.Cod_Insumo, i.Nombre, c.Cantidad \n"
                    + "FROM softfood.contiene c INNER JOIN softfood.insumo i ON c.Cod_Insumo=i.Codigo "
                    + "WHERE c.Codigo = ?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                codigoproductotext.setText(rs.getString("Cod_Producto"));
                nombreInsumoText.setText(rs.getString("Nombre"));
                cantidadInsumoText.setText(rs.getString("Cantidad"));
                codigoContiene = Integer.parseInt(rs.getString("Codigo"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jTableInsumoContenidoMouseClicked

    private void btnModificarInsumoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarInsumoProductoActionPerformed
        Conexion con = new Conexion();

        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("UPDATE contiene SET Cantidad=? WHERE Codigo = ?");
            ps.setString(1, cantidadInsumoText.getText());
            ps.setInt(2, codigoContiene);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Insumo modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar insumo ");
            }

            cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnModificarInsumoProductoActionPerformed

    private void btnEliminarInsumoContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInsumoContenidoActionPerformed
        Conexion con = new Conexion();

        try {
            Connection cone = con.getConec();
            ps = cone.prepareStatement("DELETE FROM contiene WHERE Codigo=?");
            ps.setInt(1, codigoContiene);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Insumo eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar insumo ");
                limpiar();
            }

            cone.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnEliminarInsumoContenidoActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AgregarCantidadIsnumoText;
    private javax.swing.JTextField AgregarIsnumoText;
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarInsumoContenido;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarInsumoProducto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cantidadInsumoText;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JTextField codigoText;
    private javax.swing.JTextField codigoproductotext;
    private javax.swing.JButton jBCargar;
    private javax.swing.JButton jBCargarInsumoProducto;
    private javax.swing.JButton jBnAgregarInsumo;
    private javax.swing.JButton jBtnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanelAgregarInsumos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableInsumoContenido;
    private javax.swing.JTable jTableProducto;
    private javax.swing.JTextField nombreInsumoText;
    private javax.swing.JTextField nombreText;
    private javax.swing.JTextField valorText;
    // End of variables declaration//GEN-END:variables
}
