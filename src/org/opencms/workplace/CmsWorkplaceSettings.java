/*
 * File   : $Source: /alkacon/cvs/opencms/src/org/opencms/workplace/CmsWorkplaceSettings.java,v $
 * Date   : $Date: 2007/08/13 16:30:06 $
 * Version: $Revision: 1.59 $
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

package org.opencms.workplace;

import org.opencms.db.CmsPublishList;
import org.opencms.db.CmsUserSettings;
import org.opencms.file.CmsResource;
import org.opencms.file.CmsUser;
import org.opencms.file.collectors.I_CmsResourceCollector;
import org.opencms.i18n.CmsMessageContainer;
import org.opencms.main.OpenCms;
import org.opencms.util.CmsUUID;
import org.opencms.workplace.explorer.CmsExplorer;
import org.opencms.workplace.tools.CmsToolUserData;

import java.util.HashMap;
import java.util.Map;

/**
 * Object to conveniently access and modify the state of the workplace for a user,
 * will be stored in the session of a user.<p>
 *
 * @author  Alexander Kandzior 
 * 
 * @version $Revision: 1.59 $ 
 * 
 * @since 6.0.0 
 */
public class CmsWorkplaceSettings {

    private I_CmsResourceCollector m_collector;
    private String m_currentSite;
    private Object m_dialogObject;
    private CmsMessageContainer m_errorMessage;
    private String m_explorerFlaturl;
    private String m_explorerMode;
    private int m_explorerPage;
    private String m_explorerProjectFilter;
    private CmsUUID m_explorerProjectId;
    private Map m_explorerResource;
    private Map m_frameUris;
    private String m_galleryType;
    private Map m_lastUsedGalleries;
    private Object m_listObject;
    private String m_permissionDetailView;
    private CmsUUID m_project;
    private CmsPublishList m_publishList;
    private CmsToolUserData m_toolUserData;
    private Map m_treeSite;
    private Map m_treeType;
    private CmsUser m_user;
    private CmsUserSettings m_userSettings;
    private String m_viewStartup;
    private String m_viewUri;

    /**
     * Constructor, only package visible.<p>
     */
    CmsWorkplaceSettings() {

        m_explorerPage = 1;
        m_explorerResource = new HashMap();
        m_treeType = new HashMap();
        m_treeSite = new HashMap();
        m_frameUris = new HashMap();
        m_lastUsedGalleries = new HashMap();
        m_currentSite = OpenCms.getSiteManager().getDefaultSite().getSiteRoot();
    }

    /**
     * Returns the collector object.<p>
     *
     * Use this mechanism for transferring a resource collector between
     * several page instances of an interactive dialog. <p> 
     *
     * @return the dialog object
     */
    public I_CmsResourceCollector getCollector() {

        return m_collector;
    }

    /**
     * Returns the dialog object.<p>
     *
     * Use this mechanism for transferring a complex object between
     * several page instances of an interactive dialog. This is usually 
     * required when editing a complex object in a dialog of the "Administration" view.<p> 
     *
     * @return the dialog object
     */
    public Object getDialogObject() {

        return m_dialogObject;
    }

    /**
     * Returns the error message to display in the workplace.<p>
     *
     * @return the error message to display in the workplace
     */
    public CmsMessageContainer getErrorMessage() {

        return m_errorMessage;
    }

    /**
     * Returns the explorer flat url.<p>
     *  
     * @return the explorer flat url
     */
    public String getExplorerFlaturl() {

        return m_explorerFlaturl;
    }

    /**
     * Returns the current explorer mode.<p> 
     * 
     * @return the current explorer mode
     */
    public String getExplorerMode() {

        return m_explorerMode;
    }

    /**
     * Returns the currently selected page in the explorer view.<p>
     * 
     * @return the currently selected page in the explorer view
     */
    public int getExplorerPage() {

        return m_explorerPage;
    }

