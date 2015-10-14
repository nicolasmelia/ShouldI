import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_shouldIhome_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/shouldI/home.gsp" }
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
invokeTag('resource','g',16,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',17,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',18,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',20,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',22,['src':("facebookLogin.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',23,['src':("dataAccess.js")],-1)
printHtmlPart(10)
invokeTag('resource','g',26,['dir':("css"),'file':("typehead-searchBar.css")],-1)
printHtmlPart(11)
invokeTag('resource','g',28,['dir':("js/typedJS"),'file':("typed.min.js")],-1)
printHtmlPart(12)
invokeTag('resource','g',31,['dir':("js/typeaheadJS"),'file':("typeahead.jquery.min.js")],-1)
printHtmlPart(12)
invokeTag('resource','g',34,['dir':("js/chart"),'file':("Chart.min.js")],-1)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',41,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(16)
if(true && (session.name)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(20)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(21)
if(true && (session.name)) {
printHtmlPart(22)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(23)
expressionOut.print(notifyCount)
printHtmlPart(24)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(25)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(26)
}
else {
printHtmlPart(27)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(26)
}
printHtmlPart(28)
if(true && (session.name)) {
printHtmlPart(29)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(30)
expressionOut.print(session.name)
printHtmlPart(31)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(35)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(36)
}
else {
printHtmlPart(37)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(resource(dir:'images',file:'logoDark.png'))
printHtmlPart(40)
if(true && (session.name)) {
printHtmlPart(41)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(42)
}
else {
printHtmlPart(43)
}
printHtmlPart(44)
expressionOut.print(messageTitle)
printHtmlPart(45)
expressionOut.print(raw(messageText))
printHtmlPart(46)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(47)
for( _it1350066054 in (popularQuestions) ) {
changeItVariable(_it1350066054)
printHtmlPart(48)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(49)
if(true && (it.answerOneImage)) {
printHtmlPart(50)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(51)
}
else {
printHtmlPart(52)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(it.userName)
printHtmlPart(55)
expressionOut.print(it.questionTitle)
printHtmlPart(56)
expressionOut.print(it.totalVotes)
printHtmlPart(57)
expressionOut.print(it.totalViews)
printHtmlPart(58)
}
printHtmlPart(59)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(60)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(61)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(62)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(63)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(64)
expressionOut.print(yesCount)
printHtmlPart(65)
expressionOut.print(noCount)
printHtmlPart(66)
})
invokeTag('captureBody','sitemesh',274,['style':("background-color: #F6F6F6!important; background-image:url('${resource(dir: "images", file: "wall1.jpg")}'); margin-bottom: 20px; background-size: cover;  background-attachment: fixed; min-width: 320px;  ")],1)
printHtmlPart(67)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444785706944L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
