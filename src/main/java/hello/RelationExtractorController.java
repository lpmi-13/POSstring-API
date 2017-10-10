package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relation")
public class RelationExtractorController {

    @Autowired
    public RelationExtractor extractor;

    @RequestMapping(method = RequestMethod.GET, params = {"sentence"})
    public String sendRelations(@RequestParam(value="sentence") String sentence) { return extractor.relations(sentence);}
}