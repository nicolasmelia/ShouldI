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
expressionOut.print(user.name)
printHtmlPart(37)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID]))
printHtmlPart(38)
if(true && (following == true)) {
printHtmlPart(39)
expressionOut.print(createLink(controller: 'User', action: 'followUser'))
printHtmlPart(30)
expressionOut.print(user.userID)
printHtmlPart(40)
}
else {
printHtmlPart(41)
if(true && (session.name)) {
printHtmlPart(42)
expressionOut.print(createLink(controller: 'User', action: 'followUser'))
printHtmlPart(30)
expressionOut.print(user.userID)
printHtmlPart(43)
}
else {
printHtmlPart(44)
}
printHtmlPart(45)
}
printHtmlPart(46)
invokeTag('formatDate','g',127,['format':("MM-dd-yyyy"),'date':(user.dateCreated)],-1)
printHtmlPart(47)
expressionOut.print(user.followerCount)
printHtmlPart(48)
expressionOut.print(user.peopleReached)
printHtmlPart(49)
if(true && (user.about != '')) {
printHtmlPart(50)
expressionOut.print(raw(user.about))
printHtmlPart(51)
}
else {
printHtmlPart(52)
}
printHtmlPart(53)
expressionOut.print(category)
printHtmlPart(54)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [category: 'New Questions', id: user.userID]))
printHtmlPart(55)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [category: 'Top Questions', id: user.userID]))
printHtmlPart(56)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [category: 'Favorites', id: user.userID]))
printHtmlPart(57)
if(true && (question.isEmpty())) {
printHtmlPart(58)
}
printHtmlPart(59)
for( _it536167075 in (question) ) {
changeItVariable(_it536167075)
printHtmlPart(60)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(61)
if(true && (it.answerOneImage)) {
printHtmlPart(62)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(63)
}
else {
printHtmlPart(64)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(65)
}
printHtmlPart(66)
expressionOut.print(it.userName)
printHtmlPart(67)
expressionOut.print(it.questionTitle)
printHtmlPart(68)
expressionOut.print(it.totalVotes)
printHtmlPart(69)
expressionOut.print(it.totalViews)
printHtmlPart(70)
}
printHtmlPart(71)
createClosureForHtmlPart(72, 2)
invokeTag('link','g',207,['action':("profile"),'params':([offset: offset, up: 'false', category: category, id: user.userID ]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(73)
createClosureForHtmlPart(74, 2)
invokeTag('link','g',211,['action':("profile"),'params':([offset: offset, up: 'true', category: category, id : user.userID]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(75)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(76)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(77)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(78)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(79)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(80)
invokeTag('javascript','g',259,['src':("dataAccess.js")],-1)
printHtmlPart(81)
invokeTag('resource','g',260,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(82)
invokeTag('javascript','g',261,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(83)
})
invokeTag('captureBody','sitemesh',279,[:],1)
printHtmlPart(84)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444090003744L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
