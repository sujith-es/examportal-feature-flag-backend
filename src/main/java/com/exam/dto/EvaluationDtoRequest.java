package com.exam.dto;

import java.util.Map;
import java.util.Optional;

public class EvaluationDtoRequest {
    private  Optional<String> requestId;

    private  String flagKey;

    private  String entityId;

    private  Map<String, String> context;

    @Override
    public String toString() {
        return "EvaluationDtoRequest{" +
                "requestId=" + requestId +
                ", flagKey='" + flagKey + '\'' +
                ", entityId='" + entityId + '\'' +
                ", context=" + context +
                '}';
    }

    public Optional<String> getRequestId() {
        return requestId;
    }

    public void setRequestId(Optional<String> requestId) {
        this.requestId = requestId;
    }

    public String getFlagKey() {
        return flagKey;
    }

    public void setFlagKey(String flagKey) {
        this.flagKey = flagKey;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public Map<String, String> getContext() {
        return context;
    }

    public void setContext(Map<String, String> context) {
        this.context = context;
    }
}
