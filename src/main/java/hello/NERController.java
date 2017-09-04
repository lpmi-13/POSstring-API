package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ner")
public class NERController {

    @Autowired
    public NERclassifier classifier;

    @RequestMapping(method = RequestMethod.GET, params = {"sentence"})
    public String sendNERTags(@RequestParam(value="sentence") String sentence) {return classifier.nerTags(sentence);}
}
