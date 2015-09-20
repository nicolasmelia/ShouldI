import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_userprofile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/profile.gsp" }
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
expressionOut.print(userID)
printHtmlPart(18)
expressionOut.print(session.name)
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(user.name)
printHtmlPart(22)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID]))
printHtmlPart(23)
expressionOut.print(opQuestionCount)
printHtmlPart(24)
expressionOut.print(user.peopleReached)
printHtmlPart(25)
if(true && (user.about != '')) {
printHtmlPart(26)
expressionOut.print(raw(it.about))
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(category)
printHtmlPart(30)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'New Questions']))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'Top Questions']))
printHtmlPart(32)
if(true && (question.isEmpty())) {
printHtmlPart(33)
}
printHtmlPart(34)
for( _it934426842 in (question) ) {
changeItVariable(_it934426842)
printHtmlPart(35)
expressionOut.print(it.questionID)
printHtmlPart(36)
if(true && (it.answerOneImage)) {
printHtmlPart(37)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(38)
}
else {
printHtmlPart(39)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(40)
}
printHtmlPart(41)
expressionOut.print(it.userName)
printHtmlPart(42)
expressionOut.print(it.questionTitle)
printHtmlPart(43)
expressionOut.print(it.totalVotes)
printHtmlPart(44)
}
printHtmlPart(45)
createClosureForHtmlPart(46, 2)
invokeTag('link','g',164,['action':("profile"),'params':([offset: offset, up: 'false', category: category, id: user.userID ]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(47)
createClosureForHtmlPart(48, 2)
invokeTag('link','g',168,['action':("profile"),'params':([offset: offset, up: 'true', category: category, id : user.userID]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(49)
invokeTag('javascript','g',182,['src':("dataAccess.js")],-1)
printHtmlPart(50)
invokeTag('resource','g',183,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(51)
invokeTag('javascript','g',184,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(52)
})
invokeTag('captureBody','sitemesh',199,[:],1)
printHtmlPart(53)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442708929230L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
