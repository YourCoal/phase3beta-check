/*************************************************************************
 * 
 * AVRGAMING LLC
 * __________________
 * 
 *  [2013] AVRGAMING LLC
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of AVRGAMING LLC and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to AVRGAMING LLC
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from AVRGAMING LLC.
 */
package com.civcraft.questions;

import com.civcraft.main.CivGlobal;
import com.civcraft.main.CivMessage;
import com.civcraft.object.Civilization;
import com.civcraft.object.Relation;
import com.civcraft.object.Resident;
import com.civcraft.util.CivColor;

public class ChangeRelationResponse implements QuestionResponseInterface {

	public Civilization fromCiv;
	public Civilization toCiv;
	public Relation.Status status;
	
	@Override
	public void processResponse(String param) {
		if (param.equalsIgnoreCase("accept")) {
			CivGlobal.setRelation(fromCiv, toCiv, status);
		} else {
			CivMessage.sendCiv(fromCiv, CivColor.LightGray+toCiv.getName()+" declined our offer.");
		}
	}
	@Override
	public void processResponse(String response, Resident responder) {
		processResponse(response);		
	}
}
