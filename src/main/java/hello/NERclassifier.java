package hello;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import org.springframework.stereotype.Component;

@Component
public class NERclassifier {

    private final AbstractSequenceClassifier classifier;

    public NERclassifier(AbstractSequenceClassifier classifier) {this.classifier = classifier;};

    public String nerTags(String sentence) {
        return classifier.classifyToString(sentence);
    }
}
