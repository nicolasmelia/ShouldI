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
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("ShouldI.fm is a place where you can ask the world questions and get honest answers. Start a poll, it's free and easy!")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("ShouldI.fm")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir:'images',file:'logoBrowser.png'))
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(6)
invokeTag('resource','g',17,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',18,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',19,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',20,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',22,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',24,['src':("facebookLogin.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',25,['src':("dataAccess.js")],-1)
printHtmlPart(10)
invokeTag('resource','g',28,['dir':("css"),'file':("typehead-searchBar.css")],-1)
printHtmlPart(11)
invokeTag('resource','g',29,['dir':("js/typedJS"),'file':("typed.min.js")],-1)
printHtmlPart(12)
invokeTag('resource','g',31,['dir':("js/typeaheadJS"),'file':("typeahead.jquery.min.js")],-1)
printHtmlPart(13)
invokeTag('resource','g',34,['dir':("js/chart"),'file':("Chart.min.js")],-1)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',42,[:],1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(17)
if(true && (session.name)) {
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(21)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(22)
if(true && (session.name)) {
printHtmlPart(23)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(24)
expressionOut.print(notifyCount)
printHtmlPart(25)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(26)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(27)
}
else {
printHtmlPart(28)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(27)
}
printHtmlPart(29)
if(true && (session.name)) {
printHtmlPart(30)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(31)
expressionOut.print(session.name)
printHtmlPart(32)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(35)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(36)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(37)
}
else {
printHtmlPart(38)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(39)
}
printHtmlPart(40)
expressionOut.print(resource(dir:'images',file:'logoDark.png'))
printHtmlPart(41)
if(true && (session.name)) {
printHtmlPart(42)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(43)
}
else {
printHtmlPart(44)
}
printHtmlPart(45)
expressionOut.print(messageTitle)
printHtmlPart(46)
expressionOut.print(raw(messageText))
printHtmlPart(47)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(48)
for( _it878765293 in (trendingQuestions) ) {
changeItVariable(_it878765293)
printHtmlPart(49)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(50)
if(true && (it.answerOneImage)) {
printHtmlPart(51)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
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
expressionOut.print(it.questionTitle)
printHtmlPart(57)
expressionOut.print(it.totalVotes)
printHtmlPart(58)
expressionOut.print(it.totalViews)
printHtmlPart(59)
}
printHtmlPart(60)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(61)
for( _it1246052237 in (randomQuestions) ) {
changeItVariable(_it1246052237)
printHtmlPart(62)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(63)
if(true && (it.answerOneImage)) {
printHtmlPart(64)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(65)
}
else {
printHtmlPart(66)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(65)
}
printHtmlPart(67)
expressionOut.print(it.questionTitle)
printHtmlPart(68)
}
printHtmlPart(69)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(70)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(71)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(72)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(73)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(74)
expressionOut.print(yesCount)
printHtmlPart(75)
expressionOut.print(noCount)
printHtmlPart(76)
})
invokeTag('captureBody','sitemesh',342,['style':("background-color: #F6F6F6!important; background-image:url('${resource(dir: "images", file: "wall1.jpg")}'); margin-bottom: 20px; background-size: cover;  background-attachment: fixed; min-width: 320px;  ")],1)
printHtmlPart(77)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444409033044L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
