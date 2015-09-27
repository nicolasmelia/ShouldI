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
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
invokeTag('resource','g',14,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',15,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',16,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',17,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',19,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',21,['src':("facebookLogin.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',22,['src':("dataAccess.js")],-1)
printHtmlPart(9)
invokeTag('resource','g',25,['dir':("css"),'file':("typehead-searchBar.css")],-1)
printHtmlPart(10)
invokeTag('resource','g',26,['dir':("js/typedJS"),'file':("typed.min.js")],-1)
printHtmlPart(11)
invokeTag('resource','g',28,['dir':("js/typeaheadJS"),'file':("typeahead.jquery.min.js")],-1)
printHtmlPart(12)
invokeTag('resource','g',31,['dir':("js/chart"),'file':("Chart.min.js")],-1)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',39,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(14)
if(true && (session.name)) {
printHtmlPart(15)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(18)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(19)
if(true && (session.name)) {
printHtmlPart(20)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(21)
expressionOut.print(notifyCount)
printHtmlPart(22)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(23)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(24)
}
else {
printHtmlPart(25)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(24)
}
printHtmlPart(26)
if(true && (session.name)) {
printHtmlPart(27)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(28)
expressionOut.print(session.name)
printHtmlPart(29)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(30)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(31)
}
else {
printHtmlPart(32)
}
printHtmlPart(33)
expressionOut.print(resource(dir:'images',file:'logoDark.png'))
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
if(true && (Success == false)) {
printHtmlPart(36)
}
printHtmlPart(37)
invokeTag('actionSubmit','g',123,['value':("Login"),'type':("submit"),'action':("loginRedditAttempt"),'style':("margin-top: 5px; width: 100%; "),'class':("btn btn-primary")],-1)
printHtmlPart(1)
})
invokeTag('form','g',124,['controller':("Authentication"),'action':("loginRedditAttempt"),'enctype':("multipart/form-data"),'class':("form-signin"),'style':("max-width: 300px; margin: auto;")],2)
printHtmlPart(38)
})
invokeTag('captureBody','sitemesh',139,['style':("background-color: #F6F6F6!important; background-image:url('${resource(dir: "images", file: "wall1.jpg")}'); margin-bottom: 20px; background-size: cover;  background-attachment: fixed; min-width: 320px;  ")],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443320074969L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
