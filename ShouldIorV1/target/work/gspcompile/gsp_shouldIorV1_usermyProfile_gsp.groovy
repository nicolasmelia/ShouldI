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
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(11)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(12)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(13)
if(true && (session.name)) {
printHtmlPart(14)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(15)
expressionOut.print(notifyCount)
printHtmlPart(16)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(17)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(18)
}
else {
printHtmlPart(19)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(18)
}
printHtmlPart(20)
if(true && (session.name)) {
printHtmlPart(21)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(22)
expressionOut.print(session.name)
printHtmlPart(23)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(24)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(25)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(26)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(27)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(28)
}
else {
printHtmlPart(29)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(30)
}
printHtmlPart(31)
expressionOut.print(user.userName)
printHtmlPart(32)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID]))
printHtmlPart(33)
invokeTag('formatDate','g',94,['format':("MM-dd-yyyy"),'date':(user.dateCreated)],-1)
printHtmlPart(34)
expressionOut.print(user.peopleReached)
printHtmlPart(35)
expressionOut.print(opQuestionCount)
printHtmlPart(36)
expressionOut.print(user.totalVotes)
printHtmlPart(37)
if(true && (user.about != '')) {
printHtmlPart(38)
expressionOut.print(createLink(controller:'User', action: 'editAbout'))
printHtmlPart(39)
expressionOut.print(raw(user.about))
printHtmlPart(40)
}
else {
printHtmlPart(38)
expressionOut.print(createLink(controller:'User', action: 'editAbout'))
printHtmlPart(41)
}
printHtmlPart(42)
expressionOut.print(category)
printHtmlPart(43)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(44)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(45)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Favorites']))
printHtmlPart(46)
if(true && (question.isEmpty())) {
printHtmlPart(47)
}
printHtmlPart(48)
for( _it1326245948 in (question) ) {
changeItVariable(_it1326245948)
printHtmlPart(49)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(50)
if(true && (it.answerOneImage)) {
printHtmlPart(51)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(52)
}
else {
printHtmlPart(53)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(54)
}
printHtmlPart(55)
expressionOut.print(it.userName)
printHtmlPart(56)
if(true && (it.opNotifyVoteCount > 0 && session.userID == it.userID)) {
printHtmlPart(57)
expressionOut.print(it.opNotifyVoteCount)
printHtmlPart(58)
}
printHtmlPart(59)
expressionOut.print(it.questionTitle)
printHtmlPart(60)
expressionOut.print(it.totalVotes)
printHtmlPart(61)
expressionOut.print(it.totalViews)
printHtmlPart(62)
}
printHtmlPart(63)
createClosureForHtmlPart(64, 2)
invokeTag('link','g',179,['action':("myProfile"),'params':([offset: offset, up: 'false', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(65)
createClosureForHtmlPart(66, 2)
invokeTag('link','g',183,['action':("myProfile"),'params':([offset: offset, up: 'true', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(67)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(68)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(69)
invokeTag('javascript','g',223,['src':("dataAccess.js")],-1)
printHtmlPart(70)
invokeTag('resource','g',224,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(71)
invokeTag('javascript','g',225,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(72)
})
invokeTag('captureBody','sitemesh',240,[:],1)
printHtmlPart(73)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443487780871L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
