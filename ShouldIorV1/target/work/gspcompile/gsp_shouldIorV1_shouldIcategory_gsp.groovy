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
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("ShouldI.fm is a place where you can ask the world questions and get honest answers. Start a poll, it's free and easy!")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("ShouldI.fm")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir:'images',file:'logoBrowser.png'))
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(6)
invokeTag('resource','g',16,['dir':("css"),'file':("bootstrap.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',17,['dir':("css"),'file':("buttons.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',18,['dir':("css"),'file':("customBoot.css")],-1)
printHtmlPart(7)
invokeTag('resource','g',19,['dir':("css"),'file':("awesome-bootstrap-checkbox.css")],-1)
printHtmlPart(8)
invokeTag('resource','g',21,['dir':("js"),'file':("bootstrap.min.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',23,['src':("facebookLogin.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',24,['src':("dataAccess.js")],-1)
printHtmlPart(10)
invokeTag('resource','g',27,['dir':("css"),'file':("typehead-searchBar.css")],-1)
printHtmlPart(11)
invokeTag('resource','g',29,['dir':("js/typedJS"),'file':("typed.min.js")],-1)
printHtmlPart(12)
invokeTag('javascript','g',31,['src':("dataAccess.js")],-1)
printHtmlPart(13)
invokeTag('resource','g',33,['dir':("js/typeaheadJS"),'file':("typeahead.jquery.min.js")],-1)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',40,[:],1)
printHtmlPart(15)
expressionOut.print(category)
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(17)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(16)
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
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: 'Trending']))
printHtmlPart(41)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: 'Recent']))
printHtmlPart(42)
for( _it1505424071 in (categories) ) {
changeItVariable(_it1505424071)
printHtmlPart(43)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [category: it.category]))
printHtmlPart(44)
expressionOut.print(it.category)
printHtmlPart(45)
}
printHtmlPart(46)
expressionOut.print(category)
printHtmlPart(47)
if(true && (categorySort != 'None')) {
printHtmlPart(48)
expressionOut.print(categorySort)
printHtmlPart(49)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [categorySort: 'Trending', category: category]))
printHtmlPart(50)
expressionOut.print(createLink(controller: 'shouldI', action: 'category', params: [categorySort: 'Recent', category: category]))
printHtmlPart(51)
}
printHtmlPart(52)
if(true && (questions.isEmpty())) {
printHtmlPart(53)
}
printHtmlPart(54)
for( _it216421817 in (questions) ) {
changeItVariable(_it216421817)
printHtmlPart(55)
expressionOut.print(createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID]))
printHtmlPart(56)
if(true && (it.answerOneImage)) {
printHtmlPart(57)
expressionOut.print(createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True']))
printHtmlPart(58)
}
else {
printHtmlPart(59)
expressionOut.print(resource(dir:'images',file:'noImg.png'))
printHtmlPart(60)
}
printHtmlPart(61)
expressionOut.print(it.userName)
printHtmlPart(62)
expressionOut.print(it.questionTitle)
printHtmlPart(63)
expressionOut.print(it.totalVotes)
printHtmlPart(64)
expressionOut.print(it.totalViews)
printHtmlPart(65)
}
printHtmlPart(66)
createClosureForHtmlPart(67, 2)
invokeTag('link','g',216,['action':("category"),'params':([offset: offset, up: 'false', category: category, categorySort: categorySort]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(68)
createClosureForHtmlPart(69, 2)
invokeTag('link','g',220,['action':("category"),'params':([offset: offset, up: 'true', category: category, categorySort: categorySort]),'style':("padding-top: 2px; padding-bottom: 2px;"),'class':("btn btn-default")],2)
printHtmlPart(70)
expressionOut.print(createLink(controller: 'ShouldI', action: 'privacyPolicy'))
printHtmlPart(71)
expressionOut.print(createLink(controller: 'ShouldI', action: 'help'))
printHtmlPart(72)
expressionOut.print(createLink(controller: 'ShouldI', action: 'aboutPollaris'))
printHtmlPart(73)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginFaceBook'))
printHtmlPart(74)
expressionOut.print(createLink(controller: 'Authentication', action: 'loginReddit'))
printHtmlPart(75)
})
invokeTag('captureBody','sitemesh',301,['style':("margin-bottom: 20px; min-width: 320px;  ")],1)
printHtmlPart(76)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444179674078L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
