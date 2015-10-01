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
for( _it1140684760 in (categories) ) {
changeItVariable(_it1140684760)
printHtmlPart(42)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: it.category]))
printHtmlPart(43)
expressionOut.print(it.category)
printHtmlPart(44)
}
printHtmlPart(45)
expressionOut.print(category)
printHtmlPart(46)
if(true && (categorySort != 'None')) {
printHtmlPart(47)
expressionOut.print(categorySort)
printHtmlPart(48)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [categorySort: 'Trending', category: category]))
printHtmlPart(49)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [categorySort: 'Recent', category: category]))
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (questions.isEmpty())) {
printHtmlPart(52)
}
printHtmlPart(53)
for( _it1519451306 in (questions) ) {
changeItVariable(_it1519451306)
printHtmlPart(54)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(55)
if(true && (it.answerOneImage)) {
printHtmlPart(56)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1']))
printHtmlPart(57)
}
else {
printHtmlPart(58)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(59)
}
printHtmlPart(60)
expressionOut.print(it.userName)
printHtmlPart(61)
expressionOut.print(it.questionTitle)
printHtmlPart(62)
expressionOut.print(it.totalVotes)
printHtmlPart(63)
expressionOut.print(it.totalViews)
printHtmlPart(64)
}
printHtmlPart(65)
createClosureForHtmlPart(66, 2)
invokeTag('link','g',214,['action':("category"),'params':([offset: offset, up: 'false', category: category, categorySort: categorySort]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(67)
createClosureForHtmlPart(68, 2)
invokeTag('link','g',218,['action':("category"),'params':([offset: offset, up: 'true', category: category, categorySort: categorySort]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(69)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(70)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(71)
})
invokeTag('captureBody','sitemesh',291,['style':("margin-bottom: 20px; min-width: 320px;  ")],1)
printHtmlPart(72)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443631811705L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
