/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;
import java.sql.*; 
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Camila Ugalde Derbez 5IM8
 */
public class form implements ActionListener {
    
    //Jframe en donde esta contenido todo(ventana)
    private JFrame ventana;
    private JTextField nombre, apellidom,apellidop,escuela,telefono;
    private Container cont;
    private JButton agregar;
    //metodo para mostrar la ventana
    
    public form(){
        //se crea la ventana
        ventana = new JFrame("Formulario");//establecer titulo
        ventana.setBounds(200, 200, 500, 500);//tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        cont= ventana.getContentPane();
    }
    
    public void prendeApaga(boolean prendeApaga){
    muestraElementos();
    ventana.setVisible(true);
    }
    
    //elementos
    private void muestraElementos(){
        //nombre
        nombre = new JTextField("nombre");
        nombre.setBounds(10, 10, 120, 40);
        cont.add(nombre);
        //apellido materno
        apellidom = new JTextField("apellidom");
        apellidom.setBounds(10, 50, 120, 40);
        cont.add(apellidom);
        //apellido paterno
        apellidop = new JTextField("apellidop");
        apellidop.setBounds(10,90,120,40);
        cont.add(apellidop);
        //escuela
        escuela = new JTextField("escuela");
        escuela.setBounds(10, 130, 120, 40);
        cont.add(escuela);
        //telefono
        telefono = new JTextField("telefono");
        telefono.setBounds(10, 170, 120, 40);
        cont.add(telefono);
        //boton de agregar
        agregar = new JButton("Agregar");
        agregar.setBounds(10,210,120,40);
        agregar.addActionListener(this);
        cont.add(agregar);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    
    String nom = nombre.getText();
    String app = apellidop.getText();
    String apm = apellidom.getText();
    String esc = escuela.getText();
    String tel = telefono.getText();
    



  Connection con = null;
    java.sql.Statement st = null;

    String user = "root";
    //Cambia la contraseña
    String pass = "l0v1n0";
    String driver = "com.mysql.jdbc.Driver";
    //Junta la direccion de la base con el localhost, no se pone el numero de local host
    String url = "jdbc:mysql://localhost/dbformulario";
    
    
    try {
        //newInstance es necesario o no funcionara 
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url, user, pass);
        st = con.createStatement();
        st.executeUpdate("insert into datinis values('"+nom+"','"+app+"','"+apm+"','"+esc+"','"+tel+"');");
        con.close();
        System.out.println("Datos agregados ;0");
    } catch (Exception ex) {
        //Imprime errores
        System.out.println("E R R O R: " + ex.getMessage() + ":'0");
    }}}


//ESTO NO VA LOL (ya no sirvio)

/*Connection con=null;
        Statement sta=null;
        
        try{
                Class.forName("com.mysql.jdbc.Driver"); 
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbformulario","root","l0v1n0");
                //con= DriverManager.getConnection("jdbc:mysql://localhost/datinis","root","l0v1n0");
                sta = (Statement) con.createStatement();
            }
            catch(SQLException error){
                //System.out.println("lol");
            }
            try{
                sta = con.createStatement();
                String sql = "update person set cname='Rakesh' where id=4";
                sta.executeUpdate(sql);
                //sta.executeUpdate("INSERT INTO producto VALUES('"+nom+"','"+app+"','"+apm+"','"+esc+"','"+tel+"');");
                //System.out.println("nope");
                con.close();
            }
            catch(SQLException error){
                //System.out.println("lmao nope");
                //out.println(error.toString());
            }
        try {
            con.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(form.class.getName()).log(Level.SEVERE, null, ex);
        }

>:(

*/
