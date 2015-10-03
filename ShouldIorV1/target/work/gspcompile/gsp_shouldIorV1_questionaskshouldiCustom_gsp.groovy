import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_questionaskshouldiCustom_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/question/askshouldiCustom.gsp" }
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
invokeTag('captureHead','sitemesh',44,[:],1)
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
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(22)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(23)
}
else {
printHtmlPart(24)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(23)
}
printHtmlPart(25)
if(true && (session.name)) {
printHtmlPart(26)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(27)
expressionOut.print(session.name)
printHtmlPart(28)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(29)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(30)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(33)
}
else {
printHtmlPart(34)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI', params: [category: 'Trending']))
printHtmlPart(37)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldICustom', params: [category: 'Recent']))
printHtmlPart(38)
createTagBody(2, {->
printHtmlPart(39)
for( _it580316429 in (categories) ) {
changeItVariable(_it580316429)
printHtmlPart(40)
expressionOut.print(it.category)
printHtmlPart(41)
expressionOut.print(it.category)
printHtmlPart(42)
}
printHtmlPart(43)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(44)
invokeTag('actionSubmit','g',264,['onclick':("return validate()"),'value':("Post"),'action':("postShouldICutom"),'style':("margin-top: 1px; width: 100px; display: inline-block;"),'class':("btn btn-default")],-1)
printHtmlPart(45)
})
invokeTag('form','g',266,['controller':("Question"),'action':("postShouldICutom"),'enctype':("multipart/form-data")],2)
printHtmlPart(46)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(47)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(48)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(49)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(50)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(51)
invokeTag('resource','g',332,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput-angular.js")],-1)
printHtmlPart(52)
invokeTag('resource','g',333,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.js")],-1)
printHtmlPart(53)
invokeTag('resource','g',334,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.css")],-1)
printHtmlPart(54)
})
invokeTag('captureBody','sitemesh',592,['style':("background-color: #f4f4f4; min-width: 330px; ")],1)
printHtmlPart(55)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443806072703L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
