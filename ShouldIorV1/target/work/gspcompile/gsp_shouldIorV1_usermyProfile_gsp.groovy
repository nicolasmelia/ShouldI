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
if(true && (session.name)) {
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(15)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(16)
if(true && (session.name)) {
printHtmlPart(17)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(18)
expressionOut.print(notifyCount)
printHtmlPart(19)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(20)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(21)
}
else {
printHtmlPart(22)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(21)
}
printHtmlPart(23)
if(true && (session.name)) {
printHtmlPart(24)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(25)
expressionOut.print(session.name)
printHtmlPart(26)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(27)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(28)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(29)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(30)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(31)
}
else {
printHtmlPart(32)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (user.certified == true)) {
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print(user.userName)
printHtmlPart(37)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID]))
printHtmlPart(38)
invokeTag('formatDate','g',108,['format':("MM-dd-yyyy"),'date':(user.dateCreated)],-1)
printHtmlPart(39)
expressionOut.print(user.followerCount)
printHtmlPart(40)
expressionOut.print(user.peopleReached)
printHtmlPart(41)
if(true && (user.about != '')) {
printHtmlPart(42)
expressionOut.print(createLink(controller:'User', action: 'editAbout'))
printHtmlPart(43)
expressionOut.print(raw(user.about))
printHtmlPart(44)
}
else {
printHtmlPart(42)
expressionOut.print(createLink(controller:'User', action: 'editAbout'))
printHtmlPart(45)
}
printHtmlPart(46)
expressionOut.print(category)
printHtmlPart(47)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(48)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(49)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Favorites']))
printHtmlPart(50)
if(true && (question.isEmpty())) {
printHtmlPart(51)
}
printHtmlPart(52)
for( _it902753409 in (question) ) {
changeItVariable(_it902753409)
printHtmlPart(53)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(54)
if(true && (it.answerOneImage)) {
printHtmlPart(55)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(56)
}
else {
printHtmlPart(57)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(58)
}
printHtmlPart(59)
expressionOut.print(it.userName)
printHtmlPart(60)
if(true && (it.opNotifyVoteCount > 0 && session.userID == it.userID)) {
printHtmlPart(61)
expressionOut.print(it.opNotifyVoteCount)
printHtmlPart(62)
}
printHtmlPart(63)
expressionOut.print(it.questionTitle)
printHtmlPart(64)
expressionOut.print(it.totalVotes)
printHtmlPart(65)
expressionOut.print(it.totalViews)
printHtmlPart(66)
}
printHtmlPart(67)
createClosureForHtmlPart(68, 2)
invokeTag('link','g',192,['action':("myProfile"),'params':([offset: offset, up: 'false', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(69)
createClosureForHtmlPart(70, 2)
invokeTag('link','g',196,['action':("myProfile"),'params':([offset: offset, up: 'true', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(71)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(72)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(73)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(74)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(75)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(76)
invokeTag('javascript','g',248,['src':("dataAccess.js")],-1)
printHtmlPart(77)
invokeTag('resource','g',249,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(78)
invokeTag('javascript','g',250,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(79)
})
invokeTag('captureBody','sitemesh',265,[:],1)
printHtmlPart(80)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444090003775L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
