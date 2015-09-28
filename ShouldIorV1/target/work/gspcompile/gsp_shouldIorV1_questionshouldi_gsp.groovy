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
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(18)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(19)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(20)
if(true && (session.name)) {
printHtmlPart(21)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(22)
expressionOut.print(notifyCount)
printHtmlPart(23)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(24)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(25)
}
else {
printHtmlPart(26)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(25)
}
printHtmlPart(27)
if(true && (session.name)) {
printHtmlPart(28)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(29)
expressionOut.print(session.name)
printHtmlPart(30)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(35)
}
else {
printHtmlPart(36)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(question.totalVotes)
printHtmlPart(39)
expressionOut.print(question.answerOneVotes)
printHtmlPart(40)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(41)
expressionOut.print(question.answerThreeVotes)
printHtmlPart(42)
expressionOut.print(question.answerFourVotes)
printHtmlPart(43)
expressionOut.print(question.questionID)
printHtmlPart(44)
if(true && (question.anonymous == false)) {
printHtmlPart(45)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: question.userID]))
printHtmlPart(46)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: question.userID, category : 'New Questions']))
printHtmlPart(47)
expressionOut.print(question.userName)
printHtmlPart(48)
expressionOut.print(opQuestionCount)
printHtmlPart(49)
expressionOut.print(peopleReached)
printHtmlPart(50)
}
else {
printHtmlPart(51)
expressionOut.print(resource(dir:'images',file:'blankAv.png'))
printHtmlPart(52)
}
printHtmlPart(53)
expressionOut.print(question.requireLoginToVote)
printHtmlPart(54)
if(true && (thisUserPost == true || question.requireLoginToVote == false)) {
printHtmlPart(55)
if(true && (question.requireLoginToVote == false)) {
printHtmlPart(56)
}
printHtmlPart(57)
if(true && (thisUserPost == true)) {
printHtmlPart(58)
expressionOut.print(question.questionID)
printHtmlPart(59)
}
printHtmlPart(60)
}
printHtmlPart(61)
invokeTag('formatDate','g',172,['format':("MM-dd-yyyy"),'date':(question.date)],-1)
printHtmlPart(62)
expressionOut.print(question.totalVotes)
printHtmlPart(63)
if(true && (session.name)) {
printHtmlPart(64)
expressionOut.print(createLink(controller: 'Question', action: 'addToFavorites'))
printHtmlPart(34)
expressionOut.print(question.questionID)
printHtmlPart(65)
}
else {
printHtmlPart(66)
}
printHtmlPart(67)
if(true && (favorite == null)) {
printHtmlPart(68)
}
else {
printHtmlPart(69)
}
printHtmlPart(70)
expressionOut.print(question.questionTitle)
printHtmlPart(71)
if(true && (question.custom.toString().equals('false'))) {
printHtmlPart(72)
if(true && (question.answerOneImage)) {
printHtmlPart(73)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1']))
printHtmlPart(74)
}
printHtmlPart(75)
}
printHtmlPart(76)
expressionOut.print(raw(question.question))
printHtmlPart(77)
expressionOut.print(topAnswer)
printHtmlPart(78)
if(true && (question.custom.toString().equals('true'))) {
printHtmlPart(79)
if(true && (question.answerOneImage)) {
printHtmlPart(80)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1']))
printHtmlPart(81)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(82)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(83)
}
printHtmlPart(84)
if(true && (question.answerTwoImage)) {
printHtmlPart(80)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '2']))
printHtmlPart(81)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(85)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(83)
}
printHtmlPart(86)
}
printHtmlPart(87)
if(true && (question.custom.toString().equals('false'))) {
printHtmlPart(88)
expressionOut.print(question.answerOneVotes)
printHtmlPart(89)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(90)
}
else {
printHtmlPart(91)
expressionOut.print(question.answerOne)
printHtmlPart(92)
expressionOut.print(question.answerOneVotes)
printHtmlPart(93)
expressionOut.print(question.answerTwo)
printHtmlPart(94)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(90)
}
printHtmlPart(95)
if(true && (question.answerThree)) {
printHtmlPart(96)
if(true && (question.answerThreeImage)) {
printHtmlPart(80)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '3']))
printHtmlPart(97)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(82)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(83)
}
printHtmlPart(98)
}
printHtmlPart(99)
if(true && (question.answerFour)) {
printHtmlPart(100)
if(true && (question.answerFourImage)) {
printHtmlPart(80)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '4']))
printHtmlPart(81)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(82)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(83)
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
for( _it1864357825 in (questionPromo1) ) {
changeItVariable(_it1864357825)
printHtmlPart(113)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(114)
if(true && (it.answerOneImage)) {
printHtmlPart(115)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(116)
}
else {
printHtmlPart(117)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(116)
}
printHtmlPart(118)
expressionOut.print(it.questionTitle)
printHtmlPart(119)
}
printHtmlPart(120)
expressionOut.print(questionID)
printHtmlPart(121)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(122)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(123)
invokeTag('javascript','g',451,['src':("dataAccess.js")],-1)
printHtmlPart(124)
invokeTag('resource','g',452,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(125)
invokeTag('javascript','g',453,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(126)
})
invokeTag('captureBody','sitemesh',539,['style':(" margin-bottom: 20px;  ")],1)
printHtmlPart(127)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443376176748L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
