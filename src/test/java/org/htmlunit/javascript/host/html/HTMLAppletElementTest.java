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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.htmlunit.BrowserRunner;
import org.htmlunit.Page;
import org.htmlunit.StatusHandler;
import org.htmlunit.WebClient;
import org.htmlunit.WebTestCase;
import org.htmlunit.BrowserRunner.Alerts;
import org.htmlunit.html.HtmlButton;
import org.htmlunit.html.HtmlPage;

/**
 * Tests for {@link HTMLAppletElement}.
 * @version $Revision: 4503 $
 * @author Marc Guillemot
 * @author Daniel Gredler
 */
@RunWith(BrowserRunner.class)
public class HTMLAppletElementTest extends WebTestCase {

    /**
     * Tests calling applet method from JavaScript code.
     * @throws Exception if the test fails
     */
    @Test
    public void callAppletMethodFromJS() throws Exception {
        final URL url = getClass().getResource("/applets/simpleAppletDoIt.html");

        final WebClient webClient = getWebClient();
        final List<String> collectedStatus = new ArrayList<String>();
        final StatusHandler statusHandler = new StatusHandler() {
            public void statusMessageChanged(final Page page, final String message) {
                collectedStatus.add(message);
            }
        };
        webClient.setStatusHandler(statusHandler);
        webClient.setAppletEnabled(true);

        final HtmlPage page = webClient.getPage(url);

        final HtmlButton button1 = page.getHtmlElementById("button1");
        button1.click();

        final HtmlButton button2 = page.getHtmlElementById("button2");
        button2.click();

        final String[] expectedStatus = {"Called: doIt('hello')", "Called: doIt('12345')"};
        assertEquals(expectedStatus, collectedStatus);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(FF = {"", "hello", "left", "hi", "right" },
            IE = {"", "error", "", "left", "error", "left", "right" })
    public void align() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + "      function test() {\n"
            + "        var applet = document.getElementById('a');\n"
            + "        alert(applet.align);\n"
            + "        set(applet, 'hello');\n"
            + "        alert(applet.align);\n"
            + "        set(applet, 'left');\n"
            + "        alert(applet.align);\n"
            + "        set(applet, 'hi');\n"
            + "        alert(applet.align);\n"
            + "        set(applet, 'right');\n"
            + "        alert(applet.align);\n"
            + "      }\n"
            + "      function set(e, value) {\n"
            + "        try {\n"
            + "          e.align = value;\n"
            + "        } catch (e) {\n"
            + "          alert('error');\n"
            + "        }\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'><applet id='a'></applet></body>\n"
            + "</html>";
        loadPageWithAlerts(html);
    }

}
