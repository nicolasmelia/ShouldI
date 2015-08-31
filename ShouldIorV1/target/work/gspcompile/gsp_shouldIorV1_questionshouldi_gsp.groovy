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
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
invokeTag('resource','g',12,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(5)
invokeTag('resource','g',13,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',15,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(7)
invokeTag('javascript','g',17,['src':("facebookLogin.js")],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
if(true && (session.name)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(percentDiff)
printHtmlPart(14)
expressionOut.print(vote)
printHtmlPart(15)
expressionOut.print(answerOneVote)
printHtmlPart(16)
expressionOut.print(answerTwoVote)
printHtmlPart(17)
expressionOut.print(answerThreeVote)
printHtmlPart(18)
expressionOut.print(answerFourVote)
printHtmlPart(19)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(20)
if(true && (session.name)) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (session.name)) {
printHtmlPart(24)
expressionOut.print(session.userID)
printHtmlPart(25)
expressionOut.print(session.name)
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
for( _it698336642 in (question) ) {
changeItVariable(_it698336642)
printHtmlPart(29)
expressionOut.print(it.questionID)
printHtmlPart(30)
expressionOut.print(it.userID)
printHtmlPart(31)
expressionOut.print(it.questionTitle)
printHtmlPart(32)
expressionOut.print(it.questionID)
printHtmlPart(33)
expressionOut.print(raw(it.question))
printHtmlPart(34)
expressionOut.print(it.answerOneVotes)
printHtmlPart(35)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(36)
}
printHtmlPart(37)
for( _it811249375 in (questionArray) ) {
changeItVariable(_it811249375)
printHtmlPart(38)
expressionOut.print(it.questionID)
printHtmlPart(39)
if(true && (it.answerOneImage)) {
printHtmlPart(40)
expressionOut.print(it.questionID)
printHtmlPart(41)
}
else {
printHtmlPart(42)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(43)
}
printHtmlPart(44)
expressionOut.print(it.questionTitle)
printHtmlPart(45)
}
printHtmlPart(46)
expressionOut.print(questionID)
printHtmlPart(47)
invokeTag('javascript','g',267,['src':("dataAccess.js")],-1)
printHtmlPart(48)
invokeTag('resource','g',268,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(49)
})
invokeTag('captureBody','sitemesh',302,['style':("  ")],1)
printHtmlPart(50)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1440997707516L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
