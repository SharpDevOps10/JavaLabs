package com.daniorerio.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Encryptor extends FilterOutputStream {
    private final int keyOffset;
    private static final Logger logger = LogManager.getLogger(Encryptor.class);
    public Encryptor(OutputStream out, char keyChar) {
        super(out);
        this.keyOffset = keyChar;
    }

    @Override
    public void write(int b) throws IOException {
        logger.debug("Шифрування байта: {}", b);
        super.write(b + keyOffset);
    }
}