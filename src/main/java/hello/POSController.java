package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pos")
public class POSController {

    @Autowired
    public Tagger tagger;

    @RequestMapping(method = RequestMethod.GET, params= {"sentence"})
    public String sendPOSTags(@RequestParam(value="sentence") String sentence) {
        return tagger.taggedWords(sentence);
    }

}
