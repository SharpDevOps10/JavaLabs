package com.daniorerio.Task3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Decryptor extends FilterInputStream {
    private final int keyOffset;
    private static final Logger logger = LogManager.getLogger(Decryptor.class);
    public Decryptor(InputStream in, char keyChar) {
        super(in);
        this.keyOffset = keyChar;
    }

    @Override
    public int read() throws IOException {
        int b = super.read();
        if (b == -1) return -1;
        logger.debug("Розшифрування байта: {}", b);
        return b - keyOffset;
    }
}