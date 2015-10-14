import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_authenticationloginReddit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/authentication/loginReddit.gsp" }
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
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("ShouldI.fm is a place where you can ask the world questions and get honest answers. Start a poll, it's free and easy!")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("ShouldI.fm")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir:'images',file:'logoBrowser.png'))
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(6)
invokeTag('resource','g',17,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',18,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',19,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',20,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',22,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',24,['src':("facebookLogin.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',25,['src':("dataAccess.js")],-1)
printHtmlPart(10)
invokeTag('resource','g',28,['dir':("css"),'file':("typehead-searchBar.css")],-1)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',36,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(12)
if(true && (session.name)) {
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(16)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(17)
if(true && (session.name)) {
printHtmlPart(18)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(19)
expressionOut.print(notifyCount)
printHtmlPart(20)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(21)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(22)
}
else {
printHtmlPart(23)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(22)
}
printHtmlPart(24)
if(true && (session.name)) {
printHtmlPart(25)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(26)
expressionOut.print(session.name)
printHtmlPart(27)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(28)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(29)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(30)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(32)
}
else {
printHtmlPart(33)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(34)
}
printHtmlPart(35)
expressionOut.print(resource(dir:'images',file:'logoDark.png'))
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
if(true && (Success == false)) {
printHtmlPart(38)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
invokeTag('actionSubmit','g',129,['value':("Login"),'onclick':("return validate()"),'type':("submit"),'action':("loginRedditAttempt"),'style':("margin-top: 5px; width: 100%; "),'class':("btn btn-primary")],-1)
printHtmlPart(1)
})
invokeTag('form','g',130,['controller':("Authentication"),'action':("loginRedditAttempt"),'enctype':("multipart/form-data"),'class':("form-signin"),'style':("max-width: 300px; margin: auto;")],2)
printHtmlPart(41)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(42)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(43)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(44)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(45)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(46)
})
invokeTag('captureBody','sitemesh',216,['style':("background-color: #F6F6F6!important; background-image:url('${resource(dir: "images", file: "wall1.jpg")}'); margin-bottom: 20px; background-size: cover;  background-attachment: fixed; min-width: 320px;  ")],1)
printHtmlPart(47)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444670856134L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
