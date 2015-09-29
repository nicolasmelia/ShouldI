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
invokeTag('javascript','g',22,['src':("dataAccess.js")],-1)
printHtmlPart(9)
invokeTag('resource','g',25,['dir':("css"),'file':("typehead-searchBar.css")],-1)
printHtmlPart(10)
invokeTag('resource','g',27,['dir':("js/typedJS"),'file':("typed.min.js")],-1)
printHtmlPart(11)
invokeTag('javascript','g',29,['src':("dataAccess.js")],-1)
printHtmlPart(12)
invokeTag('resource','g',31,['dir':("js/typeaheadJS"),'file':("typeahead.jquery.min.js")],-1)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',38,[:],1)
printHtmlPart(14)
expressionOut.print(category)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(15)
if(true && (session.name)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(20)
expressionOut.print(resource(dir:'images',file:'logo.png'))
printHtmlPart(21)
if(true && (session.name)) {
printHtmlPart(22)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications']))
printHtmlPart(23)
expressionOut.print(notifyCount)
printHtmlPart(24)
expressionOut.print(createLink(controller: 'Question', action: 'askShouldI'))
printHtmlPart(25)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(26)
}
else {
printHtmlPart(27)
expressionOut.print(createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(26)
}
printHtmlPart(28)
if(true && (session.name)) {
printHtmlPart(29)
expressionOut.print(createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID]))
printHtmlPart(30)
expressionOut.print(session.name)
printHtmlPart(31)
expressionOut.print(createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions']))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'ShouldI', action: 'home'))
printHtmlPart(35)
expressionOut.print(createLink(controller: 'Authentication', action: 'logout'))
printHtmlPart(36)
}
else {
printHtmlPart(37)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(40)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: 'Recent']))
printHtmlPart(41)
for( _it1179799230 in (categories) ) {
changeItVariable(_it1179799230)
printHtmlPart(42)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: it.category]))
printHtmlPart(43)
expressionOut.print(it.category)
printHtmlPart(44)
}
printHtmlPart(45)
expressionOut.print(category)
printHtmlPart(46)
for( _it501766514 in (questions) ) {
changeItVariable(_it501766514)
printHtmlPart(47)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(48)
if(true && (it.answerOneImage)) {
printHtmlPart(49)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(50)
}
else {
printHtmlPart(51)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(52)
}
printHtmlPart(53)
expressionOut.print(it.userName)
printHtmlPart(54)
expressionOut.print(it.questionTitle)
printHtmlPart(55)
expressionOut.print(it.totalVotes)
printHtmlPart(56)
expressionOut.print(it.totalViews)
printHtmlPart(57)
}
printHtmlPart(58)
createClosureForHtmlPart(59, 2)
invokeTag('link','g',189,['action':("category"),'params':([offset: offset, up: 'false', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(60)
createClosureForHtmlPart(61, 2)
invokeTag('link','g',193,['action':("category"),'params':([offset: offset, up: 'true', category: category]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(62)
createClosureForHtmlPart(63, 2)
invokeTag('link','g',199,['action':("category"),'params':([offset: offset, up: 'false']),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(64)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(65)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(66)
})
invokeTag('captureBody','sitemesh',274,['style':("margin-bottom: 20px; min-width: 320px;  ")],1)
printHtmlPart(67)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443489912855L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
