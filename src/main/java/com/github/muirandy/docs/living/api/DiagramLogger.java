package com.github.muirandy.docs.living.api;

public interface DiagramLogger {

    void log(Log log);

    Logs read();

    void markEnd(String sequence_diagram_id);

    Logs read(String logId);
}
