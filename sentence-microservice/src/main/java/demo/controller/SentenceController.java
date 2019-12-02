package demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import demo.service.SentenceService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceController {

    private SentenceService sentenceService;

    public SentenceController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @GetMapping("/sentence")
	public String getSentence() {
		return sentenceService.buildSentence();
	}
}
