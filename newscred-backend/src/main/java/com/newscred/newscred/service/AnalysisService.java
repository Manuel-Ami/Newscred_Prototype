package com.newscred.newscred.service;

import com.newscred.newscred.dto.AnalysisRequest;
import com.newscred.newscred.entity.Analysis;
import com.newscred.newscred.repository.AnalysisRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnalysisService {

    private final AnalysisRepository analysisRepository;

    public AnalysisService(
            AnalysisRepository analysisRepository) {

        this.analysisRepository = analysisRepository;
    }

    public Analysis analyze(
            AnalysisRequest request,
            String userEmail) {

        int score = 50;

        String text =
                request.getArticleText().toLowerCase();

        if(text.contains("source"))
            score += 15;

        if(text.contains("research"))
            score += 15;

        if(text.contains("study"))
            score += 10;

        if(text.length() > 500)
            score += 10;

        if(score > 100)
            score = 100;

        String label;

        if(score >= 80)
            label = "Highly Credible";
        else if(score >= 60)
            label = "Moderately Credible";
        else
            label = "Low Credibility";

        Analysis analysis = new Analysis();

        analysis.setArticleText(
                request.getArticleText());

        analysis.setCredibilityScore(score);
        analysis.setCredibilityLabel(label);
        analysis.setUserEmail(userEmail);

        return analysisRepository.save(analysis);
    }

    public List<Analysis> getHistory(String userEmail) {
    return analysisRepository.findByUserEmail(userEmail);
}
}