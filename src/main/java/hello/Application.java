package hello;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.parser.nndep.DependencyParser;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static edu.stanford.nlp.parser.lexparser.LexicalizedParser.loadModel;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application{

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MaxentTagger tagger() {return new MaxentTagger("edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");}

    @Bean
    public DependencyParser depParser() { return DependencyParser.loadFromModelFile("edu/stanford/nlp/models/parser/nndep/english_UD.gz"); }

    @Bean
    public AbstractSequenceClassifier classifier() { return CRFClassifier.getClassifierNoExceptions("edu/stanford/nlp/models/ner/english.all.3class.distsim.crf.ser.gz");}

    @Bean
    public LexicalizedParser parser() {
        return loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
    }

}
