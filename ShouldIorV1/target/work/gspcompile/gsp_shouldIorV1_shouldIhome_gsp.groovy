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
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
invokeTag('resource','g',14,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',15,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',16,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',18,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',20,['src':("facebookLogin.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',21,['src':("dataRequest.js")],-1)
printHtmlPart(9)
invokeTag('resource','g',24,['dir':("css"),'file':("typehead-searchBar.css")],-1)
printHtmlPart(10)
invokeTag('resource','g',26,['dir':("js/typedJS"),'file':("typed.min.js")],-1)
printHtmlPart(11)
invokeTag('resource','g',29,['dir':("js/typeaheadJS"),'file':("typeahead.jquery.min.js")],-1)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',36,[:],1)
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
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(17)
if(true && (session.name)) {
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (session.name)) {
printHtmlPart(21)
expressionOut.print(session.userID)
printHtmlPart(22)
expressionOut.print(session.name)
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
expressionOut.print(resource(dir:'images',file:'logoDark.png'))
printHtmlPart(26)
for( _it1626987646 in (question) ) {
changeItVariable(_it1626987646)
printHtmlPart(27)
expressionOut.print(it.questionID)
printHtmlPart(28)
if(true && (it.answerOneImage)) {
printHtmlPart(29)
expressionOut.print(it.questionID)
printHtmlPart(30)
}
else {
printHtmlPart(31)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(32)
}
printHtmlPart(33)
expressionOut.print(it.questionTitle)
printHtmlPart(34)
expressionOut.print(it.totalVotes)
printHtmlPart(35)
}
printHtmlPart(36)
for( _it22958662 in (question) ) {
changeItVariable(_it22958662)
printHtmlPart(37)
expressionOut.print(it.questionID)
printHtmlPart(38)
if(true && (it.answerOneImage)) {
printHtmlPart(39)
expressionOut.print(it.questionID)
printHtmlPart(40)
}
else {
printHtmlPart(41)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(42)
}
printHtmlPart(43)
expressionOut.print(it.questionTitle)
printHtmlPart(44)
}
printHtmlPart(45)
})
invokeTag('captureBody','sitemesh',337,['style':("background-image:url('${resource(dir: "images", file: "wall21.jpg")}'); margin-bottom: 20px; background-size: cover;  background-attachment: fixed; min-width: 330px;  ")],1)
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1440998301555L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
