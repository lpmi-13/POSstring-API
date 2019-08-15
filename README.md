# POS String API

## Setup (easy version with Docker)

`docker build -t NAME_OF_YOUR_CONTAINER .`

...then

`docker run -p 8080:8080 NAME_OF_YOUR_CONTAINER`

## Setup (non-easy version without Docker)

(do the usual java installation steps, involving setting the JAVA_HOME, etc...)

`apt install maven -y`

install maven


`mvn install`

set up dependencies


`mvn spring-boot:run`

run the API

## using the API

...the service should now be available to query on port 8080 like so:

### POS tagging (part of speech tagging)

`localhost:8080/pos?sentence=this is an example sentence`

should return

`(ROOT (S (NP (DT this)) (VP (VBZ is) (NP (DT an) (NN example) (NN sentence)))))`

### NER (named entity recognition)

`localhost:8080/ner?sentence=Obama is a celebrity in Kenya and Indonesia`

should return

`Obama/PERSON is/O a/O celebrity/O in/O Kenya/LOCATION and/O Indonesia/LOCATION`

### Dependency parsing (syntactical roles/relationships of different words in a sentence)

`localhost:8080/dependency?sentence=this sentence which I am typing has a few dependencies`

should return

`ROOT-0{CharacterOffsetBeginAnnotation=-1, CharacterOffsetEndAnnotation=-1, PartOfSpeechAnnotation=null, TextAnnotation=ROOT}Typed Dependencies: [det(sentence-2, this-1), root(ROOT-0, sentence-2), dobj(typing-6, which-3), nsubj(typing-6, I-4), cop(typing-6, am-5), acl:relcl(sentence-2, typing-6), ccomp(typing-6, has-7), det(dependencies-10, a-8), amod(dependencies-10, few-9), dobj(has-7, dependencies-10)]`


---

These are currently just coming back in the browser (or even curl), and there isn't anything nice like a tidy json response. This was mostly just an experiment with spring boot and the stanford core nlp tooling.
