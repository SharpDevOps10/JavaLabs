package com.daniorerio.Task3;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Encryptor extends FilterOutputStream {
    private final int keyOffset;

    public Encryptor(OutputStream out, char keyChar) {
        super(out);
        this.keyOffset = keyChar;
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b + keyOffset);
    }
}