package com.exam.service;

import com.exam.dto.EvaluationDtoRequest;
import com.flipt.api.client.evaluate.exceptions.EvaluateException;
import com.flipt.api.client.evaluate.types.EvaluationRequest;
import com.flipt.api.client.evaluate.types.EvaluationResponse;
import com.flipt.api.client.flags.types.Flag;

import java.util.HashMap;

public interface FeatureFlagService {

    /**
     * A simple Boolean feature flag that returns either true or false for all users.
     */
    Boolean isGlobalBooleanFeatureActive();

    EvaluationResponse evaluate(String user_email_address, EvaluationDtoRequest evaluationDtoRequest) throws EvaluateException;

    Flag FliptEvaluate(String flagKey);
}
