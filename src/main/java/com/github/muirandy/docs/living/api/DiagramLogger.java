package com.github.muirandy.docs.living.api;

import java.util.List;

public interface DiagramLogger {

    void log(Log log);

    Logs read();
    Logs read(String logId);
    List<Logs> readGoldenMaster(String sequence_diagram_id);

    void markEnd(String sequence_diagram_id);
    void markGoldenMaster(String sequence_diagram_id);
}
