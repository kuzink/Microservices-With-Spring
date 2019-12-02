package demo.service;

import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

    private WordService wordService;

    public SentenceServiceImpl(WordService wordService) {
        this.wordService = wordService;
    }

    public String buildSentence() {
        return String.format("%s %s %s %s %s.",
				wordService.getSubject(),
                wordService.getVerb(),
                wordService.getArticle(),
                wordService.getAdjective(),
                wordService.getNoun());
    }
}
