package com.exam.service.flipt;

import com.exam.dto.EvaluationDtoRequest;
import com.exam.service.FeatureFlagService;
import com.flipt.api.FliptApiClient;
import com.flipt.api.client.evaluate.endpoints.Evaluate;
import com.flipt.api.client.evaluate.exceptions.EvaluateException;
import com.flipt.api.client.evaluate.types.EvaluationRequest;
import com.flipt.api.client.evaluate.types.EvaluationResponse;
import com.flipt.api.client.flags.endpoints.Get;
import com.flipt.api.client.flags.exceptions.GetException;
import com.flipt.api.client.flags.types.Flag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class FliptFeatureFlagService implements FeatureFlagService {
    private final Logger logger = LoggerFactory.getLogger(FliptFeatureFlagService.class);

    //    @Autowired
    private FliptApiClient fliptApiClient;

    public FliptFeatureFlagService(FliptApiClient fliptApiClient) {
        this.fliptApiClient = fliptApiClient;
    }

    @Override
    public Boolean isGlobalBooleanFeatureActive() {
        return false;
    }

    @Override
    public EvaluationResponse evaluate(String user_email_address, EvaluationDtoRequest evaluationDtoRequest)
            throws EvaluateException {

        String entityId = evaluationDtoRequest.getEntityId();
        String requestId = entityId + ":" + user_email_address;

        return this.fliptApiClient.evaluate().
                evaluate(Evaluate.Request.builder()
                        .body(EvaluationRequest
                                .builder()
                                .flagKey(evaluationDtoRequest.getFlagKey())
                                .entityId(entityId)
                                .requestId(requestId)
                                .context(evaluationDtoRequest.getContext())
                                .build()).build());
    }

    @Override
    public Flag FliptEvaluate(String flagKey) {
        try {
            Flag flag = this.fliptApiClient.flags().get(Get.Request.builder()
                    .key("feature-button-color")
                    .build());
            System.out.println("Successfully fetched flag with id" + flag.getKey());
            return flag;
        } catch (GetException e) {
            System.out.println("Encountered error while getting flag" + e.getMessage());
        }

        return null;
    }

}
