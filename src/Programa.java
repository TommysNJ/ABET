import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Programa extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton quemarDatosButton;
    private JTextField fieldRegistrarCedula;
    private JTextField fieldRegistrarNombre;
    private JTextField fieldRegistrarSueldo;
    private JButton registrarEmpleadoButton;
    private JTextArea areaRegistrar;
    private JButton buscarButton;
    private JTextArea areaBuscar;
    private JButton mostrarInformeButton;
    private JTextArea areaInforme;
    private JTextField fieldBuscarCedula;
    private JTextField fieldModificarNombre;
    private JTextField fieldModificarSueldo;
    private JButton modificarButton;
    private JTextArea areaModificar;
    private JTextField fieldEliminarCedula;
    private JButton eliminarEmpleadoButton;
    private JTextArea areaEliminar;
    private JTextField fieldBuscarCedula1;
    private JTextField fieldBuscarNombre;
    private JButton buscarButton1;
    private JTextField fieldNombre;
    private JTextField fieldCedula;
    private JTextField fieldSueldo;
    private JButton modificarButton1;
    private JTextArea areaBuscarNombre;

    private Funcionamiento l = new Funcionamiento();

    public Programa(){
        setContentPane(panel1);

        quemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleado e1 = new Empleado("5034053443","Mateo Andrade", 5050);
                Empleado e2 = new Empleado("4952495433","Luisa Teran", 12000);
                Empleado e3 = new Empleado("0242343234","Francisco Ordoñez", 20000);
                Empleado e4 = new Empleado("1265477653","Cristobal Colón", 2000);

                l.agregar(e1);
                l.agregar(e2);
                l.agregar(e3);
                l.agregar(e4);

                quemarDatosButton.setEnabled(false);
                JOptionPane.showMessageDialog(null,"Datos ingresados correctamente.");
            }
        });
        registrarEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (l.agregar(new Empleado(fieldRegistrarCedula.getText(),fieldRegistrarNombre.getText(),Double.parseDouble(fieldRegistrarSueldo.getText())))){
                    areaRegistrar.setText(l.imprimirEmpleado(fieldRegistrarCedula.getText()).toString());
                    fieldRegistrarCedula.setText("");
                    fieldRegistrarNombre.setText("");
                    fieldRegistrarSueldo.setText("");
                    JOptionPane.showMessageDialog(null,"Usuario creado con éxito.");
                } else{
                    fieldRegistrarCedula.setText("");
                    areaRegistrar.setText("");
                    JOptionPane.showMessageDialog(null,"No se pudo registrar el usuario porque la cédula ya existe.");
                }
            }
        });
        mostrarInformeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaInforme.setText(l.toString());
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (l.searchById(fieldBuscarCedula.getText())!=-1){
                    areaModificar.setText("");
                    areaModificar.append("***EMPLEADO A MODIFICAR***\n" + l.imprimirEmpleado(fieldBuscarCedula.getText()).toString());
                    l.ModificarEmpleados(fieldBuscarCedula.getText(),fieldModificarNombre.getText(),Double.parseDouble(fieldModificarSueldo.getText()));
                    JOptionPane.showMessageDialog(null,"Empleado modificado con éxito.");
                    areaModificar.append("-> MODIFICACIÓN\n" + l.imprimirEmpleado(fieldBuscarCedula.getText()).toString());
                    fieldBuscarCedula.setText("");
                    fieldModificarNombre.setText("");
                    fieldModificarSueldo.setText("");
                } else{
                    areaModificar.setText("");
                    fieldBuscarCedula.setText("");
                    JOptionPane.showMessageDialog(null,"No se pudo modificar el empleado porque la cédula ingresada no existe.");
                }
            }
        });
        eliminarEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (l.searchById(fieldEliminarCedula.getText())!=-1){
                    areaEliminar.setText("***EMPLEADO ELIMINADO***\n" + l.imprimirEmpleado(fieldEliminarCedula.getText()).toString());
                    l.eliminarEmpleado(fieldEliminarCedula.getText());
                    fieldEliminarCedula.setText("");
                    JOptionPane.showMessageDialog(null,"Se eliminó con éxito el empleado.");
                } else {
                    fieldEliminarCedula.setText("");
                    areaEliminar.setText("");
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar el empleado porque la cédula ingresada no existe.");
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (l.searchById(fieldBuscarCedula1.getText())!=-1){
                    areaBuscar.setText("***EMPLEADO ENCONTRADO***\n" + l.imprimirEmpleado(fieldBuscarCedula1.getText()).toString());
                    fieldBuscarCedula1.setText("");
                } else {
                    fieldBuscarCedula1.setText("");
                    areaBuscar.setText("***EMPLEADO NO ENCONTRADO***\nIngrese una cédula existente.");
                }
            }
        });
        buscarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (l.busquedaNombre(fieldBuscarNombre.getText())!=null){
                    areaBuscar.setText("***EMPLEADO ENCONTRADO***\n" + l.busquedaNombre(fieldBuscarNombre.getText()).toString());
                    fieldBuscarNombre.setText("");
                } else{
                    fieldBuscarNombre.setText("");
                    areaBuscar.setText("***EMPLEADO NO ENCONTRADO***\nIngrese un nombre existente.");
                }
            }
        });
        modificarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (l.busquedaNombre(fieldNombre.getText())!=null){
                    areaModificar.setText("");
                    areaModificar.append("***EMPLEADO A MODIFICAR***\n" + l.busquedaNombre(fieldNombre.getText()).toString());
                    l.modificarEmpleadoPorNombre(fieldCedula.getText(),fieldNombre.getText(),Double.parseDouble(fieldSueldo.getText()));
                    JOptionPane.showMessageDialog(null,"Empleado modificado con éxito.");
                    areaModificar.append("-> MODIFICACIÓN\n" + l.busquedaNombre(fieldNombre.getText()).toString());
                    fieldBuscarCedula.setText("");
                    fieldModificarNombre.setText("");
                    fieldModificarSueldo.setText("");
                } else {
                    areaModificar.setText("");
                    fieldNombre.setText("");
                    JOptionPane.showMessageDialog(null,"No se pudo modificar el empleado porque el nombre ingresado no existe.");
                }
            }
        });
        fieldRegistrarSueldo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c!='.') {
                    e.consume();
                }
            }
        });
        fieldRegistrarNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        fieldRegistrarCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        fieldBuscarCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        fieldModificarNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        fieldModificarSueldo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c!='.') {
                    e.consume();
                }
            }
        });
        fieldBuscarCedula1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        fieldEliminarCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
}