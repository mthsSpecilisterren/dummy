package nl.hsac.fitnesse.telfort;

import nl.hsac.fitnesse.fixture.slim.web.BrowserTest;
import nl.hsac.fitnesse.fixture.slim.web.annotation.TimeoutPolicy;
import nl.hsac.fitnesse.fixture.slim.web.annotation.WaitUntil;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by TeunisV on 28-6-2016.
 */
public class TelfortTest extends BrowserTest {
    /**
     * Retrieves the attribute of an Javascript element.
     * @param attr attribute to check.
     * @param jsSelector element to check. (by javascript selector! this makes selecting base/window elements possible)
     * @return contents of the attribute of the given Javascript element.
     */
    @WaitUntil(TimeoutPolicy.RETURN_NULL)
    public String getAttributeOfJsselector(String attr, String  jsSelector) {
        try {
            String attribute = (String)getSeleniumHelper().executeJavascript("return %s.%s;", jsSelector, attr );
            String result = URLDecoder.decode(attribute, "UTF-8");
            return result;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private WebDriver driver() {
        return getSeleniumHelper().driver();
    }

    /**
     * Set a Cookie
     * @param name The name of the cookie
     * @param value The cookie value
     * @param path The path the cookie is visible to. If left blank, will be set to "/".
     * @param domain  The domain the cookie is visible to. If left blank, will be set to "current domain".
     * @return true
     */
    public Boolean setCookieNameValuePathDomain(String name, String value, String path, String domain) {
        return SetCookieImpl(name, value, domain, null, false, false, path);
    }

    /**
     * Set a Cookie, Path = '/', Domain = current domain
     * @param name The name of the cookie
     * @param value The cookie value
     * @return true
     */
    public Boolean setCookieNameValue(String name, String value) {
        return SetCookieImpl(name, value, "", null, false, false, "");
    }

    protected Boolean SetCookieImpl(String name, String value, String domain, Date expiresOn, Boolean isHttpOnly, Boolean isSecure, String path)
    {
        try {
            Cookie c = new Cookie.Builder(name, value).expiresOn(expiresOn)
                    .domain(domain).path(path)
                    .isHttpOnly(isHttpOnly).isSecure(isSecure).build();
            driver().manage().addCookie(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
