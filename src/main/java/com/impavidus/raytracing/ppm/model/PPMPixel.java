package com.impavidus.raytracing.ppm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PPMPixel {
    private int r = 0;
    private int g = 0;
    private int b = 255;
}
