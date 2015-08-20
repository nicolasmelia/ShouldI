import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_questionshouldi_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/question/shouldi.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
invokeTag('resource','g',14,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',15,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',18,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(8)
invokeTag('javascript','g',22,['src':("facebookLogin.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',23,['src':("dataRequest.js")],-1)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
if(true && (session.name)) {
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(16)
if(true && (session.name)) {
printHtmlPart(17)
expressionOut.print(session.name)
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(resource(dir:'images',file:'blankAv.png'))
printHtmlPart(21)
for( _it1270901310 in (question) ) {
changeItVariable(_it1270901310)
printHtmlPart(22)
expressionOut.print(it.questionID)
printHtmlPart(23)
expressionOut.print(it.questionID)
printHtmlPart(24)
expressionOut.print(raw(it.question))
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('javascript','g',314,['src':("shouldIVote.js")],-1)
printHtmlPart(27)
invokeTag('resource','g',316,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',342,['style':("  ")],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1440037236326L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
