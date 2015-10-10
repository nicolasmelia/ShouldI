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
expressionOut.print(createLink(controller:'User', action: 'editProfile'))
printHtmlPart(37)
if(true && (user.certified == true)) {
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(user.name)
printHtmlPart(40)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID]))
printHtmlPart(41)
expressionOut.print(user.totalQuestions)
printHtmlPart(42)
expressionOut.print(user.followerCount)
printHtmlPart(43)
expressionOut.print(user.peopleReached)
printHtmlPart(44)
if(true && (user.about != '')) {
printHtmlPart(45)
expressionOut.print(raw(user.about))
printHtmlPart(46)
}
else {
printHtmlPart(47)
}
printHtmlPart(48)
expressionOut.print(category)
printHtmlPart(49)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(50)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(51)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Favorites']))
printHtmlPart(52)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'Following']))
printHtmlPart(53)
if(true && (question.isEmpty() && users.isEmpty())) {
printHtmlPart(54)
}
printHtmlPart(55)
if(true && (category != 'Following')) {
printHtmlPart(56)
for( _it1095941391 in (question) ) {
changeItVariable(_it1095941391)
printHtmlPart(57)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(58)
if(true && (it.answerOneImage)) {
printHtmlPart(59)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(60)
}
else {
printHtmlPart(61)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(62)
}
printHtmlPart(63)
expressionOut.print(it.userName)
printHtmlPart(64)
if(true && (it.opNotifyVoteCount > 0 && session.userID == it.userID)) {
printHtmlPart(65)
expressionOut.print(it.opNotifyVoteCount)
printHtmlPart(66)
}
printHtmlPart(67)
expressionOut.print(it.questionTitle)
printHtmlPart(68)
expressionOut.print(it.totalVotes)
printHtmlPart(69)
expressionOut.print(it.totalViews)
printHtmlPart(70)
}
printHtmlPart(71)
}
else {
printHtmlPart(72)
for( _it282658241 in (users) ) {
changeItVariable(_it282658241)
printHtmlPart(73)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: it.userID, category : 'New Questions']))
printHtmlPart(74)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: it.userID]))
printHtmlPart(75)
expressionOut.print(it.name)
printHtmlPart(76)
}
printHtmlPart(71)
}
printHtmlPart(77)
createClosureForHtmlPart(78, 2)
invokeTag('link','g',223,['action':("myProfile"),'params':([offset: offset, up: 'false', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(79)
createClosureForHtmlPart(80, 2)
invokeTag('link','g',227,['action':("myProfile"),'params':([offset: offset, up: 'true', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(81)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(82)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(83)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(84)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(85)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(86)
invokeTag('javascript','g',279,['src':("dataAccess.js")],-1)
printHtmlPart(87)
invokeTag('resource','g',280,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(88)
invokeTag('javascript','g',281,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(89)
})
invokeTag('captureBody','sitemesh',297,[:],1)
printHtmlPart(90)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444408422688L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
