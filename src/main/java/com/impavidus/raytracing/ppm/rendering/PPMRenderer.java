package com.impavidus.raytracing.ppm.rendering;

import com.impavidus.raytracing.ppm.util.PPMFileWriter;
import com.impavidus.raytracing.ppm.model.PPMPixel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PPMRenderer {
    private final String colorType = "P3";
    private final int maxColor = 255;
    private int width = 800;
    private int height = 600;
    private PPMPixel[][] pixels;
    private PPMFileWriter ppmFileWriter;

    public PPMRenderer() {
        initRenderer();
    }

    private void initRenderer() {
        this.pixels = new PPMPixel[width][height];
        for (int x = 0; x < this.pixels.length; x++) {
            for (int y = 0; y < this.pixels[x].length; y++) {
                pixels[x][y] = new PPMPixel();
            }
        }
        this.ppmFileWriter = new PPMFileWriter();
    }

    public void renderToFile(){
        this.ppmFileWriter.writePPMToFile(this.renderSting());
    }

    public void renderToScreen(){

    }

    public String renderSting() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(colorType)
                .append("\n")
                .append(width)
                .append(" ")
                .append(height)
                .append("\n")
                .append(maxColor)
                .append("\n");

        for (int j = height - 1; j >= 0; j--) {
            for (int i = 0; i < width; i++) {
                PPMPixel pixel = pixels[i][j];
                stringBuilder
                        .append(pixel.getR())
                        .append(" ")
                        .append(pixel.getG())
                        .append(" ")
                        .append(pixel.getB())
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void setPixelsSampleGradient() {
        for (int j = height - 1; j >= 0; j--) {
            for (int i = 0; i < width; i++) {
                float r = (float) i / width;
                float g = (float) j / height;
                float b = 0.2f;
                int ir = (int) (255.99f * r);
                int ig = (int) (255.99f * g);
                int ib = (int) (255.99f * b);
                PPMPixel pixel = pixels[i][j];
                pixel.setR(ir);
                pixel.setG(ig);
                pixel.setB(ib);
            }
        }
    }

}
