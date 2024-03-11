package com.lukasluknar.model;

import java.io.Serializable;
import java.util.Scanner;

public interface Settable extends Serializable {
    void setValue(Scanner scanner);
}
