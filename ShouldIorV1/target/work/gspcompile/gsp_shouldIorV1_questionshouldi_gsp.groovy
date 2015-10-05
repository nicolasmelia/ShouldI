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
printHtmlPart(6)
invokeTag('resource','g',15,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',17,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(8)
invokeTag('javascript','g',19,['src':("facebookLogin.js")],-1)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',27,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
if(true && (session.name)) {
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(15)
expressionOut.print(percentDiff)
printHtmlPart(16)
expressionOut.print(vote)
printHtmlPart(17)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(18)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(19)
if(true && (session.name)) {
printHtmlPart(20)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(21)
expressionOut.print(notifyCount)
printHtmlPart(22)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(23)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(24)
}
else {
printHtmlPart(25)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(24)
}
printHtmlPart(26)
if(true && (session.name)) {
printHtmlPart(27)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(28)
expressionOut.print(session.name)
printHtmlPart(29)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(30)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(34)
}
else {
printHtmlPart(35)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(36)
}
printHtmlPart(37)
expressionOut.print(question.totalVotes)
printHtmlPart(38)
expressionOut.print(question.answerOneVotes)
printHtmlPart(39)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(40)
expressionOut.print(question.answerThreeVotes)
printHtmlPart(41)
expressionOut.print(question.answerFourVotes)
printHtmlPart(42)
expressionOut.print(question.questionID)
printHtmlPart(43)
if(true && (question.anonymous == false)) {
printHtmlPart(44)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: question.userID]))
printHtmlPart(45)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: question.userID, category : 'New Questions']))
printHtmlPart(46)
expressionOut.print(question.userName)
printHtmlPart(47)
expressionOut.print(opQuestionCount)
printHtmlPart(48)
expressionOut.print(peopleReached)
printHtmlPart(49)
}
else {
printHtmlPart(50)
expressionOut.print(resource(dir:'images',file:'blankAv.png'))
printHtmlPart(51)
}
printHtmlPart(52)
expressionOut.print(question.requireLoginToVote)
printHtmlPart(53)
if(true && (thisUserPost == true || question.requireLoginToVote == false)) {
printHtmlPart(54)
if(true && (question.requireLoginToVote == false)) {
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (thisUserPost == true)) {
printHtmlPart(57)
expressionOut.print(question.questionID)
printHtmlPart(58)
}
printHtmlPart(59)
}
printHtmlPart(60)
invokeTag('formatDate','g',170,['format':("MM-dd-yyyy"),'date':(question.date)],-1)
printHtmlPart(61)
expressionOut.print(question.totalVotes)
printHtmlPart(62)
if(true && (session.name)) {
printHtmlPart(63)
expressionOut.print(createLink(controller: 'Question', action: 'addToFavorites'))
printHtmlPart(33)
expressionOut.print(question.questionID)
printHtmlPart(64)
}
else {
printHtmlPart(65)
}
printHtmlPart(66)
if(true && (favorite == null)) {
printHtmlPart(67)
}
else {
printHtmlPart(68)
}
printHtmlPart(69)
expressionOut.print(question.questionTitle)
printHtmlPart(70)
if(true && (question.custom == false)) {
printHtmlPart(71)
if(true && (question.answerOneImage == true)) {
printHtmlPart(72)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(73)
}
printHtmlPart(74)
}
printHtmlPart(75)
expressionOut.print(raw(question.question))
printHtmlPart(76)
expressionOut.print(topAnswer)
printHtmlPart(77)
if(true && (question.custom.toString().equals('true'))) {
printHtmlPart(78)
if(true && (question.answerOneImage  == true)) {
printHtmlPart(79)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(80)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(81)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(82)
}
printHtmlPart(83)
if(true && (question.answerTwoImage  == true)) {
printHtmlPart(79)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '2', thumb: 'False']))
printHtmlPart(80)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(84)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(82)
}
printHtmlPart(85)
}
printHtmlPart(86)
if(true && (question.custom.toString().equals('false'))) {
printHtmlPart(87)
expressionOut.print(question.answerOneVotes)
printHtmlPart(88)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(89)
}
else {
printHtmlPart(90)
expressionOut.print(question.answerOne)
printHtmlPart(91)
expressionOut.print(question.answerOneVotes)
printHtmlPart(92)
expressionOut.print(question.answerTwo)
printHtmlPart(93)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(89)
}
printHtmlPart(94)
if(true && (question.answerThree)) {
printHtmlPart(95)
if(true && (question.answerThreeImage == true)) {
printHtmlPart(79)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '3', thumb: 'False']))
printHtmlPart(96)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(81)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(82)
}
printHtmlPart(97)
}
printHtmlPart(98)
if(true && (question.answerFour)) {
printHtmlPart(99)
if(true && (question.answerFourImage  == true)) {
printHtmlPart(79)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '4', thumb: 'False']))
printHtmlPart(100)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(81)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(82)
}
printHtmlPart(101)
}
printHtmlPart(102)
if(true && (question.answerThree)) {
printHtmlPart(103)
expressionOut.print(question.answerThree)
printHtmlPart(104)
expressionOut.print(question.answerThreeVotes)
printHtmlPart(105)
}
printHtmlPart(106)
if(true && (question.answerFour)) {
printHtmlPart(107)
expressionOut.print(question.answerFour)
printHtmlPart(108)
expressionOut.print(question.answerFourVotes)
printHtmlPart(109)
}
printHtmlPart(110)
expressionOut.print(createLink(controller: 'Question', action: 'nextInCat', params: [category: question.category]))
printHtmlPart(111)
expressionOut.print(question.category)
printHtmlPart(112)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: question.category, categorySort: 'Trending']))
printHtmlPart(113)
for( _it1657624109 in (questionPromo1) ) {
changeItVariable(_it1657624109)
printHtmlPart(114)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(115)
if(true && (it.answerOneImage)) {
printHtmlPart(116)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(117)
}
else {
printHtmlPart(118)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(117)
}
printHtmlPart(119)
expressionOut.print(it.questionTitle)
printHtmlPart(120)
}
printHtmlPart(121)
expressionOut.print(questionID)
printHtmlPart(122)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(123)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(124)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(125)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(126)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(127)
invokeTag('javascript','g',449,['src':("dataAccess.js")],-1)
printHtmlPart(128)
invokeTag('resource','g',450,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(129)
invokeTag('javascript','g',451,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(130)
})
invokeTag('captureBody','sitemesh',539,['style':(" margin-bottom: 20px;  ")],1)
printHtmlPart(131)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444001483414L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
