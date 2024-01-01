package com.github.muirandy.docs.living.api.runs;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MultipleTestRuns {
    private List<SingleTestSuiteRun> multipleTestRuns = new ArrayList<>();

    public MultipleTestRuns() {
    }

    public Optional<SingleTestSuiteRun> getLatestSingleTestRunForContainer(String containerId) {
        return multipleTestRuns.stream()
                .filter(r -> r.getContainerId().equals(containerId))
                .findFirst();
    }

    public Optional<SingleTestSuiteRun> getLatestSingleTestRunForContainerAndTestRunId(String containerId, String testRunId) {
        return multipleTestRuns.stream()
                .filter(r -> r.getContainerId().equals(containerId))
                .filter(r -> r.getTestRunId().equals(testRunId))
                .findFirst();
    }

    public MultipleTestRuns(List<SingleTestSuiteRun> multipleTestRuns) {
        this.multipleTestRuns = multipleTestRuns;
    }

    public void add(SingleTestSuiteRun singleTestSuiteRun) {
        multipleTestRuns.add(singleTestSuiteRun);
    }

    public List<SingleTestSuiteRun> getMultipleTestRuns() {
        return multipleTestRuns;
    }

    public void setMultipleTestRuns(List<SingleTestSuiteRun> multipleTestRuns) {
        this.multipleTestRuns = multipleTestRuns;
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
