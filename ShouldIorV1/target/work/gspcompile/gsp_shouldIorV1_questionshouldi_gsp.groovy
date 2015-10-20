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
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick'))
printHtmlPart(28)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(29)
}
else {
printHtmlPart(30)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick'))
printHtmlPart(28)
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
expressionOut.print(question.quick)
printHtmlPart(50)
if(true && (question.anonymous == false && question.UserID != 'nonUser' && question.privateQuestion == false)) {
printHtmlPart(51)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: question.userID]))
printHtmlPart(52)
if(true && (user.certified == true)) {
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(createLink(controller: 'User', action: 'profile', params: [id: question.userID, category : 'New Questions']))
printHtmlPart(55)
expressionOut.print(question.userName)
printHtmlPart(56)
expressionOut.print(user.followerCount)
printHtmlPart(57)
expressionOut.print(user.peopleReached)
printHtmlPart(58)
}
else if(true && (question.UserID == 'nonUser' || question.privateQuestion == true)) {
printHtmlPart(59)
expressionOut.print(question.questionID)
printHtmlPart(60)
}
else {
printHtmlPart(61)
expressionOut.print(resource(dir:'images',file:'blankAv.png'))
printHtmlPart(62)
}
printHtmlPart(63)
expressionOut.print(question.requireLoginToVote)
printHtmlPart(64)
if(true && (thisUserPost == true || question.requireLoginToVote == false)) {
printHtmlPart(65)
if(true && (question.requireLoginToVote == false)) {
printHtmlPart(66)
}
printHtmlPart(67)
if(true && (thisUserPost == true && question.privateQuestion == false)) {
printHtmlPart(68)
expressionOut.print(question.questionID)
printHtmlPart(69)
}
printHtmlPart(70)
}
printHtmlPart(71)
invokeTag('formatDate','g',184,['format':("MM-dd-yyyy"),'date':(question.date)],-1)
printHtmlPart(72)
expressionOut.print(question.totalVotes)
printHtmlPart(73)
if(true && (session.name)) {
printHtmlPart(74)
expressionOut.print(createLink(controller: 'Question', action: 'addToFavorites'))
printHtmlPart(38)
expressionOut.print(question.questionID)
printHtmlPart(75)
}
else {
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (favorite == null)) {
printHtmlPart(78)
}
else {
printHtmlPart(79)
}
printHtmlPart(80)
if(true && (!question.quick)) {
printHtmlPart(81)
expressionOut.print(question.questionTitle)
printHtmlPart(82)
}
printHtmlPart(83)
if(true && (question.custom == false)) {
printHtmlPart(67)
if(true && (question.answerOneImage == true)) {
printHtmlPart(84)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(85)
}
printHtmlPart(86)
}
printHtmlPart(87)
if(true && (!question.quick)) {
printHtmlPart(88)
expressionOut.print(raw(question.question))
printHtmlPart(89)
}
else {
printHtmlPart(90)
expressionOut.print(raw(question.question))
printHtmlPart(91)
}
printHtmlPart(92)
expressionOut.print(topAnswer)
printHtmlPart(93)
if(true && (question.custom.toString().equals('true'))) {
printHtmlPart(94)
if(true && (question.answerOneImage  == true)) {
printHtmlPart(95)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1', thumb: 'False']))
printHtmlPart(96)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(97)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(98)
}
printHtmlPart(99)
if(true && (question.answerTwoImage  == true)) {
printHtmlPart(95)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '2', thumb: 'False']))
printHtmlPart(96)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(100)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(98)
}
printHtmlPart(101)
}
printHtmlPart(67)
if(true && (question.custom == false && question.quick == false)) {
printHtmlPart(102)
expressionOut.print(question.answerOneVotes)
printHtmlPart(103)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(104)
}
else {
printHtmlPart(105)
expressionOut.print(question.answerOne)
printHtmlPart(106)
expressionOut.print(question.answerOneVotes)
printHtmlPart(107)
expressionOut.print(question.answerTwo)
printHtmlPart(108)
expressionOut.print(question.answerTwoVotes)
printHtmlPart(104)
}
printHtmlPart(109)
if(true && (question.answerThree)) {
printHtmlPart(110)
if(true && (question.answerThreeImage == true)) {
printHtmlPart(95)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '3', thumb: 'False']))
printHtmlPart(111)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(97)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(98)
}
printHtmlPart(112)
}
printHtmlPart(113)
if(true && (question.answerFour)) {
printHtmlPart(114)
if(true && (question.answerFourImage  == true)) {
printHtmlPart(95)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '4', thumb: 'False']))
printHtmlPart(115)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(97)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(98)
}
printHtmlPart(112)
}
printHtmlPart(116)
if(true && (question.answerThree)) {
printHtmlPart(117)
expressionOut.print(question.answerThree)
printHtmlPart(118)
expressionOut.print(question.answerThreeVotes)
printHtmlPart(119)
}
printHtmlPart(113)
if(true && (question.answerFour)) {
printHtmlPart(120)
expressionOut.print(question.answerFour)
printHtmlPart(121)
expressionOut.print(question.answerFourVotes)
printHtmlPart(119)
}
printHtmlPart(122)
expressionOut.print(createLink(controller: 'Question', action: 'nextInCat', params: [category: question.category]))
printHtmlPart(123)
expressionOut.print(question.category)
printHtmlPart(124)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: question.category, categorySort: 'Trending']))
printHtmlPart(125)
for( _it1113284578 in (questionPromo1) ) {
changeItVariable(_it1113284578)
printHtmlPart(126)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(127)
if(true && (it.answerOneImage)) {
printHtmlPart(128)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(129)
}
else {
printHtmlPart(130)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(129)
}
printHtmlPart(131)
expressionOut.print(it.questionTitle)
printHtmlPart(132)
}
printHtmlPart(133)
expressionOut.print(questionID)
printHtmlPart(134)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(135)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(136)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(137)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(138)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(139)
invokeTag('javascript','g',437,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(140)
})
invokeTag('captureBody','sitemesh',538,['style':("background-color: #f5f8fa!important; margin-bottom: 20px;  ")],1)
printHtmlPart(141)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445365665633L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
