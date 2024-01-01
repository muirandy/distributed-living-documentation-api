package com.github.muirandy.docs.living.api.runs;

import com.github.muirandy.docs.living.api.Logs;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class SingleTestSuiteRun {
    private String containerId;
    private String testRunId;
    private Map<String, Logs> logsForTestRun;

    public SingleTestSuiteRun() {
    }

    public SingleTestSuiteRun(String containerId, String testRunId, Map<String, Logs> logsForTestRun) {
        this.containerId = containerId;
        this.testRunId = testRunId;
        this.logsForTestRun = logsForTestRun;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getTestRunId() {
        return testRunId;
    }

    public void setTestRunId(String testRunId) {
        this.testRunId = testRunId;
    }

    public Map<String, Logs> getLogsForTestRun() {
        return logsForTestRun;
    }

    public void setLogsForTestRun(Map<String, Logs> logsForTestRun) {
        this.logsForTestRun = logsForTestRun;
    }

    public Optional<Collection<Logs>> listOfLogsForTestRun() {
        return (logsForTestRun == null) ? Optional.empty() : Optional.of(logsForTestRun.values());
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
