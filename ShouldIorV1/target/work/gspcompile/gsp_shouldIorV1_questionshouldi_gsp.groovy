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
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(17)
if(true && (session.name)) {
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (session.name)) {
printHtmlPart(21)
expressionOut.print(session.userID)
printHtmlPart(22)
expressionOut.print(session.name)
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
for( _it1037983544 in (question) ) {
changeItVariable(_it1037983544)
printHtmlPart(26)
expressionOut.print(it.totalVotes)
printHtmlPart(27)
expressionOut.print(it.answerOneVotes)
printHtmlPart(28)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(29)
expressionOut.print(it.answerThreeVotes)
printHtmlPart(30)
expressionOut.print(it.answerFourVotes)
printHtmlPart(31)
expressionOut.print(it.questionID)
printHtmlPart(32)
expressionOut.print(it.userID)
printHtmlPart(33)
if(true && (vote.toString().equals('NONE'))) {
printHtmlPart(34)
expressionOut.print(it.totalVotes)
printHtmlPart(35)
}
else {
printHtmlPart(36)
expressionOut.print(topAnswer)
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(it.questionTitle)
printHtmlPart(39)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(40)
if(true && (it.answerOneImage)) {
printHtmlPart(41)
expressionOut.print(it.questionID)
printHtmlPart(42)
}
printHtmlPart(43)
}
printHtmlPart(44)
expressionOut.print(raw(it.question))
printHtmlPart(45)
if(true && (it.custom.toString().equals('true'))) {
printHtmlPart(46)
if(true && (it.answerOneImage)) {
printHtmlPart(47)
expressionOut.print(it.questionID)
printHtmlPart(48)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(49)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (it.answerTwoImage)) {
printHtmlPart(47)
expressionOut.print(it.questionID)
printHtmlPart(52)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(53)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(50)
}
printHtmlPart(54)
}
printHtmlPart(55)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(56)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(57)
expressionOut.print(it.answerOneVotes)
printHtmlPart(58)
}
printHtmlPart(59)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(57)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(58)
}
printHtmlPart(60)
}
else {
printHtmlPart(61)
expressionOut.print(it.answerOne)
printHtmlPart(62)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(63)
expressionOut.print(it.answerOneVotes)
printHtmlPart(64)
}
printHtmlPart(65)
expressionOut.print(it.answerTwo)
printHtmlPart(66)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(67)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(64)
}
printHtmlPart(68)
}
printHtmlPart(69)
if(true && (it.answerThree)) {
printHtmlPart(70)
if(true && (it.answerThreeImage)) {
printHtmlPart(47)
expressionOut.print(it.questionID)
printHtmlPart(71)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(49)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(50)
}
printHtmlPart(72)
}
printHtmlPart(73)
if(true && (it.answerFour)) {
printHtmlPart(74)
if(true && (it.answerFourImage)) {
printHtmlPart(47)
expressionOut.print(it.questionID)
printHtmlPart(75)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(49)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(50)
}
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (it.answerThree)) {
printHtmlPart(78)
expressionOut.print(it.answerThree)
printHtmlPart(79)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(80)
expressionOut.print(it.answerThreeVotes)
printHtmlPart(58)
}
printHtmlPart(81)
}
printHtmlPart(82)
if(true && (it.answerFour)) {
printHtmlPart(83)
expressionOut.print(it.answerFour)
printHtmlPart(84)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(85)
expressionOut.print(it.answerFourVotes)
printHtmlPart(58)
}
printHtmlPart(86)
}
printHtmlPart(87)
}
printHtmlPart(88)
for( _it105856166 in (questionArray) ) {
changeItVariable(_it105856166)
printHtmlPart(89)
expressionOut.print(it.questionID)
printHtmlPart(90)
if(true && (it.answerOneImage)) {
printHtmlPart(91)
expressionOut.print(it.questionID)
printHtmlPart(92)
}
else {
printHtmlPart(93)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(94)
}
printHtmlPart(95)
expressionOut.print(it.questionTitle)
printHtmlPart(96)
}
printHtmlPart(97)
expressionOut.print(questionID)
printHtmlPart(98)
invokeTag('javascript','g',369,['src':("dataAccess.js")],-1)
printHtmlPart(99)
invokeTag('resource','g',370,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(100)
invokeTag('javascript','g',371,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(101)
})
invokeTag('captureBody','sitemesh',446,['style':("  ")],1)
printHtmlPart(102)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441668722466L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
