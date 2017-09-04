package hello;

import edu.stanford.nlp.coref.data.DocumentPreprocessor;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.nndep.DependencyParser;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.util.logging.Redwood;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.List;

@Component
public class DependencyDemo {

    private static Redwood.RedwoodChannels log = Redwood.channels(DependencyDemo.class);


    public final DependencyParser depParser;

    public DependencyDemo(DependencyParser depParser) { this.depParser = depParser; }

    public final MaxentTagger tagger;

    public DependencyDemo(MaxentTagger tagger) {this.tagger = tagger;}


    public String returnDeps(String sentence) {
        DocumentPreprocessor tokenizer = new DocumentPreprocessor(new StringReader(sentence));

        List<TaggedWord> tagged = tagger.tagSentence(tokenizer.toString());
            GrammaticalStructure gs = depParser.predict(tagged);

            // Print typed dependencies
            return gs.toString());
    }


}