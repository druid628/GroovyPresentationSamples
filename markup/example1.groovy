#!/usr/bin/groovy
import groovy.xml.MarkupBuilder

def html = new MarkupBuilder()
buildHtml(html)

def buildHtml(html) 
{
	html.html {
		head {
			title "Far Out Man!"
		}
		body {
            h1 (class:"header", "Welcome to the Groovy Markup Builder")
				br()
                hr()
            div(class:"bodyContent") { 
              p ( "lots and lots of text!" )
            }
			a ( href:"http://www.druid628.com", "Script Created by DruiD628.com")
		}
	}
}


