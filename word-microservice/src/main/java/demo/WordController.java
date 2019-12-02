package demo;
import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WordController {

	@Value("${words}")
	String[] words;
	
	@GetMapping("/")
	public Word getWord() {
		return new Word(words[new Random().nextInt(words.length)]);
	}
}
