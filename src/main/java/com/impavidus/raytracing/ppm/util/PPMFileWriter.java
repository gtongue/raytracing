package com.impavidus.raytracing.ppm.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Slf4j
public class PPMFileWriter {
    private PrintWriter makeNewFile(String filename) {
        PrintWriter pw = null;
        try {
            File file = new File("target/ppm_renders/" + filename);
            file.getParentFile().mkdirs();
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            log.error("Problem creating file {} with error {}", filename, e.toString());
        }
        return pw;
    }

    public void writePPMToFile(String ppmFileContents) {
        String filename = LocalDateTime.now().toString() + ".ppm";
        log.info("Rendering PPM {}", filename);
        PrintWriter printWriter = makeNewFile(filename);
        printWriter.write(ppmFileContents);
        printWriter.close();
        log.info("{} Rendered Successfully", filename);
    }
}