    /**
     * Gets the explorer project filter for the project view.<p>
     * 
     * This parameter is used in the administration to filter
     * files belonging to a project.
     * 
     * @return the explorer project filter
     */
    public String getExplorerProjectFilter() {

        return m_explorerProjectFilter;
    }

    /**
     * Gets the explorer project id for the project view.<p>
     * 
     * This parameter is used in the administration to filter
     * files belonging to a selected project.
     * 
     * @return the explorer project id
     */
    public CmsUUID getExplorerProjectId() {

        return m_explorerProjectId;
    }

    /**
     * Returns the current resource to be displayed in the explorer.<p>
     * 
     * @return the current resource to be displayed in the explorer
     */
    public String getExplorerResource() {

        // get the current explorer mode
        String mode = getExplorerMode();
        if (mode == null) {
            mode = CmsExplorer.VIEW_EXPLORER;
        }
        if (CmsExplorer.VIEW_EXPLORER.equals(mode)) {
            // append the current site to the key when in explorer view mode
            mode += "_" + getSite() + "/";
        }
        // get the resource for the given mode
        String resource = (String)m_explorerResource.get(mode);
        if (resource == null) {
            resource = "/";
        }
        return resource;
    }

    /**
     * Returns the frame URIs of the currently loaded frameset, with the frame names as keys.<p>
     * 
     * @return the frame URIs of the currently loaded frameset
     */
    public Map getFrameUris() {

        return m_frameUris;
    }

    /**
     * Returns the current gallery type name.<p>
     *
     * @return the current gallery type name
     */
    public String getGalleryType() {

        return m_galleryType;
    }

    /**
     * Returns the last saved gallery for the given gallery type id.<p>
     * 
     * @param galleryTypeId the type id of the gallery
     * @return the last saved gallery for the given gallery type id
     */
    public String getLastUsedGallery(int galleryTypeId) {

        return (String)m_lastUsedGalleries.get(String.valueOf(galleryTypeId));
    }

    /**
     * Returns the list dialog object.<p>
     *
     * Use this mechanism for transfering a html list object between
     * several page instances of an interactive dialog. This is usually 
     * required when having several lists in a tool or when a list action 
     * another list displays of the "Administration" view.<p> 
     *
     * @return the dialog object
     * 
     * @see org.opencms.workplace.list.A_CmsListDialog#getListObject(Class, CmsWorkplaceSettings)
     */
    public Object getListObject() {

        return m_listObject;
    }

    /**
     * Returns the current detail grade of the view.<p>
     *  
     * @return value of the details.
     */
    public String getPermissionDetailView() {

        return m_permissionDetailView;
    }

    /**
     * Returns the currently selected project of the workplace user.<p> 
     * 
     * @return the currently selected project of the workplace user
     */
    public CmsUUID getProject() {

        return m_project;
    }

    /**
     * Returns the publish list.<p>
     * 
     * @return the publishList
     */
    public CmsPublishList getPublishList() {

        return m_publishList;
    }

    /**
     * Returns the current site for the user.<p>
     * 
     * @return the current site for the user 
     */
    public String getSite() {

        return m_currentSite;
    }

    /**
     * Returns the new admin view tool User Data.<p>
     *
     * @return the tool User Data
     */
    public CmsToolUserData getToolUserData() {

        return m_toolUserData;
    }

    /**
     * Returns the tree resource uri for the specified tree type.<p>
     * 
     * @param type the type of the tree
     * @return the tree resource uri for the specified tree type
     */
    public String getTreeResource(String type) {

        String result = (String)m_treeType.get(type);
        if (result == null) {
            result = "/";
        }
        return result;
    }

    /**
     * Returns the tree site uri for the specified tree type.<p>
     * 
     * @param type the type of the tree
     * @return the tree site uri for the specified tree type
     */
    public String getTreeSite(String type) {

        String result = (String)m_treeSite.get(type);
        return result;
    }

    /**
     * Returns the current workplace user.<p>
     * 
     * @return the current workplace user
     */
    public CmsUser getUser() {

        return m_user;
    }

