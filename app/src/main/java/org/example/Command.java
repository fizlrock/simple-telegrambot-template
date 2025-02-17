package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/** Command */
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

  String value();
}
