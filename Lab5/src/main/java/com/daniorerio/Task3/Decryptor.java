package com.daniorerio.Task3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Decryptor extends FilterInputStream {
    private final int keyOffset;

    public Decryptor(InputStream in, char keyChar) {
        super(in);
        this.keyOffset = keyChar;
    }

    @Override
    public int read() throws IOException {
        int b = super.read();
        if (b == -1) return -1;
        return b - keyOffset;
    }
}