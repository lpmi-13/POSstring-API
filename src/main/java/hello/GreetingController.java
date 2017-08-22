package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pos")
public class GreetingController {

    @Autowired
    public Tagger tagger;

    @RequestMapping(method = RequestMethod.GET, params= {"sentence"})
    public String respond(@RequestParam(value="sentence") String sentence) {
        return tagger.taggedWords(sentence);
    }

}
