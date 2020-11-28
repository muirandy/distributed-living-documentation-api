package com.github.muirandy.docs.living.api;

public interface SequenceDiagramFacade {
    void generate();

    void log(Log log);

    void generate(String sequenceDiagramId);
}
