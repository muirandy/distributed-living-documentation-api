package com.github.muirandy.docs.living.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoOpDiagramLoggerShould {
    @Test
    void doNothing() {
        DiagramLogger noOpDiagramLogger = new NoOpDiagramLogger();
        Log log = new Log("protocol", "message", "body");
        noOpDiagramLogger.log(log);
        noOpDiagramLogger.markEnd("id");
        assertThat(noOpDiagramLogger.read()).isEqualTo(new Logs());
        assertThat(noOpDiagramLogger.read("id")).isEqualTo(new Logs());
    }
}
