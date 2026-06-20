package com.newscred.newscred.controller;

import com.newscred.newscred.dto.AnalysisRequest;
import com.newscred.newscred.entity.Analysis;
import com.newscred.newscred.service.AnalysisService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;

    public AnalysisController(
            AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping
    public Analysis analyze(
            @RequestBody AnalysisRequest request) {

        return analysisService.analyze(
                request,
                "lance@example.com"
        );
    }

    @GetMapping("/history")
    public List<Analysis> history() {

    return analysisService.getHistory(
            "lance@example.com"
    );
}
}