    /**
     * Returns the current workplace user settings object.<p>
     * 
     * @return the current workplace user settings object
     */
    public CmsUserSettings getUserSettings() {

        return m_userSettings;
    }

    /**
     * Returns the view startup page.<p>
     *
     * The view startup page can be used to directly load a specific workplace dialog or other workplace resource in the 
     * OpenCms workplace base frameset after the user logs in.<p>
     *
     * @return the view startup page
     */
    public String getViewStartup() {

        return m_viewStartup;
    }

    /**
     * Returns the current view Uri selected in the workplace.<p>
     * 
     * @return the current view Uri selected in the workplace 
     */
    public String getViewUri() {

        return m_viewUri;
    }

    /**
     * Checks if the current view is the explorer view.<p>
     * 
     * @return true if the current view is the explorer view, otherwise false 
     */
    public boolean isViewExplorer() {

        return getViewUri().endsWith(CmsWorkplace.FILE_EXPLORER_FILELIST);
    }

    /**
     * Sets the collector object.<p>
     * 
     * Use this mechanism for transferring a resource collector between
     * several page instances of an interactive dialog.<p>
     *  
     * @param collector the dialog object to set
     */
    public void setCollector(I_CmsResourceCollector collector) {

        m_collector = collector;
    }

    /**
     * Sets the dialog object.<p>
     * 
     * Use this mechanism for transferring a complex object between
     * several page instances of an interactive dialog. This is usually 
     * required when editing a complex object in a dialog of the "Administration" view.<p>
     *  
     * @param dialogObject the dialog object to set
     */
    public void setDialogObject(Object dialogObject) {

        m_dialogObject = dialogObject;
    }

    /**
     * Sets the error message to display in the workplace.<p>
     *
     * @param errorMessage the error message to display in the workplace
     */
    public void setErrorMessage(CmsMessageContainer errorMessage) {

        m_errorMessage = errorMessage;
    }

    /**
     * Sets the explorer flat url.<p>
     * 
     * @param value the explorer flat url
     */
    public void setExplorerFlaturl(String value) {

        m_explorerFlaturl = value;
    }

    /**
     * Sets the current explorer mode.<p>
     * 
     * @param value the current explorer mode
     */
    public void setExplorerMode(String value) {

        m_explorerMode = value;
    }

    /**
     * Sets the currently selected page in the explorer view.<p>
     * 
     * @param page the currently selected page in the explorer view
     */
    public void setExplorerPage(int page) {

        m_explorerPage = page;
    }

    /**
     * Sets the explorer project filter for the project view.<p>
     * 
     * @param value the explorer project filter
     */
    public void setExplorerProjectFilter(String value) {

        m_explorerProjectFilter = value;
    }

    /**
     * Sets the explorer project id for the project view.<p>
     * 
     * @param value the explorer project id
     */
    public void setExplorerProjectId(CmsUUID value) {

        m_explorerProjectId = value;
    }

    /**
     * Sets the current resource to be displayed in the explorer.<p>
     * 
     * @param value the current resource to be displayed in the explorer
     */
    public void setExplorerResource(String value) {

        if (value == null) {
            return;
        }
        // get the current explorer mode
        String mode = getExplorerMode();
        if (mode == null) {
            mode = CmsExplorer.VIEW_EXPLORER;
        }
        if (CmsExplorer.VIEW_EXPLORER.equals(mode)) {
            // append the current site to the key when in explorer view mode
            mode += "_" + getSite() + "/";
        }

        // set the resource for the given mode
        if (value.startsWith(CmsResource.VFS_FOLDER_SYSTEM + "/")
            && (!value.startsWith(m_currentSite))
            && (!CmsExplorer.VIEW_GALLERY.equals(getExplorerMode()))) {
            // restrict access to /system/ 
            m_explorerResource.put(mode, "/");
        } else {
            m_explorerResource.put(mode, value);
        }
    }

