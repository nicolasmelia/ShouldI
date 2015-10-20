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
invokeTag('resource','g',20,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(9)
invokeTag('resource','g',21,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(9)
invokeTag('resource','g',22,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(10)
invokeTag('resource','g',25,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(11)
invokeTag('javascript','g',28,['src':("facebookLogin.js")],-1)
printHtmlPart(12)
invokeTag('javascript','g',29,['src':("dataAccess.js")],-1)
printHtmlPart(13)
invokeTag('resource','g',39,['dir':("js/wysihtml5"),'file':("advanced.js")],-1)
printHtmlPart(14)
invokeTag('resource','g',40,['dir':("js/wysihtml5"),'file':("wysihtml5-0.3.0.min.js")],-1)
printHtmlPart(15)
})
invokeTag('captureHead','sitemesh',51,[:],1)
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(17)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(18)
if(true && (session.name)) {
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
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
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick'))
printHtmlPart(27)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(28)
}
else {
printHtmlPart(29)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick'))
printHtmlPart(27)
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
expressionOut.print(createLink(controller: 'Question', action: 'askShouldIQuick', params: [category: 'Trending']))
printHtmlPart(42)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI', params: [category: 'Trending']))
printHtmlPart(43)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldICustom', params: [category: 'Recent']))
printHtmlPart(44)
createTagBody(2, {->
printHtmlPart(45)
for( _it866416391 in (categories) ) {
changeItVariable(_it866416391)
printHtmlPart(46)
expressionOut.print(it.category)
printHtmlPart(47)
expressionOut.print(it.category)
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(50)
invokeTag('actionSubmit','g',209,['onclick':("return validate()"),'value':("Post"),'action':("postShouldI"),'style':("margin-top: 1px; width: 100px; display: inline-block;"),'class':("btn btn-default")],-1)
printHtmlPart(51)
})
invokeTag('form','g',214,['controller':("Question"),'action':("postShouldI"),'enctype':("multipart/form-data")],2)
printHtmlPart(52)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(53)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(54)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(55)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(56)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(57)
})
invokeTag('captureBody','sitemesh',442,['style':("background-color: #f4f4f4; min-width: 330px; ")],1)
printHtmlPart(58)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445383075473L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
