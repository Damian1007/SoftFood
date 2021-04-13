package softfood;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import static softfood.Cliente.carrito;


public class ReportesCli extends javax.swing.JFrame {
    
    Date date;
    String Fecha_Inicio;
    String Fecha_Fin;
    PreparedStatement ps;
    ResultSet rs;
    java.sql.Date convertidoIni;
    java.sql.Date convertidoFinal;
    static Vector Nombre = new Vector();
    static Vector cant = new Vector();
    static Vector valor = new Vector();
    static Vector fecha = new Vector();
    int cualusurioes;
    int restaurante;
    
    FondoPanel fondo = new FondoPanel();
    
    public ReportesCli() {
        this.setContentPane(fondo);
        initComponents();
    }
    public ReportesCli(int cualusuario, int restaurante) {
        this.setContentPane(fondo);
        initComponents();
        
        this.cualusurioes = cualusuario;
        this.restaurante = restaurante;
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        rSDateChooser2 = new rojeru_san.componentes.RSDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fecha_Inicial: ");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Fecha_Final:");
        jLabel2.setOpaque(true);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos Vendidos", "Productos Vendidos/Dia", "Recepciòn Insumos", "Ventas Promedio" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Reportes:");
        jLabel3.setOpaque(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Generar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Dia:");
        jLabel4.setOpaque(true);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Menu Principal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REPORTES");
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)
                        .addGap(106, 106, 106)
                        .addComponent(jButton2)))
                .addGap(67, 67, 67)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel2))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(rSDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addGap(119, 119, 119))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int OpcionReporte = jComboBox1.getSelectedIndex();
        if(OpcionReporte == 3){
            
        }else {
            Date date = rSDateChooser1.getDatoFecha() ; 
       
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            Fecha_Inicio = dateFormat.format(date);
        
            date = rSDateChooser2.getDatoFecha() ; 
            Fecha_Fin = dateFormat.format(date);
        }
        
        
        
        switch (OpcionReporte) {
            case 0:
                fecha_Produ_libre();
                break;
            case 1:
                fecha_Produ();
                break;
            case 2:
                fecha_Insumos();
                break;
            case 3:
                fecha_Ventas();
                Grafico_VentaP();
                break;
           
        }
        
        Nombre.clear();
        cant .clear();
        valor.clear();
        fecha.clear();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    public void Grafico_VentaP(){
      
      
      DefaultPieDataset datos = new DefaultPieDataset();
      for (int i = 0; i < Nombre.size(); i++) {
                datos.setValue((String) Nombre.elementAt(i), Float.valueOf((String) valor.elementAt(i)));
            }
      JFreeChart grafico = ChartFactory.createPieChart("VENTAS PROMEDIO", datos,true,true,false);
      
      ChartPanel panel = new ChartPanel(grafico);
      panel.setMouseWheelEnabled(true);
      panel.setPreferredSize(new Dimension(400,200));
      
      jPanel1.setLayout(new BorderLayout());
      jPanel1.add(panel,BorderLayout.NORTH);
      
      pack();
      repaint();
      
      
      
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int OpcionComboBox = jComboBox1.getSelectedIndex();
        switch (OpcionComboBox) {
            case 0:
                jComboBox2.setEnabled(false);
                break;
            case 1:
                jComboBox2.setEnabled(true);
                break;
            case 2:
                jComboBox2.setEnabled(true);
                break;
            case 3:
                jComboBox2.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Menu_Principal menu = new Menu_Principal(cualusurioes, restaurante);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
     
    private void fecha_Insumos(){
        int OpcionComboBox = jComboBox2.getSelectedIndex();
        switch (OpcionComboBox) {
            case 0:
                report_insu(0);
                break;
            case 1:
                report_insu(1);
                break;
            case 2:
                report_insu(2);
                break;
            case 3:
                report_insu(3);
                break;
            case 4:
                report_insu(4);
                break;
            case 5:
                report_insu(5);
                break;
            case 6:
                report_insu(6);
                break;
            case 7:
                report_insu(7);
                break;
        }
    }
    public void report_insu(int diaSemana) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            
            Conexion con = new Conexion();
            Connection cone = con.getConec();
            LocalDate localDate_Ini = LocalDate.parse(Fecha_Inicio);
            LocalDate localDate_Final = LocalDate.parse(Fecha_Fin);
            String sql = "SELECT *, (ELT(WEEKDAY(Fecha_Compra) + 1,  'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo')) AS DIA_SEMANA\n"
                    + "FROM softfood.insumo\n"
                    + "WHERE (Fecha_Compra BETWEEN '"+localDate_Ini+"' AND '"+localDate_Final+"') and WEEKDAY(Fecha_Compra) = ? ";
            ps = cone.prepareStatement(sql);
            
          
            ps.setInt(1, diaSemana);
            rs = ps.executeQuery();

           

            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Valor");
            modelo.addColumn("Fecha_Compra");

            while (rs.next()) {

                Nombre.addElement(rs.getString(2));
                cant.addElement(rs.getString(3));
                valor.addElement(rs.getString(4));
                fecha.addElement(rs.getString(5));
            }
            GenerarPdf();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void GenerarPdf(){
      
        try{
        FileOutputStream archivo;
        String file = "src/pdf/venta.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        
            Paragraph para = new Paragraph("INSUMOS REPORTE BY SOFTFOOD");
            document.add(para);
            para = new Paragraph(" ");
            document.add(para);
            PdfPTable table = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("Producto"));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Cantidad"));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Valor"));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Fecha Ingreso"));
            table.addCell(c1);
            table.setHeaderRows(1);
             for (int i = 0; i < Nombre.size(); i++) {
                table.addCell((String) Nombre.elementAt(i));
                table.addCell((String) cant.elementAt(i));
                table.addCell((String)  valor.elementAt(i));
                table.addCell((String)  fecha.elementAt(i));
            }
            
            
            document.add(table);
            
            document.close();
            
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void fecha_Produ(){
        int OpcionComboBox = jComboBox2.getSelectedIndex();
        switch (OpcionComboBox) {
            case 0:
                report_Produ(0);
                break;
            case 1:
                report_Produ(1);
                break;
            case 2:
                report_Produ(2);
                break;
            case 3:
                report_Produ(3);
                break;
            case 4:
                report_Produ(4);
                break;
            case 5:
                report_Produ(5);
                break;
            case 6:
                report_Produ(6);
                break;
            case 7:
                report_Produ(7);
                break;
        }
    }
    public void report_Produ(int diaSemana) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            
            Conexion con = new Conexion();
            Connection cone = con.getConec();
            LocalDate localDate_Ini = LocalDate.parse(Fecha_Inicio);
            LocalDate localDate_Final = LocalDate.parse(Fecha_Fin);
            String sql = 
                        "SELECT *, (ELT(WEEKDAY(Fecha) + 1,  'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo')) AS DIA_SEMANA\n"
                    +" FROM incluye i INNER JOIN pedido p ON p.Codigo = i.Cod_Pedido "
                    + "WHERE (Fecha BETWEEN '"+localDate_Ini+"' AND '"+localDate_Final+"') and WEEKDAY(Fecha) = ?";
            ps = cone.prepareStatement(sql);
            
          
            ps.setInt(1, diaSemana);
            rs = ps.executeQuery();

           

            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Valor");
            modelo.addColumn("Fecha_Compra");

            while (rs.next()) {
                Nombre.addElement(rs.getString(2)); //acomodar segun el join
                cant.addElement(rs.getString(4));
                fecha.addElement(rs.getString(6));
            }
            GenerarPdf_Produ();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }        
    public void GenerarPdf_Produ(){
      
        try{
        FileOutputStream archivo;
        String file = "src/pdf/venta.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        
            Paragraph para = new Paragraph("PRODUCTOS REPORTE BY SOFTFOOD");
            document.add(para);
            para = new Paragraph(" ");
            document.add(para);
            PdfPTable table = new PdfPTable(3);
            PdfPCell c1 = new PdfPCell(new Phrase("Producto"));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Cantidad"));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Fecha"));
            table.addCell(c1);
           
            table.setHeaderRows(1);
             for (int i = 0; i < Nombre.size(); i++) {
                table.addCell((String) Nombre.elementAt(i));
                table.addCell((String) cant.elementAt(i));
                table.addCell((String)  fecha.elementAt(i));
            }
            
            
            document.add(table);
            
            document.close();
            
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void fecha_Produ_libre(){
        int OpcionComboBox = jComboBox2.getSelectedIndex();
        switch (OpcionComboBox) {
            case 0:
                report_Produ_Libre(0);
                break;
            case 1:
                report_Produ_Libre(1);
                break;
            case 2:
                report_Produ_Libre(2);
                break;
            case 3:
                report_Produ_Libre(3);
                break;
            case 4:
                report_Produ_Libre(4);
                break;
            case 5:
                report_Produ_Libre(5);
                break;
            case 6:
                report_Produ_Libre(6);
                break;
            case 7:
                report_Produ_Libre(7);
                break;
        }
    }
    public void report_Produ_Libre(int diaSemana) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            
            Conexion con = new Conexion();
            Connection cone = con.getConec();
            LocalDate localDate_Ini = LocalDate.parse(Fecha_Inicio);
            LocalDate localDate_Final = LocalDate.parse(Fecha_Fin);
            String sql = "SELECT *"
                    + " FROM incluye i INNER JOIN pedido p ON p.Codigo = i.Cod_Pedido " 
                    + "WHERE (Fecha BETWEEN '"+localDate_Ini+"' AND '"+localDate_Final+"')  ";
            ps = cone.prepareStatement(sql);
            
          
      
            rs = ps.executeQuery();

           

            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Valor");
            modelo.addColumn("Fecha_Compra");

            while (rs.next()) {
                Nombre.addElement(rs.getString(2)); //acomodar segun el join
                cant.addElement(rs.getString(4));
                fecha.addElement(rs.getString(6));
            }
            GenerarPdf_Produ_Libre();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }      
    public void GenerarPdf_Produ_Libre(){
      
        try{
        FileOutputStream archivo;
        String file = "src/pdf/venta.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        
            Paragraph para = new Paragraph("PRODUCTOS REPORTE BY SOFTFOOD");
            document.add(para);
            para = new Paragraph(" ");
            document.add(para);
            PdfPTable table = new PdfPTable(3);
            PdfPCell c1 = new PdfPCell(new Phrase("Producto"));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Cantidad"));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Fecha"));
            table.addCell(c1);
           
            table.setHeaderRows(1);
             for (int i = 0; i < Nombre.size(); i++) {
                table.addCell((String) Nombre.elementAt(i));
                table.addCell((String) cant.elementAt(i));
                table.addCell((String)  fecha.elementAt(i));
            }
            
            
            document.add(table);
            
            document.close();
            
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
     private void fecha_Ventas(){
        int OpcionComboBox = jComboBox2.getSelectedIndex();
        switch (OpcionComboBox) {
            case 0:
                report_Ventas(0);
                break;
            case 1:
                report_Ventas(1);
                break;
            case 2:
                report_Ventas(2);
                break;
            case 3:
                report_Ventas(3);
                break;
            case 4:
                report_Ventas(4);
                break;
            case 5:
                report_Ventas(5);
                break;
            case 6:
                report_Ventas(6);
                break;
            case 7:
                report_Ventas(7);
                break;
        }
    }
     public void report_Ventas(int diaSemana) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            
            Conexion con = new Conexion();
            Connection cone = con.getConec();
            
            String sql = 
            "SELECT Restaurante,AVG(Valor_Total) FROM softfood.pedido  "+
            "GROUP BY Restaurante having AVG(Valor_Total)";
            ps = cone.prepareStatement(sql);
            
          
      
            rs = ps.executeQuery();

           

            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Valor");
            modelo.addColumn("Fecha_Compra");

            while (rs.next()) {
                Nombre.addElement(rs.getString(1)); //acomodar segun el join
                valor.addElement(rs.getString(2));
                
            }
            GenerarPdf_Ventas();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }  
     public void GenerarPdf_Ventas(){
      
        try{
        FileOutputStream archivo;
        String file = "src/pdf/venta.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        
            Paragraph para = new Paragraph("Ventas Promedio REPORTE BY SOFTFOOD");
            document.add(para);
            para = new Paragraph(" ");
            document.add(para);
            PdfPTable table = new PdfPTable(2);
            PdfPCell c1 = new PdfPCell(new Phrase("Restaurante"));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Ventas Promedio"));
            table.addCell(c1);
            
           
            table.setHeaderRows(1);
             for (int i = 0; i < Nombre.size(); i++) {
                table.addCell((String) Nombre.elementAt(i));
                table.addCell((String) valor.elementAt(i));
            }
            
            
            document.add(table);
            
            document.close();
            
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
     
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
            java.util.logging.Logger.getLogger(ReportesCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportesCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportesCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportesCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesCli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private rojeru_san.componentes.RSDateChooser rSDateChooser1;
    private rojeru_san.componentes.RSDateChooser rSDateChooser2;
    // End of variables declaration//GEN-END:variables

class FondoPanel extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Imagen_Restaurante_2.png")).getImage();
            
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
