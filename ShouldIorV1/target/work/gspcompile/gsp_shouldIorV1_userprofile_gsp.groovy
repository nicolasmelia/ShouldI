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
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("ShouldI.fm is a place where you can ask the world questions and get honest answers. Start a poll, it's free and easy!")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("ShouldI.fm")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir:'images',file:'logoBrowser.png'))
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(6)
invokeTag('resource','g',15,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',16,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',17,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',19,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(9)
invokeTag('javascript','g',21,['src':("facebookLogin.js")],-1)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',29,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(13)
if(true && (session.name)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(17)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(18)
if(true && (session.name)) {
printHtmlPart(19)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(20)
expressionOut.print(notifyCount)
printHtmlPart(21)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(22)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(23)
}
else {
printHtmlPart(24)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(23)
}
printHtmlPart(25)
if(true && (session.name)) {
printHtmlPart(26)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(27)
expressionOut.print(session.name)
printHtmlPart(28)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(29)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(30)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(33)
}
else {
printHtmlPart(34)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (user.certified == true)) {
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(user.name)
printHtmlPart(39)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID]))
printHtmlPart(40)
if(true && (following == true)) {
printHtmlPart(41)
expressionOut.print(createLink(controller: 'User', action: 'followUser'))
printHtmlPart(32)
expressionOut.print(user.userID)
printHtmlPart(42)
}
else {
printHtmlPart(43)
if(true && (session.name)) {
printHtmlPart(44)
expressionOut.print(createLink(controller: 'User', action: 'followUser'))
printHtmlPart(32)
expressionOut.print(user.userID)
printHtmlPart(45)
}
else {
printHtmlPart(46)
}
printHtmlPart(47)
}
printHtmlPart(48)
expressionOut.print(user.totalQuestions)
printHtmlPart(49)
expressionOut.print(user.followerCount)
printHtmlPart(50)
expressionOut.print(user.peopleReached)
printHtmlPart(51)
if(true && (user.about != '')) {
printHtmlPart(52)
expressionOut.print(raw(user.about))
printHtmlPart(53)
}
else {
printHtmlPart(54)
}
printHtmlPart(55)
expressionOut.print(category)
printHtmlPart(56)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [category: 'New Questions', id: user.userID]))
printHtmlPart(57)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [category: 'Top Questions', id: user.userID]))
printHtmlPart(58)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [category: 'Favorites', id: user.userID]))
printHtmlPart(59)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [category: 'Following', id: user.userID]))
printHtmlPart(60)
if(true && (question.isEmpty() && users.isEmpty())) {
printHtmlPart(61)
}
printHtmlPart(62)
if(true && (category != 'Following')) {
printHtmlPart(63)
for( _it468154998 in (question) ) {
changeItVariable(_it468154998)
printHtmlPart(64)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(65)
if(true && (it.answerOneImage)) {
printHtmlPart(66)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(67)
}
else {
printHtmlPart(68)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(69)
}
printHtmlPart(70)
expressionOut.print(it.userName)
printHtmlPart(71)
expressionOut.print(it.questionTitle)
printHtmlPart(72)
expressionOut.print(it.totalVotes)
printHtmlPart(73)
expressionOut.print(it.totalViews)
printHtmlPart(74)
}
printHtmlPart(75)
}
else {
printHtmlPart(76)
for( _it828174704 in (users) ) {
changeItVariable(_it828174704)
printHtmlPart(77)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: it.userID, category : 'New Questions']))
printHtmlPart(78)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: it.userID]))
printHtmlPart(79)
expressionOut.print(it.name)
printHtmlPart(80)
}
printHtmlPart(63)
}
printHtmlPart(81)
createClosureForHtmlPart(82, 2)
invokeTag('link','g',232,['action':("profile"),'params':([offset: offset, up: 'false', category: category, id: user.userID ]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(83)
createClosureForHtmlPart(84, 2)
invokeTag('link','g',236,['action':("profile"),'params':([offset: offset, up: 'true', category: category, id : user.userID]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(85)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(86)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(87)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(88)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(89)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(90)
invokeTag('javascript','g',284,['src':("dataAccess.js")],-1)
printHtmlPart(91)
invokeTag('resource','g',285,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(92)
invokeTag('javascript','g',286,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(93)
})
invokeTag('captureBody','sitemesh',305,[:],1)
printHtmlPart(94)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444348265821L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
