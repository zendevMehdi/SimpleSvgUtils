package org.zendev.lib.svg;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleSvgUtils {
    public static void setComponentIcon(JComponent c, String svgFilePath) throws TranscoderException, IOException {
        setComponentIcon(c, svgFilePath, (float) c.getWidth(), (float) c.getHeight());
    }

    public static void setComponentIcon(JComponent c, String svgFilePath, float width, float height) throws IOException, TranscoderException {
        InputStream svgStream = new ByteArrayInputStream(Files.readAllBytes(Path.of(svgFilePath)));
        byte[] result;

        TranscoderInput input = new TranscoderInput(svgStream);
        PNGTranscoder transcoder = new PNGTranscoder();

        transcoder.addTranscodingHint(PNGTranscoder.KEY_WIDTH, width);
        transcoder.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, height);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        TranscoderOutput output = new TranscoderOutput(outStream);

        transcoder.transcode(new TranscoderInput(input.getInputStream()), new TranscoderOutput(output.getOutputStream()));
        result = outStream.toByteArray();
        outStream.close();

        if (c instanceof JButton btn) {
            btn.setIcon(new ImageIcon(result));
        } else if (c instanceof JLabel label) {
            label.setIcon(new ImageIcon(result));
        } else if (c instanceof JMenuItem mi) {
            mi.setIcon(new ImageIcon(result));
        } else if (c instanceof JToggleButton button) {
            button.setIcon(new ImageIcon(result));
        }
    }
}
