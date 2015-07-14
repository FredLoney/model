package org.reactome.web.pwp.model.classes;

import com.google.gwt.json.client.JSONObject;
import org.reactome.web.pwp.model.factory.SchemaClass;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class Requirement extends PositiveRegulation {

    public Requirement() {
        super(SchemaClass.REQUIREMENT);
    }

    @Override
    public void load(JSONObject jsonObject) {
        super.load(jsonObject);
    }
}
