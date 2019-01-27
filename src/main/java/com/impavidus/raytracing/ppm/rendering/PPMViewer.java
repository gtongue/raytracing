package com.impavidus.raytracing.ppm.rendering;

import javax.swing.*;

public class PPMViewer extends JFrame {
    public PPMViewer(PPMRenderer ppmRenderer){
        this.setSize(ppmRenderer.getWidth(), ppmRenderer.getHeight());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(new PPMPanel(ppmRenderer));
        this.setVisible(true);
    }
}

class PPMPanel extends JPanel {
    public PPMPanel(PPMRenderer ppmRenderer){

    }
}