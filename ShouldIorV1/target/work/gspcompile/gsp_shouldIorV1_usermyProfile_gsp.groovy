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
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(24)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(user.userName)
printHtmlPart(28)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID]))
printHtmlPart(29)
invokeTag('formatDate','g',91,['format':("MM-dd-yyyy"),'date':(user.dateCreated)],-1)
printHtmlPart(30)
expressionOut.print(user.peopleReached)
printHtmlPart(31)
expressionOut.print(opQuestionCount)
printHtmlPart(32)
expressionOut.print(user.totalVotes)
printHtmlPart(33)
if(true && (user.about != '')) {
printHtmlPart(34)
expressionOut.print(createLink(controller:'User', action: 'editAbout'))
printHtmlPart(35)
expressionOut.print(raw(user.about))
printHtmlPart(36)
}
else {
printHtmlPart(34)
expressionOut.print(createLink(controller:'User', action: 'editAbout'))
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(category)
printHtmlPart(39)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(40)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(41)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Favorites']))
printHtmlPart(42)
if(true && (question.isEmpty())) {
printHtmlPart(43)
}
printHtmlPart(44)
for( _it1330901425 in (question) ) {
changeItVariable(_it1330901425)
printHtmlPart(45)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(46)
if(true && (it.answerOneImage)) {
printHtmlPart(47)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(48)
}
else {
printHtmlPart(49)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(it.userName)
printHtmlPart(52)
if(true && (it.opNotifyVoteCount > 0)) {
printHtmlPart(53)
expressionOut.print(it.opNotifyVoteCount)
printHtmlPart(54)
}
printHtmlPart(55)
expressionOut.print(it.questionTitle)
printHtmlPart(56)
expressionOut.print(it.totalVotes)
printHtmlPart(57)
expressionOut.print(it.totalViews)
printHtmlPart(58)
}
printHtmlPart(59)
createClosureForHtmlPart(60, 2)
invokeTag('link','g',177,['action':("myProfile"),'params':([offset: offset, up: 'false', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(61)
createClosureForHtmlPart(62, 2)
invokeTag('link','g',181,['action':("myProfile"),'params':([offset: offset, up: 'true', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(63)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(64)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(65)
invokeTag('javascript','g',221,['src':("dataAccess.js")],-1)
printHtmlPart(66)
invokeTag('resource','g',222,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(67)
invokeTag('javascript','g',223,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(68)
})
invokeTag('captureBody','sitemesh',238,[:],1)
printHtmlPart(69)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443376176627L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
