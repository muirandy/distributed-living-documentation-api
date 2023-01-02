package com.github.muirandy.docs.living.api;

import java.util.Collections;
import java.util.List;

public class NoOpDiagramLogger implements DiagramLogger {
    @Override
    public void log(Log log) {
    }

    @Override
    public Logs read() {
        return new Logs();
    }

    @Override
    public void markEnd(String sequence_diagram_id) {
    }

    @Override
    public void markGoldenMaster(String sequence_diagram_id) {
    }

    @Override
    public Logs read(String logId) {
        return new Logs();
    }

    @Override
    public List<Logs> readGoldenMaster(String sequence_diagram_id) {
        return Collections.emptyList();
    }
}
