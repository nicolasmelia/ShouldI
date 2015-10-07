import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_questionshouldi_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/question/shouldi.gsp" }
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
createTagBody(3, {->
printHtmlPart(5)
expressionOut.print(question.questionTitle)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(6)
invokeTag('resource','g',15,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',16,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',18,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(9)
invokeTag('resource','g',20,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(10)
invokeTag('javascript','g',22,['src':("facebookLogin.js")],-1)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',30,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
if(true && (session.name)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(17)
expressionOut.print(percentDiff)
printHtmlPart(18)
expressionOut.print(vote)
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
expressionOut.print(question.totalVotes)
printHtmlPart(40)
expressionOut.print(question.answerOneVotes)
printHtmlPart(41)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(42)
expressionOut.print(question.answerThreeVotes)
printHtmlPart(43)
expressionOut.print(question.answerFourVotes)
printHtmlPart(44)
expressionOut.print(question.questionID)
printHtmlPart(45)
if(true && (question.anonymous == false)) {
printHtmlPart(46)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: question.userID]))
printHtmlPart(47)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: question.userID, category : 'New Questions']))
printHtmlPart(48)
expressionOut.print(question.userName)
printHtmlPart(49)
expressionOut.print(user.followerCount)
printHtmlPart(50)
expressionOut.print(user.peopleReached)
printHtmlPart(51)
}
else {
printHtmlPart(52)
expressionOut.print(resource(dir:'images',file:'blankAv.png'))
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(question.requireLoginToVote)
printHtmlPart(55)
if(true && (thisUserPost == true || question.requireLoginToVote == false)) {
printHtmlPart(56)
if(true && (question.requireLoginToVote == false)) {
printHtmlPart(57)
}
printHtmlPart(58)
if(true && (thisUserPost == true)) {
printHtmlPart(59)
expressionOut.print(question.questionID)
printHtmlPart(60)
}
printHtmlPart(61)
}
printHtmlPart(62)
invokeTag('formatDate','g',173,['format':("MM-dd-yyyy"),'date':(question.date)],-1)
printHtmlPart(63)
expressionOut.print(question.totalVotes)
printHtmlPart(64)
if(true && (session.name)) {
printHtmlPart(65)
expressionOut.print(createLink(controller: 'Question', action: 'addToFavorites'))
printHtmlPart(35)
expressionOut.print(question.questionID)
printHtmlPart(66)
}
else {
printHtmlPart(67)
}
printHtmlPart(68)
if(true && (favorite == null)) {
printHtmlPart(69)
}
else {
printHtmlPart(70)
}
printHtmlPart(71)
expressionOut.print(question.questionTitle)
printHtmlPart(72)
if(true && (question.custom == false)) {
printHtmlPart(73)
if(true && (question.answerOneImage == true)) {
printHtmlPart(74)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(75)
}
printHtmlPart(76)
}
printHtmlPart(77)
expressionOut.print(raw(question.question))
printHtmlPart(78)
expressionOut.print(topAnswer)
printHtmlPart(79)
if(true && (question.custom.toString().equals('true'))) {
printHtmlPart(80)
if(true && (question.answerOneImage  == true)) {
printHtmlPart(81)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(82)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(83)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(84)
}
printHtmlPart(85)
if(true && (question.answerTwoImage  == true)) {
printHtmlPart(81)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '2', thumb: 'False']))
printHtmlPart(82)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(86)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(84)
}
printHtmlPart(87)
}
printHtmlPart(88)
if(true && (question.custom.toString().equals('false'))) {
printHtmlPart(89)
expressionOut.print(question.answerOneVotes)
printHtmlPart(90)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(91)
}
else {
printHtmlPart(92)
expressionOut.print(question.answerOne)
printHtmlPart(93)
expressionOut.print(question.answerOneVotes)
printHtmlPart(94)
expressionOut.print(question.answerTwo)
printHtmlPart(95)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(91)
}
printHtmlPart(96)
if(true && (question.answerThree)) {
printHtmlPart(97)
if(true && (question.answerThreeImage == true)) {
printHtmlPart(81)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '3', thumb: 'False']))
printHtmlPart(98)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(83)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(84)
}
printHtmlPart(99)
}
printHtmlPart(100)
if(true && (question.answerFour)) {
printHtmlPart(101)
if(true && (question.answerFourImage  == true)) {
printHtmlPart(81)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '4', thumb: 'False']))
printHtmlPart(102)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(83)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(84)
}
printHtmlPart(103)
}
printHtmlPart(104)
if(true && (question.answerThree)) {
printHtmlPart(105)
expressionOut.print(question.answerThree)
printHtmlPart(106)
expressionOut.print(question.answerThreeVotes)
printHtmlPart(107)
}
printHtmlPart(108)
if(true && (question.answerFour)) {
printHtmlPart(109)
expressionOut.print(question.answerFour)
printHtmlPart(110)
expressionOut.print(question.answerFourVotes)
printHtmlPart(111)
}
printHtmlPart(112)
expressionOut.print(createLink(controller: 'Question', action: 'nextInCat', params: [category: question.category]))
printHtmlPart(113)
expressionOut.print(question.category)
printHtmlPart(114)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: question.category, categorySort: 'Trending']))
printHtmlPart(115)
for( _it1097965321 in (questionPromo1) ) {
changeItVariable(_it1097965321)
printHtmlPart(116)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(117)
if(true && (it.answerOneImage)) {
printHtmlPart(118)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(119)
}
else {
printHtmlPart(120)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(119)
}
printHtmlPart(121)
expressionOut.print(it.questionTitle)
printHtmlPart(122)
}
printHtmlPart(123)
expressionOut.print(questionID)
printHtmlPart(124)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(125)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(126)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(127)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(128)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(129)
invokeTag('javascript','g',452,['src':("dataAccess.js")],-1)
printHtmlPart(130)
invokeTag('resource','g',453,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(131)
invokeTag('javascript','g',454,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(132)
})
invokeTag('captureBody','sitemesh',542,['style':(" margin-bottom: 20px;  ")],1)
printHtmlPart(133)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444181443691L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
