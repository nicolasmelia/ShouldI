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
expressionOut.print(percentDiff)
printHtmlPart(15)
expressionOut.print(vote)
printHtmlPart(16)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(17)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(18)
if(true && (session.name)) {
printHtmlPart(19)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(20)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [cat: 'trending']))
printHtmlPart(21)
}
else {
printHtmlPart(22)
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
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [cat: 'trending']))
printHtmlPart(28)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(29)
}
else {
printHtmlPart(30)
}
printHtmlPart(31)
for( _it1316928159 in (question) ) {
changeItVariable(_it1316928159)
printHtmlPart(32)
expressionOut.print(it.totalVotes)
printHtmlPart(33)
expressionOut.print(it.answerOneVotes)
printHtmlPart(34)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(35)
expressionOut.print(it.answerThreeVotes)
printHtmlPart(36)
expressionOut.print(it.answerFourVotes)
printHtmlPart(37)
expressionOut.print(it.questionID)
printHtmlPart(38)
if(true && (it.anonymous == false)) {
printHtmlPart(39)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: it.userID]))
printHtmlPart(40)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: it.userID, category : 'New Questions']))
printHtmlPart(41)
expressionOut.print(it.userName)
printHtmlPart(42)
expressionOut.print(opQuestionCount)
printHtmlPart(43)
expressionOut.print(peopleReached)
printHtmlPart(44)
}
else {
printHtmlPart(45)
expressionOut.print(resource(dir:'images',file:'blankAv.png'))
printHtmlPart(46)
}
printHtmlPart(47)
expressionOut.print(it.requireLoginToVote)
printHtmlPart(48)
if(true && (thisUserPost == true || it.requireLoginToVote == false)) {
printHtmlPart(49)
if(true && (it.requireLoginToVote == false)) {
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (thisUserPost == true)) {
printHtmlPart(52)
expressionOut.print(it.questionID)
printHtmlPart(53)
}
printHtmlPart(54)
}
printHtmlPart(55)
expressionOut.print(it.totalVotes)
printHtmlPart(56)
expressionOut.print(it.questionTitle)
printHtmlPart(57)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(58)
if(true && (it.answerOneImage)) {
printHtmlPart(59)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(60)
}
printHtmlPart(61)
}
printHtmlPart(62)
expressionOut.print(raw(it.question))
printHtmlPart(63)
expressionOut.print(topAnswer)
printHtmlPart(64)
if(true && (it.custom.toString().equals('true'))) {
printHtmlPart(65)
if(true && (it.answerOneImage)) {
printHtmlPart(66)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(67)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(68)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(69)
}
printHtmlPart(70)
if(true && (it.answerTwoImage)) {
printHtmlPart(66)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '2']))
printHtmlPart(67)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(71)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(69)
}
printHtmlPart(72)
}
printHtmlPart(73)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(74)
expressionOut.print(it.answerOneVotes)
printHtmlPart(75)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(76)
}
else {
printHtmlPart(77)
expressionOut.print(it.answerOne)
printHtmlPart(78)
expressionOut.print(it.answerOneVotes)
printHtmlPart(79)
expressionOut.print(it.answerTwo)
printHtmlPart(80)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(76)
}
printHtmlPart(81)
if(true && (it.answerThree)) {
printHtmlPart(82)
if(true && (it.answerThreeImage)) {
printHtmlPart(66)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '3']))
printHtmlPart(83)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(68)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(69)
}
printHtmlPart(84)
}
printHtmlPart(85)
if(true && (it.answerFour)) {
printHtmlPart(86)
if(true && (it.answerFourImage)) {
printHtmlPart(66)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '4']))
printHtmlPart(67)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(68)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(69)
}
printHtmlPart(87)
}
printHtmlPart(88)
if(true && (it.answerThree)) {
printHtmlPart(89)
expressionOut.print(it.answerThree)
printHtmlPart(90)
expressionOut.print(it.answerThreeVotes)
printHtmlPart(91)
}
printHtmlPart(92)
if(true && (it.answerFour)) {
printHtmlPart(93)
expressionOut.print(it.answerFour)
printHtmlPart(94)
expressionOut.print(it.answerFourVotes)
printHtmlPart(95)
}
printHtmlPart(96)
}
printHtmlPart(97)
for( _it193206035 in (questionArray) ) {
changeItVariable(_it193206035)
printHtmlPart(98)
expressionOut.print(it.questionID)
printHtmlPart(99)
if(true && (it.answerOneImage)) {
printHtmlPart(100)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(101)
}
else {
printHtmlPart(102)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(101)
}
printHtmlPart(103)
expressionOut.print(it.questionTitle)
printHtmlPart(104)
}
printHtmlPart(105)
expressionOut.print(questionID)
printHtmlPart(106)
invokeTag('javascript','g',409,['src':("dataAccess.js")],-1)
printHtmlPart(107)
invokeTag('resource','g',410,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(108)
invokeTag('javascript','g',411,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(109)
})
invokeTag('captureBody','sitemesh',495,['style':(" margin-bottom: 20px;  ")],1)
printHtmlPart(110)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442702214284L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
