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
package org.htmlunit.javascript.host;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.htmlunit.BrowserRunner;
import org.htmlunit.WebTestCase;
import org.htmlunit.BrowserRunner.Alerts;
import org.htmlunit.BrowserRunner.Browser;
import org.htmlunit.BrowserRunner.Browsers;

/**
 * Tests for {@link EventNode}.
 *
 * @version $Revision: 4002 $
 * @author Ahmed Ashour
 */
@RunWith(BrowserRunner.class)
public class EventNodeTest extends WebTestCase {

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Browsers(Browser.IE)
    @Alerts("true")
    public void fireEvent() throws Exception {
        final String html
            = "<html><head>\n"
            + "<script>\n"
            + "  function test() {\n"
            + "    var form = document.getElementById('myForm');\n"
            + "    alert(form.fireEvent('onsubmit'));\n"
            + "  }\n"
            + "</script>\n"
            + "</head><body onload='test()'>\n"
            + "  <form id='myForm'>\n"
            + "  </form>\n"
            + "</body></html>";
        loadPageWithAlerts(html);
    }

}
