package controlador;

//trabajar las ventanas, pa que se cierren y se abran

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vista.Principal;
import vista.VistaAgregar;
import vista.VistaEliminar;

public class ControladorVentana implements ActionListener {

    Principal principal;
    VistaAgregar VistaAa;
    VistaEliminar VistaEe;

    public ControladorVentana(Principal principal, VistaAgregar VistaAa, VistaEliminar VistaEe) {
        this.principal = principal;
        this.VistaAa = VistaAa;
        this.VistaEe = VistaEe;
        this.principal.btn_agregarm.addActionListener(this);
        this.principal.btn_eliminarm.addActionListener(this);
        this.VistaAa.btn_returna.addActionListener(this);
        this.VistaEe.btn_returne.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.btn_agregarm) {
            VistaAa.setVisible(true);
            principal.dispose();
        } else if (e.getSource() == principal.btn_eliminarm) {
            VistaEe.setVisible(true);
            principal.dispose();
        } else {
            principal.setVisible(true);
            VistaAa.dispose();
            VistaEe.dispose();
        }
    }
}