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
})
invokeTag('captureHead','sitemesh',31,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
if(true && (session.name)) {
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(percentDiff)
printHtmlPart(15)
expressionOut.print(voted)
printHtmlPart(16)
expressionOut.print(answerOneVote)
printHtmlPart(17)
expressionOut.print(answerTwoVote)
printHtmlPart(18)
expressionOut.print(answerThreeVote)
printHtmlPart(19)
expressionOut.print(answerFourVote)
printHtmlPart(20)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(21)
if(true && (session.name)) {
printHtmlPart(22)
expressionOut.print(session.name)
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
for( _it516952715 in (question) ) {
changeItVariable(_it516952715)
printHtmlPart(26)
expressionOut.print(it.questionID)
printHtmlPart(27)
expressionOut.print(it.userID)
printHtmlPart(28)
expressionOut.print(it.questionTitle)
printHtmlPart(29)
expressionOut.print(it.questionID)
printHtmlPart(30)
expressionOut.print(raw(it.question))
printHtmlPart(31)
expressionOut.print(it.answerOneVotes)
printHtmlPart(32)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(33)
}
printHtmlPart(34)
for( _it1394205948 in (comments) ) {
changeItVariable(_it1394205948)
printHtmlPart(35)
expressionOut.print(it.userID)
printHtmlPart(36)
expressionOut.print(it.userName)
printHtmlPart(37)
expressionOut.print(it.comment)
printHtmlPart(38)
expressionOut.print(it.voteDiff)
printHtmlPart(39)
}
printHtmlPart(40)
invokeTag('javascript','g',350,['src':("dataAccess.js")],-1)
printHtmlPart(41)
invokeTag('resource','g',352,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',383,['style':("  ")],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1440365512032L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
