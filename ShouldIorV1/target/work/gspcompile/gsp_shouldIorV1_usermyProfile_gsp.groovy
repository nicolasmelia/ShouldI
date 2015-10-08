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
if(true && (user.certified == true)) {
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(user.name)
printHtmlPart(39)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID]))
printHtmlPart(40)
expressionOut.print(createLink(controller:'User', action: 'editProfile'))
printHtmlPart(41)
invokeTag('formatDate','g',117,['format':("MM-dd-yyyy"),'date':(user.dateCreated)],-1)
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
expressionOut.print(createLink(controller:'User', action: 'editAbout'))
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(category)
printHtmlPart(50)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(51)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(52)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Favorites']))
printHtmlPart(53)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'Following']))
printHtmlPart(54)
if(true && (question.isEmpty() && users.isEmpty())) {
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (category != 'Following')) {
printHtmlPart(57)
for( _it1874912328 in (question) ) {
changeItVariable(_it1874912328)
printHtmlPart(58)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(59)
if(true && (it.answerOneImage)) {
printHtmlPart(60)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(61)
}
else {
printHtmlPart(62)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(63)
}
printHtmlPart(64)
expressionOut.print(it.userName)
printHtmlPart(65)
if(true && (it.opNotifyVoteCount > 0 && session.userID == it.userID)) {
printHtmlPart(66)
expressionOut.print(it.opNotifyVoteCount)
printHtmlPart(67)
}
printHtmlPart(68)
expressionOut.print(it.questionTitle)
printHtmlPart(69)
expressionOut.print(it.totalVotes)
printHtmlPart(70)
expressionOut.print(it.totalViews)
printHtmlPart(71)
}
printHtmlPart(72)
}
else {
printHtmlPart(73)
for( _it1612269828 in (users) ) {
changeItVariable(_it1612269828)
printHtmlPart(74)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: it.userID, category : 'New Questions']))
printHtmlPart(75)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: it.userID]))
printHtmlPart(76)
expressionOut.print(it.name)
printHtmlPart(77)
}
printHtmlPart(72)
}
printHtmlPart(78)
createClosureForHtmlPart(79, 2)
invokeTag('link','g',216,['action':("myProfile"),'params':([offset: offset, up: 'false', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(80)
createClosureForHtmlPart(81, 2)
invokeTag('link','g',220,['action':("myProfile"),'params':([offset: offset, up: 'true', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(82)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(83)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(84)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(85)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(86)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(87)
invokeTag('javascript','g',272,['src':("dataAccess.js")],-1)
printHtmlPart(88)
invokeTag('resource','g',273,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(89)
invokeTag('javascript','g',274,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(90)
})
invokeTag('captureBody','sitemesh',289,[:],1)
printHtmlPart(91)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444264902079L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
