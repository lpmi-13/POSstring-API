package hello;

import edu.stanford.nlp.coref.data.DocumentPreprocessor;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.nndep.DependencyParser;
import edu.stanford.nlp.process.WhitespaceTokenizer;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.util.logging.Redwood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.List;

@Component
public class DependencyDemo {


    public DependencyParser depParser;
    public MaxentTagger tagger;


    public DependencyDemo(DependencyParser depParser, MaxentTagger tagger) {
        this.depParser = depParser;
        this.tagger = tagger;
    }


    public String returnDeps(String rawText) {
        edu.stanford.nlp.process.DocumentPreprocessor tokenizer = new edu.stanford.nlp.process.DocumentPreprocessor(new StringReader(rawText));

        final StringBuffer typeDependencies = new StringBuffer();

        for (List<HasWord> sentence : tokenizer) {
            List<TaggedWord> tagged = tagger.tagSentence(sentence);
            GrammaticalStructure gs = depParser.predict(tagged);
            typeDependencies.append(gs.toString());
        }
        return typeDependencies.toString();
    }


}