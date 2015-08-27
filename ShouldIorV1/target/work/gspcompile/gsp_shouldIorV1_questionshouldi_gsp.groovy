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
for( _it2041386868 in (question) ) {
changeItVariable(_it2041386868)
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':("/"),'property':("og:url"),'content':("http://localhost:8080/ShouldIorV1/")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':("/"),'property':("og:type"),'content':("website")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':("/"),'property':("og:title"),'content':("ShouldI.fm")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',16,['gsp_sm_xmlClosingForEmptyTag':("/"),'property':("og:description"),'content':(it.questionTitle)],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',17,['gsp_sm_xmlClosingForEmptyTag':("/"),'property':("og:image"),'content':("http://localhost:8080/ShouldIorV1/Question/getAnswerOneImageById/${it.questionID}")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(2, {->
createClosureForHtmlPart(8, 3)
invokeTag('captureTitle','sitemesh',21,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',21,[:],2)
printHtmlPart(9)
invokeTag('resource','g',24,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(10)
invokeTag('resource','g',25,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(11)
invokeTag('resource','g',28,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(12)
invokeTag('javascript','g',32,['src':("facebookLogin.js")],-1)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',41,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
if(true && (session.name)) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(percentDiff)
printHtmlPart(19)
expressionOut.print(voted)
printHtmlPart(20)
expressionOut.print(answerOneVote)
printHtmlPart(21)
expressionOut.print(answerTwoVote)
printHtmlPart(22)
expressionOut.print(answerThreeVote)
printHtmlPart(23)
expressionOut.print(answerFourVote)
printHtmlPart(24)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(25)
if(true && (session.name)) {
printHtmlPart(26)
expressionOut.print(session.name)
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
for( _it105856166 in (question) ) {
changeItVariable(_it105856166)
printHtmlPart(30)
expressionOut.print(it.questionID)
printHtmlPart(31)
expressionOut.print(it.userID)
printHtmlPart(32)
expressionOut.print(it.questionTitle)
printHtmlPart(33)
expressionOut.print(it.questionID)
printHtmlPart(34)
expressionOut.print(raw(it.question))
printHtmlPart(35)
expressionOut.print(it.answerOneVotes)
printHtmlPart(36)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(questionID)
printHtmlPart(39)
invokeTag('javascript','g',304,['src':("dataAccess.js")],-1)
printHtmlPart(40)
invokeTag('resource','g',306,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',343,['style':("  ")],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1440632624643L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
