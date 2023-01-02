package com.github.muirandy.docs.living.api;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class NoOpDiagramLoggerShould {
    @Test
    void doNothing() {
        DiagramLogger noOpDiagramLogger = new NoOpDiagramLogger();
        Log log = new Log("protocol", "source", "target", "message", "body");
        noOpDiagramLogger.log(log);
        noOpDiagramLogger.markEnd("id");
        noOpDiagramLogger.markGoldenMaster("id");

        assertThat(noOpDiagramLogger.read()).isEqualTo(new Logs());
        assertThat(noOpDiagramLogger.read("id")).isEqualTo(new Logs());
        assertThat(noOpDiagramLogger.readGoldenMaster("id")).isEqualTo(Collections.emptyList());
    }
}
