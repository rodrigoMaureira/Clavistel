package clavistel;
//main class
import controlador.ControladorProducto;
import controlador.ControladorVentana;
import modelo.ConsultaProducto;
import modelo.Producto;
import vista.Principal;
import vista.VistaAgregar;
import vista.VistaEliminar;

public class Clavistel {

    public static void main(String[] args) {
        Producto pro = new Producto();
        ConsultaProducto proC = new ConsultaProducto();
        VistaAgregar VistaA = new VistaAgregar();
        VistaEliminar VistaE = new VistaEliminar();
        ControladorProducto ctrl = new ControladorProducto(pro, proC, VistaA, VistaE);
        Principal frmP = new Principal();
        ControladorVentana ctrlV = new ControladorVentana(frmP, VistaA, VistaE);
        ctrl.start();
        frmP.setVisible(true);
    }

}
