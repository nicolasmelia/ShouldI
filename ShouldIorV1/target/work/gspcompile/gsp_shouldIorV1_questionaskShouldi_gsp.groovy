import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_questionaskShouldi_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/question/askShouldi.gsp" }
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
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(13)
if(true && (session.name)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(17)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(18)
if(true && (session.name)) {
printHtmlPart(19)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(20)
expressionOut.print(notifyCount)
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
}
else {
printHtmlPart(31)
}
printHtmlPart(32)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI', params: [category: 'Trending']))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldICustom', params: [category: 'Recent']))
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(36)
invokeTag('actionSubmit','g',206,['onclick':("return validate()"),'value':("Post"),'action':("postShouldI"),'style':("margin-top: 1px; width: 100px; display: inline-block;"),'class':("btn btn-default")],-1)
printHtmlPart(37)
})
invokeTag('form','g',211,['controller':("Question"),'action':("postShouldI"),'enctype':("multipart/form-data")],2)
printHtmlPart(38)
invokeTag('resource','g',231,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput-angular.js")],-1)
printHtmlPart(39)
invokeTag('resource','g',232,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.js")],-1)
printHtmlPart(40)
invokeTag('resource','g',233,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.css")],-1)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',374,['style':("background-color: #f4f4f4; min-width: 330px; ")],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443054438208L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
