package com.impavidus.raytracing;

import com.impavidus.raytracing.ppm.rendering.PPMRenderer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RaytracingApplication {
    public static void main(String[] args) {
        PPMRenderer ppmRenderer = new PPMRenderer();
        ppmRenderer.setPixelsSampleGradient();
        ppmRenderer.render();
    }
}
