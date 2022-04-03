package controlador;

//trabjar los metodos e importar las vistas

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.ConsultaProducto;
import modelo.Producto;
import vista.VistaAgregar;
import vista.VistaEliminar;
import vista.Principal;

public class ControladorProducto implements ActionListener {

    private Producto pro;
    private ConsultaProducto proC;
    private VistaAgregar VistaA;
    private VistaEliminar VistaE;

//llamando a todas las clases para hacer los metodos    
    public ControladorProducto(Producto pro, ConsultaProducto proC, VistaAgregar vistaA, VistaEliminar VistaE) {
        this.pro = pro;
        this.proC = proC;
        this.VistaA = vistaA;
        this.VistaE = VistaE;
        this.VistaA.btn_agregar.addActionListener(this);
        this.VistaA.btn_buscar.addActionListener(this);
        this.VistaA.btn_editar.addActionListener(this);
        this.VistaA.txt_detalles.addActionListener(this);
        this.VistaA.txt_marca.addActionListener(this);
        this.VistaA.txt_modelo.addActionListener(this);
        this.VistaA.txt_precio.addActionListener(this);
        this.VistaE.btn_eliminar.addActionListener(this);
        this.VistaE.txt_eliminar.addActionListener(this);

    }

    public void start() {
        VistaA.setTitle("modelos");
        VistaA.setLocationRelativeTo(null);
    }

//pa guardar @_@
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VistaA.btn_agregar) {
            pro.setModelo(VistaA.txt_modelo.getText());
            pro.setMarca(VistaA.txt_marca.getText());
            pro.setDetalles(VistaA.txt_detalles.getText());
            pro.setPrecio(Integer.parseInt(VistaA.txt_precio.getText()));
            if (proC.registrar(pro)) {
                JOptionPane.showMessageDialog(null, "Modelo Guardado");
                clean();
            } else {
                JOptionPane.showMessageDialog(null, "error al guardar");
                clean();
            }
        }/// fin guardar

        //pa modificar
        if (e.getSource() == VistaA.btn_editar) {
            pro.setId(Integer.parseInt(VistaA.txt_id.getText()));
            pro.setModelo(VistaA.txt_modelo.getText());
            pro.setMarca(VistaA.txt_marca.getText());
            pro.setDetalles(VistaA.txt_detalles.getText());
            pro.setPrecio(Integer.parseInt(VistaA.txt_precio.getText()));
            if (proC.modificar(pro)) {
                JOptionPane.showMessageDialog(null, "celular modificado");
                clean();
            } else {
                JOptionPane.showMessageDialog(null, "error al modificar");
                clean();
            }
        } //fin modificar

        // pa hacer la eliminacion
        if (e.getSource() == VistaE.btn_eliminar) {
            pro.setId(Integer.parseInt(VistaE.txt_eliminar.getText()));

            if (proC.eliminar(pro)) {
                JOptionPane.showMessageDialog(null, "Celular eliminado");
                clean();
            /*nop, no muestra el mensajeee}else if(proC.eliminar(pro)){
                JOptionPane.showMessageDialog(null, "No existe celular");
                clean();*/
            } else {
                JOptionPane.showMessageDialog(null, "error al eliminar");
            }
        }//fineliminar

        //pa buscar
        if (e.getSource() == VistaA.btn_buscar) {
            pro.setId(Integer.parseInt(VistaA.txt_id.getText()));

            if (proC.buscar(pro)) {
                VistaA.txt_modelo.setText(pro.getModelo());
                VistaA.txt_marca.setText(pro.getMarca());
                VistaA.txt_detalles.setText(pro.getDetalles());
                VistaA.txt_precio.setText(String.valueOf(pro.getPrecio()));
                JOptionPane.showMessageDialog(null,"Celular encontrado c: ! ");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado celular :C !");
                clean();
            }
        }//fin buscar
    }//fin O.R

    //pa limpiar
    public void clean() {
        VistaA.txt_modelo.setText(null);
        VistaA.txt_marca.setText(null);
        VistaA.txt_detalles.setText(null);
        VistaA.txt_precio.setText(null);
    }//fin limpiar @_@
}//end all