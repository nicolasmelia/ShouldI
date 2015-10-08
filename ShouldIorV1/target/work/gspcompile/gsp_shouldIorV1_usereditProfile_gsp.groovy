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
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("ShouldI.fm")],-1)
printHtmlPart(4)
expressionOut.print(resource(dir:'images',file:'logoBrowser.png'))
printHtmlPart(5)
createTagBody(2, {->
createClosureForHtmlPart(6, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(7)
invokeTag('resource','g',18,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',19,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',20,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(9)
invokeTag('resource','g',23,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(10)
invokeTag('javascript','g',26,['src':("facebookLogin.js")],-1)
printHtmlPart(11)
invokeTag('javascript','g',27,['src':("dataAccess.js")],-1)
printHtmlPart(12)
invokeTag('resource','g',39,['dir':("js/wysihtml5"),'file':("advanced.js")],-1)
printHtmlPart(13)
invokeTag('resource','g',40,['dir':("js/wysihtml5"),'file':("wysihtml5-0.3.0.min.js")],-1)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',48,[:],1)
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
expressionOut.print(createLink(controller: 'User', action: 'checkUserName'))
printHtmlPart(20)
expressionOut.print(session.userID)
printHtmlPart(21)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(22)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(23)
if(true && (session.name)) {
printHtmlPart(24)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(25)
expressionOut.print(notifyCount)
printHtmlPart(26)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(27)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(28)
}
else {
printHtmlPart(29)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(28)
}
printHtmlPart(30)
if(true && (session.name)) {
printHtmlPart(31)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(32)
expressionOut.print(session.name)
printHtmlPart(33)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(35)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(36)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(37)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(38)
}
else {
printHtmlPart(39)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(40)
}
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(42)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(43)
expressionOut.print(user.name)
printHtmlPart(44)
expressionOut.print(user.about)
printHtmlPart(45)
invokeTag('actionSubmit','g',194,['value':("Update"),'onclick':("return validate()"),'action':("updateProfile"),'style':("margin-top: 1px; width: 100px; display: inline-block;"),'class':("btn btn-default")],-1)
printHtmlPart(46)
})
invokeTag('form','g',201,['controller':("User"),'action':("updateProfile"),'enctype':("multipart/form-data")],2)
printHtmlPart(47)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(48)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(49)
invokeTag('resource','g',241,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput-angular.js")],-1)
printHtmlPart(50)
invokeTag('resource','g',242,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.js")],-1)
printHtmlPart(51)
invokeTag('resource','g',243,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.css")],-1)
printHtmlPart(52)
})
invokeTag('captureBody','sitemesh',441,['style':("background-color: #f4f4f4; min-width: 330px; ")],1)
printHtmlPart(53)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444271888875L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
