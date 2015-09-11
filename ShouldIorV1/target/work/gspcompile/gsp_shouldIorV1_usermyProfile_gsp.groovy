import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_usermyProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/myProfile.gsp" }
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
invokeTag('resource','g',13,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(5)
invokeTag('resource','g',14,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',16,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(7)
invokeTag('javascript','g',18,['src':("facebookLogin.js")],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
expressionOut.print(createLink(controller:'ShouldI', action: 'home'))
printHtmlPart(11)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(12)
if(true && (session.name)) {
printHtmlPart(13)
expressionOut.print(createLink(controller:'Question', action: 'askShouldI'))
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (session.name)) {
printHtmlPart(17)
expressionOut.print(session.userID)
printHtmlPart(18)
expressionOut.print(session.name)
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(session.name)
printHtmlPart(22)
expressionOut.print(session.userID)
printHtmlPart(23)
for( _it1615804266 in (question) ) {
changeItVariable(_it1615804266)
printHtmlPart(24)
expressionOut.print(it.questionID)
printHtmlPart(25)
if(true && (it.answerOneImage)) {
printHtmlPart(26)
expressionOut.print(it.questionID)
printHtmlPart(27)
}
else {
printHtmlPart(28)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(29)
}
printHtmlPart(30)
expressionOut.print(it.userName)
printHtmlPart(31)
expressionOut.print(it.questionTitle)
printHtmlPart(32)
expressionOut.print(it.totalVotes)
printHtmlPart(33)
}
printHtmlPart(34)
createClosureForHtmlPart(35, 2)
invokeTag('link','g',154,['action':("myProfile"),'params':([offset: offset, up: 'false']),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(36)
createClosureForHtmlPart(37, 2)
invokeTag('link','g',158,['action':("myProfile"),'params':([offset: offset, up: 'true']),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(38)
invokeTag('javascript','g',172,['src':("dataAccess.js")],-1)
printHtmlPart(39)
invokeTag('resource','g',173,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(40)
invokeTag('javascript','g',174,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',189,[:],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441929407213L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
