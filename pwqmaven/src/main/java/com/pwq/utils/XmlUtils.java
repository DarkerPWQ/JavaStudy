package com.pwq.utils;

import com.gargoylesoftware.htmlunit.html.HtmlElement;

import java.util.List;

/**
 * Created by Yu Yangjun on 2016/6/23.
 */
public class XmlUtils {

    public static String getNodeText(HtmlElement element, String xpath){
        String result="";
        @SuppressWarnings("unchecked")
		List<HtmlElement> elements=(List<HtmlElement>)element.getByXPath(xpath);
        if(CollectionUtil.isNotEmpty(elements)&&elements.size()>0){
            result=elements.get(0).asText();
        }
        return result;
    }
}
