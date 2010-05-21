/*
 * Created on 9/10/2003
 * YAWLEditor v1.0 
 *
 * @author Lindsay Bradford
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
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */

package org.yawlfoundation.yawl.editor.actions;

import edu.stanford.ejalbert.BrowserLauncher;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class ShowSurveyLinkAction extends YAWLBaseAction {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private static final String surveyURL = "http://www.bpm.fit.qut.edu.au/surveys/yawl";  

  {
    putValue(Action.SHORT_DESCRIPTION, "Help us Improve YAWL.");
    putValue(Action.NAME, "Help us Improve YAWL...");
    putValue(Action.LONG_DESCRIPTION, "Help us Improve YAWL.");
    putValue(Action.MNEMONIC_KEY, new Integer(java.awt.event.KeyEvent.VK_I));
  }

  public void actionPerformed(ActionEvent event) {
      try {
          BrowserLauncher launcher = new BrowserLauncher();
          launcher.openURLinBrowser(surveyURL);
      }
      catch (Exception e) {
          //
      }
  }
}