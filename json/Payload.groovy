import groovy.json.*
 
 def payload = new URL("http://github.com/api/v2/json/commits/list/grails/grails-core/master").text
  
  def slurper = new JsonSlurper()
  def doc = slurper.parseText(payload)
   
   doc.commits.message.each { println it }
