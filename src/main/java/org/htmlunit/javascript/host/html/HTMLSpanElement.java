/*
 * Copyright (c) 2002-2009 Gargoyle Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.htmlunit.javascript.host.html;

import org.htmlunit.BrowserVersion;
import org.htmlunit.html.DomNode;
import org.htmlunit.html.HtmlAbbreviated;
import org.htmlunit.html.HtmlAcronym;
import org.htmlunit.html.HtmlAddress;
import org.htmlunit.html.HtmlBidirectionalOverride;
import org.htmlunit.html.HtmlBig;
import org.htmlunit.html.HtmlBlink;
import org.htmlunit.html.HtmlBold;
import org.htmlunit.html.HtmlCenter;
import org.htmlunit.html.HtmlCitation;
import org.htmlunit.html.HtmlCode;
import org.htmlunit.html.HtmlDefinition;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlEmphasis;
import org.htmlunit.html.HtmlExample;
import org.htmlunit.html.HtmlItalic;
import org.htmlunit.html.HtmlKeyboard;
import org.htmlunit.html.HtmlListing;
import org.htmlunit.html.HtmlNoBreak;
import org.htmlunit.html.HtmlPlainText;
import org.htmlunit.html.HtmlS;
import org.htmlunit.html.HtmlSample;
import org.htmlunit.html.HtmlSmall;
import org.htmlunit.html.HtmlStrike;
import org.htmlunit.html.HtmlStrong;
import org.htmlunit.html.HtmlSubscript;
import org.htmlunit.html.HtmlSuperscript;
import org.htmlunit.html.HtmlTeletype;
import org.htmlunit.html.HtmlUnderlined;
import org.htmlunit.html.HtmlVariable;
import org.htmlunit.javascript.host.ActiveXObject;

/**
 * The JavaScript object "HTMLSpanElement".
 *
 * @version $Revision: 4503 $
 * @author Ahmed Ashour
 * @author Daniel Gredler
 */
public class HTMLSpanElement extends HTMLElement {

    private static final long serialVersionUID = -1837052392526933150L;

    /**
     * Creates an instance.
     */
    public HTMLSpanElement() {
        // Empty.
    }

    /**
     * Sets the DOM node that corresponds to this JavaScript object.
     * @param domNode the DOM node
     */
    @Override
    public void setDomNode(final DomNode domNode) {
        super.setDomNode(domNode);
        final HtmlElement element = (HtmlElement) domNode;
        final BrowserVersion browserVersion = getBrowserVersion();
        if (browserVersion.isIE()) {
            if ((element instanceof HtmlAbbreviated && browserVersion.getBrowserVersionNumeric() > 6)
                || element instanceof HtmlAcronym
                || element instanceof HtmlAddress
                || element instanceof HtmlBidirectionalOverride
                || element instanceof HtmlBig
                || element instanceof HtmlBold
                || element instanceof HtmlBlink
                || element instanceof HtmlCenter
                || element instanceof HtmlCitation
                || element instanceof HtmlCode
                || element instanceof HtmlDefinition
                || element instanceof HtmlExample
                || element instanceof HtmlEmphasis
                || element instanceof HtmlItalic
                || element instanceof HtmlKeyboard
                || element instanceof HtmlListing
                || element instanceof HtmlNoBreak
                || element instanceof HtmlPlainText
                || element instanceof HtmlS
                || element instanceof HtmlSample
                || element instanceof HtmlSmall
                || element instanceof HtmlStrike
                || element instanceof HtmlStrong
                || element instanceof HtmlSubscript
                || element instanceof HtmlSuperscript
                || element instanceof HtmlTeletype
                || element instanceof HtmlUnderlined
                || element instanceof HtmlVariable) {
                ActiveXObject.addProperty(this, "cite", true, true);
            }
            if ((element instanceof HtmlAbbreviated && browserVersion.getBrowserVersionNumeric() > 6)
                    || element instanceof HtmlAcronym
                    || element instanceof HtmlBold
                    || element instanceof HtmlBidirectionalOverride
                    || element instanceof HtmlBig
                    || element instanceof HtmlBlink
                    || element instanceof HtmlCitation
                    || element instanceof HtmlCode
                    || element instanceof HtmlDefinition
                    || element instanceof HtmlEmphasis
                    || element instanceof HtmlItalic
                    || element instanceof HtmlKeyboard
                    || element instanceof HtmlNoBreak
                    || element instanceof HtmlS
                    || element instanceof HtmlSample
                    || element instanceof HtmlSmall
                    || element instanceof HtmlStrike
                    || element instanceof HtmlStrong
                    || element instanceof HtmlSubscript
                    || element instanceof HtmlSuperscript
                    || element instanceof HtmlTeletype
                    || element instanceof HtmlUnderlined
                    || element instanceof HtmlVariable) {
                ActiveXObject.addProperty(this, "dateTime", true, true);
            }
        }
    }

    /**
     * Returns the value of the "cite" property.
     * @return the value of the "cite" property
     */
    public String jsxGet_cite() {
        String cite = getDomNodeOrDie().getAttribute("cite");
        if (cite == NOT_FOUND) {
            cite = "";
        }
        return cite;
    }

    /**
     * Returns the value of the "cite" property.
     * @param cite the value
     */
    public void jsxSet_cite(final String cite) {
        getDomNodeOrDie().setAttribute("cite", cite);
    }

    /**
     * Returns the value of the "dateTime" property.
     * @return the value of the "dateTime" property
     */
    public String jsxGet_dateTime() {
        String dateTime = getDomNodeOrDie().getAttribute("datetime");
        if (dateTime == NOT_FOUND) {
            dateTime = "";
        }
        return dateTime;
    }

    /**
     * Returns the value of the "dateTime" property.
     * @param dateTime the value
     */
    public void jsxSet_dateTime(final String dateTime) {
        getDomNodeOrDie().setAttribute("datetime", dateTime);
    }
}
