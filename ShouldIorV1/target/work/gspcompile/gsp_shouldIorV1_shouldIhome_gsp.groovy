import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_shouldIhome_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/shouldI/home.gsp" }
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
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
invokeTag('resource','g',18,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',19,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',20,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',23,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',26,['src':("facebookLogin.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',27,['src':("dataRequest.js")],-1)
printHtmlPart(10)
invokeTag('resource','g',33,['dir':("css"),'file':("typehead-searchBar.css")],-1)
printHtmlPart(11)
invokeTag('resource','g',36,['dir':("js/typedJS"),'file':("typed.min.js")],-1)
printHtmlPart(12)
invokeTag('resource','g',38,['dir':("js/typeaheadJS"),'file':("typeahead.jquery.min.js")],-1)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',46,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
if(true && (session.name)) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(19)
if(true && (session.name)) {
printHtmlPart(20)
expressionOut.print(session.name)
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
for( _it105856166 in (question) ) {
changeItVariable(_it105856166)
printHtmlPart(24)
expressionOut.print(it.questionID)
printHtmlPart(25)
if(true && (it.answerOneImage)) {
printHtmlPart(26)
expressionOut.print(it.questionID)
printHtmlPart(27)
}
else {
printHtmlPart(28)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(29)
}
printHtmlPart(30)
expressionOut.print(it.questionTitle)
printHtmlPart(31)
expressionOut.print(it.totalVotes)
printHtmlPart(32)
}
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',301,['style':("background-image:url('${resource(dir: "images", file: "wall1.jpg")}');  background-size: cover;  background-attachment: fixed; min-width: 330px;  ")],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1439943931201L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
