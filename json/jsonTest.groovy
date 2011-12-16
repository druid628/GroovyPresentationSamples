import groovy.json.*

def slurper = new JsonSlurper();
def json = '{"person":{"name":"Micah Breedlove","age":29,"pets":["dog","cat"]}}';
def result = slurper.parseText(json);


System.out.println(result.person.name);
System.out.println(result.person.age);
System.out.println(result.person.pets[1]);
