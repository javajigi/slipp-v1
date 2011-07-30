<?xml version="1.0" encoding="UTF-8"?> 
<rss version="2.0">
	<channel>
		<title>지속가능한 삶, 프로그래밍, 프로그래머(SLiPP)</title>
		<link>http://www.slipp.net/</link>
		<description>지속가능한 삶, 프로그래밍, 프로그래머(sustainable life, programming, programmer)</description>
		<language>ko</language>
		<pubDate>${now?string("EEE, dd MMM yyyy HH:mm:ss Z")}</pubDate>
		<generator>slipp.net(http://www.slipp.net/)</generator>
		<image>
			<title>지속가능한 삶, 프로그래밍, 프로그래머(SLiPP)</title>
			<url><![CDATA[http://cfile23.uf.tistory.com/image/20637F134BC7B18E2E34A8]]></url>
			<link>http://www.slipp.net/</link>
			<description></description>
		</image>
		<#list diaries as diary>
		<item>
			<title><![CDATA[${diary.title?if_exists}]]></title>
			<link>http://www.slipp.net/diaries/${diary.id?c}</link>
			<description><![CDATA[${diary.displayContents?if_exists}]]></description>
			<author>javajigi</author>
			<guid>http://www.slipp.net/diaries/${diary.id?c}</guid>
			<comments>http://www.slipp.net/diaries/${diary.id?c}</comments>
			<pubDate>${diary.createdDate?string("EEE, dd MMM yyyy HH:mm:ss Z")}</pubDate>
		</item>
		</#list>
	</channel>
</rss>
