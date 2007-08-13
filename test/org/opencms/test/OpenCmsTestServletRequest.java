/*
 * File   : $Source: /alkacon/cvs/opencms/test/org/opencms/test/OpenCmsTestServletRequest.java,v $
 * Date   : $Date: 2007/08/13 16:30:02 $
 * Version: $Revision: 1.3 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) 2002 - 2007 Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software GmbH, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package org.opencms.test;

import java.io.BufferedReader;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Very incomplete implementation of <code>HttpServletRequest</code> for testing.<p>
 * 
 * @author Alexander Kandzior 
 * @version $Revision: 1.3 $
 */
public class OpenCmsTestServletRequest implements HttpServletRequest {
    
    /**
     * Constructor for test implementation.<p>
     */
    public OpenCmsTestServletRequest() {
        // noop
    }    

    /**
     * @see javax.servlet.ServletRequest#getAttribute(java.lang.String)
     */
    public Object getAttribute(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getAttributeNames()
     */
    public Enumeration getAttributeNames() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getAuthType()
     */
    public String getAuthType() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getCharacterEncoding()
     */
    public String getCharacterEncoding() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getContentLength()
     */
    public int getContentLength() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getContentType()
     */
    public String getContentType() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getContextPath()
     */
    public String getContextPath() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getCookies()
     */
    public Cookie[] getCookies() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getDateHeader(java.lang.String)
     */
    public long getDateHeader(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getHeader(java.lang.String)
     */
    public String getHeader(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getHeaderNames()
     */
    public Enumeration getHeaderNames() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getHeaders(java.lang.String)
     */
    public Enumeration getHeaders(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getInputStream()
     */
    public ServletInputStream getInputStream() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getIntHeader(java.lang.String)
     */
    public int getIntHeader(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getLocale()
     */
    public Locale getLocale() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getLocales()
     */
    public Enumeration getLocales() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getMethod()
     */
    public String getMethod() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getParameter(java.lang.String)
     */
    public String getParameter(String arg0) {

        // no parameter available
        return null;
        // throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getParameterMap()
     */
    public Map getParameterMap() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getParameterNames()
     */
    public Enumeration getParameterNames() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getParameterValues(java.lang.String)
     */
    public String[] getParameterValues(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getPathInfo()
     */
    public String getPathInfo() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getPathTranslated()
     */
    public String getPathTranslated() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getProtocol()
     */
    public String getProtocol() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getQueryString()
     */
    public String getQueryString() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getReader()
     */
    public BufferedReader getReader() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getRealPath(java.lang.String)
     * @deprecated 
     */
    public String getRealPath(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getRemoteAddr()
     */
    public String getRemoteAddr() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getRemoteHost()
     */
    public String getRemoteHost() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getRemoteUser()
     */
    public String getRemoteUser() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getRequestDispatcher(java.lang.String)
     */
    public RequestDispatcher getRequestDispatcher(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getRequestedSessionId()
     */
    public String getRequestedSessionId() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getRequestURI()
     */
    public String getRequestURI() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getRequestURL()
     */
    public StringBuffer getRequestURL() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getScheme()
     */
    public String getScheme() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getServerName()
     */
    public String getServerName() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#getServerPort()
     */
    public int getServerPort() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getServletPath()
     */
    public String getServletPath() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getSession()
     */
    public HttpSession getSession() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getSession(boolean)
     */
    public HttpSession getSession(boolean arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getUserPrincipal()
     */
    public Principal getUserPrincipal() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromCookie()
     */
    public boolean isRequestedSessionIdFromCookie() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromUrl()
     * @deprecated
     */
    public boolean isRequestedSessionIdFromUrl() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromURL()
     */
    public boolean isRequestedSessionIdFromURL() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdValid()
     */
    public boolean isRequestedSessionIdValid() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#isSecure()
     */
    public boolean isSecure() {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isUserInRole(java.lang.String)
     */
    public boolean isUserInRole(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#removeAttribute(java.lang.String)
     */
    public void removeAttribute(String arg0) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#setAttribute(java.lang.String, java.lang.Object)
     */
    public void setAttribute(String arg0, Object arg1) {

        throw new RuntimeException("Not implemented");
    }

    /**
     * @see javax.servlet.ServletRequest#setCharacterEncoding(java.lang.String)
     */
    public void setCharacterEncoding(String arg0) {

        throw new RuntimeException("Not implemented");
    }     
}