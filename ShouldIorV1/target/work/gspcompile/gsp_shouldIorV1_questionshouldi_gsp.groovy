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
expressionOut.print(createLink(controller: 'User', action: 'myProfile'))
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
for( _it2113658110 in (question) ) {
changeItVariable(_it2113658110)
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
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: it.userID]))
printHtmlPart(39)
if(true && (thisUserPost == true)) {
printHtmlPart(40)
expressionOut.print(it.questionID)
printHtmlPart(41)
}
printHtmlPart(42)
expressionOut.print(it.totalVotes)
printHtmlPart(43)
expressionOut.print(it.questionTitle)
printHtmlPart(44)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(45)
if(true && (it.answerOneImage)) {
printHtmlPart(46)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(47)
}
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(raw(it.question))
printHtmlPart(50)
expressionOut.print(topAnswer)
printHtmlPart(51)
if(true && (it.custom.toString().equals('true'))) {
printHtmlPart(52)
if(true && (it.answerOneImage)) {
printHtmlPart(53)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(54)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(55)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(56)
}
printHtmlPart(57)
if(true && (it.answerTwoImage)) {
printHtmlPart(53)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '2']))
printHtmlPart(54)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(58)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(56)
}
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(61)
expressionOut.print(it.answerOneVotes)
printHtmlPart(62)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(63)
}
else {
printHtmlPart(64)
expressionOut.print(it.answerOne)
printHtmlPart(65)
expressionOut.print(it.answerOneVotes)
printHtmlPart(66)
expressionOut.print(it.answerTwo)
printHtmlPart(67)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(63)
}
printHtmlPart(68)
if(true && (it.answerThree)) {
printHtmlPart(69)
if(true && (it.answerThreeImage)) {
printHtmlPart(53)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '3']))
printHtmlPart(70)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(55)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(56)
}
printHtmlPart(71)
}
printHtmlPart(72)
if(true && (it.answerFour)) {
printHtmlPart(73)
if(true && (it.answerFourImage)) {
printHtmlPart(53)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '4']))
printHtmlPart(54)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(55)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(56)
}
printHtmlPart(74)
}
printHtmlPart(75)
if(true && (it.answerThree)) {
printHtmlPart(76)
expressionOut.print(it.answerThree)
printHtmlPart(77)
expressionOut.print(it.answerThreeVotes)
printHtmlPart(78)
}
printHtmlPart(79)
if(true && (it.answerFour)) {
printHtmlPart(80)
expressionOut.print(it.answerFour)
printHtmlPart(81)
expressionOut.print(it.answerFourVotes)
printHtmlPart(82)
}
printHtmlPart(83)
}
printHtmlPart(84)
for( _it1064041662 in (questionArray) ) {
changeItVariable(_it1064041662)
printHtmlPart(85)
expressionOut.print(it.questionID)
printHtmlPart(86)
if(true && (it.answerOneImage)) {
printHtmlPart(87)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(88)
}
else {
printHtmlPart(89)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(88)
}
printHtmlPart(90)
expressionOut.print(it.questionTitle)
printHtmlPart(91)
}
printHtmlPart(92)
expressionOut.print(questionID)
printHtmlPart(93)
invokeTag('javascript','g',366,['src':("dataAccess.js")],-1)
printHtmlPart(94)
invokeTag('resource','g',367,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(95)
invokeTag('javascript','g',368,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(96)
})
invokeTag('captureBody','sitemesh',452,['style':(" margin-bottom: 20px;  ")],1)
printHtmlPart(97)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442105317186L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
