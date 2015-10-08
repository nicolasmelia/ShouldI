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
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("ShouldI.fm is a place where you can ask the world questions and get honest answers. Start a poll, it's free and easy!")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("ShouldI.fm")],-1)
printHtmlPart(4)
expressionOut.print(resource(dir:'images',file:'logoBrowser.png'))
printHtmlPart(5)
createTagBody(2, {->
createClosureForHtmlPart(6, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(7)
invokeTag('resource','g',19,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',20,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',21,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(9)
invokeTag('resource','g',24,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(10)
invokeTag('javascript','g',27,['src':("facebookLogin.js")],-1)
printHtmlPart(11)
invokeTag('javascript','g',28,['src':("dataAccess.js")],-1)
printHtmlPart(12)
invokeTag('resource','g',40,['dir':("js/wysihtml5"),'file':("advanced.js")],-1)
printHtmlPart(13)
invokeTag('resource','g',41,['dir':("js/wysihtml5"),'file':("wysihtml5-0.3.0.min.js")],-1)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',52,[:],1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(17)
if(true && (session.name)) {
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(21)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(22)
if(true && (session.name)) {
printHtmlPart(23)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(24)
expressionOut.print(notifyCount)
printHtmlPart(25)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(26)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(27)
}
else {
printHtmlPart(28)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(27)
}
printHtmlPart(29)
if(true && (session.name)) {
printHtmlPart(30)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(31)
expressionOut.print(session.name)
printHtmlPart(32)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(35)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(36)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(37)
}
else {
printHtmlPart(38)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(39)
}
printHtmlPart(40)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI', params: [category: 'Trending']))
printHtmlPart(41)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldICustom', params: [category: 'Recent']))
printHtmlPart(42)
createTagBody(2, {->
printHtmlPart(43)
for( _it1286172885 in (categories) ) {
changeItVariable(_it1286172885)
printHtmlPart(44)
expressionOut.print(it.category)
printHtmlPart(45)
expressionOut.print(it.category)
printHtmlPart(46)
}
printHtmlPart(47)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(48)
invokeTag('actionSubmit','g',208,['onclick':("return validate()"),'value':("Post"),'action':("postShouldI"),'style':("margin-top: 1px; width: 100px; display: inline-block;"),'class':("btn btn-default")],-1)
printHtmlPart(49)
})
invokeTag('form','g',213,['controller':("Question"),'action':("postShouldI"),'enctype':("multipart/form-data")],2)
printHtmlPart(50)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(51)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(52)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(53)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(54)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(55)
invokeTag('resource','g',286,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput-angular.js")],-1)
printHtmlPart(56)
invokeTag('resource','g',287,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.js")],-1)
printHtmlPart(57)
invokeTag('resource','g',288,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.css")],-1)
printHtmlPart(58)
})
invokeTag('captureBody','sitemesh',450,['style':("background-color: #f4f4f4; min-width: 330px; ")],1)
printHtmlPart(59)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444261576516L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
