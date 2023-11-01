package com.github.muirandy.docs.living.api.runs;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MultipleTestRuns {
    private List<SingleTestRun> multipleTestRuns = new ArrayList<>();

    public MultipleTestRuns() {
    }

    public Optional<SingleTestRun> getLatestSingleTestRunForContainer(String containerId) {
        return multipleTestRuns.stream()
                .filter(r -> r.getContainerId().equals(containerId))
                .findFirst();
    }

    public Optional<SingleTestRun> getLatestSingleTestRunForContainerAndTestRunId(String containerId, String testRunId) {
        return multipleTestRuns.stream()
                .filter(r -> r.getContainerId().equals(containerId))
                .filter(r -> r.getTestRunId().equals(testRunId))
                .findFirst();
    }

    public MultipleTestRuns(List<SingleTestRun> multipleTestRuns) {
        this.multipleTestRuns = multipleTestRuns;
    }

    public void add(SingleTestRun singleTestRun) {
        multipleTestRuns.add(singleTestRun);
    }

    public List<SingleTestRun> getMultipleTestRuns() {
        return multipleTestRuns;
    }

    public void setMultipleTestRuns(List<SingleTestRun> multipleTestRuns) {
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
