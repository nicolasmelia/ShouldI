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
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(11)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(12)
if(true && (session.name)) {
printHtmlPart(13)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(14)
expressionOut.print(notifyCount)
printHtmlPart(15)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(16)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(17)
}
else {
printHtmlPart(18)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(17)
}
printHtmlPart(19)
if(true && (session.name)) {
printHtmlPart(20)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(21)
expressionOut.print(session.name)
printHtmlPart(22)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(23)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(user.name)
printHtmlPart(27)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID]))
printHtmlPart(28)
invokeTag('formatDate','g',89,['format':("MM-dd-yyyy"),'date':(user.dateCreated)],-1)
printHtmlPart(29)
expressionOut.print(user.peopleReached)
printHtmlPart(30)
expressionOut.print(opQuestionCount)
printHtmlPart(31)
expressionOut.print(user.totalVotes)
printHtmlPart(32)
if(true && (user.about != '')) {
printHtmlPart(33)
expressionOut.print(raw(user.about))
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print(category)
printHtmlPart(37)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [category: 'New Questions', id: user.userID]))
printHtmlPart(38)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [category: 'Top Questions', id: user.userID]))
printHtmlPart(39)
if(true && (question.isEmpty())) {
printHtmlPart(40)
}
printHtmlPart(41)
for( _it1568672342 in (question) ) {
changeItVariable(_it1568672342)
printHtmlPart(42)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(43)
if(true && (it.answerOneImage)) {
printHtmlPart(44)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(45)
}
else {
printHtmlPart(46)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(47)
}
printHtmlPart(48)
expressionOut.print(it.userName)
printHtmlPart(49)
expressionOut.print(it.questionTitle)
printHtmlPart(50)
expressionOut.print(it.totalVotes)
printHtmlPart(51)
}
printHtmlPart(52)
createClosureForHtmlPart(53, 2)
invokeTag('link','g',169,['action':("profile"),'params':([offset: offset, up: 'false', category: category, id: user.userID ]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(54)
createClosureForHtmlPart(55, 2)
invokeTag('link','g',173,['action':("profile"),'params':([offset: offset, up: 'true', category: category, id : user.userID]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(56)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(57)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(58)
invokeTag('javascript','g',212,['src':("dataAccess.js")],-1)
printHtmlPart(59)
invokeTag('resource','g',213,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(60)
invokeTag('javascript','g',214,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(61)
})
invokeTag('captureBody','sitemesh',229,[:],1)
printHtmlPart(62)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443402695368L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
