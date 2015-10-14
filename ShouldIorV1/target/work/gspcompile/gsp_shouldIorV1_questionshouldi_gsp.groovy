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
invokeTag('resource','g',14,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',15,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',16,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',18,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(9)
invokeTag('javascript','g',21,['src':("facebookLogin.js")],-1)
printHtmlPart(10)
invokeTag('javascript','g',27,['src':("dataAccess.js")],-1)
printHtmlPart(11)
invokeTag('resource','g',28,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(12)
if(true && (question.answerOneImage == true)) {
printHtmlPart(13)
invokeTag('captureMeta','sitemesh',39,['gsp_sm_xmlClosingForEmptyTag':("/"),'property':("og:image"),'content':("http://shouldiBeta.elasticbeanstalk.com/Question/getShareImageById/${question.questionID}")],-1)
printHtmlPart(1)
}
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',42,[:],1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
if(true && (session.name)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(20)
expressionOut.print(percentDiff)
printHtmlPart(21)
expressionOut.print(vote)
printHtmlPart(22)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(23)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(24)
if(true && (session.name)) {
printHtmlPart(25)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(26)
expressionOut.print(notifyCount)
printHtmlPart(27)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(28)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(29)
}
else {
printHtmlPart(30)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(29)
}
printHtmlPart(31)
if(true && (session.name)) {
printHtmlPart(32)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(33)
expressionOut.print(session.name)
printHtmlPart(34)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(35)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(36)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(37)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(38)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(39)
}
else {
printHtmlPart(40)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(41)
}
printHtmlPart(42)
expressionOut.print(question.totalVotes)
printHtmlPart(43)
expressionOut.print(question.answerOneVotes)
printHtmlPart(44)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(45)
expressionOut.print(question.answerThreeVotes)
printHtmlPart(46)
expressionOut.print(question.answerFourVotes)
printHtmlPart(47)
expressionOut.print(question.questionID)
printHtmlPart(48)
expressionOut.print(question.answerOneImage)
printHtmlPart(49)
if(true && (question.anonymous == false)) {
printHtmlPart(50)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: question.userID]))
printHtmlPart(51)
if(true && (user.certified == true)) {
printHtmlPart(52)
}
printHtmlPart(53)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: question.userID, category : 'New Questions']))
printHtmlPart(54)
expressionOut.print(question.userName)
printHtmlPart(55)
expressionOut.print(user.followerCount)
printHtmlPart(56)
expressionOut.print(user.peopleReached)
printHtmlPart(57)
}
else {
printHtmlPart(58)
expressionOut.print(resource(dir:'images',file:'blankAv.png'))
printHtmlPart(59)
}
printHtmlPart(60)
expressionOut.print(question.requireLoginToVote)
printHtmlPart(61)
if(true && (thisUserPost == true || question.requireLoginToVote == false)) {
printHtmlPart(62)
if(true && (question.requireLoginToVote == false)) {
printHtmlPart(63)
}
printHtmlPart(64)
if(true && (thisUserPost == true)) {
printHtmlPart(65)
expressionOut.print(question.questionID)
printHtmlPart(66)
}
printHtmlPart(67)
}
printHtmlPart(68)
invokeTag('formatDate','g',166,['format':("MM-dd-yyyy"),'date':(question.date)],-1)
printHtmlPart(69)
expressionOut.print(question.totalVotes)
printHtmlPart(70)
if(true && (session.name)) {
printHtmlPart(71)
expressionOut.print(createLink(controller: 'Question', action: 'addToFavorites'))
printHtmlPart(38)
expressionOut.print(question.questionID)
printHtmlPart(72)
}
else {
printHtmlPart(73)
}
printHtmlPart(74)
if(true && (favorite == null)) {
printHtmlPart(75)
}
else {
printHtmlPart(76)
}
printHtmlPart(77)
expressionOut.print(question.questionTitle)
printHtmlPart(78)
if(true && (question.custom == false)) {
printHtmlPart(64)
if(true && (question.answerOneImage == true)) {
printHtmlPart(79)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(80)
}
printHtmlPart(81)
}
printHtmlPart(82)
expressionOut.print(raw(question.question))
printHtmlPart(83)
expressionOut.print(topAnswer)
printHtmlPart(84)
if(true && (question.custom.toString().equals('true'))) {
printHtmlPart(85)
if(true && (question.answerOneImage  == true)) {
printHtmlPart(86)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(87)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(88)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(89)
}
printHtmlPart(90)
if(true && (question.answerTwoImage  == true)) {
printHtmlPart(86)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '2', thumb: 'False']))
printHtmlPart(87)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(91)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(89)
}
printHtmlPart(92)
}
printHtmlPart(64)
if(true && (question.custom.toString().equals('false'))) {
printHtmlPart(93)
expressionOut.print(question.answerOneVotes)
printHtmlPart(94)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(95)
}
else {
printHtmlPart(96)
expressionOut.print(question.answerOne)
printHtmlPart(97)
expressionOut.print(question.answerOneVotes)
printHtmlPart(98)
expressionOut.print(question.answerTwo)
printHtmlPart(99)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(95)
}
printHtmlPart(100)
if(true && (question.answerThree)) {
printHtmlPart(101)
if(true && (question.answerThreeImage == true)) {
printHtmlPart(86)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '3', thumb: 'False']))
printHtmlPart(102)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(88)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(89)
}
printHtmlPart(103)
}
printHtmlPart(104)
if(true && (question.answerFour)) {
printHtmlPart(105)
if(true && (question.answerFourImage  == true)) {
printHtmlPart(86)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '4', thumb: 'False']))
printHtmlPart(106)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(88)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(89)
}
printHtmlPart(103)
}
printHtmlPart(107)
if(true && (question.answerThree)) {
printHtmlPart(108)
expressionOut.print(question.answerThree)
printHtmlPart(109)
expressionOut.print(question.answerThreeVotes)
printHtmlPart(110)
}
printHtmlPart(104)
if(true && (question.answerFour)) {
printHtmlPart(111)
expressionOut.print(question.answerFour)
printHtmlPart(112)
expressionOut.print(question.answerFourVotes)
printHtmlPart(110)
}
printHtmlPart(113)
expressionOut.print(createLink(controller: 'Question', action: 'nextInCat', params: [category: question.category]))
printHtmlPart(114)
expressionOut.print(question.category)
printHtmlPart(115)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: question.category, categorySort: 'Trending']))
printHtmlPart(116)
for( _it772166315 in (questionPromo1) ) {
changeItVariable(_it772166315)
printHtmlPart(117)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(118)
if(true && (it.answerOneImage)) {
printHtmlPart(119)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(120)
}
else {
printHtmlPart(121)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(120)
}
printHtmlPart(122)
expressionOut.print(it.questionTitle)
printHtmlPart(123)
}
printHtmlPart(124)
expressionOut.print(questionID)
printHtmlPart(125)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(126)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(127)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(128)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(129)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(130)
invokeTag('javascript','g',406,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(131)
})
invokeTag('captureBody','sitemesh',499,['style':(" margin-bottom: 20px;  ")],1)
printHtmlPart(132)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444778647336L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
