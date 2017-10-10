package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dependency")
public class DependencyController {

    @Autowired
    public DependencyDemo depper;

    @RequestMapping(method = RequestMethod.GET, params = {"sentence"})
    public String sendDependencies(@RequestParam(value="sentence") String sentence) {return depper.returnDeps(sentence);}
}
