import groovy.json.*

def slurper = new JsonSlurper();
def json = '{"person":{"name":"Micah Breedlove","handle":"DruiD628","age":29,"pets":["dog","cat"]}}';
def result = slurper.parseText(json);

result.person.each{ key, value  ->
    println(value)
}

