package org.example.mower;

import org.example.lawn.Lawn;

public interface Mower {
    void executeInstructions(String instructions, Lawn lawn);
    String getPosition();
}
