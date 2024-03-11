package com.lukasluknar.model;

import java.io.Serializable;

public interface Printable extends Serializable {
    String getProperties();
    String getPropertiesKeys();
    String getPropertiesValues();
}
