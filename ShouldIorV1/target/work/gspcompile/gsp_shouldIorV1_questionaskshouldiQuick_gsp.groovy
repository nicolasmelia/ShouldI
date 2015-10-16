import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_questionaskshouldiQuick_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/question/askshouldiQuick.gsp" }
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
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(6)
invokeTag('resource','g',15,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',16,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',17,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(9)
invokeTag('resource','g',19,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(10)
invokeTag('resource','g',21,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(11)
invokeTag('javascript','g',23,['src':("facebookLogin.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',24,['src':("dataAccess.js")],-1)
printHtmlPart(12)
invokeTag('resource','g',30,['dir':("js/wysihtml5"),'file':("advanced.js")],-1)
printHtmlPart(13)
invokeTag('resource','g',33,['dir':("js/wysihtml5"),'file':("wysihtml5-0.3.0.min.js")],-1)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',40,[:],1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(4)
if(true && (session.name)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
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
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick'))
printHtmlPart(25)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(26)
}
else {
printHtmlPart(27)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick'))
printHtmlPart(25)
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
if(true && (session.name)) {
printHtmlPart(40)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick', params: [category: 'Allow']))
printHtmlPart(41)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI', params: [category: 'Allow']))
printHtmlPart(42)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldICustom', params: [category: 'Allow']))
printHtmlPart(43)
}
else {
printHtmlPart(44)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick', params: [category: 'Allow']))
printHtmlPart(45)
}
printHtmlPart(46)
createTagBody(2, {->
printHtmlPart(47)
for( _it118105337 in (categories) ) {
changeItVariable(_it118105337)
printHtmlPart(48)
expressionOut.print(it.category)
printHtmlPart(49)
expressionOut.print(it.category)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (!session.name)) {
printHtmlPart(52)
}
else {
printHtmlPart(53)
}
printHtmlPart(54)
invokeTag('actionSubmit','g',234,['onclick':("return validate()"),'value':("Post"),'action':("postShouldIQuick"),'style':("margin-top: 1px; width: 100px; display: inline-block;"),'class':("btn btn-default")],-1)
printHtmlPart(55)
})
invokeTag('form','g',238,['controller':("Question"),'action':("postShouldIQuick"),'enctype':("multipart/form-data")],2)
printHtmlPart(56)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(57)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(58)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(59)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(60)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(61)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(57)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(62)
})
invokeTag('captureBody','sitemesh',576,['style':("background-color: #f4f4f4; min-width: 330px; ")],1)
printHtmlPart(63)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444928666264L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
