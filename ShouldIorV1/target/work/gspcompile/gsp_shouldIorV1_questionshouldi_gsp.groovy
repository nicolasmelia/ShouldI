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
for( _it187885955 in (question) ) {
changeItVariable(_it187885955)
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
if(true && (thisUserPost == true)) {
printHtmlPart(34)
expressionOut.print(it.questionID)
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print(it.totalVotes)
printHtmlPart(37)
expressionOut.print(it.questionTitle)
printHtmlPart(38)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(39)
if(true && (it.answerOneImage)) {
printHtmlPart(40)
expressionOut.print(it.questionID)
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(43)
expressionOut.print(raw(it.question))
printHtmlPart(44)
if(true && (vote.toString().equals('NONE'))) {
printHtmlPart(45)
}
else {
printHtmlPart(46)
expressionOut.print(topAnswer)
printHtmlPart(47)
}
printHtmlPart(48)
if(true && (it.custom.toString().equals('true'))) {
printHtmlPart(49)
if(true && (it.answerOneImage)) {
printHtmlPart(50)
expressionOut.print(it.questionID)
printHtmlPart(51)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(52)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(53)
}
printHtmlPart(54)
if(true && (it.answerTwoImage)) {
printHtmlPart(50)
expressionOut.print(it.questionID)
printHtmlPart(55)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(56)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(53)
}
printHtmlPart(57)
}
printHtmlPart(58)
if(true && (it.custom.toString().equals('false'))) {
printHtmlPart(59)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(60)
expressionOut.print(it.answerOneVotes)
printHtmlPart(61)
}
printHtmlPart(62)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(60)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(61)
}
printHtmlPart(63)
}
else {
printHtmlPart(64)
expressionOut.print(it.answerOne)
printHtmlPart(65)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(66)
expressionOut.print(it.answerOneVotes)
printHtmlPart(67)
}
printHtmlPart(68)
expressionOut.print(it.answerTwo)
printHtmlPart(69)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(70)
expressionOut.print(it.answerTwoVotes)
printHtmlPart(67)
}
printHtmlPart(71)
}
printHtmlPart(72)
if(true && (it.answerThree)) {
printHtmlPart(73)
if(true && (it.answerThreeImage)) {
printHtmlPart(50)
expressionOut.print(it.questionID)
printHtmlPart(74)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(52)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(53)
}
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (it.answerFour)) {
printHtmlPart(77)
if(true && (it.answerFourImage)) {
printHtmlPart(50)
expressionOut.print(it.questionID)
printHtmlPart(78)
}
else if(true && (hasQuestionImage.toString().equals('true'))) {
printHtmlPart(52)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(53)
}
printHtmlPart(79)
}
printHtmlPart(80)
if(true && (it.answerThree)) {
printHtmlPart(81)
expressionOut.print(it.answerThree)
printHtmlPart(82)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(83)
expressionOut.print(it.answerThreeVotes)
printHtmlPart(61)
}
printHtmlPart(84)
}
printHtmlPart(85)
if(true && (it.answerFour)) {
printHtmlPart(86)
expressionOut.print(it.answerFour)
printHtmlPart(87)
if(true && (!vote.toString().equals('NONE'))) {
printHtmlPart(88)
expressionOut.print(it.answerFourVotes)
printHtmlPart(61)
}
printHtmlPart(89)
}
printHtmlPart(90)
}
printHtmlPart(91)
for( _it383753182 in (questionArray) ) {
changeItVariable(_it383753182)
printHtmlPart(92)
expressionOut.print(it.questionID)
printHtmlPart(93)
if(true && (it.answerOneImage)) {
printHtmlPart(94)
expressionOut.print(it.questionID)
printHtmlPart(95)
}
else {
printHtmlPart(96)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(97)
}
printHtmlPart(98)
expressionOut.print(it.questionTitle)
printHtmlPart(99)
}
printHtmlPart(100)
expressionOut.print(questionID)
printHtmlPart(101)
invokeTag('javascript','g',385,['src':("dataAccess.js")],-1)
printHtmlPart(102)
invokeTag('resource','g',386,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(103)
invokeTag('javascript','g',387,['src':("buttonAnswerGlow.js")],-1)
printHtmlPart(104)
})
invokeTag('captureBody','sitemesh',463,['style':(" margin-bottom: 20px;  ")],1)
printHtmlPart(105)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441905478348L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
