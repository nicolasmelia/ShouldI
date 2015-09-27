import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_shouldIorV1_shouldIcategory_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/shouldI/category.gsp" }
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
invokeTag('resource','g',16,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(6)
invokeTag('resource','g',17,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',19,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',21,['src':("facebookLogin.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',22,['src':("dataRequest.js")],-1)
printHtmlPart(9)
invokeTag('resource','g',25,['dir':("css"),'file':("typehead-searchBar.css")],-1)
printHtmlPart(10)
invokeTag('resource','g',27,['dir':("js/typedJS"),'file':("typed.min.js")],-1)
printHtmlPart(11)
invokeTag('resource','g',30,['dir':("js/typeaheadJS"),'file':("typeahead.jquery.min.js")],-1)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',37,[:],1)
printHtmlPart(13)
expressionOut.print(category)
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
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(24)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(25)
}
else {
printHtmlPart(26)
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
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(32)
}
else {
printHtmlPart(33)
}
printHtmlPart(34)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(35)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: 'Recent']))
printHtmlPart(36)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: 'two']))
printHtmlPart(37)
expressionOut.print(category)
printHtmlPart(38)
for( _it1039629818 in (questions) ) {
changeItVariable(_it1039629818)
printHtmlPart(39)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(40)
if(true && (it.answerOneImage)) {
printHtmlPart(41)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(42)
}
else {
printHtmlPart(43)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(44)
}
printHtmlPart(45)
expressionOut.print(it.userName)
printHtmlPart(46)
expressionOut.print(it.questionTitle)
printHtmlPart(47)
expressionOut.print(it.totalVotes)
printHtmlPart(48)
expressionOut.print(it.totalViews)
printHtmlPart(49)
}
printHtmlPart(50)
createClosureForHtmlPart(51, 2)
invokeTag('link','g',179,['action':("category"),'params':([offset: offset, up: 'false', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(52)
createClosureForHtmlPart(53, 2)
invokeTag('link','g',183,['action':("category"),'params':([offset: offset, up: 'true', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(54)
createClosureForHtmlPart(55, 2)
invokeTag('link','g',189,['action':("category"),'params':([offset: offset, up: 'false']),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(56)
})
invokeTag('captureBody','sitemesh',262,['style':("margin-bottom: 20px; min-width: 320px;  ")],1)
printHtmlPart(57)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443112414896L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
