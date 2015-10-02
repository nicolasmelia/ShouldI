import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_shouldIerrorPage404_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/shouldI/errorPage404.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("keywords"),'content':("404 ERROR")],-1)
printHtmlPart(3)
invokeTag('resource','g',6,['dir':("css"),'file':("errorStyle.css")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(7)
expressionOut.print(resource(dir:'images',file:'error-img.png'))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',29,['style':("	background: url(${resource(dir:'images',file:'bg1.png')});")],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443747662812L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
