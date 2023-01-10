package com.exam.controller;

import com.exam.dto.EvaluationDtoRequest;
import com.exam.helper.MapNullOrEmpty;
import com.exam.model.User;
import com.exam.service.flipt.FliptFeatureFlagService;
import com.flipt.api.client.evaluate.types.EvaluationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flipt")
@CrossOrigin("*")
public class FliptController {

    @Autowired
    private FliptFeatureFlagService fliptFeatureFlagService;

    @PostMapping("/evaluate")
    public ResponseEntity<EvaluationResponse> createUser(@RequestBody EvaluationDtoRequest evaluationDtoRequest)
            throws Exception {

        if (evaluationDtoRequest == null || MapNullOrEmpty.isNotNullOrEmptyMap(evaluationDtoRequest.getContext())) {
            return (ResponseEntity<EvaluationResponse>) ResponseEntity.badRequest();
        }

        User principal = new User();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            principal = (User) authentication.getPrincipal();
        }

        EvaluationResponse response = this.fliptFeatureFlagService.evaluate(principal.getEmail(), evaluationDtoRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
