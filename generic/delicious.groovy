#!/usr/bin/groovy
/**
 *  Del.icio.us RSS to HTML converter
 * commandline groovy script execution requires 1 command line argument
 * with 1 optional argument
 *
 * syntax:
 *    groovy delicious http://feeds.delicious.com/v2/rss/<user>?private=<key>\&count=<count> [ /path/to/output/file ]
 *
 *    URL - the url passed should be the rss feed [public or private] with a count larger than the number of
 *         bookmarks contained on that account (del.icio.us defaults to 15)
 *
 *    /path/to/output/file - optional parameter defaults to current working directory allows user to specify a location
 *         in which the html output file can be stored
 *
 *
 * @author: Micah Breedlove a.k.a. DruiD628
 * http://www.druid628.com
 * 10 December, 2010
 */

import groovy.xml.MarkupBuilder

if ( args.size() == 0 )
{
	getHelpText();
}

def getHelpText() {
	println("No URL PASSED!")
	println("Syntax: \n groovy delicious http://url.to.del.icio.us.rss.feed [optional: /path/to/output/file]\n")
	println("If no optional path to output file is passed script will put output file in working directory\n\n-DruiD628")
	System.exit(0)
}

def buildHtml(html, delicious) {

	def num = 1
	html.html {
		head {
			title "${delicious.channel.description}"
		}
		body {
			for ( item in delicious.channel.item )
			{
				a ( href: item.link, "${num}. ${item.title}" )

				if( item.category.size() > 0)
				{

					ul {
						for ( category in item.category )
						{
							if(!category.toString().contains("system:"))
							{
								li ("${category}")
							}
						}
					}
				}
				else
				{
					br()
				}
				num++
			}
			a ( href:"http://www.druid628.com", "Script Created by DruiD628.com")
		}
	}
}


def url = args[0]
def delicious = new XmlSlurper().parseText("${url}".toURL().text)
def writer = new StringWriter()
def html = new MarkupBuilder(writer)
def outputFile;

if (args.size() == 2)
{
	outputFile = new File(args[1])
}
else
{
	outputFile = new File('deliciousBookMarks.html')
}
buildHtml(html, delicious)
outputFile.write(writer.toString())
