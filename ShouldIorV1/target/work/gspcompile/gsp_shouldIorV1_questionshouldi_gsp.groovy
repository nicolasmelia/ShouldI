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
if(true && (user.certified == true)) {
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: question.userID, category : 'New Questions']))
printHtmlPart(50)
expressionOut.print(question.userName)
printHtmlPart(51)
expressionOut.print(user.followerCount)
printHtmlPart(52)
expressionOut.print(user.peopleReached)
printHtmlPart(53)
}
else {
printHtmlPart(54)
expressionOut.print(resource(dir:'images',file:'blankAv.png'))
printHtmlPart(55)
}
printHtmlPart(56)
expressionOut.print(question.requireLoginToVote)
printHtmlPart(57)
if(true && (thisUserPost == true || question.requireLoginToVote == false)) {
printHtmlPart(58)
if(true && (question.requireLoginToVote == false)) {
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (thisUserPost == true)) {
printHtmlPart(61)
expressionOut.print(question.questionID)
printHtmlPart(62)
}
printHtmlPart(63)
}
printHtmlPart(64)
invokeTag('formatDate','g',180,['format':("MM-dd-yyyy"),'date':(question.date)],-1)
printHtmlPart(65)
expressionOut.print(question.totalVotes)
printHtmlPart(66)
if(true && (session.name)) {
printHtmlPart(67)
expressionOut.print(createLink(controller: 'Question', action: 'addToFavorites'))
printHtmlPart(35)
expressionOut.print(question.questionID)
printHtmlPart(68)
}
else {
printHtmlPart(69)
}
printHtmlPart(70)
if(true && (favorite == null)) {
printHtmlPart(71)
}
else {
printHtmlPart(72)
}
printHtmlPart(73)
expressionOut.print(question.questionTitle)
printHtmlPart(74)
if(true && (question.custom == false)) {
printHtmlPart(75)
if(true && (question.answerOneImage == true)) {
printHtmlPart(76)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(77)
}
printHtmlPart(78)
}
printHtmlPart(79)
expressionOut.print(raw(question.question))
printHtmlPart(80)
expressionOut.print(topAnswer)
printHtmlPart(81)
if(true && (question.custom.toString().equals('true'))) {
printHtmlPart(82)
if(true && (question.answerOneImage  == true)) {
printHtmlPart(83)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(84)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(85)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(86)
}
printHtmlPart(87)
if(true && (question.answerTwoImage  == true)) {
printHtmlPart(83)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '2', thumb: 'False']))
printHtmlPart(84)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(88)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(86)
}
printHtmlPart(89)
}
printHtmlPart(90)
if(true && (question.custom.toString().equals('false'))) {
printHtmlPart(91)
expressionOut.print(question.answerOneVotes)
printHtmlPart(92)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(93)
}
else {
printHtmlPart(94)
expressionOut.print(question.answerOne)
printHtmlPart(95)
expressionOut.print(question.answerOneVotes)
printHtmlPart(96)
expressionOut.print(question.answerTwo)
printHtmlPart(97)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(93)
}
printHtmlPart(98)
if(true && (question.answerThree)) {
printHtmlPart(99)
if(true && (question.answerThreeImage == true)) {
printHtmlPart(83)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '3', thumb: 'False']))
printHtmlPart(100)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(85)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(86)
}
printHtmlPart(101)
}
printHtmlPart(102)
if(true && (question.answerFour)) {
printHtmlPart(103)
if(true && (question.answerFourImage  == true)) {
printHtmlPart(83)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '4', thumb: 'False']))
printHtmlPart(104)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(85)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(86)
}
printHtmlPart(105)
}
printHtmlPart(106)
if(true && (question.answerThree)) {
printHtmlPart(107)
expressionOut.print(question.answerThree)
printHtmlPart(108)
expressionOut.print(question.answerThreeVotes)
printHtmlPart(109)
}
printHtmlPart(110)
if(true && (question.answerFour)) {
printHtmlPart(111)
expressionOut.print(question.answerFour)
printHtmlPart(112)
expressionOut.print(question.answerFourVotes)
printHtmlPart(113)
}
printHtmlPart(114)
expressionOut.print(createLink(controller: 'Question', action: 'nextInCat', params: [category: question.category]))
printHtmlPart(115)
expressionOut.print(question.category)
printHtmlPart(116)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: question.category, categorySort: 'Trending']))
printHtmlPart(117)
for( _it1242489018 in (questionPromo1) ) {
changeItVariable(_it1242489018)
printHtmlPart(118)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(119)
if(true && (it.answerOneImage)) {
printHtmlPart(120)
expressionOut.print(it.totalVotes)
printHtmlPart(121)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(122)
}
else {
printHtmlPart(123)
expressionOut.print(it.totalVotes)
printHtmlPart(124)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(122)
}
printHtmlPart(125)
expressionOut.print(it.questionTitle)
printHtmlPart(126)
}
printHtmlPart(127)
expressionOut.print(questionID)
printHtmlPart(128)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(129)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(130)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(131)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(132)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(133)
invokeTag('javascript','g',472,['src':("dataAccess.js")],-1)
printHtmlPart(134)
invokeTag('resource','g',473,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(135)
invokeTag('javascript','g',474,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(136)
})
invokeTag('captureBody','sitemesh',562,['style':(" margin-bottom: 20px;  ")],1)
printHtmlPart(137)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444350948196L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
