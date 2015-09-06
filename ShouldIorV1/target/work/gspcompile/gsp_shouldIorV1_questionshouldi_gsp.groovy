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
invokeTag('resource','g',13,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',15,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(7)
invokeTag('javascript','g',17,['src':("facebookLogin.js")],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
if(true && (session.name)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(percentDiff)
printHtmlPart(14)
expressionOut.print(vote)
printHtmlPart(15)
expressionOut.print(answerOneVote)
printHtmlPart(16)
expressionOut.print(answerTwoVote)
printHtmlPart(17)
expressionOut.print(answerThreeVote)
printHtmlPart(18)
expressionOut.print(answerFourVote)
printHtmlPart(19)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(20)
if(true && (session.name)) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (session.name)) {
printHtmlPart(24)
expressionOut.print(session.userID)
printHtmlPart(25)
expressionOut.print(session.name)
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
for( _it501766514 in (question) ) {
changeItVariable(_it501766514)
printHtmlPart(29)
expressionOut.print(it.questionID)
printHtmlPart(30)
expressionOut.print(it.userID)
printHtmlPart(31)
if(true && (vote.toString().equals('NONE'))) {
printHtmlPart(32)
expressionOut.print(it.totalVotes)
printHtmlPart(33)
}
else {
printHtmlPart(34)
expressionOut.print(topAnswer)
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print(it.questionTitle)
printHtmlPart(37)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(38)
if(true && (it.answerOneImage)) {
printHtmlPart(39)
expressionOut.print(it.questionID)
printHtmlPart(40)
}
printHtmlPart(41)
}
printHtmlPart(42)
expressionOut.print(raw(it.question))
printHtmlPart(43)
expressionOut.print(hasQuestionImage)
printHtmlPart(44)
if(true && (it.custom.toString().equals('true'))) {
printHtmlPart(45)
if(true && (it.answerOneImage)) {
printHtmlPart(46)
expressionOut.print(it.questionID)
printHtmlPart(47)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(48)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(49)
}
printHtmlPart(50)
if(true && (it.answerTwoImage)) {
printHtmlPart(46)
expressionOut.print(it.questionID)
printHtmlPart(51)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(52)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(49)
}
printHtmlPart(53)
}
printHtmlPart(54)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(55)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(56)
expressionOut.print(it.answerOneVotes)
printHtmlPart(57)
}
printHtmlPart(58)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(56)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(57)
}
printHtmlPart(59)
}
else {
printHtmlPart(60)
expressionOut.print(it.answerOne)
printHtmlPart(61)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(62)
expressionOut.print(it.answerOneVotes)
printHtmlPart(63)
}
printHtmlPart(64)
expressionOut.print(it.answerTwo)
printHtmlPart(65)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(66)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(63)
}
printHtmlPart(67)
}
printHtmlPart(68)
if(true && (it.answerThree)) {
printHtmlPart(69)
if(true && (it.answerThreeImage)) {
printHtmlPart(46)
expressionOut.print(it.questionID)
printHtmlPart(70)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(48)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(49)
}
printHtmlPart(71)
}
printHtmlPart(72)
if(true && (it.answerFour)) {
printHtmlPart(73)
if(true && (it.answerFourImage)) {
printHtmlPart(46)
expressionOut.print(it.questionID)
printHtmlPart(74)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(48)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(49)
}
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (it.answerThree)) {
printHtmlPart(77)
expressionOut.print(it.answerThree)
printHtmlPart(78)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(79)
expressionOut.print(it.answerThreeVotes)
printHtmlPart(57)
}
printHtmlPart(80)
}
printHtmlPart(81)
if(true && (it.answerFour)) {
printHtmlPart(82)
expressionOut.print(it.answerFour)
printHtmlPart(83)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(84)
expressionOut.print(it.answerFourVotes)
printHtmlPart(57)
}
printHtmlPart(85)
}
printHtmlPart(86)
}
printHtmlPart(87)
for( _it1471278212 in (questionArray) ) {
changeItVariable(_it1471278212)
printHtmlPart(88)
expressionOut.print(it.questionID)
printHtmlPart(89)
if(true && (it.answerOneImage)) {
printHtmlPart(90)
expressionOut.print(it.questionID)
printHtmlPart(91)
}
else {
printHtmlPart(92)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(93)
}
printHtmlPart(94)
expressionOut.print(it.questionTitle)
printHtmlPart(95)
}
printHtmlPart(96)
expressionOut.print(questionID)
printHtmlPart(97)
invokeTag('javascript','g',349,['src':("dataAccess.js")],-1)
printHtmlPart(98)
invokeTag('resource','g',350,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(99)
invokeTag('javascript','g',351,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(100)
})
invokeTag('captureBody','sitemesh',400,['style':("  ")],1)
printHtmlPart(101)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441510487078L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
