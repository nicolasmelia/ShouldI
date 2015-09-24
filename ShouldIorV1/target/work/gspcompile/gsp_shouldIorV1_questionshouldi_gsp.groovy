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
for( _it594531345 in (question) ) {
changeItVariable(_it594531345)
printHtmlPart(39)
expressionOut.print(it.totalVotes)
printHtmlPart(40)
expressionOut.print(it.answerOneVotes)
printHtmlPart(41)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(42)
expressionOut.print(it.answerThreeVotes)
printHtmlPart(43)
expressionOut.print(it.answerFourVotes)
printHtmlPart(44)
expressionOut.print(it.questionID)
printHtmlPart(45)
if(true && (it.anonymous == false)) {
printHtmlPart(46)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: it.userID]))
printHtmlPart(47)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: it.userID, category : 'New Questions']))
printHtmlPart(48)
expressionOut.print(it.userName)
printHtmlPart(49)
expressionOut.print(opQuestionCount)
printHtmlPart(50)
expressionOut.print(peopleReached)
printHtmlPart(51)
}
else {
printHtmlPart(52)
expressionOut.print(resource(dir:'images',file:'blankAv.png'))
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(it.requireLoginToVote)
printHtmlPart(55)
if(true && (thisUserPost == true || it.requireLoginToVote == false)) {
printHtmlPart(56)
if(true && (it.requireLoginToVote == false)) {
printHtmlPart(57)
}
printHtmlPart(58)
if(true && (thisUserPost == true)) {
printHtmlPart(59)
expressionOut.print(it.questionID)
printHtmlPart(60)
}
printHtmlPart(61)
}
printHtmlPart(62)
expressionOut.print(it.totalVotes)
printHtmlPart(63)
expressionOut.print(it.questionTitle)
printHtmlPart(64)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(65)
if(true && (it.answerOneImage)) {
printHtmlPart(66)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(67)
}
printHtmlPart(68)
}
printHtmlPart(69)
expressionOut.print(raw(it.question))
printHtmlPart(70)
expressionOut.print(topAnswer)
printHtmlPart(71)
if(true && (it.custom.toString().equals('true'))) {
printHtmlPart(72)
if(true && (it.answerOneImage)) {
printHtmlPart(73)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(74)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(75)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (it.answerTwoImage)) {
printHtmlPart(73)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '2']))
printHtmlPart(74)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(78)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(76)
}
printHtmlPart(79)
}
printHtmlPart(80)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(81)
expressionOut.print(it.answerOneVotes)
printHtmlPart(82)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(83)
}
else {
printHtmlPart(84)
expressionOut.print(it.answerOne)
printHtmlPart(85)
expressionOut.print(it.answerOneVotes)
printHtmlPart(86)
expressionOut.print(it.answerTwo)
printHtmlPart(87)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(83)
}
printHtmlPart(88)
if(true && (it.answerThree)) {
printHtmlPart(89)
if(true && (it.answerThreeImage)) {
printHtmlPart(73)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '3']))
printHtmlPart(90)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(75)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(76)
}
printHtmlPart(91)
}
printHtmlPart(92)
if(true && (it.answerFour)) {
printHtmlPart(93)
if(true && (it.answerFourImage)) {
printHtmlPart(73)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '4']))
printHtmlPart(74)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(75)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(76)
}
printHtmlPart(94)
}
printHtmlPart(95)
if(true && (it.answerThree)) {
printHtmlPart(96)
expressionOut.print(it.answerThree)
printHtmlPart(97)
expressionOut.print(it.answerThreeVotes)
printHtmlPart(98)
}
printHtmlPart(99)
if(true && (it.answerFour)) {
printHtmlPart(100)
expressionOut.print(it.answerFour)
printHtmlPart(101)
expressionOut.print(it.answerFourVotes)
printHtmlPart(102)
}
printHtmlPart(103)
}
printHtmlPart(104)
expressionOut.print(createLink(controller: 'Question', action: 'nextInCat', params: [category: question.category]))
printHtmlPart(105)
expressionOut.print(question.category)
printHtmlPart(106)
for( _it1686151267 in (questionPromo1) ) {
changeItVariable(_it1686151267)
printHtmlPart(107)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(108)
if(true && (it.answerOneImage)) {
printHtmlPart(109)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(110)
}
else {
printHtmlPart(111)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(110)
}
printHtmlPart(112)
expressionOut.print(it.questionTitle)
printHtmlPart(113)
}
printHtmlPart(114)
expressionOut.print(questionID)
printHtmlPart(115)
invokeTag('javascript','g',406,['src':("dataAccess.js")],-1)
printHtmlPart(116)
invokeTag('resource','g',407,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(117)
invokeTag('javascript','g',408,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(118)
})
invokeTag('captureBody','sitemesh',494,['style':(" margin-bottom: 20px;  ")],1)
printHtmlPart(119)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443027432235L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
