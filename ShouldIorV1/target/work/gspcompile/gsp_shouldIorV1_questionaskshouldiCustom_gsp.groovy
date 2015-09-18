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
if(true && (session.name)) {
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(16)
if(true && (session.name)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (session.name)) {
printHtmlPart(20)
expressionOut.print(session.userID)
printHtmlPart(21)
expressionOut.print(session.name)
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
invokeTag('actionSubmit','g',259,['onclick':("return validate()"),'value':("Post"),'action':("postShouldICutom"),'style':("margin-top: 1px; width: 100px; display: inline-block;"),'class':("btn btn-default")],-1)
printHtmlPart(26)
})
invokeTag('form','g',261,['controller':("Question"),'action':("postShouldICutom"),'enctype':("multipart/form-data")],2)
printHtmlPart(27)
invokeTag('resource','g',277,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput-angular.js")],-1)
printHtmlPart(28)
invokeTag('resource','g',278,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.js")],-1)
printHtmlPart(29)
invokeTag('resource','g',279,['dir':("js/tagsJS"),'file':("bootstrap-tagsinput.css")],-1)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',523,['style':("background-color: #f4f4f4; min-width: 330px; ")],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442532852366L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
