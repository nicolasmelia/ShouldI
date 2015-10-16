import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_usereditProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/editProfile.gsp" }
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
printHtmlPart(7)
invokeTag('resource','g',17,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',18,['dir':("css"),'file':("cropper.min.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',22,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',24,['src':("facebookLogin.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',25,['src':("dataAccess.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',26,['src':("cropper.min.js")],-1)
printHtmlPart(10)
invokeTag('resource','g',34,['dir':("js/wysihtml5"),'file':("advanced.js")],-1)
printHtmlPart(11)
invokeTag('resource','g',37,['dir':("js/wysihtml5"),'file':("wysihtml5-0.3.0.min.js")],-1)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',52,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(1)
if(true && (session.name)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(createLink(controller: 'User', action: 'checkUserName'))
printHtmlPart(17)
expressionOut.print(session.userID)
printHtmlPart(18)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(19)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(20)
if(true && (session.name)) {
printHtmlPart(21)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(22)
expressionOut.print(notifyCount)
printHtmlPart(23)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick'))
printHtmlPart(24)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(25)
}
else {
printHtmlPart(26)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick'))
printHtmlPart(24)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(25)
}
printHtmlPart(27)
if(true && (session.name)) {
printHtmlPart(28)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(29)
expressionOut.print(session.name)
printHtmlPart(30)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(35)
}
else {
printHtmlPart(36)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(37)
}
printHtmlPart(38)
createTagBody(2, {->
printHtmlPart(39)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(40)
expressionOut.print(user.name)
printHtmlPart(41)
expressionOut.print(user.name)
printHtmlPart(42)
expressionOut.print(user.about)
printHtmlPart(43)
invokeTag('actionSubmit','g',169,['value':("Update"),'onclick':("return validate()"),'action':("updateProfile"),'style':("margin-top: 1px; width: 100px; display: inline-block;"),'class':("btn btn-default")],-1)
printHtmlPart(44)
})
invokeTag('form','g',171,['controller':("User"),'action':("updateProfile"),'enctype':("multipart/form-data")],2)
printHtmlPart(45)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(46)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(47)
})
invokeTag('captureBody','sitemesh',407,['style':("background-color: #f4f4f4; min-width: 330px; ")],1)
printHtmlPart(48)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444928194534L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