    /**
     * Sets the current gallery type name.<p>
     *
     * @param currentGallery the current gallery type name to set
     */
    public void setGalleryType(String currentGallery) {

        m_galleryType = currentGallery;
    }

    /**
     * Saves the last gallery.<p>
     * 
     * @param galleryTypeId the type id of the gallery as key
     * @param gallerypath the resourcepath of the gallery
     */
    public void setLastUsedGallery(int galleryTypeId, String gallerypath) {

        m_lastUsedGalleries.put(String.valueOf(galleryTypeId), gallerypath);
    }

    /**
     * Sets the list object.<p>
     * 
     * Use this mechanism for transfering a html list object between
     * several page instances of an interactive dialog. This is usually 
     * required when having several lists in a tool or when a list action 
     * another list displays of the "Administration" view.<p> 
     *  
     * @param listObject the list object to set
     * 
     * @see org.opencms.workplace.list.A_CmsListDialog#setListObject(Class, org.opencms.workplace.list.CmsHtmlList)
     */
    public void setListObject(Object listObject) {

        m_listObject = listObject;
    }

    /**
     * Sets the current detail grade of the view.<p>
     * 
     * @param value the current details.
     */
    public void setPermissionDetailView(String value) {

        m_permissionDetailView = value;
    }

    /**
     * Sets the currently selected project of the workplace user.<p>
     * 
     * @param project the currently selected project of thw workplace user
     */
    public void setProject(CmsUUID project) {

        m_project = project;
    }

    /**
     * Sets the publish list.<p>
     * 
     * @param publishList the publishList to set
     */
    public void setPublishList(CmsPublishList publishList) {

        m_publishList = publishList;
    }

    /**
     * Sets the current site for the user.<p>
     * 
     * @param value the current site for the user
     */
    public void setSite(String value) {

        if ((value != null) && !value.equals(m_currentSite)) {
            m_currentSite = value;
            m_treeType = new HashMap();
        }
    }

    /**
     * Sets the new admin view tool User Data.<p>
     *
     * @param toolUserData the tool User Data to set
     */
    public void setToolUserData(CmsToolUserData toolUserData) {

        m_toolUserData = toolUserData;
    }

    /**
     * Sets the tree resource uri for the specified tree type.<p>
     * 
     * @param type the type of the tree
     * @param value the resource uri to set for the type
     */
    public void setTreeResource(String type, String value) {

        if (value == null) {
            return;
        }
        if (value.startsWith(CmsResource.VFS_FOLDER_SYSTEM + "/") && (!value.startsWith(m_currentSite))) {
            // restrict access to /system/ 
            value = "/";
        }
        m_treeType.put(type, value);
    }

    /**
     * Sets the tree resource uri for the specified tree type.<p>
     * 
     * @param type the type of the tree
     * @param value the resource uri to set for the type
     */
    public void setTreeSite(String type, String value) {

        if (value == null) {
            return;
        }
        m_treeSite.put(type, value);
    }

    /**
     * Sets the current workplace user.<p>
     * 
     * @param user the current workplace user
     */
    public void setUser(CmsUser user) {

        m_user = user;
    }

    /**
     * Sets the current workplace user settings object.<p>
     * 
     * @param userSettings the current workplace user settings object
     */
    public void setUserSettings(CmsUserSettings userSettings) {

        m_userSettings = userSettings;
    }

    /**
     * Sets the view startup page.<p>
     *
     * The view startup page can be used to directly load a specific workplace dialog or other workplace resource in the 
     * OpenCms workplace base frameset after the user logs in.<p>
     *
     * @param viewStartup the view startup page to set
     */
    public void setViewStartup(String viewStartup) {

        m_viewStartup = viewStartup;
    }

    /**
     * Sets the view Uri for the workplace.<p>
     * 
     * @param string the view Uri for the workplace
     */
    public void setViewUri(String string) {

        m_viewUri = string;
    }
}