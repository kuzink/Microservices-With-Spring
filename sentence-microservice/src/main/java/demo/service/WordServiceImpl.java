package demo.service;

import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.dao.AdjectiveClient;
import demo.dao.ArticleClient;
import demo.dao.NounClient;
import demo.dao.SubjectClient;
import demo.dao.VerbClient;
import demo.domain.Word;

@Service
public class WordServiceImpl implements WordService {

	private SubjectClient subjectClient;
	private VerbClient verbClient;
	private ArticleClient articleClient;
	private AdjectiveClient adjectiveClient;
	private NounClient nounClient;

	public WordServiceImpl(SubjectClient subjectClient, VerbClient verbClient, ArticleClient articleClient,
						   AdjectiveClient adjectiveClient, NounClient nounClient) {
		this.subjectClient = subjectClient;
		this.verbClient = verbClient;
		this.articleClient = articleClient;
		this.adjectiveClient = adjectiveClient;
		this.nounClient = nounClient;
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackSubject")
	public Word getSubject() {
		return subjectClient.getWord();
	}
	
	@Override
	public Word getVerb() {
		return verbClient.getWord();
	}
	
	@Override
	public Word getArticle() {
		return articleClient.getWord();
	}
	
	@Override
	public Word getAdjective() {
		return adjectiveClient.getWord();
	}
	
	@Override
	public Word getNoun() {
		return nounClient.getWord();
	}	


	public Word getFallbackSubject() {
		return new Word("Someone");
	}
}
