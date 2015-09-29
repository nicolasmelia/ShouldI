import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_usereditAbout_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/editAbout.gsp" }
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
invokeTag('resource','g',14,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(4)
invokeTag('resource','g',15,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(4)
invokeTag('resource','g',16,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(5)
invokeTag('resource','g',19,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(6)
invokeTag('javascript','g',22,['src':("facebookLogin.js")],-1)
printHtmlPart(7)
invokeTag('javascript','g',23,['src':("dataRequest.js")],-1)
printHtmlPart(8)
invokeTag('resource','g',35,['dir':("js/wysihtml5"),'file':("advanced.js")],-1)
printHtmlPart(9)
invokeTag('resource','g',36,['dir':("js/wysihtml5"),'file':("wysihtml5-0.3.0.min.js")],-1)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',47,[:],1)
printHtmlPart(11)
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
createTagBody(2, {->
printHtmlPart(36)
expressionOut.print(user.about)
printHtmlPart(37)
invokeTag('actionSubmit','g',157,['value':("Update"),'action':("updateAbout"),'style':("margin-top: 1px; width: 100px; display: inline-block;"),'class':("btn btn-default")],-1)
printHtmlPart(38)
})
invokeTag('form','g',159,['controller':("User"),'action':("updateAbout"),'enctype':("multipart/form-data")],2)
printHtmlPart(39)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(40)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(41)
invokeTag('resource','g',200,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput-angular.js")],-1)
printHtmlPart(42)
invokeTag('resource','g',201,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.js")],-1)
printHtmlPart(43)
invokeTag('resource','g',202,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.css")],-1)
printHtmlPart(44)
})
invokeTag('captureBody','sitemesh',345,['style':("background-color: #f4f4f4; min-width: 330px; ")],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443458276318L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
